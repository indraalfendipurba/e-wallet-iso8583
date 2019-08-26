package com.example.e_wallet12021996ver1.ewallet
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.ListView
import android.widget.Toast
import com.example.e_wallet12021996ver1.R
import com.example.e_wallet12021996ver1.adapters.Adapter4
import com.example.e_wallet12021996ver1.databaseSqlite.Database
import com.example.e_wallet12021996ver1.models.model4
class FundAnak : AppCompatActivity() {
    internal var db = Database(this)
    lateinit var lv4 : ListView
    var list = mutableListOf<model4>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fund_anak)
    }
    override fun onStart() {
        super.onStart()
        viewall()
    }
    private fun viewall(){
        lv4 = findViewById(R.id.lv4)

        val adapter = Adapter4(this, R.layout.elv4, list)
        lv4.adapter = adapter

        list.clear()
        val res = db.allData4
        if(res.count == 0){
            Toast.makeText(this, "No data", Toast.LENGTH_LONG).show()
        }
        while(res.moveToNext()){
            list.add(model4 (
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
