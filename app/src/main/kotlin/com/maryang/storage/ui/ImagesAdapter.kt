package com.maryang.storage.ui

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.maryang.storage.R
import com.maryang.storage.base.ActivityContext
import com.maryang.storage.entity.model.PixabayImage
import com.maryang.storage.util.FileUtil
import com.maryang.storage.util.ImageUtil
import io.reactivex.observers.DisposableSingleObserver
import kotlinx.android.synthetic.main.item_image.view.*
import org.jetbrains.anko.selector
import org.jetbrains.anko.toast

class ImagesAdapter(
    private val activityContext: ActivityContext
) : RecyclerView.Adapter<ImagesAdapter.ImageViewHolder>() {

    var items: List<PixabayImage> = emptyList()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageViewHolder =
        ImageViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.item_image, parent, false),
            activityContext
        )

    override fun onBindViewHolder(holder: ImageViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount(): Int = items.size

    class ImageViewHolder(
        view: View,
        private val activityContext: ActivityContext
    ) : RecyclerView.ViewHolder(view) {

        fun bind(image: PixabayImage) {
            with(itemView) {
                Glide.with(context)
                    .load(image.previewUrl)
                    .centerCrop()
                    .into(imageView)
                imageView.setOnClickListener {
                    context.selector(null, listOf("파일경로 보기", "저장하기")) { _, i ->
                        when (i) {
                            0 -> showFilePath(context, image)
                            1 -> save(context, image)
                        }
                    }
                }
            }
        }

        private fun showFilePath(context: Context, image: PixabayImage) {
            FileUtil.getFilePathQ(
                ImageUtil.withJpg(image.id.toString()),
                activityContext.getContext()
            ).let {
                if (it.isNotEmpty())
                    context.toast("'$it'에 파일이 있습니다")
                else
                    context.toast("파일이 없습니다")
            }
        }

        private fun save(context: Context, image: PixabayImage) {
            activityContext.showLoading()
            ImageUtil.save(image.imageUrl, image.id.toString())
                .subscribe(object : DisposableSingleObserver<String>() {
                    override fun onSuccess(t: String) {
                        activityContext.hideLoading()
                        context.toast("'$t'에 파일을 저장하였습니다")
                    }

                    override fun onError(e: Throwable) {
                    }
                })
        }
    }
}
