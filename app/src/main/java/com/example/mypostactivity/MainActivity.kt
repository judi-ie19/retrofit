package com.example.mypostactivity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mypostactivity.databinding.ActivityMainBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
      fetchPosts()
    }
    fun fetchPosts(){
        var apiClient=ApiClient.buildApiClient(ApiInterface::class.java)
        var request=apiClient.getPost()
        request.enqueue(object :Callback<List<Post>> {
            override fun onResponse(call: Call<List<Post>>, response: Response<List<Post>>) {
                if (response.isSuccessful) {
                    var post = response.body()
                    Toast.makeText(baseContext, "fetched ${post!!.size} posts", Toast.LENGTH_LONG)
                        .show()
                    var adapter=PostRvAdapter(post)
                    binding.rvretrofit.layoutManager=LinearLayoutManager(baseContext)
                    binding.rvretrofit.adapter=adapter

                }

            }

            override fun onFailure(call: Call<List<Post>>,t: Throwable) {

            }


        })
    }
}




