package com.maryang.storage.util

import android.graphics.Bitmap
import android.graphics.drawable.Drawable
import com.bumptech.glide.Glide
import com.bumptech.glide.request.target.CustomTarget
import com.bumptech.glide.request.transition.Transition
import com.maryang.storage.base.BaseApplication
import io.reactivex.Single
import io.reactivex.SingleOnSubscribe
import io.reactivex.schedulers.Schedulers

object ImageUtil {

    fun withJpg(name: String) = "$name.jpg"

    fun save(url: String, name: String) =
        Single.create(SingleOnSubscribe<String> {
            Glide.with(BaseApplication.appContext).asBitmap()
                .load(url)
                .into(object : CustomTarget<Bitmap>() {
                    override fun onResourceReady(resource: Bitmap, transition: Transition<in Bitmap>?) {
                        it.onSuccess(FileUtil.saveBitmapQ(resource, name))
                    }

                    override fun onLoadCleared(placeholder: Drawable?) {
                    }
                })
        }).subscribeOn(Schedulers.io())
}
