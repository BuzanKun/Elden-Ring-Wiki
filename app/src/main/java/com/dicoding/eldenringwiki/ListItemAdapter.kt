package com.dicoding.eldenringwiki

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.dicoding.eldenringwiki.databinding.ItemRowRemembrancesBinding

class ListItemAdapter (private val listRemembrances: ArrayList<Remembrances>) : RecyclerView.Adapter<ListItemAdapter.ListViewHolder>() {
    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ListViewHolder {
        val binding = ItemRowRemembrancesBinding.inflate(LayoutInflater.from(viewGroup.context), viewGroup, false)
        return ListViewHolder(binding)
    }

    override fun getItemCount(): Int = listRemembrances.size

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val remembrance = listRemembrances[position]
        holder.binding.imgItemImage.setImageResource(remembrance.image)
        holder.binding.tvItemName.text = remembrance.name
        holder.binding.tvItemDescription.text = remembrance.description

        holder.itemView.setOnClickListener {
            val intentDetail = Intent(holder.itemView.context, DetailActivity::class.java)
            intentDetail.putExtra("key_remembrance",listRemembrances[holder.adapterPosition])
            holder.itemView.context.startActivity(intentDetail)
        }
    }

    class ListViewHolder(var binding: ItemRowRemembrancesBinding) : RecyclerView.ViewHolder(binding.root)
}
