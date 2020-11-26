package com.trallerd.thebank.adapters

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.trallerd.thebank.R
import com.trallerd.thebank.models.Records
import kotlinx.android.synthetic.main.item_records.view.*


class RecordsAdapter : RecyclerView.Adapter<RecordsAdapter.RecorsHolder>() {
    private val records = Records.getALL()
    override fun getItemCount() = records.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        RecorsHolder(
                LayoutInflater
                        .from(parent.context)
                        .inflate(R.layout.item_records, parent, false)
        )

    override fun onBindViewHolder(holder: RecorsHolder, position: Int) {
        Log.i("","records")
        val record = records[position]
        holder.fillView(record)
    }

    class RecorsHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        fun fillView(record: Records){
            itemView.lbPerson.text = record.person
            itemView.lbRemarks.text = record.remarks
            itemView.lbInfoAmount.text = record.value.toString()
            itemView.lbDateInfo.text = record.registredAt.toString()
        }
    }



}