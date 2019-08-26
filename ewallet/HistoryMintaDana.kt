package com.example.e_wallet12021996ver1.ewallet

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.ListView
import android.widget.Toast
import com.example.e_wallet12021996ver1.R
import com.example.e_wallet12021996ver1.adapters.Adapter6
import com.example.e_wallet12021996ver1.databaseSqlite.Database
import com.example.e_wallet12021996ver1.models.model6


class HistoryMintaDana : AppCompatActivity() {
    internal var db = Database(this)
    lateinit var lv6 : ListView
    var list = mutableListOf<model6>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_history_minta_dana)
    }
    override fun onStart() {
        super.onStart()
        viewall()
    }
    private fun viewall(){
        lv6 = findViewById(R.id.lv6)

        val adapter = Adapter6(this, R.layout.elv6, list)
        lv6.adapter = adapter

        list.clear()
        val res = db.allData6
        if(res.count == 0){
            Toast.makeText(this, "No data", Toast.LENGTH_LONG).show()
        }
        while(res.moveToNext()){
            list.add(model6 (
                res.getString(0),
                res.getString(1),
                res.getString(2),
                res.getString(3),
                res.getString(4)
            )
            )
        }
    }
}
