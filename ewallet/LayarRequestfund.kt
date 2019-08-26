package com.example.e_wallet12021996ver1.ewallet

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.e_wallet12021996ver1.R
import com.example.e_wallet12021996ver1.databaseSqlite.Database
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import kotlinx.android.synthetic.main.activity_layar_orangtua.*
import kotlinx.android.synthetic.main.activity_layar_requestfund.*
import java.text.SimpleDateFormat
import java.util.*

class LayarRequestfund : AppCompatActivity() {
    internal var db = Database (this)
    var ref1 = FirebaseAuth.getInstance().currentUser
    var ref3 = ref1!!.uid
    var fb = FirebaseDatabase.getInstance()
    var ref = fb.getReference("useranak").child(ref3)
    var refb = fb.getReference("infoortu")
    var refc = fb.getReference("useranakb").child(ref3)
    var refd = fb.getReference("infoanak")
    //lateinit var saldo : TextView
    lateinit var etminta    : EditText
    lateinit var bminta     : Button
    lateinit var bhistory     : Button
    ///*
    val date1   = SimpleDateFormat("ddMM")
    val year1   = SimpleDateFormat("yyyy")
    val time1   = SimpleDateFormat("hhmmss")
    val date    = date1.format(Date()).toString()
    val year    = year1.format(Date()).toString()
    val time    = time1.format(Date()).toString()
    val mti     = "1140"
    val code    = "000101"
    //val nominal = etkirim.text.toString().trim()
    val iso     = "${mti}201A001000000000${code}${time}${date}${year}"
    //*/
    lateinit var button : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_layar_requestfund)

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
                    val msg2 =  refb.child(msg.trim()).child("saldo")
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

                                tvsaldoanak1.setText(msg).toString().trim()
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

        etminta = findViewById(R.id.etminta)
        bminta  = findViewById(R.id.bminta)
        bhistory  = findViewById(R.id.bhistory)

        //val waktu = SimpleDateFormat("ddMMyyyy  hh:mm:ss")

        bminta.setOnClickListener {
            ///var data = etkirim.toString().trim()
            //sistemdata1()
            jalan1()

        }


        bhistory.setOnClickListener {

            startActivity(Intent(this, HistoryMintaDana::class.java))

        }
    }
/*
    private fun sistemdata1(){
        //saldo = findViewById(R.id.textView10)
        // val parts = saldo.text.toString().replace("Rp ", "")
        val data1   = etminta
        val data2   = data1!!.length()
        //val saldo1 = parts.toInt()
        // val data3 = data1.toString().toInt()

        // if(data3 >= saldo1){
        // etkirim.error = "Nominal terlalu besar/sama dengan jumlah saldo"
        // }

        // else {

        if (data2 == 1) {
            jalan1()
        } else if (data2 == 2) {
            jalan2()
        } else if (data2 == 3) {
            jalan3()
        } else if (data2 == 4) {
            jalan4()
        } else if (data2 == 5) {
            jalan5()
        } else if (data2 == 6) {
            jalan6()
        } else if (data2 == 7) {
            jalan7()
        } else if (data2 == 8) {
            jalan8()
        } else {
            jalan9()
        }
        // }
    }

    private fun jalan1(){
        val jalan = etminta.length()
        val jalan1_1 = etminta.text.toString().trim()
        val jalan1_2 = "0000000${jalan1_1}"
        // val dataiso  = "${iso}${jalan1_2}"
        val date_1 = SimpleDateFormat("dd/MM/yyyy")
        val date_2 = date_1.format(Date())
        val time_1 = SimpleDateFormat("hh:mm:ss")
        val time_2 = time_1.format(Date())
        val kirim = "Minta Dana"
        db.inserData6( kirim, jalan1_1.toString().trim(), date_2.toString().trim(), time_2.toString().trim())
        db.inserData5( kirim, jalan1_1.toString().trim(), date_2.toString().trim(), time_2.toString().trim())

        //db.inserData5(  "Minta Dana", "dua", "tiga", "tiga")
        //db.inserData1( "satu", "dua", "tiga", "tiga")
        //db.inserData3( "satu", "dua", "tiga", "tiga")
        Toast.makeText(this, "terkirim", Toast.LENGTH_LONG).show()

    }

    private fun jalan2(){
        val jalan1_1 = etminta.text.toString().trim()
        val jalan1_2 = "0000000${jalan1_1}"
        val dataiso  = "${iso}${jalan1_2}"
        val date_1 = SimpleDateFormat("dd/MM/yyyy")
        val date_2 = date_1.format(Date())
        val time_1 = SimpleDateFormat("hh:mm:ss")
        val time_2 = time_1.format(Date())
        var kirim =  "Minta Dana"
        db.inserData6( kirim.toString().trim(), jalan1_1.toString().trim(), date_2.toString().trim(), time_2.toString().trim())
        Toast.makeText(this, "terkirim", Toast.LENGTH_LONG).show()

    }

    private fun jalan3(){
        val jalan1_1 = etminta.text.toString().trim()
        val jalan1_2 = "000000${jalan1_1}"
        val dataiso  = "${iso}${jalan1_2}"
        val date_1 = SimpleDateFormat("dd/MM/yyyy")
        val date_2 = date_1.format(Date())
        val time_1 = SimpleDateFormat("hh:mm:ss")
        val time_2 = time_1.format(Date())
        var kirim =  "Minta Dana"
        db.inserData6( kirim.toString().trim(), jalan1_1.toString().trim(), date_2.toString().trim(), time_2.toString().trim())
        Toast.makeText(this, "terkirim", Toast.LENGTH_LONG).show()
    }

    private fun jalan4(){
        val jalan1_1 = etminta.text.toString().trim()
        val jalan1_2 = "00000${jalan1_1}"
        val dataiso  = "${iso}${jalan1_2}"
        val date_1 = SimpleDateFormat("dd/MM/yyyy")
        val date_2 = date_1.format(Date())
        val time_1 = SimpleDateFormat("hh:mm:ss")
        val time_2 = time_1.format(Date())
        var kirim =  "Minta Dana"
        db.inserData6( kirim.toString().trim(), jalan1_1.toString().trim(), date_2.toString().trim(), time_2.toString().trim())
        Toast.makeText(this, "terkirim", Toast.LENGTH_LONG).show()
    }

    private fun jalan5(){
        val jalan1_1 = etminta.text.toString().trim()
        val jalan1_2 = "0000${jalan1_1}"
        val dataiso  = "${iso}${jalan1_2}"
        val date_1 = SimpleDateFormat("dd/MM/yyyy")
        val date_2 = date_1.format(Date())
        val time_1 = SimpleDateFormat("hh:mm:ss")
        val time_2 = time_1.format(Date())
        var kirim =  "Minta Dana"
        db.inserData6( kirim.toString().trim(), jalan1_1.toString().trim(), date_2.toString().trim(), time_2.toString().trim())
        Toast.makeText(this, "terkirim", Toast.LENGTH_LONG).show()
    }

    private fun jalan6(){
        val jalan1_1 = etminta.text.toString().trim()
        val jalan1_2 = "000${jalan1_1}"
        val dataiso  = "${iso}${jalan1_2}"
        val date_1 = SimpleDateFormat("dd/MM/yyyy")
        val date_2 = date_1.format(Date())
        val time_1 = SimpleDateFormat("hh:mm:ss")
        val time_2 = time_1.format(Date())
        var kirim =  "Minta Dana"
        db.inserData6( kirim.toString().trim(), jalan1_1.toString().trim(), date_2.toString().trim(), time_2.toString().trim())
        Toast.makeText(this, "terkirim", Toast.LENGTH_LONG).show()
    }

    private fun jalan7(){
        val jalan1_1 = etminta.text.toString().trim()
        val jalan1_2 = "${jalan1_1}"
        val dataiso  = "${iso}${jalan1_2}"
        val date_1 = SimpleDateFormat("dd/MM/yyyy")
        val date_2 = date_1.format(Date())
        val time_1 = SimpleDateFormat("hh:mm:ss")
        val time_2 = time_1.format(Date())
        var kirim =  "Minta Dana"
        db.inserData6( kirim.toString().trim(), jalan1_1.toString().trim(), date_2.toString().trim(), time_2.toString().trim())
        Toast.makeText(this, "terkirim", Toast.LENGTH_LONG).show()
    }

    private fun jalan8(){
        val jalan1_1 = etminta.text.toString().trim()
        val dataiso  = "${iso}${jalan1_1}"
        val date_1 = SimpleDateFormat("dd/MM/yyyy")
        val date_2 = date_1.format(Date())
        val time_1 = SimpleDateFormat("hh:mm:ss")
        val time_2 = time_1.format(Date())
        var kirim = "Minta Dana"
        db.inserData6( kirim.toString().trim(), jalan1_1.toString().trim(), date_2.toString().trim(), time_2.toString().trim())
        Toast.makeText(this, "terkirim", Toast.LENGTH_LONG).show()

    }

    private fun jalan9(){
        etminta.error = "Tolong isi nominal yang benar"

    }*/

    private fun jalan1(){
        val saldoortu = tvsaldoanak1.text.toString().trim().toInt()
        val pjg = etminta.text.length
        if (saldoortu < etminta.text.toString().toInt()){
            etminta.error = "Jumlah dana terlalu besar"
        }

        else if(pjg > 8){
            etminta.error = "Jumlah digit lebih dari 8"
        }

        else{
            val panjang = etminta.text.toString().length
            if (panjang == 1) {
                val jalan1_1 = etminta.text.toString().trim()
                val jalan1_2 = "0000000${jalan1_1}"
                val date_1 = SimpleDateFormat("dd/MM/yyyy")
                val date_2 = date_1.format(Date())
                val time_1 = SimpleDateFormat("hh:mm:ss")
                val time_2 = time_1.format(Date())

                val dataiso  = "${iso}${jalan1_2}"

                val kirim = "Minta dana"

                refc.addListenerForSingleValueEvent(object : ValueEventListener {

                    override fun onDataChange(p0: DataSnapshot)  {

                        var it : Iterable<DataSnapshot> = p0!!.children

                        it.forEach{
                            var msg = ""
                            var itr = it.children
                            itr.forEach{
                                msg = msg+"\n"+it.value
                            }
                            refd.child(msg.trim()).child("database6").push().child("iso").setValue(dataiso)
                            db.inserData6( kirim, jalan1_1.trim(), date_2.toString().trim(), time_2.toString().trim())
                            toast()
                        }
                    }
                    override fun onCancelled(p0: DatabaseError) {
                        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                    }
                })

            }
            else if (panjang == 2) {
                val jalan1_1 = etminta.text.toString().trim()
                val jalan1_2 = "000000${jalan1_1}"
                val date_1 = SimpleDateFormat("dd/MM/yyyy")
                val date_2 = date_1.format(Date())
                val time_1 = SimpleDateFormat("hh:mm:ss")
                val time_2 = time_1.format(Date())

                val dataiso  = "${iso}${jalan1_2}"

                val kirim = "Minta dana"

                refc.addListenerForSingleValueEvent(object : ValueEventListener {

                    override fun onDataChange(p0: DataSnapshot)  {

                        var it : Iterable<DataSnapshot> = p0!!.children

                        it.forEach{
                            var msg = ""
                            var itr = it.children
                            itr.forEach{
                                msg = msg+"\n"+it.value
                            }
                            refd.child(msg.trim()).child("database6").push().child("iso").setValue(dataiso)
                            db.inserData6( kirim, jalan1_1.trim(), date_2.toString().trim(), time_2.toString().trim())
                            toast()
                        }
                    }
                    override fun onCancelled(p0: DatabaseError) {
                        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                    }
                })

            }
            else if (panjang == 3) {
                val jalan1_1 = etminta.text.toString().trim()
                val jalan1_2 = "00000${jalan1_1}"
                val date_1 = SimpleDateFormat("dd/MM/yyyy")
                val date_2 = date_1.format(Date())
                val time_1 = SimpleDateFormat("hh:mm:ss")
                val time_2 = time_1.format(Date())

                val dataiso  = "${iso}${jalan1_2}"

                val kirim = "Minta dana"

                refc.addListenerForSingleValueEvent(object : ValueEventListener {

                    override fun onDataChange(p0: DataSnapshot)  {

                        var it : Iterable<DataSnapshot> = p0!!.children

                        it.forEach{
                            var msg = ""
                            var itr = it.children
                            itr.forEach{
                                msg = msg+"\n"+it.value
                            }
                            refd.child(msg.trim()).child("database6").push().child("iso").setValue(dataiso)
                            db.inserData6( kirim, jalan1_1.trim(), date_2.toString().trim(), time_2.toString().trim())
                            toast()
                        }
                    }
                    override fun onCancelled(p0: DatabaseError) {
                        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                    }
                })

            }
            else if (panjang == 4) {
                val jalan1_1 = etminta.text.toString().trim()
                val jalan1_2 = "0000${jalan1_1}"
                val date_1 = SimpleDateFormat("dd/MM/yyyy")
                val date_2 = date_1.format(Date())
                val time_1 = SimpleDateFormat("hh:mm:ss")
                val time_2 = time_1.format(Date())

                val dataiso  = "${iso}${jalan1_2}"

                val kirim = "Minta dana"

                refc.addListenerForSingleValueEvent(object : ValueEventListener {

                    override fun onDataChange(p0: DataSnapshot)  {

                        var it : Iterable<DataSnapshot> = p0!!.children

                        it.forEach{
                            var msg = ""
                            var itr = it.children
                            itr.forEach{
                                msg = msg+"\n"+it.value
                            }
                            refd.child(msg.trim()).child("database6").push().child("iso").setValue(dataiso)
                            db.inserData6( kirim, jalan1_1.trim(), date_2.toString().trim(), time_2.toString().trim())
                            toast()
                        }
                    }
                    override fun onCancelled(p0: DatabaseError) {
                        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                    }
                })

            }
            else if (panjang == 5) {
                val jalan1_1 = etminta.text.toString().trim()
                val jalan1_2 = "000${jalan1_1}"
                val date_1 = SimpleDateFormat("dd/MM/yyyy")
                val date_2 = date_1.format(Date())
                val time_1 = SimpleDateFormat("hh:mm:ss")
                val time_2 = time_1.format(Date())

                val dataiso  = "${iso}${jalan1_2}"

                val kirim = "Minta dana"

                refc.addListenerForSingleValueEvent(object : ValueEventListener {

                    override fun onDataChange(p0: DataSnapshot)  {

                        var it : Iterable<DataSnapshot> = p0!!.children

                        it.forEach{
                            var msg = ""
                            var itr = it.children
                            itr.forEach{
                                msg = msg+"\n"+it.value
                            }
                            refd.child(msg.trim()).child("database6").push().child("iso").setValue(dataiso)
                            db.inserData6( kirim, jalan1_1.trim(), date_2.toString().trim(), time_2.toString().trim())
                            toast()
                        }
                    }
                    override fun onCancelled(p0: DatabaseError) {
                        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                    }
                })

            }
            else if (panjang == 6) {
                val jalan1_1 = etminta.text.toString().trim()
                val jalan1_2 = "00${jalan1_1}"
                val date_1 = SimpleDateFormat("dd/MM/yyyy")
                val date_2 = date_1.format(Date())
                val time_1 = SimpleDateFormat("hh:mm:ss")
                val time_2 = time_1.format(Date())

                val dataiso  = "${iso}${jalan1_2}"

                val kirim = "Minta dana"

                refc.addListenerForSingleValueEvent(object : ValueEventListener {

                    override fun onDataChange(p0: DataSnapshot)  {

                        var it : Iterable<DataSnapshot> = p0!!.children

                        it.forEach{
                            var msg = ""
                            var itr = it.children
                            itr.forEach{
                                msg = msg+"\n"+it.value
                            }
                            refd.child(msg.trim()).child("database6").push().child("iso").setValue(dataiso)
                            db.inserData6( kirim, jalan1_1.trim(), date_2.toString().trim(), time_2.toString().trim())
                            toast()
                        }
                    }
                    override fun onCancelled(p0: DatabaseError) {
                        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                    }
                })

            }
            else if (panjang == 7) {
                val jalan1_1 = etminta.text.toString().trim()
                val jalan1_2 = "0${jalan1_1}"
                val date_1 = SimpleDateFormat("dd/MM/yyyy")
                val date_2 = date_1.format(Date())
                val time_1 = SimpleDateFormat("hh:mm:ss")
                val time_2 = time_1.format(Date())

                val dataiso  = "${iso}${jalan1_2}"

                val kirim = "Minta dana"

                refc.addListenerForSingleValueEvent(object : ValueEventListener {

                    override fun onDataChange(p0: DataSnapshot)  {

                        var it : Iterable<DataSnapshot> = p0!!.children

                        it.forEach{
                            var msg = ""
                            var itr = it.children
                            itr.forEach{
                                msg = msg+"\n"+it.value
                            }
                            refd.child(msg.trim()).child("database6").push().child("iso").setValue(dataiso)
                            db.inserData6( kirim, jalan1_1.trim(), date_2.toString().trim(), time_2.toString().trim())
                            toast()
                        }
                    }
                    override fun onCancelled(p0: DatabaseError) {
                        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                    }
                })

            }
            else if (panjang == 8) {
                val jalan1_1 = etminta.text.toString().trim()
                val date_1 = SimpleDateFormat("dd/MM/yyyy")
                val date_2 = date_1.format(Date())
                val time_1 = SimpleDateFormat("hh:mm:ss")
                val time_2 = time_1.format(Date())

                val dataiso  = "${iso}${jalan1_1}"

                val kirim = "Minta dana"

                refc.addListenerForSingleValueEvent(object : ValueEventListener {

                    override fun onDataChange(p0: DataSnapshot)  {

                        var it : Iterable<DataSnapshot> = p0!!.children

                        it.forEach{
                            var msg = ""
                            var itr = it.children
                            itr.forEach{
                                msg = msg+"\n"+it.value
                            }
                            refd.child(msg.trim()).child("database6").push().child("iso").setValue(dataiso)
                            db.inserData6( kirim, jalan1_1.trim(), date_2.toString().trim(), time_2.toString().trim())
                            toast()
                        }
                    }
                    override fun onCancelled(p0: DatabaseError) {
                        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                    }
                })

            }
            else{
                null
            }


        }
    }

    private  fun toast(){
        Toast.makeText(this, "terkirim", Toast.LENGTH_LONG).show()
    }
}
