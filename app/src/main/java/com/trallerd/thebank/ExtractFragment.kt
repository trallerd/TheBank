package com.trallerd.thebank

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import com.trallerd.thebank.adapters.AllAdapter
import kotlinx.android.synthetic.main.fragment_extract.*
import kotlinx.android.synthetic.main.fragment_extract.view.*


class ExtractFragment : Fragment(), View.OnClickListener {
    var navController: NavController? = null
    private lateinit var allAdapter: AllAdapter
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        allAdapter = AllAdapter(this.context)
        val view = inflater.inflate(R.layout.fragment_extract, container, false)
        view.listRecords.adapter = AllAdapter(this.context)
        view.listRecords.layoutManager = LinearLayoutManager(this.context,LinearLayoutManager.VERTICAL,false)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = Navigation.findNavController(view)
        view.findViewById<Button>(R.id.btnSearch).setOnClickListener(this)

    }


    override fun onClick(v: View?) {
        when(v!!.id){
            R.id.btnSearch->{
                val name = txtSearch.text.toString()
                    allAdapter.search(name)
                }

            }
        }
    }
