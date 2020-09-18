package com.androidtest.wymo.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.androidtest.wymo.R
import com.androidtest.wymo.model.Data
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.rv_bank_item_list.view.*

class BankListAdapter(private val bankList: ArrayList<Data>, private val itemClickListener: ItemClickListener) : RecyclerView.Adapter<BankListAdapter.BankViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BankViewHolder {
        return BankViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.rv_bank_item_list,parent,false))
    }

    override fun onBindViewHolder(holder: BankViewHolder, position: Int) {
        holder.bind(bankList[position])
    }

    override fun getItemCount(): Int = bankList.size

    inner class BankViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(bankData: Data) {
            var context = itemView.context

            //item data set up
            itemView.tv_bank_name.text = bankData.name
            itemView.tv_type.text = bankData.type

            //image loading
            if(!bankData.logoUrl.isNullOrEmpty())
                Glide.with(context).load(bankData.logoUrl).into(itemView.iv_bank)

            itemView.layout_item.setOnClickListener {
                itemClickListener.onItemClick(adapterPosition,bankData)
            }
        }
    }

    interface ItemClickListener {
        fun onItemClick(position: Int,data: Data)
    }
}