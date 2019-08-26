package com.example.e_wallet12021996ver1.ewallet

import android.content.Intent
import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import com.example.e_wallet12021996ver1.R
import com.example.e_wallet12021996ver1.databaseSqlite.Database
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import kotlinx.android.synthetic.main.activity_layar_anak.*
import kotlinx.android.synthetic.main.activity_layar_mitra.*
import kotlinx.android.synthetic.main.activity_layar_orangtua.*

class LayarOrangtua : AppCompatActivity() {

    lateinit var saldo : TextView
    internal var db = Database (this)
    lateinit var tv : TextView

    var ref1 = FirebaseAuth.getInstance().currentUser
    var ref3 = ref1!!.uid
    var fb = FirebaseDatabase.getInstance()
    var ref = fb.getReference("userortub").child(ref3)
    var refa = fb.getReference("infoortu")
    var refb = fb.getReference("userortu").child(ref3)
    var refc = fb.getReference("infoanak")
    var refe = fb.getReference("userortu").child(ref3)
    var reff = fb.getReference("infoanak")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_layar_orangtua)
        saldo = findViewById(R.id.textView10)

       // viewall()



        fundusaget.setOnClickListener {
            startActivity(Intent(this, LayarFundusage::class.java))
        }

        sendfundt.setOnClickListener {
            startActivity(Intent(this, LayarSendfund::class.java))

        }

        kontrolanakt.setOnClickListener {
            startActivity(Intent(this, LayarKontrolanak::class.java))
        }

        notiforangtuat.setOnClickListener {
            startActivity(Intent(this, NotifOrangtua::class.java))
        }

        logout1.setOnClickListener {
           // startActivity(Intent(this, LayarUtama::class.java))
            onBackPressed()
        }
    }

    override fun onStart() {
        super.onStart()
        // view()
        //view1()
        // viewall()
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
                    val msg2 =  refc.child(msg.trim()).child("saldo")
                    msg2.addListenerForSingleValueEvent(object : ValueEventListener {

                        override fun onDataChange(p0: DataSnapshot)  {
                            //var list1 = mutableListOf<String>()
                            var it : Iterable<DataSnapshot> = p0!!.children

                            it.forEach{
                                var msg = ""
                                var itr = it.children
                                itr.forEach{
                                    msg = msg+it.value
                                }
                                var msg3 = "Saldo anak : Rp ${msg}"
                                tvsaldoAnak.setText(msg3)
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
        refe.addListenerForSingleValueEvent(object : ValueEventListener {

            override fun onDataChange(p0: DataSnapshot)  {
                var list1 = mutableListOf<String>()
                var it : Iterable<DataSnapshot> = p0!!.children

                it.forEach{
                    var msg = ""
                    var itr = it.children
                    itr.forEach{
                        msg = msg+"\n"+it.value
                    }

                    reff.child(msg.trim()).child("database6").addListenerForSingleValueEvent(object :
                        ValueEventListener {

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

                                if(harga.substring(0,1) != "0" ){
                                    db.inserData2("Minta dana", "${harga}", "${tgl}", "${jam}")
                                }
                                else if(harga.substring(0,1) == "0" && harga.substring(1,2) != "0" ){
                                    val harga1 = "${harga.substring(1, 8)}"
                                    db.inserData2("Minta dana", "${harga1}", "${tgl}", "${jam}")

                                }
                                else if(harga.substring(1,2) == "0" && harga.substring(2,3) != "0" ){
                                    val harga1 = "${harga.substring(2, 8)}"
                                    db.inserData2("Minta dana", "${harga1}", "${tgl}", "${jam}")
                                }
                                else if(harga.substring(2,3) == "0" && harga.substring(3,4) != "0" ){
                                    val harga1 = "${harga.substring(3, 8)}"
                                    db.inserData2("Minta dana", "${harga1}", "${tgl}", "${jam}")
                                }
                                else if(harga.substring(3,4) == "0" && harga.substring(4,5) != "0" ){
                                    val harga1 = "${harga.substring(4, 8)}"
                                    db.inserData2("Minta dana", "${harga1}", "${tgl}", "${jam}")

                                }
                                else if(harga.substring(4,5) == "0" && harga.substring(5,6) != "0" ){
                                    val harga1 = "${harga.substring(5, 8)}"
                                    db.inserData2("Minta dana", "${harga1}", "${tgl}", "${jam}")
                                }
                                else if(harga.substring(5,6) == "0" && harga.substring(6,7) != "0" ){
                                    val harga1 = "${harga.substring(6, 8)}"
                                    db.inserData2("Minta dana", "${harga1}", "${tgl}", "${jam}")

                                }
                                else if(harga.substring(6,7) == "0" && harga.substring(7,8) != "0" ){
                                    val harga1 = "${harga.substring(7, 8)}"
                                    db.inserData2("Minta dana", "${harga1}", "${tgl}", "${jam}")
                                }
                                else if(harga.substring(7,8) != "0"  ){
                                    db.inserData2("Minta dana", "0", "${tgl}", "${jam}")

                                }
                                else {
                                    null
                                }


                            }

                            reff.child(msg.trim()).child("database6").removeValue()

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
                var list1 = mutableListOf<String>()
                var it : Iterable<DataSnapshot> = p0!!.children

                it.forEach{
                    var msg = ""
                    var itr = it.children
                    itr.forEach{
                        msg = msg+"\n"+it.value
                    }
                    val msg2 =  refa.child(msg.trim()).child("saldo")
                    msg2.addListenerForSingleValueEvent(object : ValueEventListener {

                        override fun onDataChange(p0: DataSnapshot)  {
                            //var list1 = mutableListOf<String>()
                            var it : Iterable<DataSnapshot> = p0!!.children

                            it.forEach{
                                var msg = ""
                                var itr = it.children
                                itr.forEach{
                                    msg = msg+it.value
                                }
                                var msg3 = "Rp ${msg}"
                                textView10.setText(msg3)
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
    }

    private fun view1(){
        saldo = findViewById(R.id.textView10)
        //val parts = saldo.text.split(Regex("Rp "))
        val parts = saldo.text.toString().replace("Rp ", "")

        saldo.setText("${parts}Nihil")
    }

    private fun viewall(){
        tv = findViewById(R.id.textView18)
        val res = db.allData2
        var res1 = res.count.toString()
        if(res.count == 0){
            tv.setText("")
        }
        else{
            tv.setText("${res1}")
        }

    }


/*
    private fun view(){
        saldo = findViewById(R.id.textView10)
        val res = db.Data1
        if(res.count == 0){
            Toast.makeText(this, "No data", Toast.LENGTH_LONG).show()
        }
        else if(res.moveToLast()){
            val data = res.getString(2)
            val parts = saldo.text.toString().replace("Rp ", "")
            val dat = parts.toInt()
            val data2 = data.toInt()
            val cetak1 = (dat - data2)
            val cetak2 =cetak1.toString()
            val cetak3 = "Rp ${cetak2}"
            saldo.setText(cetak3).toString()
            //Toast.makeText(this, "data is avaiable", Toast.LENGTH_LONG).show()
        }
        /*
        while (res.moveToLast()) {
           val parts = saldo.text.toString().replace("Rp ", "")

            val dat = parts.toInt()

            val data = res.getString(2)
            val data2 = data.toInt()
            val cetak =  saldo.setText(data).toString()
            val cetak1 = "Rp " + (dat - data2)
            saldo.setText(data).toString()
        }
*/

    }

  */
}
