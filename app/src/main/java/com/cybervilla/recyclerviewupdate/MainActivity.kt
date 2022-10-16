package com.cybervilla.recyclerviewupdate

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlin.random.Random

class MainActivity : AppCompatActivity(),AdapterMain.OnItemClickListener {
    lateinit var recyclerView: RecyclerView
    lateinit var adapterMain: AdapterMain
    lateinit var btnUpdate: Button
    lateinit var listOfString: ArrayList<String>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        recyclerView = findViewById(R.id.recycler_main_update)
        btnUpdate = findViewById(R.id.btn_update)
        listOfString = ArrayList()
        adapterMain = AdapterMain(listOfString,this)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapterMain
        updateRecyclerview()
        btnUpdate.setOnClickListener {
            updateRecyclerview()
        }
    }

    fun updateRecyclerview(){
        listOfString.clear()
        for (i in 1..50){
            listOfString.add("Test item ${Random.nextInt()}")
        }
        adapterMain.update(listOfString)
    }

    override fun onItemClick(position: Int) {
        Toast.makeText(this, "Item pos = $position", Toast.LENGTH_SHORT).show()
    }
}