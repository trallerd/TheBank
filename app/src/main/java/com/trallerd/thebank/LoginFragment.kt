package com.trallerd.thebank

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.navigation.NavController
import androidx.navigation.Navigation

class LoginFragment : Fragment(), View.OnClickListener{
    var navController: NavController? = null
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_login, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = Navigation.findNavController(view)
        view.findViewById<Button>(R.id.btLogin).setOnClickListener(this)
        view.findViewById<TextView>(R.id.signin).setOnClickListener(this)
    }
    override fun onClick(v: View?) {
        when(v!!.id){
            R.id.btLogin->navController!!.navigate(R.id.loginToHome)
            R.id.signin->navController!!.navigate(R.id.loginToSignIn)
        }
    }
}