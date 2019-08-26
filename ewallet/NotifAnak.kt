package com.example.e_wallet12021996ver1.ewallet

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.ListView
import android.widget.Toast
import com.example.e_wallet12021996ver1.R
import com.example.e_wallet12021996ver1.adapters.Adapter5
import com.example.e_wallet12021996ver1.databaseSqlite.Database
import com.example.e_wallet12021996ver1.models.model5
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import kotlinx.android.synthetic.main.activity_layar_orangtua.*
import java.text.SimpleDateFormat
import java.util.*

class NotifAnak : AppCompatActivity() {

    var ref1 = FirebaseAuth.getInstance().currentUser
    var ref3 = ref1!!.uid
    var fb = FirebaseDatabase.getInstance()
    var ref = fb.getReference("useranak").child(ref3)
    var refb = fb.getReference("infoortu")
    var refc = fb.getReference("useranakb").child(ref3)
    var refd = fb.getReference("infoanak")
    internal var db = Database(this)
    lateinit var lv5 : ListView
    var list = mutableListOf<model5>()




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_notif_anak)
        /*
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

                    refb.child(msg.trim()).child("database1").addListenerForSingleValueEvent(object : ValueEventListener {

                        override fun onDataChange(p0: DataSnapshot)  {
                            var list1 = mutableListOf<String>()
                            var it : Iterable<DataSnapshot> = p0!!.children

                            it.forEach{
                                var msg = ""
                                var itr = it.children
                                itr.forEach{
                                    msg = msg+"\n"+it.value
                                }
                                val iso = msg.trim().substring(20, 48)
                                val jam = "${iso.substring(6, 8)}:${iso.substring(8, 10)}:${iso.substring(10, 12)}"
                                val tgl = "${iso.substring(12, 14)}/${iso.substring(14, 16)}/${iso.substring(16, 20)}"

                                val harga = "${iso.substring(20,28)}"

                                if(harga.substring(0,1) != "0" ) {
                                    db.inserData5("Dana diterima", "${harga}", "${tgl}", "${jam}")
                                    /*
                                    refb.addListenerForSingleValueEvent(object : ValueEventListener {

                                        override fun onDataChange(p0: DataSnapshot)  {
                                            var list1 = mutableListOf<String>()
                                            var it : Iterable<DataSnapshot> = p0!!.children

                                            it.forEach{
                                                var msg = ""
                                                var itr = it.children
                                                itr.forEach{
                                                    msg = msg+"\n"+it.value
                                                }

                                                val nilai = msg.trim().toInt()
                                                val nilai1 = nilai + harga.toInt()
                                                refc.child(msg.trim()).child("saldo").child("push").child("nilai").setValue("${nilai1}")




                                            }
                                        }
                                        override fun onCancelled(p0: DatabaseError) {
                                            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                                        }
                                    })
                                    */
                                }
                                else if(harga.substring(0,1) == "0" && harga.substring(1,2) != "0" ){
                                    val harga1 = "${harga.substring(1, 8)}"
                                    db.inserData5("Dana diterima", "${harga1}", "${tgl}", "${jam}")
                                    /*
                                    refb.addListenerForSingleValueEvent(object : ValueEventListener {

                                        override fun onDataChange(p0: DataSnapshot)  {
                                            var list1 = mutableListOf<String>()
                                            var it : Iterable<DataSnapshot> = p0!!.children

                                            it.forEach{
                                                var msg = ""
                                                var itr = it.children
                                                itr.forEach{
                                                    msg = msg+"\n"+it.value
                                                }

                                                val nilai = msg.trim().toInt()
                                                val nilai1 = nilai + harga1.toInt()
                                                refc.child(msg.trim()).child("saldo").child("push").child("nilai").setValue("${nilai1}")




                                            }
                                        }
                                        override fun onCancelled(p0: DatabaseError) {
                                            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                                        }
                                    })
                                    */
                                }
                                else if(harga.substring(1,2) == "0" && harga.substring(2,3) != "0" ){
                                    val harga1 = "${harga.substring(2, 8)}"
                                    db.inserData5("Dana diterima", "${harga1}", "${tgl}", "${jam}")
                                    /*
                                    refb.addListenerForSingleValueEvent(object : ValueEventListener {

                                        override fun onDataChange(p0: DataSnapshot)  {
                                            var list1 = mutableListOf<String>()
                                            var it : Iterable<DataSnapshot> = p0!!.children

                                            it.forEach{
                                                var msg = ""
                                                var itr = it.children
                                                itr.forEach{
                                                    msg = msg+"\n"+it.value
                                                }

                                                val nilai = msg.trim().toInt()
                                                val nilai1 = nilai + harga1.toInt()
                                                refc.child(msg.trim()).child("saldo").child("push").child("nilai").setValue("${nilai1}")




                                            }
                                        }
                                        override fun onCancelled(p0: DatabaseError) {
                                            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                                        }
                                    })
                                    */
                                }
                                else if(harga.substring(2,3) == "0" && harga.substring(3,4) != "0" ){
                                    val harga1 = "${harga.substring(3, 8)}"
                                    db.inserData5("Dana diterima", "${harga1}", "${tgl}", "${jam}")
                                    /*
                                    refb.addListenerForSingleValueEvent(object : ValueEventListener {

                                        override fun onDataChange(p0: DataSnapshot)  {
                                            var list1 = mutableListOf<String>()
                                            var it : Iterable<DataSnapshot> = p0!!.children

                                            it.forEach{
                                                var msg = ""
                                                var itr = it.children
                                                itr.forEach{
                                                    msg = msg+"\n"+it.value
                                                }

                                                val nilai = msg.trim().toInt()
                                                val nilai1 = nilai + harga1.toInt()
                                                refc.child(msg.trim()).child("saldo").child("push").child("nilai").setValue("${nilai1}")




                                            }
                                        }
                                        override fun onCancelled(p0: DatabaseError) {
                                            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                                        }
                                    })
                                    */
                                }
                                else if(harga.substring(3,4) == "0" && harga.substring(4,5) != "0" ){
                                    val harga1 = "${harga.substring(4, 8)}"
                                    db.inserData5("Dana diterima", "${harga1}", "${tgl}", "${jam}")
                                    /*
                                    refb.addListenerForSingleValueEvent(object : ValueEventListener {

                                        override fun onDataChange(p0: DataSnapshot)  {
                                            var list1 = mutableListOf<String>()
                                            var it : Iterable<DataSnapshot> = p0!!.children

                                            it.forEach{
                                                var msg = ""
                                                var itr = it.children
                                                itr.forEach{
                                                    msg = msg+"\n"+it.value
                                                }

                                                val nilai = msg.trim().toInt()
                                                val nilai1 = nilai + harga1.toInt()
                                                refc.child(msg.trim()).child("saldo").child("push").child("nilai").setValue("${nilai1}")




                                            }
                                        }
                                        override fun onCancelled(p0: DatabaseError) {
                                            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                                        }
                                    })
                                    */
                                }
                                else if(harga.substring(4,5) == "0" && harga.substring(5,6) != "0" ){
                                    val harga1 = "${harga.substring(5, 8)}"
                                    db.inserData5("Dana diterima", "${harga1}", "${tgl}", "${jam}")
                                    /*
                                    refb.addListenerForSingleValueEvent(object : ValueEventListener {

                                        override fun onDataChange(p0: DataSnapshot)  {
                                            var list1 = mutableListOf<String>()
                                            var it : Iterable<DataSnapshot> = p0!!.children

                                            it.forEach{
                                                var msg = ""
                                                var itr = it.children
                                                itr.forEach{
                                                    msg = msg+"\n"+it.value
                                                }

                                                val nilai = msg.trim().toInt()
                                                val nilai1 = nilai + harga1.toInt()
                                                refc.child(msg.trim()).child("saldo").child("push").child("nilai").setValue("${nilai1}")




                                            }
                                        }
                                        override fun onCancelled(p0: DatabaseError) {
                                            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                                        }
                                    })
                                    */
                                }
                                else if(harga.substring(5,6) == "0" && harga.substring(6,7) != "0" ){
                                    val harga1 = "${harga.substring(6, 8)}"
                                    db.inserData5("Dana diterima", "${harga1}", "${tgl}", "${jam}")
                                    /*
                                    refb.addListenerForSingleValueEvent(object : ValueEventListener {

                                        override fun onDataChange(p0: DataSnapshot)  {
                                            var list1 = mutableListOf<String>()
                                            var it : Iterable<DataSnapshot> = p0!!.children

                                            it.forEach{
                                                var msg = ""
                                                var itr = it.children
                                                itr.forEach{
                                                    msg = msg+"\n"+it.value
                                                }

                                                val nilai = msg.trim().toInt()
                                                val nilai1 = nilai + harga1.toInt()
                                                refc.child(msg.trim()).child("saldo").child("push").child("nilai").setValue("${nilai1}")




                                            }
                                        }
                                        override fun onCancelled(p0: DatabaseError) {
                                            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                                        }
                                    })
                                    */
                                }
                                else if(harga.substring(6,7) == "0" && harga.substring(7,8) != "0" ){
                                    val harga1 = "${harga.substring(7, 8)}"
                                    db.inserData5("Dana diterima", "${harga1}", "${tgl}", "${jam}")
                                    /*
                                    refb.addListenerForSingleValueEvent(object : ValueEventListener {

                                        override fun onDataChange(p0: DataSnapshot)  {
                                            var list1 = mutableListOf<String>()
                                            var it : Iterable<DataSnapshot> = p0!!.children

                                            it.forEach{
                                                var msg = ""
                                                var itr = it.children
                                                itr.forEach{
                                                    msg = msg+"\n"+it.value
                                                }

                                                val nilai = msg.trim().toInt()
                                                val nilai1 = nilai + harga1.toInt()
                                                refc.child(msg.trim()).child("saldo").child("push").child("nilai").setValue("${nilai1}")
                                            }
                                        }
                                        override fun onCancelled(p0: DatabaseError) {
                                            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                                        }
                                    })
                                    */
                                }

                                else {
                                    null
                                }
                            }

                            refb.child(msg.trim()).child("database1").removeValue()

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
        */
    }

    override fun onStart() {
        super.onStart()
        viewall()
    }

    private fun remove(){
        /*
        ref.addListenerForSingleValueEvent(object : ValueEventListener {

            override fun onDataChange(p0: DataSnapshot)  {

                var it : Iterable<DataSnapshot> = p0!!.children

                it.forEach{
                    var msg = ""
                    var itr = it.children
                    itr.forEach{
                        msg = msg+"\n"+it.value
                    }

                    refa.child(msg.trim()).child("database1").removeValue()
                }
            }
            override fun onCancelled(p0: DatabaseError) {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }
        })
        */
    }
///*
    private fun viewall(){
        lv5 = findViewById(R.id.lv5)

        val adapter = Adapter5(this, R.layout.elv5, list)
        lv5.adapter = adapter

        list.clear()
        val res = db.allData5
        if(res.count == 0){
            Toast.makeText(this, "No data", Toast.LENGTH_LONG).show()
        }
        while(res.moveToNext()){
            list.add(model5 (
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
