package com.trallerd.thebank

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button

import androidx.navigation.NavController
import androidx.navigation.Navigation

class MainFragment : Fragment(), View.OnClickListener {
    var navController : NavController? = null
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = Navigation.findNavController(view)
        view.findViewById<Button>(R.id.btLoginBank).setOnClickListener(this)
        view.findViewById<Button>(R.id.btSignInBank).setOnClickListener(this)
    }

    override fun onClick(v: View){
        when(v.id){
            R.id.btLoginBank->navController!!.navigate(R.id.mainToLogin)
            R.id.btSignInBank->navController!!.navigate(R.id.mainToSignIn)
        }
    }
}