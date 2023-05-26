package com.example.imagedemo

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor() : ViewModel() {

    private var _photoList = MutableLiveData<ImagePhotos>()
    val photoList : LiveData<ImagePhotos> = _photoList


    fun getRecentPhoto() : LiveData<ImagePhotos> {
        _photoList = Repository.getRecentPhoto()
        return _photoList
    }

}