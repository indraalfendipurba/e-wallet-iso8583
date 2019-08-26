package com.example.e_wallet12021996ver1.ewallet

import android.app.ProgressDialog
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.e_wallet12021996ver1.R
import com.example.e_wallet12021996ver1.databaseSqlite.Database
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.*
import kotlinx.android.synthetic.main.activity_layar_login1.*

class  LayarLogin1 : AppCompatActivity() {
    internal var db = Database (this)
    lateinit var lusername1 : EditText
    lateinit var lpassword1 : EditText
    lateinit var log : DatabaseReference
    lateinit var mAuth: FirebaseAuth
    lateinit var login1 : Button
    lateinit var mProgressDialog : ProgressDialog


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_layar_login1)


        lusername1 = findViewById(R.id.email1)
        lpassword1 = findViewById(R.id.password1)
        login1 = findViewById(R.id.login1)

        log = FirebaseDatabase.getInstance().getReference()

        mProgressDialog = ProgressDialog(this)
        mProgressDialog.setMessage("Sedang memproses...")
        daftart.setOnClickListener {
            //pindah ke activity daftar

            var intent1 = Intent(this, LayarLogin1::class.java)
            startActivity(Intent(this, LayarDaftar::class.java))
        }


        login1.setOnClickListener{
            mProgressDialog.show()
            sign3()
        }

    }

    private fun sign3(){
        val susername1 = lusername1.text.toString().trim()
        val spassword1 = lpassword1.text.toString().trim()
        var akun = FirebaseDatabase.getInstance()
        var ref = akun.getReference("akunortu")
        val cek = lusername1.text
        if (susername1.isEmpty() || spassword1.isEmpty()) {


            Toast.makeText(baseContext, "Tolong isi kolom yang kosong", Toast.LENGTH_SHORT).show()
        }
        else{

            ref.addListenerForSingleValueEvent(object : ValueEventListener {

                override fun onDataChange(p0: DataSnapshot) {
                    var found = false
                    val list = mutableListOf<String>()

                    var it : Iterable<DataSnapshot> = p0!!.children

                    it.forEach{
                        var itr = it.children
                        var msg = ""
                        itr.forEach{
                            msg = msg+it.value

                        }
                        list.add(msg)

                    }
                    ///*
                    for (n in list){
                        if (cek.toString().equals(n)) {

                            found = true
                            break

                        }


                    }
//*/

                    if (found == true) {
                        mAuth = FirebaseAuth.getInstance()


                        mAuth.signInWithEmailAndPassword(susername1, spassword1)
                            // .addOnCompleteListener {  }
                            .addOnCompleteListener(this@LayarLogin1) { task ->
                                if (task.isSuccessful) {
                                    val user = mAuth.currentUser
                                    mProgressDialog.hide()
                                    Toast.makeText(applicationContext, "LOGIN : Berhasil", Toast.LENGTH_LONG).show()
                                    masukintent()
                                    //updateUI(user)
                                    // found3 = false
                                    // }
                                }
                                else {
                                    mProgressDialog.hide()
                                    Toast.makeText(applicationContext, "LOGIN : Gagal", Toast.LENGTH_LONG).show()
                                    //updateUI(null)
                                }
                            }
                    }
                    else{  mProgressDialog.hide()
                        lusername1.error = "email tidak terdaftar, ganti dengan email lain"
                    }
                }
                override fun onCancelled(p0: DatabaseError) {
                    TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                }
            })
        }

    }
    private fun masukintent (){

       // open1()
        startActivity(Intent(this, LayarOrangtua::class.java))
    }

    private fun open1(){
        var ref1 = FirebaseAuth.getInstance().currentUser
        var ref3 = ref1!!.uid
        var fb = FirebaseDatabase.getInstance()
        var refe = fb.getReference("userortu").child(ref3)
        var reff = fb.getReference("infoanak")
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
    }
/*
    public override fun onStart() {
        super.onStart()
        val currentUser = mAuth.currentUser
        //updateUI(currentUser)
    }
*/
}
