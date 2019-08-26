package com.example.e_wallet12021996ver1.ewallet

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.ListView
import android.widget.Toast
import com.example.e_wallet12021996ver1.R
import com.example.e_wallet12021996ver1.adapters.Adapter3
import com.example.e_wallet12021996ver1.databaseSqlite.Database
import com.example.e_wallet12021996ver1.models.model3
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import kotlinx.android.synthetic.main.activity_layar_orangtua.*

class FundAnak1 : AppCompatActivity() {
    var ref1 = FirebaseAuth.getInstance().currentUser
    var ref3 = ref1!!.uid
    var fb = FirebaseDatabase.getInstance()
    var ref = fb.getReference("userortu").child(ref3)
    var refa = fb.getReference("infoanak")

    internal var db = Database(this)
    lateinit var lv3 : ListView
    var list = mutableListOf<model3>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fund_anak1)
        ref.addListenerForSingleValueEvent(object : ValueEventListener {

            override fun onDataChange(p0: DataSnapshot)  {
                var list1 = mutableListOf<String>()
                var it : Iterable<DataSnapshot> = p0!!.children

                it.forEach{
                    var msg = ""
                    var itr = it.children
                    itr.forEach{
                        msg = msg+"\n"+it.value
                    }

                    refa.child(msg.trim()).child("database4").addListenerForSingleValueEvent(object : ValueEventListener {

                        override fun onDataChange(p0: DataSnapshot)  {
                            var list1 = mutableListOf<String>()
                            var it : Iterable<DataSnapshot> = p0!!.children

                            it.forEach{
                                var msg = ""
                                var itr = it.children
                                itr.forEach{
                                    msg = msg+"\n"+it.value
                                }
                                val iso = msg.trim().substring(20, 52)
                                val jam = "${iso.substring(6, 8)}:${iso.substring(8, 10)}:${iso.substring(10, 12)}"
                                val tgl = "${iso.substring(12, 14)}/${iso.substring(14, 16)}/${iso.substring(16, 20)}"
                                val mitra = "${iso.substring(20,24)}"
                                val harga = "${iso.substring(24,32)}"

                                if(harga.substring(0,1) != "0" ){
                                    when (mitra) {
                                        "0001" -> {
                                            db.inserData3("Mitra1", "${harga}", "${tgl}", "${jam}")
                                        }
                                        "0002" -> {
                                            db.inserData3("Mitra2", "${harga}", "${tgl}", "${jam}")
                                        }
                                        "0003" -> {
                                            db.inserData3("Mitra3", "${harga}", "${tgl}", "${jam}")
                                        }
                                        "0004" -> {
                                            db.inserData3("Mitra4", "${harga}", "${tgl}", "${jam}")
                                        }
                                        "0005" -> {
                                            db.inserData3("Mitra5", "${harga}", "${tgl}", "${jam}")
                                        }
                                        "0006" -> {
                                            db.inserData3("Mitra6", "${harga}", "${tgl}", "${jam}")
                                        }
                                        "0007" -> {
                                            db.inserData3("Mitra7", "${harga}", "${tgl}", "${jam}")
                                        }
                                        "0008" -> {
                                            db.inserData3("Mitra8", "${harga}", "${tgl}", "${jam}")
                                        }
                                        "0009" -> {
                                            db.inserData3("Mitra9", "${harga}", "${tgl}", "${jam}")
                                        }
                                        "0010" -> {
                                            db.inserData3("Mitra10", "${harga}", "${tgl}", "${jam}")
                                        }
                                        else -> null
                                    }

                                }
                                else if(harga.substring(0,1) == "0" && harga.substring(1,2) != "0" ){
                                    val harga1 = "${harga.substring(1, 8)}"
                                    if (mitra == "0001") {
                                        db.inserData3("Mitra1", "${harga1}", "${tgl}", "${jam}")
                                    }
                                    else if (mitra == "0002") {
                                        db.inserData3("Mitra2", "${harga1}", "${tgl}", "${jam}")
                                    }
                                    else if (mitra == "0003") {
                                        db.inserData3("Mitra3", "${harga1}", "${tgl}", "${jam}")
                                    }
                                    else if (mitra == "0004") {
                                        db.inserData3("Mitra4", "${harga1}", "${tgl}", "${jam}")
                                    }
                                    else if (mitra == "0005") {
                                        db.inserData3("Mitra5", "${harga1}", "${tgl}", "${jam}")
                                    }
                                    else if (mitra == "0006") {
                                        db.inserData3("Mitra6", "${harga1}", "${tgl}", "${jam}")
                                    }
                                    else if (mitra == "0007") {
                                        db.inserData3("Mitra7", "${harga1}", "${tgl}", "${jam}")
                                    }
                                    else if (mitra == "0008") {
                                        db.inserData3("Mitra8", "${harga1}", "${tgl}", "${jam}")
                                    }
                                    else if (mitra == "0009") {
                                        db.inserData3("Mitra9", "${harga1}", "${tgl}", "${jam}")
                                    }
                                    else if (mitra == "0010") {
                                        db.inserData3("Mitra10", "${harga1}", "${tgl}", "${jam}")
                                    }
                                    else null

                                }
                                else if(harga.substring(1,2) == "0" && harga.substring(2,3) != "0" ){
                                    val harga1 = "${harga.substring(2, 8)}"
                                    if (mitra == "0001") {
                                        db.inserData3("Mitra1", "${harga1}", "${tgl}", "${jam}")
                                    }
                                    else if (mitra == "0002") {
                                        db.inserData3("Mitra2", "${harga1}", "${tgl}", "${jam}")
                                    }
                                    else if (mitra == "0003") {
                                        db.inserData3("Mitra3", "${harga1}", "${tgl}", "${jam}")
                                    }
                                    else if (mitra == "0004") {
                                        db.inserData3("Mitra4", "${harga1}", "${tgl}", "${jam}")
                                    }
                                    else if (mitra == "0005") {
                                        db.inserData3("Mitra5", "${harga1}", "${tgl}", "${jam}")
                                    }
                                    else if (mitra == "0006") {
                                        db.inserData3("Mitra6", "${harga1}", "${tgl}", "${jam}")
                                    }
                                    else if (mitra == "0007") {
                                        db.inserData3("Mitra7", "${harga1}", "${tgl}", "${jam}")
                                    }
                                    else if (mitra == "0008") {
                                        db.inserData3("Mitra8", "${harga1}", "${tgl}", "${jam}")
                                    }
                                    else if (mitra == "0009") {
                                        db.inserData3("Mitra9", "${harga1}", "${tgl}", "${jam}")
                                    }
                                    else if (mitra == "0010") {
                                        db.inserData3("Mitra10", "${harga1}", "${tgl}", "${jam}")
                                    }
                                    else null

                                }
                                else if(harga.substring(2,3) == "0" && harga.substring(3,4) != "0" ){
                                    val harga1 = "${harga.substring(3, 8)}"
                                    if (mitra == "0001") {
                                        db.inserData3("Mitra1", "${harga1}", "${tgl}", "${jam}")
                                    }
                                    else if (mitra == "0002") {
                                        db.inserData3("Mitra2", "${harga1}", "${tgl}", "${jam}")
                                    }
                                    else if (mitra == "0003") {
                                        db.inserData3("Mitra3", "${harga1}", "${tgl}", "${jam}")
                                    }
                                    else if (mitra == "0004") {
                                        db.inserData3("Mitra4", "${harga1}", "${tgl}", "${jam}")
                                    }
                                    else if (mitra == "0005") {
                                        db.inserData3("Mitra5", "${harga1}", "${tgl}", "${jam}")
                                    }
                                    else if (mitra == "0006") {
                                        db.inserData3("Mitra6", "${harga1}", "${tgl}", "${jam}")
                                    }
                                    else if (mitra == "0007") {
                                        db.inserData3("Mitra7", "${harga1}", "${tgl}", "${jam}")
                                    }
                                    else if (mitra == "0008") {
                                        db.inserData3("Mitra8", "${harga1}", "${tgl}", "${jam}")
                                    }
                                    else if (mitra == "0009") {
                                        db.inserData3("Mitra9", "${harga1}", "${tgl}", "${jam}")
                                    }
                                    else if (mitra == "0010") {
                                        db.inserData3("Mitra10", "${harga1}", "${tgl}", "${jam}")
                                    }
                                    else null

                                }
                                else if(harga.substring(3,4) == "0" && harga.substring(4,5) != "0" ){
                                    val harga1 = "${harga.substring(4, 8)}"
                                    if (mitra == "0001") {
                                        db.inserData3("Mitra1", "${harga1}", "${tgl}", "${jam}")
                                    }
                                    else if (mitra == "0002") {
                                        db.inserData3("Mitra2", "${harga1}", "${tgl}", "${jam}")
                                    }
                                    else if (mitra == "0003") {
                                        db.inserData3("Mitra3", "${harga1}", "${tgl}", "${jam}")
                                    }
                                    else if (mitra == "0004") {
                                        db.inserData3("Mitra4", "${harga1}", "${tgl}", "${jam}")
                                    }
                                    else if (mitra == "0005") {
                                        db.inserData3("Mitra5", "${harga1}", "${tgl}", "${jam}")
                                    }
                                    else if (mitra == "0006") {
                                        db.inserData3("Mitra6", "${harga1}", "${tgl}", "${jam}")
                                    }
                                    else if (mitra == "0007") {
                                        db.inserData3("Mitra7", "${harga1}", "${tgl}", "${jam}")
                                    }
                                    else if (mitra == "0008") {
                                        db.inserData3("Mitra8", "${harga1}", "${tgl}", "${jam}")
                                    }
                                    else if (mitra == "0009") {
                                        db.inserData3("Mitra9", "${harga1}", "${tgl}", "${jam}")
                                    }
                                    else if (mitra == "0010") {
                                        db.inserData3("Mitra10", "${harga1}", "${tgl}", "${jam}")
                                    }
                                    else null

                                }
                                else if(harga.substring(4,5) == "0" && harga.substring(5,6) != "0" ){
                                    val harga1 = "${harga.substring(5, 8)}"
                                    if (mitra == "0001") {
                                        db.inserData3("Mitra1", "${harga1}", "${tgl}", "${jam}")
                                    }
                                    else if (mitra == "0002") {
                                        db.inserData3("Mitra2", "${harga1}", "${tgl}", "${jam}")
                                    }
                                    else if (mitra == "0003") {
                                        db.inserData3("Mitra3", "${harga1}", "${tgl}", "${jam}")
                                    }
                                    else if (mitra == "0004") {
                                        db.inserData3("Mitra4", "${harga1}", "${tgl}", "${jam}")
                                    }
                                    else if (mitra == "0005") {
                                        db.inserData3("Mitra5", "${harga1}", "${tgl}", "${jam}")
                                    }
                                    else if (mitra == "0006") {
                                        db.inserData3("Mitra6", "${harga1}", "${tgl}", "${jam}")
                                    }
                                    else if (mitra == "0007") {
                                        db.inserData3("Mitra7", "${harga1}", "${tgl}", "${jam}")
                                    }
                                    else if (mitra == "0008") {
                                        db.inserData3("Mitra8", "${harga1}", "${tgl}", "${jam}")
                                    }
                                    else if (mitra == "0009") {
                                        db.inserData3("Mitra9", "${harga1}", "${tgl}", "${jam}")
                                    }
                                    else if (mitra == "0010") {
                                        db.inserData3("Mitra10", "${harga1}", "${tgl}", "${jam}")
                                    }
                                    else null

                                }
                                else if(harga.substring(5,6) == "0" && harga.substring(6,7) != "0" ){
                                    val harga1 = "${harga.substring(6, 8)}"
                                    if (mitra == "0001") {
                                        db.inserData3("Mitra1", "${harga1}", "${tgl}", "${jam}")
                                    }
                                    else if (mitra == "0002") {
                                        db.inserData3("Mitra2", "${harga1}", "${tgl}", "${jam}")
                                    }
                                    else if (mitra == "0003") {
                                        db.inserData3("Mitra3", "${harga1}", "${tgl}", "${jam}")
                                    }
                                    else if (mitra == "0004") {
                                        db.inserData3("Mitra4", "${harga1}", "${tgl}", "${jam}")
                                    }
                                    else if (mitra == "0005") {
                                        db.inserData3("Mitra5", "${harga1}", "${tgl}", "${jam}")
                                    }
                                    else if (mitra == "0006") {
                                        db.inserData3("Mitra6", "${harga1}", "${tgl}", "${jam}")
                                    }
                                    else if (mitra == "0007") {
                                        db.inserData3("Mitra7", "${harga1}", "${tgl}", "${jam}")
                                    }
                                    else if (mitra == "0008") {
                                        db.inserData3("Mitra8", "${harga1}", "${tgl}", "${jam}")
                                    }
                                    else if (mitra == "0009") {
                                        db.inserData3("Mitra9", "${harga1}", "${tgl}", "${jam}")
                                    }
                                    else if (mitra == "0010") {
                                        db.inserData3("Mitra10", "${harga1}", "${tgl}", "${jam}")
                                    }
                                    else null

                                }
                                else if(harga.substring(6,7) == "0" && harga.substring(7,8) != "0" ){
                                    val harga1 = "${harga.substring(7, 8)}"
                                    if (mitra == "0001") {
                                        db.inserData3("Mitra1", "${harga1}", "${tgl}", "${jam}")
                                    }
                                    else if (mitra == "0002") {
                                        db.inserData3("Mitra2", "${harga1}", "${tgl}", "${jam}")
                                    }
                                    else if (mitra == "0003") {
                                        db.inserData3("Mitra3", "${harga1}", "${tgl}", "${jam}")
                                    }
                                    else if (mitra == "0004") {
                                        db.inserData3("Mitra4", "${harga1}", "${tgl}", "${jam}")
                                    }
                                    else if (mitra == "0005") {
                                        db.inserData3("Mitra5", "${harga1}", "${tgl}", "${jam}")
                                    }
                                    else if (mitra == "0006") {
                                        db.inserData3("Mitra6", "${harga1}", "${tgl}", "${jam}")
                                    }
                                    else if (mitra == "0007") {
                                        db.inserData3("Mitra7", "${harga1}", "${tgl}", "${jam}")
                                    }
                                    else if (mitra == "0008") {
                                        db.inserData3("Mitra8", "${harga1}", "${tgl}", "${jam}")
                                    }
                                    else if (mitra == "0009") {
                                        db.inserData3("Mitra9", "${harga1}", "${tgl}", "${jam}")
                                    }
                                    else if (mitra == "0010") {
                                        db.inserData3("Mitra10", "${harga1}", "${tgl}", "${jam}")
                                    }
                                    else null

                                }
                                else if(harga.substring(7,8) != "0"  ){
                                    when (mitra) {
                                        "0001" -> {
                                            db.inserData3("Mitra1", "0", "${tgl}", "${jam}")
                                        }
                                        "0002" -> {
                                            db.inserData3("Mitra2", "0", "${tgl}", "${jam}")
                                        }
                                        "0003" -> {
                                            db.inserData3("Mitra3", "0", "${tgl}", "${jam}")
                                        }
                                        "0004" -> {
                                            db.inserData3("Mitra4", "0", "${tgl}", "${jam}")
                                        }
                                        "0005" -> {
                                            db.inserData3("Mitra5", "0", "${tgl}", "${jam}")
                                        }
                                        "0006" -> {
                                            db.inserData3("Mitra6", "0", "${tgl}", "${jam}")
                                        }
                                        "0007" -> {
                                            db.inserData3("Mitra7", "0", "${tgl}", "${jam}")
                                        }
                                        "0008" -> {
                                            db.inserData3("Mitra8", "0", "${tgl}", "${jam}")
                                        }
                                        "0009" -> {
                                            db.inserData3("Mitra9", "0", "${tgl}", "${jam}")
                                        }
                                        "0010" -> {
                                            db.inserData3("Mitra10", "0", "${tgl}", "${jam}")
                                        }
                                        else -> null
                                    }

                                }
                                else {
                                    null
                                }


                            }

                            refa.child(msg.trim()).child("database4").removeValue()

                        }

                        override fun onCancelled(p0: DatabaseError) {
                            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                        }


                    })

                }
            }
            override fun onCancelled(p0: DatabaseError) {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }
        })
    }

    override fun onStart() {
        super.onStart()
        viewall()
    }
    private fun viewall(){
        lv3 = findViewById(R.id.lv3)

        val adapter = Adapter3(this, R.layout.elv3, list)
        lv3.adapter = adapter

        list.clear()
        val res = db.allData3
        if(res.count == 0){
            Toast.makeText(this, "No data", Toast.LENGTH_LONG).show()
        }
        while(res.moveToNext()){
            list.add(model3 (
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
