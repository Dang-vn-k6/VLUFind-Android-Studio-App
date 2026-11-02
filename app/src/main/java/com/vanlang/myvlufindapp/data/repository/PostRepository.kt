package com.vanlang.myvlufindapp.data.repository

import androidx.lifecycle.LiveData
import com.vanlang.myvlufindapp.data.local.PostDao
import com.vanlang.myvlufindapp.data.local.SampleData
import com.vanlang.myvlufindapp.data.model.Post
import com.vanlang.myvlufindapp.data.model.PostStatus
import com.vanlang.myvlufindapp.data.model.PostType

class PostRepository(private val postDao: PostDao) {

    val allPosts: LiveData<List<Post>> = postDao.getAllPosts()

    fun getPostsByType(type: PostType): LiveData<List<Post>> = postDao.getPostsByType(type)

    fun getPostById(id: Long): LiveData<Post?> = postDao.getPostById(id)

    fun searchPosts(keyword: String): LiveData<List<Post>> = postDao.searchPosts(keyword)

    suspend fun insert(post: Post): Long = postDao.insert(post)

    suspend fun update(post: Post) = postDao.update(post)

    suspend fun delete(post: Post) = postDao.delete(post)

    suspend fun updateStatus(id: Long, status: PostStatus) = postDao.updateStatus(id, status)

    suspend fun seedIfEmpty() {
        if (postDao.count() == 0) {
            postDao.insertAll(SampleData.posts)
        }
    }
}