package com.maryang.storage.data.repository

import com.maryang.storage.data.mapper.PixabayMapper
import com.maryang.storage.data.source.ApiManager
import com.maryang.storage.entity.model.PixabayImage
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class PixabayRepository {

    private val api = ApiManager.pixabayApi
    private val mapper = PixabayMapper()

    fun getImages(): Single<List<PixabayImage>> =
        api.getImages()
            .subscribeOn(Schedulers.io())
            .map { mapper.parseGetImages(it) }
            .observeOn(AndroidSchedulers.mainThread())
}
