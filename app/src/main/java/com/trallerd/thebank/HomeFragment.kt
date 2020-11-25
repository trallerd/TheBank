package com.trallerd.thebank

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.navigation.NavController
import androidx.navigation.Navigation

class HomeFragment : Fragment(), View.OnClickListener {
    var navController: NavController? = null
    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = Navigation.findNavController(view)
        view.findViewById<ImageView>(R.id.btnWallet).setOnClickListener(this)
        view.findViewById<ImageView>(R.id.btnExtract).setOnClickListener(this)
        view.findViewById<ImageView>(R.id.btnSenMoney).setOnClickListener(this)
        view.findViewById<ImageView>(R.id.btnReceiveMoney).setOnClickListener(this)
        view.findViewById<ImageView>(R.id.btnLogout).setOnClickListener(this)
    }
    override fun onClick(v: View?) {
        when(v!!.id){
            R.id.btnWallet->navController!!.navigate(R.id.homeToWallet)
            R.id.btnExtract->navController!!.navigate(R.id.homeToExtract)
            R.id.btnSenMoney->navController!!.navigate(R.id.homeToSendMOney)
            R.id.btnReceiveMoney->navController!!.navigate(R.id.homeToSendMOney)
            R.id.btnLogout->activity?.onBackPressed()
        }
    }
}