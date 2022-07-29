package com.example.mypostactivity

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.mypostactivity.databinding.RetrofitPostItemBinding

class PostRvAdapter (var context:Context, var postList: List<Post>)
: RecyclerView.Adapter<RetrofitViewHolder> (){
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RetrofitViewHolder {
                var bindingView = RetrofitPostItemBinding
                        .inflate(LayoutInflater.from(context),parent,false)
                return  RetrofitViewHolder(bindingView)
        }

        override fun onBindViewHolder(holder: RetrofitViewHolder, position: Int) {
                var currentItem = postList.get(position)

                with(holder.bindingView){
                        tvuserId.text = currentItem.userId.toString()
                        tvId.text = currentItem.id.toString()
                        tvtitle.text = currentItem.title
                        tvbody.text= currentItem.body
                }
        }

        override fun getItemCount(): Int {
                return postList.size
        }
}

class RetrofitViewHolder(var bindingView: RetrofitPostItemBinding):
        RecyclerView.ViewHolder(bindingView.root)




