package com.example.e_wallet12021996ver1.ewallet

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle

import android.widget.TextView
import com.example.e_wallet12021996ver1.R
import com.example.e_wallet12021996ver1.databaseSqlite.Database
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import kotlinx.android.synthetic.main.activity_layar_anak.*



class LayarAnak : AppCompatActivity() {

    internal var db = Database (this)
    lateinit var tv : TextView

    var ref1 = FirebaseAuth.getInstance().currentUser
    var ref3 = ref1!!.uid
    var fb = FirebaseDatabase.getInstance()
    var refy = fb.getReference("useranakb").child(ref3)
    var refz = fb.getReference("infoanak")
    var ref = fb.getReference("useranak").child(ref3)
    var refb = fb.getReference("infoortu")
    var refc = fb.getReference("useranakb").child(ref3)


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_layar_anak)



        requestfundt.setOnClickListener {
            startActivity(Intent(this, LayarRequestfund::class.java))
        }

        mitrat.setOnClickListener {
            startActivity(Intent(this, LayarMitra::class.java))
        }

        fundanakt2.setOnClickListener {
            startActivity(Intent(this, FundAnak::class.java))
        }

        notifanakt.setOnClickListener {
            startActivity(Intent(this, NotifAnak::class.java))
        }

        logout2.setOnClickListener {

            onBackPressed()
        }
    }

    override fun onStart() {
        super.onStart()

        refy.addListenerForSingleValueEvent(object : ValueEventListener {

            override fun onDataChange(p0: DataSnapshot)  {
                var list1 = mutableListOf<String>()
                var it : Iterable<DataSnapshot> = p0!!.children

                it.forEach{
                    var msg = ""
                    var itr = it.children
                    itr.forEach{
                        msg = msg+"\n"+it.value
                    }
                    val msg2 =  refz.child(msg.trim()).child("saldo")
                    msg2.addListenerForSingleValueEvent(object : ValueEventListener {

                        override fun onDataChange(p0: DataSnapshot)  {

                            var it : Iterable<DataSnapshot> = p0!!.children

                            it.forEach{
                                var msg = ""
                                var itr = it.children
                                itr.forEach{
                                    msg = msg+it.value
                                }
                                var msg3 = "Rp ${msg}"
                                textView12.setText(msg3)
                            }
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
        ref.addListenerForSingleValueEvent(object : ValueEventListener {

            override fun onDataChange(p0: DataSnapshot)  {

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
                                val iso1 = msg.trim().substring(20, 26)
                                val jam = "${iso.substring(6, 8)}:${iso.substring(8, 10)}:${iso.substring(10, 12)}"
                                val tgl = "${iso.substring(12, 14)}/${iso.substring(14, 16)}/${iso.substring(16, 20)}"

                                val harga = "${iso.substring(20,28)}"

                                if(harga.substring(0,1) != "0" && iso1 == "000010") {
                                    db.inserData5("Permintaan ditolak", "${harga}", "${tgl}", "${jam}")

                                }
                                else if(harga.substring(0,1) == "0" && harga.substring(1,2) != "0" && iso1 == "000010"){
                                    val harga1 = "${harga.substring(1, 8)}"
                                    db.inserData5("Permintaan ditolak", "${harga1}", "${tgl}", "${jam}")

                                }
                                else if(harga.substring(1,2) == "0" && harga.substring(2,3) != "0" && iso1 == "000010"){
                                    val harga1 = "${harga.substring(2, 8)}"
                                    db.inserData5("Permintaan ditolak", "${harga1}", "${tgl}", "${jam}")

                                }
                                else if(harga.substring(2,3) == "0" && harga.substring(3,4) != "0" && iso1 == "000010"){
                                    val harga1 = "${harga.substring(3, 8)}"
                                    db.inserData5("Permintaan ditolak", "${harga1}", "${tgl}", "${jam}")

                                }
                                else if(harga.substring(3,4) == "0" && harga.substring(4,5) != "0" && iso1 == "000010"){
                                    val harga1 = "${harga.substring(4, 8)}"
                                    db.inserData5("Permintaan ditolak", "${harga1}", "${tgl}", "${jam}")

                                }
                                else if(harga.substring(4,5) == "0" && harga.substring(5,6) != "0" && iso1 == "000010"){
                                    val harga1 = "${harga.substring(5, 8)}"
                                    db.inserData5("Permintaan ditolak", "${harga1}", "${tgl}", "${jam}")

                                }
                                else if(harga.substring(5,6) == "0" && harga.substring(6,7) != "0" && iso1 == "000010"){
                                    val harga1 = "${harga.substring(6, 8)}"
                                    db.inserData5("Permintaan ditolak", "${harga1}", "${tgl}", "${jam}")

                                }
                                else if(harga.substring(6,7) == "0" && harga.substring(7,8) != "0" && iso1 == "000010"){
                                    val harga1 = "${harga.substring(7, 8)}"
                                    db.inserData5("Permintaan ditolak", "${harga1}", "${tgl}", "${jam}")

                                }
                                else if(harga.substring(0,1) != "0" ) {
                                    db.inserData5("Dana diterima", "${harga}", "${tgl}", "${jam}")

                                }
                                else if(harga.substring(0,1) == "0" && harga.substring(1,2) != "0" ){
                                    val harga1 = "${harga.substring(1, 8)}"
                                    db.inserData5("Dana diterima", "${harga1}", "${tgl}", "${jam}")

                                }
                                else if(harga.substring(1,2) == "0" && harga.substring(2,3) != "0" ){
                                    val harga1 = "${harga.substring(2, 8)}"
                                    db.inserData5("Dana diterima", "${harga1}", "${tgl}", "${jam}")

                                }
                                else if(harga.substring(2,3) == "0" && harga.substring(3,4) != "0" ){
                                    val harga1 = "${harga.substring(3, 8)}"
                                    db.inserData5("Dana diterima", "${harga1}", "${tgl}", "${jam}")

                                }
                                else if(harga.substring(3,4) == "0" && harga.substring(4,5) != "0" ){
                                    val harga1 = "${harga.substring(4, 8)}"
                                    db.inserData5("Dana diterima", "${harga1}", "${tgl}", "${jam}")

                                }
                                else if(harga.substring(4,5) == "0" && harga.substring(5,6) != "0" ){
                                    val harga1 = "${harga.substring(5, 8)}"
                                    db.inserData5("Dana diterima", "${harga1}", "${tgl}", "${jam}")

                                }
                                else if(harga.substring(5,6) == "0" && harga.substring(6,7) != "0" ){
                                    val harga1 = "${harga.substring(6, 8)}"
                                    db.inserData5("Dana diterima", "${harga1}", "${tgl}", "${jam}")

                                }
                                else if(harga.substring(6,7) == "0" && harga.substring(7,8) != "0" ){
                                    val harga1 = "${harga.substring(7, 8)}"
                                    db.inserData5("Dana diterima", "${harga1}", "${tgl}", "${jam}")

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
    }

    private fun viewall(){
        tv = findViewById(R.id.textView29a)
        val res = db.allData5
        var res1 = res.count.toString()
        if(res.count == 0){
            tv.setText("")
        }
        else{
            tv.setText("${res1}")
        }

    }

}
