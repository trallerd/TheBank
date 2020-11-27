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
import com.trallerd.thebank.models.Money

class WalletFragment : Fragment(), View.OnClickListener {
    var navController: NavController? = null
    lateinit var money: Money
    lateinit var income: Money
    lateinit var spent: Money

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        money = requireArguments().getParcelable("money")!!
        income = requireArguments().getParcelable("income")!!
        spent = requireArguments().getParcelable("spent")!!
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_wallet, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val money = money.amount
        val income = income.amount
        val spent = spent.amount
        val balance = getString(R.string.info_doub,money)
        val infoIncome = getString(R.string.info_doub,income)
        val infoSpent = getString(R.string.info_doub,spent)

        navController = Navigation.findNavController(view)
        view.findViewById<TextView>(R.id.balanceAmount).text = balance
        view.findViewById<TextView>(R.id.incomeAmount).text = infoIncome
        view.findViewById<TextView>(R.id.spentAmount).text = infoSpent
        view.findViewById<Button>(R.id.btnVExtractWallet).setOnClickListener(this)
        view.findViewById<Button>(R.id.btnHomeWallet).setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when(v!!.id){
            R.id.btnVExtractWallet->navController!!.navigate(R.id.walletToExtract)
            R.id.btnHomeWallet->activity?.onBackPressed()
        }
    }
}