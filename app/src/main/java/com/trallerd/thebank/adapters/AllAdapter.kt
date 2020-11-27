package com.trallerd.thebank.adapters

import android.content.Context
import android.graphics.Color
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


class AllAdapter(context: Context?) : RecyclerView.Adapter<AllAdapter.RecorsHolder>() {
    private val daoRecords: RecordsDAO
    private val daoUsers: UsersDAO

    private val records: MutableList<Records>

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

        if (Controller.users.id!=null){
            records = Controller.users.id?.let { daoRecords.getAllById(it).toMutableList() }!!
        }else{
            records = daoRecords.getAll().toMutableList()
        }
    }

    fun add(user: Users){

        user.id = daoUsers.insert(user)
    }

    fun login(username: String, password: String):Users {
        val user = daoUsers.getUser(username,password)
        if (user!=null){
            Controller.users = user
        }
        return user
    }


    fun getIncomes(idUser: Long) = daoRecords.getWallet(idUser,1)

    fun getSpent(idUser: Long) = daoRecords.getWallet(idUser,0)

    fun insertRecord(record: Records) = daoRecords.insert(record)


    override fun getItemCount() = records.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        RecorsHolder(
                LayoutInflater
                        .from(parent.context)
                        .inflate(R.layout.item_records, parent, false)
        )

    override fun onBindViewHolder(holder: RecorsHolder, position: Int) {
        val record = records[position]
        holder.fillView(record)
    }

    inner class RecorsHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        fun fillView(record: Records){
            if (record.receive){
                itemView.lbPerson.text = record.person
                itemView.lbRemarks.text = record.remarks
                itemView.lbInfoAmount.setTextColor(Color.parseColor("#008000"))
                itemView.lbInfoAmount.text = "+"+record.value.toString()
                itemView.lbDateInfo.text = record.registredAt
            }else{
                itemView.lbPerson.text = record.person
                itemView.lbRemarks.text = record.remarks
                itemView.lbInfoAmount.setTextColor(Color.parseColor("#ff0000"))
                itemView.lbInfoAmount.text = "-"+record.value.toString()
                itemView.lbDateInfo.text = record.registredAt
            }

            itemView.setOnLongClickListener {
                val position = records.indexOf(record)


                notifyItemChanged(position)

                true
            }
        }
    }



}