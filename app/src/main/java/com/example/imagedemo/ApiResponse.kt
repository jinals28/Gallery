package com.example.imagedemo

import com.google.gson.annotations.SerializedName

data class ApiResponse(
    @SerializedName("photos")
    var photos: photos,
    @SerializedName("stat")
    var stat : String
)
