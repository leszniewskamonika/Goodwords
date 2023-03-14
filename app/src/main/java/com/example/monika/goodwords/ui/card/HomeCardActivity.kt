package com.example.monika.goodwords.ui.card

import android.os.AsyncTask
import android.os.Bundle
import android.view.View
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.monika.goodwords.R
import com.example.monika.goodwords.bazadanych.DatabaseHelper
import com.example.monika.goodwords.model.HomeWord

class HomeCardActivity: AppCompatActivity() {

    private val activity = this@HomeCardActivity

    private lateinit var recyclerViewCardHome: RecyclerView
    private lateinit var listHome: MutableList<HomeWord>

    private lateinit var cardHomeRecyclerAdapter: CardHomeRecyclerAdapter
    private lateinit var databaseHelper: DatabaseHelper

    private lateinit var linearLayout: LinearLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home_card)
        supportActionBar!!.hide()
        initViews()
        initObjects()

    }

    private fun initViews(){

        recyclerViewCardHome =findViewById<View>(R.id.recyclerViewCardHome) as RecyclerView
        linearLayout = findViewById<View>(R.id.linearLayout) as LinearLayout

    }

    private fun initObjects(){
        listHome = ArrayList()
        cardHomeRecyclerAdapter = CardHomeRecyclerAdapter(listHome)

        val mLayoutManager = LinearLayoutManager(applicationContext)
        recyclerViewCardHome.layoutManager = mLayoutManager
        recyclerViewCardHome.setHasFixedSize(true)
        recyclerViewCardHome.adapter = cardHomeRecyclerAdapter
        databaseHelper = DatabaseHelper(activity)

        var getDataFromSQLite = GetDataFromSQLite()
        getDataFromSQLite.execute()

    }

    inner class GetDataFromSQLite : AsyncTask<Void, Void, List<HomeWord>>() {

        override fun doInBackground(vararg p0: Void?): List<HomeWord> {
            return databaseHelper.getAllHomeWord()
        }

        override fun onPostExecute(result: List<HomeWord>?) {
            super.onPostExecute(result)
            listHome.clear()
            listHome.addAll(result!!)
        }

    }

}