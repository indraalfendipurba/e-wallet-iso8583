package com.example.e_wallet12021996ver1.ewallet

import android.annotation.SuppressLint
import android.app.ProgressDialog
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import com.example.e_wallet12021996ver1.R
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

class LayarDaftar : AppCompatActivity() {


    // private var mAuth: FirebaseAuth? = null
    lateinit var duorangtua: EditText
    lateinit var dporangtua: EditText
    lateinit var duanak: EditText
    lateinit var dpanak: EditText
    lateinit var dporangtua2 : EditText
    lateinit var dpanak2 : EditText

    lateinit var daftart2: Button
    var found1 = true
    var found2 = true
    var found3 = true
    var found4 = true

    lateinit var mAuth: FirebaseAuth
    lateinit var mAuth1: FirebaseAuth
    lateinit var mProgressDialog : ProgressDialog


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_layar_daftar)

        duorangtua = findViewById(R.id.duorangtua)
        dporangtua = findViewById(R.id.dporangtua)
        duanak = findViewById(R.id.duanak)
        dpanak = findViewById(R.id.dpanak)

        dporangtua2 = findViewById(R.id.dporangtua2)

        dpanak2 = findViewById(R.id.dpanak2)


        daftart2 = findViewById(R.id.daftart2)

        mProgressDialog = ProgressDialog(this)
        mProgressDialog.setMessage("Sedang memproses...")
        daftart2.setOnClickListener {
            mProgressDialog.show()
            saveakun1()
        }
    }


    private fun saveakun1() {


        var akun = FirebaseDatabase.getInstance()
        var ref = akun.getReference("akunortu")
        var ref0 = akun.getReference("akunanak")
        var ref1 = ref.child("orangtua")


        var ref2 = ref.child("anak")

        val email1 = duorangtua.text.toString().trim()
        val password1 = dporangtua.text.toString().trim()
        val email2 = duanak.text.toString().trim()
        val password2 = dpanak.text.toString().trim()

        val password1b = dporangtua2.text.toString().trim()

        val password2b = dpanak2.text.toString().trim()

        if (email1.isEmpty() || password1.isEmpty() || email2.isEmpty() || password2.isEmpty() || password1b.isEmpty() || password2b.isEmpty() ) {
            Toast.makeText(applicationContext, "Tolong isi kolom yang kosong", Toast.LENGTH_LONG).show()
            mProgressDialog.hide()
            return
        }

        else if ( email1 == email2){
            Toast.makeText(applicationContext, "Tolong ganti dengan email yang berbeda", Toast.LENGTH_LONG).show()
            mProgressDialog.hide()
            return
        }

        else if ( password1 != password1b || password2 != password2b){
            Toast.makeText(applicationContext, "Tolong ketikan password yang benar", Toast.LENGTH_LONG).show()
            mProgressDialog.hide()
            return
        }

        else {

            val cek = duorangtua.text
            val cek1 = duanak.text
            var akun = FirebaseDatabase.getInstance()
            var ref = akun.getReference("akunortu")
            var ref1 = akun.getReference("akunanak")

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


                    if (found == true) {
                        mProgressDialog.hide()
                        duorangtua.error = "email sudah pernah terdaftar sebelumnya"

                    }
                    else{

                        found1 = false

                    }

                }
                override fun onCancelled(p0: DatabaseError) {
                    TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                }
            })
            ref1.addListenerForSingleValueEvent(object : ValueEventListener {

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

                    for (n in list){
                        if (cek1.toString().equals(n)) {

                            found = true
                            break
                        }
                    }

                    if (found == true) {
                        mProgressDialog.hide()
                        duanak.error = "email sudah pernah terdaftar sebelumnya"

                    }
                    else{
                        found2 = false
                        mulaiintent()
                    }

                }
                override fun onCancelled(p0: DatabaseError) {
                    TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                }
            }
            )
            return
        }
    }
    private fun mulaiintent(){

        if (found1 == false && found2 == false  ){

            val email1 = duorangtua.text.toString().trim()
            val email1b = "${email1.replace(".", "_")}"
            val password1 = dporangtua.text.toString().trim()
            val email2 = duanak.text.toString().trim()
            val email2b = "${email2.replace(".", "_")}"
            val password2 = dpanak.text.toString().trim()
            var akun = FirebaseDatabase.getInstance()

            mAuth = FirebaseAuth.getInstance()
            mAuth1 = FirebaseAuth.getInstance()



            mAuth.createUserWithEmailAndPassword(email1, password1 )
                .addOnCompleteListener(this) { task ->
                    if (task.isSuccessful){
                        var akun = FirebaseDatabase.getInstance()
                        var ref = akun.getReference("userortu")
                        var refb = akun.getReference("userortub")
                        val current1 = ref.child(FirebaseAuth.getInstance().uid.toString()).child("push")
                        val current1b = refb.child(FirebaseAuth.getInstance().uid.toString()).child("push")
                        current1.child("email").setValue(email2b)
                        current1b.child( "email").setValue(email1b)

                        found3 = false

                    }

                }

            mAuth1.createUserWithEmailAndPassword(email2, password2 )
                .addOnCompleteListener(this) { task ->
                    if (task.isSuccessful){
                        var akun = FirebaseDatabase.getInstance()
                        var ref = akun.getReference("useranak")
                        var refb = akun.getReference("useranakb")
                        val current1 = ref.child(FirebaseAuth.getInstance().uid.toString()).child("push")
                        val current1b = refb.child(FirebaseAuth.getInstance().uid.toString()).child("push")
                        current1.child("email").setValue(email1b)
                        current1b.child("email").setValue(email2b)

                        found4 = false
                        mulaiintent1()
                    }
                    else{
                        mulaiintent1()
                    }
                }
        }
    }

    private  fun mulaiintent1(){
        if (found3 == false && found4 == false){

            var akun = FirebaseDatabase.getInstance()
            var ref = akun.getReference("akunortu")
            var ref0 = akun.getReference("akunanak")
            var ref1 = akun.getReference("infoortu")
            var ref2 = akun.getReference("infoanak")
            var ref3 = akun.getReference("infoortu ")
            var ref4 = akun.getReference("infoanak")
            // var ref1 = akun.getReference("pesanuser1")
            // var ref2 = akun.getReference("pesanuser2")

            val email1 = duorangtua.text.toString().trim()
            val email1b = "${email1.replace(".", "_")}"
            val password1 = dporangtua.text.toString().trim()
            val email2 = duanak.text.toString().trim()
            val email2b = "${email2.replace(".", "_")}"
            val password2 = dpanak.text.toString().trim()
            val akun1Id = ref.push().key
            val akun2Id = ref0.push().key

            val akun5Id = ref.push().key
            val akun6Id = ref0.push().key

            val mitra = ref2.child(email2b).child("kontrolmitra")
            //  val akun3Id = ref.push().key
            // val akun4Id = ref.push().key


            ref.child(akun1Id.toString()).child("orangtua").setValue(email1)
            ref0.child(akun2Id.toString()).child("anak").setValue(email2)

            ref1.child(email1b).child("saldo").child("push").child("nilai").setValue("5000000")
            ref2.child(email2b).child("saldo").child("push").child("nilai").setValue("5000000")
            mitra.child("carrefour").child("push").child("status").setValue("1001")
            mitra.child("hillpark").child("push").child("status").setValue("1002")
            mitra.child("cinemaxxi").child("push").child("status").setValue("1003")
            mitra.child("cgv").child("push").child("status").setValue("1004")
            mitra.child("alfamart").child("push").child("status").setValue("1005")
            mitra.child("indomaret").child("push").child("status").setValue("1006")
            mitra.child("kfc").child("push").child("status").setValue("1007")
            mitra.child("starbucks").child("push").child("status").setValue("1008")
            mitra.child("sunplaza").child("push").child("status").setValue("1009")
            mitra.child("uleekareng").child("push").child("status").setValue("1010")


            //ref1.child(akun3Id.toString()).child(email1).setValue("coba")
            // ref2.child(akun4Id.toString()).child(email2).setValue("coba")
            mProgressDialog.hide()
            Toast.makeText(applicationContext, "Akun telah didaftar", Toast.LENGTH_LONG).show()
            var intent9 = Intent(this, LayarDaftar::class.java)
            startActivity(Intent(this, LayarUtama::class.java))

        }
        else{
            mProgressDialog.hide()
            Toast.makeText(applicationContext, "Akun gagal didaftar", Toast.LENGTH_LONG).show()

        }
    }


    override fun onStop() {
        super.onStop()
        found1 = true
        found2 = true
        found3 = true
        found4 = true
    }
}