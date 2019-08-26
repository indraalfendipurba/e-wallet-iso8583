package com.example.e_wallet12021996ver1.ewallet

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.ListView
import android.widget.Toast
import com.example.e_wallet12021996ver1.R
import com.example.e_wallet12021996ver1.adapters.Adapter1
import com.example.e_wallet12021996ver1.databaseSqlite.Database
import com.example.e_wallet12021996ver1.models.model1

class FundOrangtua : AppCompatActivity() {

   internal var db = Database(this)
    lateinit var lv1 : ListView
    var list = mutableListOf<model1>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fund_orangtua)



    }

    override fun onStart() {
        super.onStart()
       viewall()
    }
///*
    private fun viewall(){
        lv1 = findViewById(R.id.lv1)

        val adapter = Adapter1(this, R.layout.elv1, list)
        lv1.adapter = adapter

        list.clear()
        val res = db.allData1
        if(res.count == 0){
            Toast.makeText(this, "No data", Toast.LENGTH_LONG).show()
        }
        while(res.moveToNext()){
            list.add(model1 (
                res.getString(0),
                res.getString(1),
                res.getString(2),
                res.getString(3),
                res.getString(4)
            )
            )
        }
    }
    //*/
}
