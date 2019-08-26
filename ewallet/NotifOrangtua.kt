package com.example.e_wallet12021996ver1.ewallet

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.ListView
import android.widget.Toast
import com.example.e_wallet12021996ver1.R
import com.example.e_wallet12021996ver1.adapters.Adapter2
import com.example.e_wallet12021996ver1.databaseSqlite.Database
import com.example.e_wallet12021996ver1.models.model2
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

class NotifOrangtua : AppCompatActivity() {
    var ref1 = FirebaseAuth.getInstance().currentUser
    var ref3 = ref1!!.uid
    var fb = FirebaseDatabase.getInstance()
    var refe = fb.getReference("userortu").child(ref3)
    var reff = fb.getReference("infoanak")
    internal var db = Database(this)
    lateinit var lv2 : ListView
    var list = mutableListOf<model2>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_notif_orangtua)
        viewall()
    }
    override fun onStart() {
        super.onStart()
        viewall()
    }
///*
    private fun viewall(){
        lv2 = findViewById(R.id.lv2)

        val adapter = Adapter2(this, R.layout.elv2, list)
        lv2.adapter = adapter

        list.clear()
        val res = db.allData2
        if(res.count == 0){
            Toast.makeText(this, "No data", Toast.LENGTH_LONG).show()
        }
        while(res.moveToNext()){
            list.add(model2 (
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
