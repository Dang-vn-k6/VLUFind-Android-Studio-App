package com.vanlang.myvlufindapp.ui.home

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.vanlang.myvlufindapp.data.local.AppDatabase
import com.vanlang.myvlufindapp.data.model.Post
import com.vanlang.myvlufindapp.data.repository.PostRepository
import kotlinx.coroutines.launch

class HomeViewModel(application: Application) : AndroidViewModel(application) {

    private val repository: PostRepository
    val posts: LiveData<List<Post>>

    init {
        val dao = AppDatabase.getInstance(application).postDao()
        repository = PostRepository(dao)
        posts = repository.allPosts
        viewModelScope.launch { repository.seedIfEmpty() }
    }
}