package com.example.monika.goodwords.ui.word

import android.os.AsyncTask
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.monika.goodwords.R
import com.example.monika.goodwords.bazadanych.DatabaseHelper
import com.example.monika.goodwords.model.HomeWord

class HomeListActivity: AppCompatActivity() {
    private val activity = this@HomeListActivity

    private lateinit var recyclerViewHome: RecyclerView
    private lateinit var listHome: MutableList<HomeWord>

    private lateinit var homeRecyclerAdapter: HomeRecyclerAdapter
    private lateinit var databaseHelper: DatabaseHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home_list)
        supportActionBar!!.hide()
        initViews()
        initObjects()
    }

    private fun initViews(){
        recyclerViewHome =findViewById<View>(R.id.recyclerViewHome) as RecyclerView

    }

    private fun initObjects(){
        listHome = ArrayList()
        homeRecyclerAdapter = HomeRecyclerAdapter(listHome)

        val mLayoutManager = LinearLayoutManager(applicationContext)
        recyclerViewHome.layoutManager = mLayoutManager
        recyclerViewHome.itemAnimator = DefaultItemAnimator()
        recyclerViewHome.setHasFixedSize(true)
        recyclerViewHome.adapter = homeRecyclerAdapter
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