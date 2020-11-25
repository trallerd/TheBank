package com.trallerd.thebank

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.stone.vega.library.VegaLayoutManager
import com.trallerd.thebank.adapters.RecordsAdapter
import kotlinx.android.synthetic.main.fragment_extract.*


class ExtractFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {


        return inflater.inflate(R.layout.fragment_extract, container, false)
    }
}