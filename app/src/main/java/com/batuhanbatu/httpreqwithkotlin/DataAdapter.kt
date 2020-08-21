package com.batuhanbatu.httpreqwithkotlin

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class DataAdapter(private var dataList: List<UserModel>) :
    RecyclerView.Adapter<DataAdapter.ViewHolder>() {

    class ViewHolder(itemLayoutView: View) : RecyclerView.ViewHolder(itemLayoutView) {
        var authornameTextView: TextView = itemLayoutView.findViewById(R.id.authorname)
        var nameTextView: TextView = itemLayoutView.findViewById(R.id.name)
        var priceTextView: TextView = itemLayoutView.findViewById(R.id.price)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.user_column_card, parent, false)
        )
    }

    override fun getItemCount(): Int {
        return dataList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val dataModel = dataList[position]
        holder.authornameTextView.text = dataModel.authorname
        holder.nameTextView.text = dataModel.name
        holder.priceTextView.text = dataModel.price
    }
}