package com.example.e_wallet12021996ver1.ewallet

import android.content.Intent
import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.app.AlertDialog
import android.widget.ImageButton
import android.widget.Toast
import com.example.e_wallet12021996ver1.R
import com.example.e_wallet12021996ver1.ScanMitra.*
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import kotlinx.android.synthetic.main.activity_layar_kontrolanak.*
import kotlinx.android.synthetic.main.activity_layar_mitra.*

class LayarMitra : AppCompatActivity() {

    lateinit var tv1    : ImageButton
    lateinit var tv2    : ImageButton
    lateinit var tv3    : ImageButton
    lateinit var tv4    : ImageButton
    lateinit var tv5    : ImageButton
    lateinit var tv6    : ImageButton
    lateinit var tv7    : ImageButton
    lateinit var tv8    : ImageButton
    lateinit var tv9    : ImageButton
    lateinit var tv10   : ImageButton

    var ref1 = FirebaseAuth.getInstance().currentUser
    var ref3 = ref1!!.uid
    var fb = FirebaseDatabase.getInstance()
    var ref = fb.getReference("useranakb").child(ref3)
    var ref4 = fb.getReference("infoanak")
    var nilai = false
    var nilai2 = false
    var nilai3 = false
    var nilai4 = false
    var nilai5 = false
    var nilai6 = false
    var nilai7 = false
    var nilai8 = false
    var nilai9 = false
    var nilai10 = false


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_layar_mitra)

        tv1 = findViewById(R.id.carrefourt2)
        tv2 = findViewById(R.id.hillparkt2)
        tv3 = findViewById(R.id.cinemaxxit2)
        tv4 = findViewById(R.id.cgvt2)
        tv5 = findViewById(R.id.alfamartt2)
        tv6 = findViewById(R.id.indomarett2)
        tv7 = findViewById(R.id.kfct2)
        tv8 = findViewById(R.id.starbuckst2)
        tv9 = findViewById(R.id.sunplazat2)
        tv10 = findViewById(R.id.uleekarengt2)



        mitra()

    }

    override fun onStart() {
        super.onStart()
        //1
        ref.addListenerForSingleValueEvent(object : ValueEventListener {

            override fun onDataChange(p0: DataSnapshot)  {
                var it : Iterable<DataSnapshot> = p0!!.children
                it.forEach{
                    var msg = ""
                    var itr = it.children
                    itr.forEach{
                        msg = msg+"\n"+it.value
                    }
                    val msg2 =  ref4.child(msg.trim()).child("kontrolmitra").child("carrefour")
                    msg2.addListenerForSingleValueEvent(object : ValueEventListener {

                        override fun onDataChange(p0: DataSnapshot)  {
                            //var list1 = mutableListOf<String>()
                            var it : Iterable<DataSnapshot> = p0!!.children

                            it.forEach{
                                var msg = ""
                                var itr = it.children
                                itr.forEach{
                                    msg = msg+"\n"+it.value
                                }
                                val code = "0001"
                                if (code == msg.trim()) {
                                    nilai = false
                                    carrefourt2.setBackgroundColor(Color.parseColor("#ffcc0000"))
                                }
                                else if (code != msg.trim()){
                                    nilai = true
                                    carrefourt2.setBackgroundColor(Color.parseColor("#38FFFFFF"))
                                }
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
        //2
        ref.addListenerForSingleValueEvent(object : ValueEventListener {

            override fun onDataChange(p0: DataSnapshot)  {
                var it : Iterable<DataSnapshot> = p0!!.children
                it.forEach{
                    var msg = ""
                    var itr = it.children
                    itr.forEach{
                        msg = msg+"\n"+it.value
                    }
                    val msg2 =  ref4.child(msg.trim()).child("kontrolmitra").child("hillpark")
                    msg2.addListenerForSingleValueEvent(object : ValueEventListener {

                        override fun onDataChange(p0: DataSnapshot)  {
                            //var list1 = mutableListOf<String>()
                            var it : Iterable<DataSnapshot> = p0!!.children

                            it.forEach{
                                var msg = ""
                                var itr = it.children
                                itr.forEach{
                                    msg = msg+"\n"+it.value
                                }
                                val code = "0002"
                                if (code == msg.trim()) {
                                    nilai2 = false
                                    hillparkt2.setBackgroundColor(Color.parseColor("#ffcc0000"))
                                }
                                else if (code != msg.trim()){
                                    nilai2 = true
                                    hillparkt2.setBackgroundColor(Color.parseColor("#38FFFFFF"))
                                }
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
        //3
        ref.addListenerForSingleValueEvent(object : ValueEventListener {

            override fun onDataChange(p0: DataSnapshot)  {
                var it : Iterable<DataSnapshot> = p0!!.children
                it.forEach{
                    var msg = ""
                    var itr = it.children
                    itr.forEach{
                        msg = msg+"\n"+it.value
                    }
                    val msg2 =  ref4.child(msg.trim()).child("kontrolmitra").child("cinemaxxi")
                    msg2.addListenerForSingleValueEvent(object : ValueEventListener {

                        override fun onDataChange(p0: DataSnapshot)  {
                            //var list1 = mutableListOf<String>()
                            var it : Iterable<DataSnapshot> = p0!!.children

                            it.forEach{
                                var msg = ""
                                var itr = it.children
                                itr.forEach{
                                    msg = msg+"\n"+it.value
                                }
                                val code = "0003"
                                if (code == msg.trim()) {
                                    nilai3 = false
                                    cinemaxxit2.setBackgroundColor(Color.parseColor("#ffcc0000"))
                                }
                                else if (code != msg.trim()){
                                    nilai3 = true
                                    cinemaxxit2.setBackgroundColor(Color.parseColor("#38FFFFFF"))
                                }
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
        //4
        ref.addListenerForSingleValueEvent(object : ValueEventListener {

            override fun onDataChange(p0: DataSnapshot)  {
                var it : Iterable<DataSnapshot> = p0!!.children
                it.forEach{
                    var msg = ""
                    var itr = it.children
                    itr.forEach{
                        msg = msg+"\n"+it.value
                    }
                    val msg2 =  ref4.child(msg.trim()).child("kontrolmitra").child("cgv")
                    msg2.addListenerForSingleValueEvent(object : ValueEventListener {

                        override fun onDataChange(p0: DataSnapshot)  {
                            //var list1 = mutableListOf<String>()
                            var it : Iterable<DataSnapshot> = p0!!.children

                            it.forEach{
                                var msg = ""
                                var itr = it.children
                                itr.forEach{
                                    msg = msg+"\n"+it.value
                                }
                                val code = "0004"
                                if (code == msg.trim()) {
                                    nilai4 = false
                                    cgvt2.setBackgroundColor(Color.parseColor("#ffcc0000"))
                                }
                                else if (code != msg.trim()){
                                    nilai4 = true
                                    cgvt2.setBackgroundColor(Color.parseColor("#38FFFFFF"))
                                }
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
        //5
        ref.addListenerForSingleValueEvent(object : ValueEventListener {

            override fun onDataChange(p0: DataSnapshot)  {
                var it : Iterable<DataSnapshot> = p0!!.children
                it.forEach{
                    var msg = ""
                    var itr = it.children
                    itr.forEach{
                        msg = msg+"\n"+it.value
                    }
                    val msg2 =  ref4.child(msg.trim()).child("kontrolmitra").child("alfamart")
                    msg2.addListenerForSingleValueEvent(object : ValueEventListener {

                        override fun onDataChange(p0: DataSnapshot)  {
                            //var list1 = mutableListOf<String>()
                            var it : Iterable<DataSnapshot> = p0!!.children

                            it.forEach{
                                var msg = ""
                                var itr = it.children
                                itr.forEach{
                                    msg = msg+"\n"+it.value
                                }
                                val code = "0005"
                                if (code == msg.trim()) {
                                    nilai5 = false
                                    alfamartt2.setBackgroundColor(Color.parseColor("#ffcc0000"))
                                }
                                else if (code != msg.trim()){
                                    nilai5 = true
                                    alfamartt2.setBackgroundColor(Color.parseColor("#38FFFFFF"))
                                }
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
        //6
        ref.addListenerForSingleValueEvent(object : ValueEventListener {

            override fun onDataChange(p0: DataSnapshot)  {
                var it : Iterable<DataSnapshot> = p0!!.children
                it.forEach{
                    var msg = ""
                    var itr = it.children
                    itr.forEach{
                        msg = msg+"\n"+it.value
                    }
                    val msg2 =  ref4.child(msg.trim()).child("kontrolmitra").child("indomaret")
                    msg2.addListenerForSingleValueEvent(object : ValueEventListener {

                        override fun onDataChange(p0: DataSnapshot)  {
                            //var list1 = mutableListOf<String>()
                            var it : Iterable<DataSnapshot> = p0!!.children

                            it.forEach{
                                var msg = ""
                                var itr = it.children
                                itr.forEach{
                                    msg = msg+"\n"+it.value
                                }
                                val code = "0006"
                                if (code == msg.trim()) {
                                    nilai6 = false
                                    indomarett2.setBackgroundColor(Color.parseColor("#ffcc0000"))
                                }
                                else if (code != msg.trim()){
                                    nilai6 = true
                                    indomarett2.setBackgroundColor(Color.parseColor("#38FFFFFF"))
                                }
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
        //7
        ref.addListenerForSingleValueEvent(object : ValueEventListener {

            override fun onDataChange(p0: DataSnapshot)  {
                var it : Iterable<DataSnapshot> = p0!!.children
                it.forEach{
                    var msg = ""
                    var itr = it.children
                    itr.forEach{
                        msg = msg+"\n"+it.value
                    }
                    val msg2 =  ref4.child(msg.trim()).child("kontrolmitra").child("kfc")
                    msg2.addListenerForSingleValueEvent(object : ValueEventListener {

                        override fun onDataChange(p0: DataSnapshot)  {
                            //var list1 = mutableListOf<String>()
                            var it : Iterable<DataSnapshot> = p0!!.children

                            it.forEach{
                                var msg = ""
                                var itr = it.children
                                itr.forEach{
                                    msg = msg+"\n"+it.value
                                }
                                val code = "0007"
                                if (code == msg.trim()) {
                                    nilai7 = false
                                    kfct2.setBackgroundColor(Color.parseColor("#ffcc0000"))
                                }
                                else if (code != msg.trim()){
                                    nilai7 = true
                                    kfct2.setBackgroundColor(Color.parseColor("#38FFFFFF"))
                                }
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
        //8
        ref.addListenerForSingleValueEvent(object : ValueEventListener {

            override fun onDataChange(p0: DataSnapshot)  {
                var it : Iterable<DataSnapshot> = p0!!.children
                it.forEach{
                    var msg = ""
                    var itr = it.children
                    itr.forEach{
                        msg = msg+"\n"+it.value
                    }
                    val msg2 =  ref4.child(msg.trim()).child("kontrolmitra").child("starbucks")
                    msg2.addListenerForSingleValueEvent(object : ValueEventListener {

                        override fun onDataChange(p0: DataSnapshot)  {
                            //var list1 = mutableListOf<String>()
                            var it : Iterable<DataSnapshot> = p0!!.children

                            it.forEach{
                                var msg = ""
                                var itr = it.children
                                itr.forEach{
                                    msg = msg+"\n"+it.value
                                }
                                val code = "0008"
                                if (code == msg.trim()) {
                                    nilai8 = false
                                    starbuckst2.setBackgroundColor(Color.parseColor("#ffcc0000"))
                                }
                                else if (code != msg.trim()){
                                    nilai8 = true
                                    starbuckst2.setBackgroundColor(Color.parseColor("#38FFFFFF"))
                                }
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
        //9
        ref.addListenerForSingleValueEvent(object : ValueEventListener {

            override fun onDataChange(p0: DataSnapshot)  {
                var it : Iterable<DataSnapshot> = p0!!.children
                it.forEach{
                    var msg = ""
                    var itr = it.children
                    itr.forEach{
                        msg = msg+"\n"+it.value
                    }
                    val msg2 =  ref4.child(msg.trim()).child("kontrolmitra").child("sunplaza")
                    msg2.addListenerForSingleValueEvent(object : ValueEventListener {

                        override fun onDataChange(p0: DataSnapshot)  {
                            //var list1 = mutableListOf<String>()
                            var it : Iterable<DataSnapshot> = p0!!.children

                            it.forEach{
                                var msg = ""
                                var itr = it.children
                                itr.forEach{
                                    msg = msg+"\n"+it.value
                                }
                                val code = "0009"
                                if (code == msg.trim()) {
                                    nilai9 = false
                                    sunplazat2.setBackgroundColor(Color.parseColor("#ffcc0000"))
                                }
                                else if (code != msg.trim()){
                                    nilai9 = true
                                    sunplazat2.setBackgroundColor(Color.parseColor("#38FFFFFF"))
                                }
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
        //10
        ref.addListenerForSingleValueEvent(object : ValueEventListener {

            override fun onDataChange(p0: DataSnapshot)  {
                var it : Iterable<DataSnapshot> = p0!!.children
                it.forEach{
                    var msg = ""
                    var itr = it.children
                    itr.forEach{
                        msg = msg+"\n"+it.value
                    }
                    val msg2 =  ref4.child(msg.trim()).child("kontrolmitra").child("uleekareng")
                    msg2.addListenerForSingleValueEvent(object : ValueEventListener {

                        override fun onDataChange(p0: DataSnapshot)  {
                            //var list1 = mutableListOf<String>()
                            var it : Iterable<DataSnapshot> = p0!!.children

                            it.forEach{
                                var msg = ""
                                var itr = it.children
                                itr.forEach{
                                    msg = msg+"\n"+it.value
                                }
                                val code = "0010"
                                if (code == msg.trim()) {
                                    nilai10 = false
                                    uleekarengt2.setBackgroundColor(Color.parseColor("#ffcc0000"))
                                }
                                else if (code != msg.trim()){
                                    nilai10 = true
                                    uleekarengt2.setBackgroundColor(Color.parseColor("#38FFFFFF"))
                                }
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

    private fun mitra(){
        tv1.setOnClickListener {

            if (nilai == false)
            {
                val builder = AlertDialog.Builder(this@LayarMitra)
                builder.setTitle("Pemberitahuan")
                builder.setMessage("Orangtua anda telah menonaktifkan Mitra1" )

                builder.setNeutralButton("KEMBALI"){dialog, which ->

                }
                val dialog : AlertDialog = builder.create()
                dialog.show()


            }
            else {
                startActivity(Intent(this, Mitra_1::class.java))
            }
        }

        tv2.setOnClickListener {

            if (nilai2 == false)
            {
                val builder = AlertDialog.Builder(this@LayarMitra)
                builder.setTitle("Pemberitahuan")
                builder.setMessage("Orangtua anda telah menonaktifkan Mitra2" )

                builder.setNeutralButton("KEMBALI"){dialog, which ->

                }
                val dialog : AlertDialog = builder.create()
                dialog.show()
            }

            else {
                startActivity(Intent(this, Mitra_2::class.java))
            }
        }

        tv3.setOnClickListener {

            if (nilai3 == false)
            {
                val builder = AlertDialog.Builder(this@LayarMitra)
                builder.setTitle("Pemberitahuan")
                builder.setMessage("Orangtua anda telah menonaktifkan Mitra3" )

                builder.setNeutralButton("KEMBALI"){dialog, which ->
                }
                val dialog : AlertDialog = builder.create()
                dialog.show()
            }

            else {
                startActivity(Intent(this, Mitra_3::class.java))

            }

        }

        tv4.setOnClickListener {
            if (nilai4 == false)
            {
                val builder = AlertDialog.Builder(this@LayarMitra)
                builder.setTitle("Pemberitahuan")
                builder.setMessage("Orangtua anda telah menonaktifkan Mitra4" )

                builder.setNeutralButton("KEMBALI"){dialog, which ->
                }
                val dialog : AlertDialog = builder.create()
                dialog.show()
            }

            else {
                startActivity(Intent(this, Mitra_4::class.java))
            }
        }

        tv5.setOnClickListener {

            if (nilai5 == false)
            {
                val builder = AlertDialog.Builder(this@LayarMitra)
                builder.setTitle("Pemberitahuan")
                builder.setMessage("Orangtua anda telah menonaktifkan Mitra5" )

                builder.setNeutralButton("KEMBALI"){dialog, which ->
                }
                val dialog : AlertDialog = builder.create()
                dialog.show()
            }

            else {
                startActivity(Intent(this, Mitra_5::class.java))
            }


        }

        tv6.setOnClickListener {
            if (nilai6 == false)
            {
                val builder = AlertDialog.Builder(this@LayarMitra)
                builder.setTitle("Pemberitahuan")
                builder.setMessage("Orangtua anda telah menonaktifkan Mitra6" )

                builder.setNeutralButton("KEMBALI"){dialog, which ->
                }
                val dialog : AlertDialog = builder.create()
                dialog.show()
            }

            else {
                startActivity(Intent(this, Mitra_6::class.java))
            }
        }

        tv7.setOnClickListener {
            if (nilai7 == false)
            {
                val builder = AlertDialog.Builder(this@LayarMitra)
                builder.setTitle("Pemberitahuan")
                builder.setMessage("Orangtua anda telah menonaktifkan Mitra7" )

                builder.setNeutralButton("KEMBALI"){dialog, which ->
                }
                val dialog : AlertDialog = builder.create()
                dialog.show()
            }

            else {
                startActivity(Intent(this, Mitra_7::class.java))
            }
        }

        tv8.setOnClickListener {

            if (nilai8 == false)
            {
                val builder = AlertDialog.Builder(this@LayarMitra)
                builder.setTitle("Pemberitahuan")
                builder.setMessage("Orangtua anda telah menonaktifkan Mitra8" )

                builder.setNeutralButton("KEMBALI"){dialog, which ->
                }
                val dialog : AlertDialog = builder.create()
                dialog.show()
            }

            else {
                startActivity(Intent(this, Mitra_8::class.java))
            }
        }

        tv9.setOnClickListener {

            if (nilai9 == false)
            {
                val builder = AlertDialog.Builder(this@LayarMitra)
                builder.setTitle("Pemberitahuan")
                builder.setMessage("Orangtua anda telah menonaktifkan Mitra9" )

                builder.setNeutralButton("KEMBALI"){dialog, which ->
                }
                val dialog : AlertDialog = builder.create()
                dialog.show()
            }

            else {
                startActivity(Intent(this, Mitra_9::class.java))
            }


        }

        tv10.setOnClickListener {

            if (nilai10 == false)
            {
                val builder = AlertDialog.Builder(this@LayarMitra)
                builder.setTitle("Pemberitahuan")
                builder.setMessage("Orangtua anda telah menonaktifkan Mitra10" )

                builder.setNeutralButton("KEMBALI"){dialog, which ->
                }
                val dialog : AlertDialog = builder.create()
                dialog.show()
            }

            else {
                startActivity(Intent(this, Mitra_10::class.java))
            }
        }
    }
}
