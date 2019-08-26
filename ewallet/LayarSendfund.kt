package com.example.e_wallet12021996ver1.ewallet

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.example.e_wallet12021996ver1.R
import com.example.e_wallet12021996ver1.databaseSqlite.Database
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import java.text.SimpleDateFormat
import java.util.*

class LayarSendfund : AppCompatActivity() {

    internal var db = Database (this)
    lateinit var tv29 : TextView


    var ref1 = FirebaseAuth.getInstance().currentUser
    var ref3 = ref1!!.uid
    var fb = FirebaseDatabase.getInstance()
    var ref = fb.getReference("userortub").child(ref3)
    var refb = fb.getReference("userortu").child(ref3)
    var refa = fb.getReference("infoortu")
    var refc = fb.getReference("infoanak")


    lateinit var etkirim    : EditText
    lateinit var bkirim     : Button
    ///*
    val date1   = SimpleDateFormat("ddMM")
    val year1   = SimpleDateFormat("yyyy")
    val time1   = SimpleDateFormat("hhmmss")
    val date    = date1.format(Date()).toString()
    val year    = year1.format(Date()).toString()
    val time    = time1.format(Date()).toString()
    val mti     = "1210"
    val code    = "000000"
    //val nominal = etkirim.text.toString().trim().toInt()
    val iso     = "${mti}201A001000000000${code}${time}${date}${year}"


//*/

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_layar_sendfund)

        etkirim = findViewById(R.id.etkirim)
        bkirim  = findViewById(R.id.bkirim)
        tv29 = findViewById(R.id.tv29)

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
                                tv29.setText(msg3)
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

        //val waktu = SimpleDateFormat("ddMMyyyy  hh:mm:ss")

        bkirim.setOnClickListener {
            ///var data = etkirim.toString().trim()
            sistemdata1()
           ///jalan1()

        }

    }

    private fun hasilanak(){
        refb.addListenerForSingleValueEvent(object : ValueEventListener {

            override fun onDataChange(p0: DataSnapshot)  {

                var it : Iterable<DataSnapshot> = p0!!.children

                it.forEach{
                    var msg = ""
                    var itr = it.children
                    itr.forEach{
                        msg = msg+it.value
                    }
                   val nilai = msg
                    //refa.child(msg.trim()).child("database1").child("push").child("iso").setValue(dataiso)

                    refc.child(msg.trim()).child("saldo").addListenerForSingleValueEvent(object : ValueEventListener {

                        override fun onDataChange(p0: DataSnapshot)  {

                            var it : Iterable<DataSnapshot> = p0!!.children

                            it.forEach{
                                var msg = ""
                                var itr = it.children
                                itr.forEach{
                                    msg = msg+it.value
                                }
                                //refa.child(msg.trim()).child("database1").child("push").child("iso").setValue(dataiso)
                                val nominal = etkirim.text.toString().trim().toInt()
                                val msg1 = msg.toInt()
                                val hasil = msg1 + nominal
                                refc.child(nilai.trim()).child("saldo").child("push").child("nilai").setValue(hasil.toString().trim())

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

    private fun angka() = object {
        val parts = tv29.text.toString().replace("Rp ", "")
        val data1   = etkirim
        val data2   = data1!!.length()
        val saldo1 = parts.toInt()
        val data3 = etkirim.text.toString().toInt()
        val kosong = ""
        val hasil = saldo1 - data3
    }

    private fun sistemdata1(){

       if(angka().data3 >= angka().saldo1){
         etkirim.error = "Nominal terlalu besar/sama dengan jumlah saldo"
         }

         else {

           if (angka().data2 == 1) {
               val jalan1_1 = etkirim.text.toString().trim()
               val jalan1_2 = "0000000${jalan1_1}"
               val date_1 = SimpleDateFormat("dd/MM/yyyy")
               val date_2 = date_1.format(Date())
               val time_1 = SimpleDateFormat("hh:mm:ss")
               val time_2 = time_1.format(Date())

               val dataiso  = "${iso}${jalan1_2}"

               val kirim = "kirim"

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
                           refa.child(msg.trim()).child("database1").push().child("iso").setValue(dataiso)
                           refa.child(msg.trim()).child("saldo").child("push").child("nilai").setValue(angka().hasil.toString())

                       }
                   }
                   override fun onCancelled(p0: DatabaseError) {
                       TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                   }
               })

               db.inserData1( kirim, jalan1_1.trim(), date_2.toString().trim(), time_2.toString().trim())
               Toast.makeText(this, "terkirim", Toast.LENGTH_LONG).show()
               hasilanak()



           }

           else if (angka().data2 == 2) {
               val jalan1_1 = etkirim.text.toString().trim()
               val jalan1_2 = "000000${jalan1_1}"
               val dataiso  = "${iso}${jalan1_2}"
               val date_1 = SimpleDateFormat("dd/MM/yyyy")
               val date_2 = date_1.format(Date())
               val time_1 = SimpleDateFormat("hh:mm:ss")
               val time_2 = time_1.format(Date())
               var kirim = "kirim"
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
                           refa.child(msg.trim()).child("database1").push().child("iso").setValue(dataiso)
                           refa.child(msg.trim()).child("saldo").child("push").child("nilai").setValue(angka().hasil.toString())

                       }
                   }
                   override fun onCancelled(p0: DatabaseError) {
                       TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                   }
               })
               db.inserData1( kirim.toString().trim(), jalan1_1.toString().trim(), date_2.toString().trim(), time_2.toString().trim())
               Toast.makeText(this, "terkirim", Toast.LENGTH_LONG).show()
               hasilanak()
           }

           else if (angka().data2 == 3) {
               val jalan1_1 = etkirim.text.toString().trim()
               val jalan1_2 = "00000${jalan1_1}"
               val dataiso  = "${iso}${jalan1_2}"
               val date_1 = SimpleDateFormat("dd/MM/yyyy")
               val date_2 = date_1.format(Date())
               val time_1 = SimpleDateFormat("hh:mm:ss")
               val time_2 = time_1.format(Date())
               var kirim = "kirim"
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
                           refa.child(msg.trim()).child("database1").push().child("iso").setValue(dataiso)
                           refa.child(msg.trim()).child("saldo").child("push").child("nilai").setValue(angka().hasil.toString())

                       }
                   }
                   override fun onCancelled(p0: DatabaseError) {
                       TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                   }
               })
               db.inserData1( kirim.toString().trim(), jalan1_1.toString().trim(), date_2.toString().trim(), time_2.toString().trim())
               Toast.makeText(this, "terkirim", Toast.LENGTH_LONG).show()
               hasilanak()
           }

           else if (angka().data2 == 4) {
               val jalan1_1 = etkirim.text.toString().trim()
               val jalan1_2 = "0000${jalan1_1}"
               val dataiso  = "${iso}${jalan1_2}"
               val date_1 = SimpleDateFormat("dd/MM/yyyy")
               val date_2 = date_1.format(Date())
               val time_1 = SimpleDateFormat("hh:mm:ss")
               val time_2 = time_1.format(Date())
               var kirim = "kirim"
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
                           refa.child(msg.trim()).child("database1").push().child("iso").setValue(dataiso)
                           refa.child(msg.trim()).child("saldo").child("push").child("nilai").setValue(angka().hasil.toString())

                       }
                   }
                   override fun onCancelled(p0: DatabaseError) {
                       TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                   }
               })
               db.inserData1( kirim.toString().trim(), jalan1_1.toString().trim(), date_2.toString().trim(), time_2.toString().trim())
               Toast.makeText(this, "terkirim", Toast.LENGTH_LONG).show()
               hasilanak()
           }

           else if (angka().data2 == 5) {
               val jalan1_1 = etkirim.text.toString().trim()
               val jalan1_2 = "000${jalan1_1}"
               val dataiso  = "${iso}${jalan1_2}"
               val date_1 = SimpleDateFormat("dd/MM/yyyy")
               val date_2 = date_1.format(Date())
               val time_1 = SimpleDateFormat("hh:mm:ss")
               val time_2 = time_1.format(Date())
               var kirim = "kirim"
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
                           refa.child(msg.trim()).child("database1").push().child("iso").setValue(dataiso)
                           refa.child(msg.trim()).child("saldo").child("push").child("nilai").setValue(angka().hasil.toString())

                       }
                   }
                   override fun onCancelled(p0: DatabaseError) {
                       TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                   }
               })
               db.inserData1( kirim.toString().trim(), jalan1_1.toString().trim(), date_2.toString().trim(), time_2.toString().trim())
               Toast.makeText(this, "terkirim", Toast.LENGTH_LONG).show()
               hasilanak()
           }

           else if (angka().data2 == 6) {
               val jalan1_1 = etkirim.text.toString().trim()
               val jalan1_2 = "00${jalan1_1}"
               val dataiso  = "${iso}${jalan1_2}"
               val date_1 = SimpleDateFormat("dd/MM/yyyy")
               val date_2 = date_1.format(Date())
               val time_1 = SimpleDateFormat("hh:mm:ss")
               val time_2 = time_1.format(Date())
               var kirim = "kirim"
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
                           refa.child(msg.trim()).child("database1").push().child("iso").setValue(dataiso)
                           refa.child(msg.trim()).child("saldo").child("push").child("nilai").setValue(angka().hasil.toString())

                       }
                   }
                   override fun onCancelled(p0: DatabaseError) {
                       TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                   }
               })
               db.inserData1( kirim.toString().trim(), jalan1_1.toString().trim(), date_2.toString().trim(), time_2.toString().trim())
               Toast.makeText(this, "terkirim", Toast.LENGTH_LONG).show()
                hasilanak()
           }

           else if (angka().data2 == 7) {
               val jalan1_1 = etkirim.text.toString().trim()
               val jalan1_2 = "0${jalan1_1}"
               val dataiso  = "${iso}${jalan1_2}"
               val date_1 = SimpleDateFormat("dd/MM/yyyy")
               val date_2 = date_1.format(Date())
               val time_1 = SimpleDateFormat("hh:mm:ss")
               val time_2 = time_1.format(Date())
               var kirim = "kirim"
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
                           refa.child(msg.trim()).child("database1").push().child("iso").setValue(dataiso)
                           refa.child(msg.trim()).child("saldo").child("push").child("nilai").setValue(angka().hasil.toString())

                       }
                   }
                   override fun onCancelled(p0: DatabaseError) {
                       TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                   }
               })
               db.inserData1( kirim.toString().trim(), jalan1_1.toString().trim(), date_2.toString().trim(), time_2.toString().trim())
               Toast.makeText(this, "terkirim", Toast.LENGTH_LONG).show()
               hasilanak()
           }

           else if (angka().data2 == 8) {
               val jalan1_1 = etkirim.text.toString().trim()
               val dataiso  = "${iso}${jalan1_1}"
               val date_1 = SimpleDateFormat("dd/MM/yyyy")
               val date_2 = date_1.format(Date())
               val time_1 = SimpleDateFormat("hh:mm:ss")
               val time_2 = time_1.format(Date())
               var kirim = "kirim"
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
                           refa.child(msg.trim()).child("database1").push().child("iso").setValue(dataiso)
                           refa.child(msg.trim()).child("saldo").child("push").child("nilai").setValue(angka().hasil.toString())

                       }
                   }
                   override fun onCancelled(p0: DatabaseError) {
                       TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                   }
               })
               db.inserData1( kirim.toString().trim(), jalan1_1.toString().trim(), date_2.toString().trim(), time_2.toString().trim())
               Toast.makeText(this, "terkirim", Toast.LENGTH_LONG).show()
               hasilanak()
           }

           else{
               null
           }
        }


    }
}





