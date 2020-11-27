package com.trallerd.thebank

import android.os.Bundle
import android.text.TextUtils
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.trallerd.thebank.adapters.AllAdapter
import com.trallerd.thebank.database.Controller
import com.trallerd.thebank.models.Money
import com.trallerd.thebank.models.Records
import kotlinx.android.synthetic.main.fragment_send_money.*
import java.math.BigDecimal
import kotlin.properties.Delegates

class SendMoneyFragment : Fragment(), View.OnClickListener {
    var navController: NavController? = null
    lateinit var allAdapter: AllAdapter
    var flag by Delegates.notNull<Boolean>()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        flag = arguments?.getBoolean("flag")!!
        allAdapter = AllAdapter(this.context)
        return inflater.inflate(R.layout.fragment_send_money, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = Navigation.findNavController(view)
        if (flag){
            txtSendorRec.text = getString(R.string.receive_text_question)
            recipientAnswer.hint = getString(R.string.receive_from)
            btnSend.text = getString(R.string.receive_money)
        }
        view.findViewById<Button>(R.id.btnSend).setOnClickListener(this)
        view.findViewById<Button>(R.id.btnCancel).setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when(v!!.id){
            R.id.btnSend->{
                if(!TextUtils.isEmpty(amountAnswer.text.toString())||!TextUtils.isEmpty(recipientAnswer.text.toString())){
                    val person = recipientAnswer.text.toString()
                    val value = amountAnswer.text.toString().toDouble()
                    val remarks = ""
                    val fk = Controller.users.id
                    if(flag){
                        val received = true
                        val record = Records(value,person,remarks,received,fk)
                        allAdapter.insertRecord(record)
                        val bundle = bundleOf(
                            "date" to record.registredAt,
                            "amount" to value,
                            "sendTo" to person,
                            "flag" to flag
                        )
                        navController!!.navigate(R.id.sendToConfirmatio, bundle)
                    }else{
                        val received = false
                        val record = Records(value,person,remarks,received,fk)
                        allAdapter.insertRecord(record)
                        val bundle = bundleOf(
                            "date" to record.registredAt,
                            "amount" to value,
                            "sendTo" to person,
                            "flag" to flag
                        )
                        navController!!.navigate(R.id.sendToConfirmatio,bundle)
                    }

                }else{
                    Toast.makeText(activity,R.string.field_message,Toast.LENGTH_SHORT).show()
                }
            }
            R.id.btnCancel->activity?.onBackPressed()
        }
    }
}