package com.trallerd.thebank

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.trallerd.thebank.adapters.RecordsAdapter
import kotlinx.android.synthetic.main.fragment_extract.view.*


class ExtractFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_extract, container, false)
        view.listRecords.adapter = RecordsAdapter()
        view.listRecords.layoutManager = LinearLayoutManager(this.context,LinearLayoutManager.VERTICAL,false)

        return view
    }
}