package com.example.e_wallet12021996ver1.ScanMitra

import android.app.Activity
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.app.AlertDialog
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.example.e_wallet12021996ver1.R
import com.example.e_wallet12021996ver1.databaseSqlite.Database
import com.example.e_wallet12021996ver1.ewallet.LayarMitra
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import com.google.zxing.integration.android.IntentIntegrator
import kotlinx.android.synthetic.main.activity_mitra_2.*
import kotlinx.android.synthetic.main.activity_mitra_5.*
import java.text.SimpleDateFormat
import java.util.*

class Mitra_5 : AppCompatActivity() {

    var ref1 = FirebaseAuth.getInstance().currentUser
    var ref3 = ref1!!.uid
    var fb = FirebaseDatabase.getInstance()
    var ref = fb.getReference("useranakb").child(ref3)
    var refa = fb.getReference("infoanak")

    val date1   = SimpleDateFormat("ddMM")
    val year1   = SimpleDateFormat("yyyy")
    val time1   = SimpleDateFormat("hhmmss")
    val date    = date1.format(Date()).toString()
    val year    = year1.format(Date()).toString()
    val time    = time1.format(Date()).toString()
    val mti     = "1210"
    val code    = "000110"
    //val nominal = etkirim.text.toString().trim().toInt()
    val iso     = "${mti}201A401000000000${code}${time}${date}${year}0005"
    internal var db = Database(this)
    lateinit var tv     : TextView
    lateinit var btn    : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mitra_5)
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

                    refa.child(msg.trim()).child("saldo").addListenerForSingleValueEvent(object : ValueEventListener {

                        override fun onDataChange(p0: DataSnapshot)  {
                            var list1 = mutableListOf<String>()
                            var it : Iterable<DataSnapshot> = p0!!.children

                            it.forEach{
                                var msg = ""
                                var itr = it.children
                                itr.forEach{
                                    msg = msg+it.value
                                }

                                var msg3 = "Rp ${msg}"
                                tvscan5.setText(msg3)

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
        tv  = findViewById(R.id.tvscan5)
        btn = findViewById(R.id.bscan5)

        btn.setOnClickListener {
            val scanner = IntentIntegrator(this)
            scanner.setDesiredBarcodeFormats(IntentIntegrator.QR_CODE)
            //scanner.setBeepEnabled(false)
            scanner.initiateScan()
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if(resultCode == Activity.RESULT_OK){
            val result = IntentIntegrator.parseActivityResult(requestCode, resultCode, data)
            if(result != null){
                if (result.contents == null){
                    Toast.makeText(this, "Cancelled", Toast.LENGTH_LONG).show()
                }
                else{
                    //Toast.makeText(this, "Scanned: " + result.contents, Toast.LENGTH_LONG).show()
                    val hasil = result.contents.toString().trim()
                    val hasil2 = hasil.substring(0, 4)
                    val hasil01 = hasil.length
                    val hasil02 = hasil.substring(4, hasil01)
                    val rp = "Rp ${hasil02}"
                    val hasil3 = hasil2.toInt()
                    val code = ("1005").toInt()
                    val hasil4 = tvscan5.text.toString().replace("Rp ", "")
                    val hasil5 = hasil4.toInt() - hasil02.toInt()

                    if (hasil3 == code) {

                        if(hasil5 < 0){
                            val builder = AlertDialog.Builder(this@Mitra_5)
                            builder.setTitle("Transaksi Gagal")
                            builder.setMessage("Saldo anda tidak mencukupi")
                            builder.setNeutralButton("Kembali"){_,_ ->
                                Toast.makeText(applicationContext,"Transaksi dibatalkan", Toast.LENGTH_SHORT).show()
                            }

                            val dialog : AlertDialog = builder.create()
                            dialog.show()
                        }
                        else{
                            // /*
                            val builder = AlertDialog.Builder(this@Mitra_5)
                            builder.setTitle("Konfirmasi transaksi")
                            builder.setMessage("Apakah anda ingin membayar ${rp} kepada mitra Mitra5")

                            builder.setPositiveButton("YA"){dialog, which ->
                                Toast.makeText(applicationContext,"Transaksi anda akan diproses...", Toast.LENGTH_SHORT).show()
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
                                            val date_1 = SimpleDateFormat("dd/MM/yyyy")
                                            val date_2 = date_1.format(Date())
                                            val time_1 = SimpleDateFormat("hh:mm:ss")
                                            val time_2 = time_1.format(Date())
                                            val panjang = hasil02.length
                                            if(panjang == 1)
                                            {
                                                val panjang1 = "0000000${hasil02}"
                                                val dataiso = "${iso}${panjang1}"
                                                refa.child(msg.trim()).child("database4").push().child("iso").setValue(dataiso.trim())
                                                refa.child(msg.trim()).child("saldo").child("push").child("nilai").setValue("${hasil5}")
                                                db.inserData4("Mitra5", "${hasil02}", "${date_2}", "${time_2}")
                                                tampil()
                                            }

                                            else if(panjang == 2)
                                            {
                                                val panjang1 = "000000${hasil02}"
                                                val dataiso = "${iso}${panjang1}"
                                                refa.child(msg.trim()).child("database4").push().child("iso").setValue(dataiso.trim())
                                                db.inserData4("Mitra5", "${hasil02}", "${date_2}", "${time_2}")
                                                refa.child(msg.trim()).child("saldo").child("push").child("nilai").setValue("${hasil5}")
                                                tampil()
                                            }

                                            else if(panjang == 3)
                                            {
                                                val panjang1 = "00000${hasil02}"
                                                val dataiso = "${iso}${panjang1}"
                                                refa.child(msg.trim()).child("database4").push().child("iso").setValue(dataiso.trim())
                                                db.inserData4("Mitra5", "${hasil02}", "${date_2}", "${time_2}")
                                                refa.child(msg.trim()).child("saldo").child("push").child("nilai").setValue("${hasil5}")
                                                tampil()
                                            }

                                            else if(panjang == 4)
                                            {
                                                val panjang1 = "0000${hasil02}"
                                                val dataiso = "${iso}${panjang1}"
                                                refa.child(msg.trim()).child("database4").push().child("iso").setValue(dataiso.trim())
                                                db.inserData4("Mitra5", "${hasil02}", "${date_2}", "${time_2}")
                                                refa.child(msg.trim()).child("saldo").child("push").child("nilai").setValue("${hasil5}")
                                                tampil()
                                            }

                                            else if(panjang == 5)
                                            {
                                                val panjang1 = "000${hasil02}"
                                                val dataiso = "${iso}${panjang1}"
                                                refa.child(msg.trim()).child("database4").push().child("iso").setValue(dataiso.trim())
                                                db.inserData4("Mitra5", "${hasil02}", "${date_2}", "${time_2}")
                                                refa.child(msg.trim()).child("saldo").child("push").child("nilai").setValue("${hasil5}")
                                                tampil()
                                            }

                                            else if(panjang == 6)
                                            {
                                                val panjang1 = "00${hasil02}"
                                                val dataiso = "${iso}${panjang1}"
                                                refa.child(msg.trim()).child("database4").push().child("iso").setValue(dataiso.trim())
                                                db.inserData4("Mitra5", "${hasil02}", "${date_2}", "${time_2}")
                                                refa.child(msg.trim()).child("saldo").child("push").child("nilai").setValue("${hasil5}")
                                                tampil()
                                            }

                                            else if(panjang == 7)
                                            {
                                                val panjang1 = "0${hasil02}"
                                                val dataiso = "${iso}${panjang1}"
                                                refa.child(msg.trim()).child("database4").push().child("iso").setValue(dataiso.trim())
                                                db.inserData4("Mitra5", "${hasil02}", "${date_2}", "${time_2}")
                                                refa.child(msg.trim()).child("saldo").child("push").child("nilai").setValue("${hasil5}")
                                                tampil()
                                            }

                                            else if(panjang == 8)
                                            {
                                                val panjang1 = "${hasil02}"
                                                val dataiso = "${iso}${panjang1}"
                                                refa.child(msg.trim()).child("database4").push().child("iso").setValue(dataiso.trim())
                                                db.inserData4("Mitra5", "${hasil02}", "${date_2}", "${time_2}")
                                                refa.child(msg.trim()).child("saldo").child("push").child("nilai").setValue("${hasil5}")
                                                tampil()
                                            }

                                        }
                                    }
                                    override fun onCancelled(p0: DatabaseError) {
                                        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                                    }
                                })
                            }

                            builder.setNegativeButton("TIDAK"){dialog,which ->
                                Toast.makeText(applicationContext,"Transaksi dibatalkan", Toast.LENGTH_SHORT).show()
                            }

                            val dialog : AlertDialog = builder.create()
                            dialog.show()
                            //*/
                        }

                    }
                    else
                    {
                        val builder = AlertDialog.Builder(this@Mitra_5)
                        builder.setTitle("Transaksi Gagal")
                        builder.setMessage("QR Code yang anda scan bukan dari mitra Mitra5")
                        builder.setNeutralButton("Kembali"){_,_ ->
                            Toast.makeText(applicationContext,"Transaksi dibatalkan", Toast.LENGTH_SHORT).show()
                        }

                        val dialog : AlertDialog = builder.create()
                        dialog.show()
                    }
                }
            }else{
                super.onActivityResult(requestCode, resultCode, data)
            }
        }
    }
    private fun tampil(){
        Toast.makeText(applicationContext,"Transaksi berhasil dilakukan", Toast.LENGTH_SHORT).show()
        onBackPressed()
        //startActivity(Intent(this, LayarMitra::class.java))
    }
}
