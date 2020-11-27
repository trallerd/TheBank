package com.trallerd.thebank

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.os.bundleOf
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.trallerd.thebank.adapters.AllAdapter
import com.trallerd.thebank.database.Controller

class HomeFragment : Fragment(), View.OnClickListener {
    var navController: NavController? = null
    lateinit var user: String
    lateinit var allAdapter: AllAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        user = arguments?.getString("user").toString()
    }

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        allAdapter = AllAdapter(this.context)
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = Navigation.findNavController(view)
        val name = user
        val welcome = getString(R.string.welcome_text,name)
        view.findViewById<TextView>(R.id.welcomeText).text = welcome
        view.findViewById<ImageView>(R.id.btnWallet).setOnClickListener(this)
        view.findViewById<ImageView>(R.id.btnExtract).setOnClickListener(this)
        view.findViewById<ImageView>(R.id.btnSenMoney).setOnClickListener(this)
        view.findViewById<ImageView>(R.id.btnReceiveMoney).setOnClickListener(this)
        view.findViewById<ImageView>(R.id.btnLogout).setOnClickListener(this)
    }
    fun walletStatus(): Bundle {
        val income = allAdapter.getIncomes(Controller.users.id!!).toFloat()
        val spent = allAdapter.getSpent(Controller.users.id!!).toFloat()
        val money = income-spent

        val bundle = bundleOf(
                "money" to money,
                "income" to income,
                "spent" to spent
        )
        return bundle
    }

    override fun onClick(v: View?) {
        when(v!!.id){
            R.id.btnWallet->{
                val bundle = walletStatus()
                navController!!.navigate(R.id.homeToWallet,bundle)
            }
            R.id.btnExtract->navController!!.navigate(R.id.homeToExtract)
            R.id.btnSenMoney->{
                val income = allAdapter.getIncomes(Controller.users.id!!).toFloat()
                val spent = allAdapter.getSpent(Controller.users.id!!).toFloat()
                val money = income-spent
                val flag = false
                val bun = bundleOf(
                        "flag" to flag,
                        "money" to money
                )
                navController!!.navigate(R.id.homeToSendMOney,bun)
            }
            R.id.btnReceiveMoney->{
                val income = allAdapter.getIncomes(Controller.users.id!!).toFloat()
                val spent = allAdapter.getSpent(Controller.users.id!!).toFloat()
                val money = income-spent
                val flag = true
                val bun = bundleOf(
                        "flag" to flag,
                        "money" to money
                )
                navController!!.navigate(R.id.homeToSendMOney,bun)
            }
            R.id.btnLogout->{
                Controller.users.password = ""
                Controller.users.username = ""
                Controller.users.id = null
                activity?.onBackPressed()
            }
        }
    }
}