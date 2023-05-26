package com.example.imagedemo

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.GridLayoutManager
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit

object Repository {

    val photoList = MutableLiveData<ImagePhotos>()

    fun getRecentPhoto() : MutableLiveData<ImagePhotos> {
        val retrofit = RetrofitClient.getInstance()
        val apiInterface = retrofit.create(ApiInterface::class.java)
        try {
            apiInterface.getRecentPhoto().enqueue( object : Callback<ApiResponse> {
                override fun onResponse(call: Call<ApiResponse>, response: Response<ApiResponse>) {
                    if (response.isSuccessful){
                        Log.d("Photo", "Successful" + response.body().toString())
                        val list = response.body()!!.photos.photoList
                        photoList.value = ImagePhotos(list)
                    }else{
                        Log.d("Photo", response.errorBody().toString())
                    }
                }

                override fun onFailure(call: Call<ApiResponse>, t: Throwable) {
                    Log.d("Photo Failure", t.message.toString())
                }

            })
        }catch (Ex: Exception){
            Log.e("Error", Ex.localizedMessage!!)
        }
        return photoList
    }

}