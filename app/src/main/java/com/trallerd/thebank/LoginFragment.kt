package com.trallerd.thebank

import android.os.Bundle
import android.text.TextUtils
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.trallerd.thebank.adapters.AllAdapter
import kotlinx.android.synthetic.main.fragment_login.*

class LoginFragment : Fragment(), View.OnClickListener{
    var navController: NavController? = null
    lateinit var allAdapter: AllAdapter
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        allAdapter = AllAdapter(this.context)
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
            R.id.btLogin->{
                if (!TextUtils.isEmpty(userName.text.toString())||!TextUtils.isEmpty(password.text.toString())){
                    val login =  allAdapter.login(userName.text.toString(),password.text.toString())
                    if (login!=null){
                        val bundle = bundleOf("user" to login.username)
                        navController!!.navigate(R.id.loginToHome, bundle)
                    }else{
                        Toast.makeText(activity,R.string.user_error,Toast.LENGTH_SHORT).show()
                    }
                }else{
                    Toast.makeText(activity,R.string.field_message,Toast.LENGTH_SHORT).show()
                }

            }
            R.id.signin->navController!!.navigate(R.id.loginToSignIn)
        }
    }
}