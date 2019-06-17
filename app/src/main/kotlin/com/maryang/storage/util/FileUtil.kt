package com.maryang.storage.util

import android.annotation.SuppressLint
import android.app.PendingIntent
import android.app.RecoverableSecurityException
import android.content.ContentUris
import android.content.ContentValues
import android.content.Context
import android.graphics.Bitmap
import android.media.ExifInterface
import android.net.Uri
import android.os.Environment
import android.provider.MediaStore
import android.util.Log
import androidx.appcompat.app.AlertDialog
import com.maryang.storage.base.BaseApplication
import java.io.File
import java.io.FileOutputStream


object FileUtil {

    //    private val PATH_PARENT =
//        BaseApplication.appContext.getExternalFilesDir(Environment.DIRECTORY_PICTURES)!!.absolutePath
    private val PATH_PARENT = "${Environment.getExternalStorageDirectory().absolutePath}/${BaseApplication.TAG}"
    private const val MIME_IMAGE_JPG = "image/jpeg"

    fun getFilePathP(name: String): String {
        val file = File(PATH_PARENT, name)
        return if (file.exists())
            file.absolutePath
        else ""
    }

    @SuppressLint("NewApi")
    fun getFilePathQ(name: String, context: Context): String {
        // Find images (both published and pending)
        val resolver = BaseApplication.appContext.contentResolver
        val collection = MediaStore.Images.Media.getContentUri(MediaStore.VOLUME_EXTERNAL_PRIMARY)
        val collectionWithPending = MediaStore.setIncludePending(collection)
        val selection = "${MediaStore.Images.ImageColumns.DISPLAY_NAME}='$name'"
        return resolver.query(collectionWithPending, null, selection, null, null)!!.use {
            // Get a specific media item uri
            val uri =
                if (it.moveToFirst()) {
                    ContentUris.withAppendedId(
                        MediaStore.Images.Media.getContentUri(MediaStore.VOLUME_EXTERNAL_PRIMARY),
                        it.getLong(it.getColumnIndex(MediaStore.Images.ImageColumns._ID))
                    ).toString()
                } else ""
            it.close()
            uri
        }.let {
            Log.d(BaseApplication.TAG, "read file uri: $it")
            // Open a specific media item
            try {
                resolver.openInputStream(Uri.parse(it)).use { stream ->
                    ExifInterface(stream!!).run {
                        // do something
                    }
                }
            } catch (e: RecoverableSecurityException) {
                AlertDialog.Builder(context)
                    .setMessage(e.userMessage)
                    .setPositiveButton(e.userAction.title)
                    { dialog, which ->
                        try {
                            e.userAction.actionIntent.send()
                        } catch (ignored: PendingIntent.CanceledException) {
                            // do nothing
                        }
                    }
                    .setNegativeButton("취소", null)
                    .show()
            }
            it
        }
    }

    fun saveBitmapP(bitmap: Bitmap, name: String): String {
        val parent = File(PATH_PARENT)
        if (parent.exists().not())
            Log.d(BaseApplication.TAG, "mkdirs: ${parent.mkdirs()}")
        val file = File(PATH_PARENT, ImageUtil.withJpg(name))
        file.createNewFile()
        val outputStream = FileOutputStream(file)
        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, outputStream)
        outputStream.close()
        Log.d(BaseApplication.TAG, "save file absolutePath: ${file.absolutePath}")
        return file.absolutePath
    }

    fun saveBitmapQ(bitmap: Bitmap, name: String): String {
        // Create a new image in the user's collection
        val values = ContentValues().apply {
            put(MediaStore.Images.Media.RELATIVE_PATH, "Pictures/Maryang Album")
            put(MediaStore.Images.Media.DISPLAY_NAME, ImageUtil.withJpg(name))
            put(MediaStore.Images.Media.MIME_TYPE, MIME_IMAGE_JPG)
            put(MediaStore.Images.Media.IS_PENDING, 1)
        }

        val resolver = BaseApplication.appContext.contentResolver
        val collection = MediaStore.Images.Media
            .getContentUri(MediaStore.VOLUME_EXTERNAL_PRIMARY)
        val item = resolver.insert(collection, values)!!

        // Write bitmap into pending image output stream
        resolver.openOutputStream(item)!!.use { stream ->
            bitmap.compress(Bitmap.CompressFormat.JPEG, 100, stream)
        }

        // Now that we're finished, reveal to other apps
        values.clear()
        values.put(MediaStore.Images.Media.IS_PENDING, 0)
        resolver.update(item, values, null, null)

        Log.d(BaseApplication.TAG, "save file uri: $item")
        return item.toString()
    }
}
