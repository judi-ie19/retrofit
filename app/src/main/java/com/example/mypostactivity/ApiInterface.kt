package com.example.mypostactivity

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiInterface {
    @GET("/posts")
    fun getPost(): Call<List<Post>>

    @GET("/posts/{postId}")
    fun getPostById(@Path("postId")postId:Int):Call<Post>
    @GET("comments")
    fun getComment():Call<List<Comment>>


}