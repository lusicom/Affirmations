package com.example.affirmations.adapter

import android.content.Context
import android.os.Build
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.recyclerview.widget.RecyclerView
import com.example.affirmations.R
import com.example.affirmations.model.Affirmation
import com.google.android.material.card.MaterialCardView

class ItemAdapter(
        private val context: Context,
        private val DataSet: List<Affirmation>
) : RecyclerView.Adapter<ItemViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val adapterLayout = LayoutInflater.from(parent.context)
                .inflate(R.layout.list_item, parent, false)

        return ItemViewHolder(adapterLayout)
    }


    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val item = DataSet[position]
        holder.textView.text = context.resources.getString(item.stringResourceId)
        holder.imageView.setImageResource(item.imageResourceId)

       if(position % 2 == 0){
           holder.cardView.background = context.getDrawable(R.color.blue_200)
       }
        else {
           holder.cardView.background = context.getDrawable(R.color.light_blue_50)
        }
    }


    override fun getItemCount() = DataSet.size
}

class ItemViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {
    val textView: TextView = view.findViewById(R.id.item_tv)
    val imageView: ImageView = view.findViewById(R.id.item_iv)
    val cardView: MaterialCardView = view.findViewById(R.id.root_view)
}
