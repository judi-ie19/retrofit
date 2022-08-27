package com.example.mypostactivity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mypostactivity.databinding.ActivityCommentBinding
import org.w3c.dom.Comment
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class commentActivity : AppCompatActivity() {
    lateinit var binding: ActivityCommentBinding
    var postId=0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityCommentBinding.inflate(layoutInflater)
        setContentView(binding.root)
        obtainPostId()
        fetchPostById()
        fetchComment()

    }
    fun obtainPostId(){
        postId=intent.extras?.getInt("POST_ID")?:0
    }
    fun fetchPostById(){
        var apiClient=ApiClient.buildApiClient((ApiInterface::class.java))
        var request=apiClient.getPostById(postId)
        request.enqueue(object:Callback<Post>{
            override fun onResponse(call: Call<Post>, response: Response<Post>) {
                if (response.isSuccessful){
                    var post=response.body()
                    binding.tvPosttitle.text=post?.title
                    binding.tvPostbody.text=post?.body
                }
            }

            override fun onFailure(call: Call<Post>, t: Throwable) {
                Toast.makeText(baseContext,t.message,Toast.LENGTH_LONG).show()
            }


        })
    }

    }
}
fun fetchComment(){
    var apiClient=ApiClient.buildApiClient((ApiInterface::class.java))
    var request=apiClient.getComment()
    request.enqueue(object :Callback<List<Comment>> {
        override fun onResponse(call: Call<List<Comment>>, response: Response<List<Comment>>) {
            if (response.isSuccessful){
                var Comment=response.body()?: emptyList()
                displayComment(Comment)
            }

        }

        override fun onFailure(call: Call<List<Comment>>, t: Throwable) {
            Toast.makeText(baseContext,t.message,Toast.LENGTH_LONG).show()

        }

    })

}
fun displayComment(commentList: List<Comment>) {
    val commentAdapter = CommentAdapter(commentList)
    binding.rvretrofits.layoutManager = LinearLayoutManager(this)
    binding.rvretofit.adapter=commentAdapter


}
