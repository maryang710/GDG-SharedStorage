package com.maryang.storage.ui

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.os.Environment
import android.provider.Settings
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.documentfile.provider.DocumentFile
import androidx.recyclerview.widget.GridLayoutManager
import com.maryang.storage.R
import com.maryang.storage.base.ActivityContext
import com.maryang.storage.base.BaseApplication
import com.maryang.storage.data.repository.PixabayRepository
import com.maryang.storage.entity.model.PixabayImage
import com.maryang.storage.util.FileUtil
import io.reactivex.observers.DisposableSingleObserver
import kotlinx.android.synthetic.main.activity_images.*


class ImagesActivity : AppCompatActivity(), ActivityContext {

    companion object {
        const val REQUEST_CODE_READ = 0
    }

    private val repository: PixabayRepository by lazy {
        PixabayRepository()
    }
    private val adapter: ImagesAdapter by lazy {
        ImagesAdapter(this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_images)

        recyclerView.layoutManager = GridLayoutManager(this, 3)
        recyclerView.adapter = this.adapter

        refreshLayout.setOnRefreshListener { loadImages() }

        loadImages(true)

        logStorage()
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, resultIntent: Intent?) {
        super.onActivityResult(requestCode, resultCode, resultIntent)
        when (requestCode) {
            REQUEST_CODE_READ -> {
                if (resultCode == Activity.RESULT_OK) {
                    val resultUri: Uri = resultIntent!!.data!!
                    val pickedFile: DocumentFile = DocumentFile.fromSingleUri(this, resultUri)!!
                    FileUtil.logDocumentFile(pickedFile)
                }
            }
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        super.onCreateOptionsMenu(menu)
        menuInflater.inflate(R.menu.menu_image, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean =
        when (item.itemId) {
            R.id.menu_setting -> {
                Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS)
                    .apply {
                        data = Uri.fromParts("package", packageName, null)
                    }.let {
                        startActivity(it)
                    }
                true
            }
            R.id.menu_picker_read -> {
                startActivityForResult(
                    Intent(Intent.ACTION_OPEN_DOCUMENT).apply {
                        type = FileUtil.MIME_IMAGE
                    },
                    REQUEST_CODE_READ
                )
                true
            }
            R.id.menu_picker_write -> {
                startActivity(Intent(Intent.ACTION_CREATE_DOCUMENT))
                true
            }
            else -> super.onOptionsItemSelected(item)
        }

    private fun loadImages(showLoading: Boolean = false) {
        if (showLoading)
            showLoading()
        repository.getImages()
            .subscribe(object : DisposableSingleObserver<List<PixabayImage>>() {
                override fun onSuccess(t: List<PixabayImage>) {
                    refreshLayout.isRefreshing = false
                    loading.visibility = View.GONE
                    adapter.items = t
                }

                override fun onError(e: Throwable) {
                    e.printStackTrace()
                }
            })
    }

    override fun showLoading() {
        loading.visibility = View.VISIBLE
    }

    override fun hideLoading() {
        loading.visibility = View.GONE
    }

    override fun getContext() = this

    override fun toast(message: String) {
        toast(message)
    }

    @SuppressLint("NewApi")
    private fun logStorage() {
        Log.d(BaseApplication.TAG, "internal dir path: ${filesDir.absolutePath}")
        Log.d(BaseApplication.TAG, "internal cache dir path: ${cacheDir.absolutePath}")
        Log.d(BaseApplication.TAG, "external dir path: ${getExternalFilesDir(null)?.absolutePath}")
        Log.d(BaseApplication.TAG, "external cache dir path: ${externalCacheDir?.absolutePath}")
        Log.d(
            BaseApplication.TAG,
            "Environment external dir path: ${Environment.getExternalStorageDirectory().absolutePath}"
        )
        Log.d(
            BaseApplication.TAG,
            "isExternalStorageLegacy: ${Environment.isExternalStorageLegacy()}"
        )
    }
}
