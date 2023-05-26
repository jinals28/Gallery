package com.example.imagedemo

import com.google.gson.annotations.SerializedName

data class photos(
    @SerializedName("page")
    var page: Int,
    @SerializedName("pages")
    var pages : Int,
    @SerializedName("per_page")
    var per_page : Int,
    @SerializedName("total")
    var total : Int,
    @SerializedName("photo")
    var photoList: ArrayList<Photo>,

)
