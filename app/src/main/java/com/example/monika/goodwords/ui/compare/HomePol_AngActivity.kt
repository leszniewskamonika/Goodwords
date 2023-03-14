package com.example.monika.goodwords.ui.compare

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

class HomePol_AngActivity: AppCompatActivity() {
    private val activity = this@HomePol_AngActivity

    private lateinit var recyclerViewPol_AngHome: RecyclerView

    private lateinit var listComparedHome: MutableList<HomeWord>

    private lateinit var comparedHomeRecyclerAdapter: ComparedHomePol_AngRecyclerAdapter
    private lateinit var databaseHelper: DatabaseHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home_pol_ang)
        supportActionBar!!.hide()
        initViews()
        initObjects()

    }

    private fun initViews(){

        recyclerViewPol_AngHome =findViewById<View>(R.id.recyclerViewPol_AngHome) as RecyclerView



    }

    private fun initObjects(){
        listComparedHome = ArrayList()
        comparedHomeRecyclerAdapter = ComparedHomePol_AngRecyclerAdapter(listComparedHome)

        val mLayoutManager = LinearLayoutManager(applicationContext)
        recyclerViewPol_AngHome.layoutManager = mLayoutManager
        recyclerViewPol_AngHome.itemAnimator = DefaultItemAnimator()
        recyclerViewPol_AngHome.setHasFixedSize(true)
        recyclerViewPol_AngHome.adapter = comparedHomeRecyclerAdapter
        databaseHelper = DatabaseHelper(activity)

        var getDataFromSQLite = GetDataFromSQLite()
        getDataFromSQLite.execute()

        val horizontalLayoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        recyclerViewPol_AngHome.setLayoutManager(horizontalLayoutManager);

    }

    inner class GetDataFromSQLite : AsyncTask<Void, Void, List<HomeWord>>() {

        override fun doInBackground(vararg p0: Void?): List<HomeWord> {
            return databaseHelper.getAllHomeWord()
        }

        override fun onPostExecute(result: List<HomeWord>?) {
            super.onPostExecute(result)
            listComparedHome.clear()
            listComparedHome.addAll(result!!)
        }

    }
}