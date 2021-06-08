package com.mahdikaseatashin.gpa.adapter

import android.view.GestureDetector
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.mahdikaseatashin.gpa.databinding.NodeItemBinding
import com.mahdikaseatashin.gpa.models.NodeModel


class NodesAdapter : RecyclerView.Adapter<NodesAdapter.MainViewHolder>() {

    var nodeList = mutableListOf<NodeModel>()

    fun setNodes(nodes: List<NodeModel>) {
        this.nodeList = nodes.toMutableList()
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = NodeItemBinding.inflate(inflater, parent, false)
        return MainViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        val node = nodeList[position]
        holder.binding.tvNodeId.text = node.name
        Glide.with(holder.itemView.context).load(node.owner.avatar_url)
            .into(holder.binding.ivNodeImage)
    }

    override fun getItemCount(): Int = nodeList.size

    inner class MainViewHolder(val binding: NodeItemBinding) : RecyclerView.ViewHolder(binding.root)

}
