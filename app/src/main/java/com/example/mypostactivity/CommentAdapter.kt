package com.example.mypostactivity

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

import com.example.mypostactivity.databinding.CommentListItemBinding

class CommentAdapter (
    var CommentList:List<Comment>):RecyclerView.Adapter<CommentViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CommentViewHolder {
        var bindingView =
            CommentListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CommentViewHolder(bindingView)


    }

    override fun onBindViewHolder(holder: CommentViewHolder, position: Int) {
        var CurrentItem = CommentList.get(position)
        with(holder.bindingView) {
            tvid.text = CurrentItem.id.toString()
            tvBody.text = CurrentItem.body
            tvTitle.text = CurrentItem.title
        }

    }


    override fun getItemCount(): Int {
        return CommentList.size


    }

}
class CommentViewHolder(var bindingView: CommentListItemBinding):
        RecyclerView.ViewHolder(bindingView.root)