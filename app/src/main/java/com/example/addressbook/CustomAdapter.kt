package com.example.addressbook

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class CustomAdapter(private val context: Context) : RecyclerView.Adapter<ItemViewHolder>(){

    var dataList = mutableListOf<Address>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.item_recycler, parent, false)
        return ItemViewHolder(view)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        holder.bind(dataList[position], context)
    }

    override fun getItemCount(): Int {
        return dataList.size
    }

}

class ItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    private val textName = itemView.findViewById<TextView>(R.id.textName)
    private val textTel = itemView.findViewById<TextView>(R.id.textTel)
    private val textAddress = itemView.findViewById<TextView>(R.id.textAddress)
    private val textEmail = itemView.findViewById<TextView>(R.id.textEmail)

    fun bind(address:Address, context: Context){
        textName.text = address.name
        textTel.text = address.tel
        textAddress.text = address.address
        textEmail.text = address.email

        itemView.setOnClickListener{


            Intent(context, ProfileDetailActivity::class.java).apply {


                putExtra("data", address)

                addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            }.run { context.startActivity(this) }

        }


    }
}