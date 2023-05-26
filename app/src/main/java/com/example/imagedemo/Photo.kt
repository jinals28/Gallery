package com.example.imagedemo

import com.google.gson.annotations.SerializedName

data class Photo(
    @SerializedName("id")
    var id : String,
    @SerializedName("title")
    var title : String,
    @SerializedName("url_s")
    var url_s : String
)
