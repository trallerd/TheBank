package com.trallerd.thebank.adapters

import android.content.Context
import android.graphics.Color
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.room.Room
import com.trallerd.thebank.R
import com.trallerd.thebank.database.AppDatabase
import com.trallerd.thebank.database.Controller
import com.trallerd.thebank.database.daos.RecordsDAO
import com.trallerd.thebank.database.daos.UsersDAO
import com.trallerd.thebank.models.Records
import com.trallerd.thebank.models.Users
import kotlinx.android.synthetic.main.item_records.view.*
import kotlinx.android.synthetic.main.item_records_edit.view.*


class AllAdapter(context: Context?) : RecyclerView.Adapter<AllAdapter.RecorsHolder>() {
    private val daoRecords: RecordsDAO
    private val daoUsers: UsersDAO
    private var recordEdit: Records? = null
    private var records: List<Records>

    init {
        //Create db instance
        val db = Room.databaseBuilder(
                context!!,
                AppDatabase::class.java,
                "theBank-db"
        )
                .allowMainThreadQueries()
                .build()
        //Get DAO
        daoRecords = db.recordDAO()
        daoUsers = db.userDAO()
        //Get all Records
        if (Controller.users.id != null) {
            records = Controller.users.id?.let { daoRecords.getAllById(it) }!!
        } else {
            records = emptyList()
        }
    }

    fun add(user: Users) {
        user.id = daoUsers.insert(user)
    }

    fun login(username: String, password: String): Users {
        val user = daoUsers.getUser(username, password)
        if (user != null) {
            Controller.users = user
        }
        return user
    }


    fun getIncomes(idUser: Long) = daoRecords.getWallet(idUser, 1)

    fun getSpent(idUser: Long) = daoRecords.getWallet(idUser, 0)

    fun insertRecord(record: Records) = daoRecords.insert(record)


    fun edit(record: Records) {
        recordEdit = record
        val position = records.indexOf(record)
        notifyItemChanged(position,record)
    }

    fun saveRec(record: Records){
        daoRecords.update(record)
        val position = records.indexOf(record)
        recordEdit = null
        notifyItemChanged(position)
    }
    override fun getItemCount(): Int {
        return records.size
    }


    override fun getItemViewType(position: Int): Int {
        val records = records[position]
        return if (records == recordEdit) {
            R.layout.item_records_edit

        } else {
            R.layout.item_records
        }
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
            RecorsHolder(
                    LayoutInflater
                            .from(parent.context)
                            .inflate(viewType, parent, true)
            )

    override fun onBindViewHolder(holder: RecorsHolder, position: Int) {
        val record = records[position]
        holder.fillView(record)
    }

    inner class RecorsHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun fillView(record: Records) {
            if (record.receive) {
                if (record == recordEdit) {
                    itemView.editRecipient.text = record.person
                    itemView.editRemarks.setText(record.remarks)
                    itemView.editAmount.setTextColor(Color.parseColor("#008000"))
                    itemView.editAmount.text = "+" + record.value.toString()
                    itemView.editDate.text = record.registredAt
                    itemView.okEdit.setOnClickListener {
                        record.remarks = itemView.editRemarks.text.toString()
                        saveRec(record)
                    }

                } else {
                    itemView.lbPerson.text = record.person
                    itemView.lbRemarks.text = record.remarks
                    itemView.lbInfoAmount.setTextColor(Color.parseColor("#008000"))
                    itemView.lbInfoAmount.text = "+" + record.value.toString()
                    itemView.lbDateInfo.text = record.registredAt
                }
            } else {
                if (record == recordEdit) {
                    itemView.editRecipient.text = record.person
                    itemView.editRemarks.setText(record.remarks)
                    itemView.editAmount.setTextColor(Color.parseColor("#ff0000"))
                    itemView.editAmount.text = "+" + record.value.toString()
                    itemView.editDate.text = record.registredAt
                    itemView.okEdit.setOnClickListener {
                        record.remarks = itemView.editRemarks.text.toString()
                        saveRec(record)
                    }
                } else {
                    itemView.lbPerson.text = record.person
                    itemView.lbRemarks.text = record.remarks
                    itemView.lbInfoAmount.setTextColor(Color.parseColor("#ff0000"))
                    itemView.lbInfoAmount.text = "-" + record.value.toString()
                    itemView.lbDateInfo.text = record.registredAt
                }

            }

            itemView.setOnClickListener {
                edit(record)
            }
        }
    }


}