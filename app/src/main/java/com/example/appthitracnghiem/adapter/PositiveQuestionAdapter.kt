package com.example.appthitracnghiem.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.appthitracnghiem.R
import com.example.appthitracnghiem.model.PositiveQuestion

class PositiveQuestionAdapter(val listPossitive : List<PositiveQuestion>,val context: Context) : RecyclerView.Adapter<PositiveQuestionAdapter.PositiveViewHolder>() {
    class PositiveViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var txtPositive : TextView = itemView.findViewById(R.id.txtPositive)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PositiveViewHolder {
        var itemView = LayoutInflater.from(parent.context).inflate(R.layout.layout_position_question,parent,false)
        return PositiveViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: PositiveViewHolder, position: Int) {
        var positiveQuestion : PositiveQuestion = listPossitive[position]
        holder.txtPositive.text = positiveQuestion.number.toString()
    }

    override fun getItemCount(): Int {
        return listPossitive.size
    }
}