package com.example.soldierstrap

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import com.example.soldierstrap.adapter.SoldierAdapter
import com.example.soldierstrap.data.Soldier
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {
    private val viewModel: SoldierViewModel by viewModels()
    private val adapter = SoldierAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        soldier_recyclerView.adapter = adapter

        viewModel.fetchSoldierData()
        viewModel.soldier.observe(this, Observer {
            adapter.setupSoldier(it)
        })


    }

}