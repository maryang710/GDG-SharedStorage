package com.maryang.storage.data.source

import com.google.gson.JsonElement
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

private const val API_KEY = "10083483-85b56530356af862b5cbcc3e7"

interface PixabayApi {

    @GET(".")
    fun getImages(
        @Query("key") key: String = API_KEY,
        @Query("image_type") imageType: String = "photo"
    ): Single<JsonElement>
}
