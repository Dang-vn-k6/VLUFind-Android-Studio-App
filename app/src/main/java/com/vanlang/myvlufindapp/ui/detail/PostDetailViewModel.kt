package com.vanlang.myvlufindapp.ui.detail

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.vanlang.myvlufindapp.data.local.AppDatabase
import com.vanlang.myvlufindapp.data.model.Post
import com.vanlang.myvlufindapp.data.remote.RetrofitClient
import com.vanlang.myvlufindapp.data.repository.PostRepository

class PostDetailViewModel(application: Application) : AndroidViewModel(application) {

    private val repository = PostRepository(
        AppDatabase.getInstance(application).postDao(),
        RetrofitClient.postApi
    )

    fun getPost(id: Long): LiveData<Post?> = repository.getPostById(id)
}