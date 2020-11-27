package com.trallerd.thebank

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.trallerd.thebank.adapters.AllAdapter
import com.trallerd.thebank.models.Money
import kotlinx.android.synthetic.main.fragment_confirmation.*
import kotlin.properties.Delegates

class ConfirmationFragment : Fragment(), View.OnClickListener{
    var navController: NavController? = null
    lateinit var allAdapter: AllAdapter
    lateinit var date: String
    var flag by Delegates.notNull<Boolean>()
    lateinit var amount: Money
    lateinit var name: String
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        date = arguments?.getString("date").toString()
        amount = requireArguments().getParcelable("amount")!!
        name = arguments?.getString("sendTo")!!
        flag = arguments?.getBoolean("flag")!!
        allAdapter = AllAdapter(this.context)
        return inflater.inflate(R.layout.fragment_confirmation, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = Navigation.findNavController(view)
        val date = getString(R.string.info_str,date)
        val amount = getString(R.string.info_doub,amount)
        val sendTo = getString(R.string.info_str,name)
        confirmaDate.text = date

    }

    override fun onClick(v: View?) {
    }
}