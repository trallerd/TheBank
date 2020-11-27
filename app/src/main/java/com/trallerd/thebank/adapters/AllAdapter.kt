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
import com.trallerd.thebank.database.daos.AccountsDAO
import com.trallerd.thebank.database.daos.RecordsDAO
import com.trallerd.thebank.database.daos.UsersDAO
import com.trallerd.thebank.models.Accounts
import com.trallerd.thebank.models.Records
import com.trallerd.thebank.models.Users
import kotlinx.android.synthetic.main.item_records.view.*


class AllAdapter(context: Context?) : RecyclerView.Adapter<AllAdapter.RecorsHolder>() {
    private val daoRecords: RecordsDAO
    private val daoUsers: UsersDAO
    private val daoAccounts: AccountsDAO

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
        daoAccounts = db.accountDAO()

        //Get all Records
        records = daoRecords.getAllById(1).toMutableList()

    }

    fun add(user: Users){

        user.id = daoUsers.insert(user)
        val account = Accounts(0.0, user.id!!)
        account.id = daoAccounts.insert(account)
    }

    fun login(username: String, password: String) = daoUsers.getUser(username,password)

    fun getBalance(idUser: Long) = daoAccounts.getBalance(idUser)

    fun getIncomes(idUser: Long) = daoRecords.getIncomes(idUser)

    fun getSpent(idUser: Long) = daoRecords.getSpent(idUser)


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
                itemView.lbInfoAmount.setTextColor(Color.parseColor(R.color.green.toString()))
                itemView.lbInfoAmount.text = "+"+record.value.toString()
                itemView.lbDateInfo.text = record.registredAt
            }else{
                itemView.lbPerson.text = record.person
                itemView.lbRemarks.text = record.remarks
                itemView.lbInfoAmount.setTextColor(Color.parseColor(R.color.red.toString()))
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