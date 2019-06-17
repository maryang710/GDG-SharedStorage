package com.maryang.storage.data.mapper

import com.google.gson.JsonElement
import com.maryang.storage.entity.model.PixabayImage

class PixabayMapper {

    fun parseGetImages(json: JsonElement): List<PixabayImage> =
        json.asJsonObject.get("hits").asJsonArray.map {
            it.asJsonObject.run {
                PixabayImage(
                    get("id").asLong,
                    get("previewURL").asString,
                    get("largeImageURL").asString
                )
            }
        }.toList()
}
