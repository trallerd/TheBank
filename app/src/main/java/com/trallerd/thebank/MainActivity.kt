package com.trallerd.thebank

import com.trallerd.thebank.R


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.stone.vega.library.VegaLayoutManager
import com.trallerd.thebank.adapters.RecordsAdapter
import kotlinx.android.synthetic.main.fragment_extract.*
import kotlinx.android.synthetic.main.item_records.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        listRecords.adapter = RecordsAdapter()
//        listRecords.layoutManager = VegaLayoutManager()
    }

}