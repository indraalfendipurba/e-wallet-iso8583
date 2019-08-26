package com.example.e_wallet12021996ver1.ewallet

import android.annotation.SuppressLint
import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.app.AlertDialog
import android.widget.Toast
import com.example.e_wallet12021996ver1.R
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import kotlinx.android.synthetic.main.activity_layar_kontrolanak.*
import kotlinx.android.synthetic.main.activity_layar_mitra.*

class LayarKontrolanak : AppCompatActivity() {

    var ref1 = FirebaseAuth.getInstance().currentUser
    var ref3 = ref1!!.uid
    var fb = FirebaseDatabase.getInstance()
    var ref = fb.getReference("userortu").child(ref3)
    var refa = fb.getReference("infoanak")
    var ref4 = fb.getReference("infoanak")


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_layar_kontrolanak)



        carrefour1.setOnClickListener {
            set1()
        }

        hillpark1.setOnClickListener {
            set2()
        }

        cinemaxxi1.setOnClickListener {
            set3()
        }

        cgv1.setOnClickListener {
            set4()
        }

        alfamart1.setOnClickListener {
            set5()
        }

        indomaret1.setOnClickListener {
            set6()
        }

        kfc1.setOnClickListener {
            set7()
        }

        starbucks1.setOnClickListener {
            set8()
        }

        sunplaza1.setOnClickListener {
            set9()
        }

        uleekareng1.setOnClickListener {
            set10()
        }
    }

    private fun set1(){

        val builder = AlertDialog.Builder(this@LayarKontrolanak)
        builder.setTitle("Konfirmasi kendali mitra")
        builder.setMessage("\n                  Pilih status mitra!" )

        builder.setPositiveButton("NONAKTIF"){dialog, which ->
            Toast.makeText(applicationContext,"Mitra Carrefour dinonaktifkan", Toast.LENGTH_SHORT).show()
            carrefour1.setBackgroundColor(Color.parseColor("#ffcc0000"))

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
                        refa.child(msg.trim()).child("kontrolmitra").child("carrefour").child("push").child("status").setValue("0001")
                    }

                }

                override fun onCancelled(p0: DatabaseError) {
                    TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                }
            })
        }

        builder.setNegativeButton("AKTIF"){dialog,which ->
            Toast.makeText(applicationContext,"Mitra Carrefour diaktifkan", Toast.LENGTH_SHORT).show()
            carrefour1.setBackgroundColor(Color.parseColor("#38FFFFFF"))

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
                        refa.child(msg.toString().trim()).child("kontrolmitra").child("carrefour").child("push").child("status").setValue("1001")
                    }
                }
                override fun onCancelled(p0: DatabaseError) {
                    TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                }
            })
        }
        val dialog : AlertDialog = builder.create()
        dialog.show()
}

    private fun set2(){

        val builder = AlertDialog.Builder(this@LayarKontrolanak)
        builder.setTitle("Konfirmasi kendali mitra")
        builder.setMessage("\n                  Pilih status mitra!" )

        builder.setPositiveButton("NONAKTIF"){dialog, which ->
            Toast.makeText(applicationContext,"Mitra Hillpark dinonaktifkan", Toast.LENGTH_SHORT).show()
            hillpark1.setBackgroundColor(Color.parseColor("#ffcc0000"))

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
                        refa.child(msg.trim()).child("kontrolmitra").child("hillpark").child("push").child("status").setValue("0002")
                    }
                }

                override fun onCancelled(p0: DatabaseError) {
                    TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                }
            })
        }

        builder.setNegativeButton("AKTIF"){dialog,which ->
            Toast.makeText(applicationContext,"Mitra Hillpark diaktifkan", Toast.LENGTH_SHORT).show()
            hillpark1.setBackgroundColor(Color.parseColor("#38FFFFFF"))

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
                        refa.child(msg.toString().trim()).child("kontrolmitra").child("hillpark").child("push").child("status").setValue("1002")
                    }
                }
                override fun onCancelled(p0: DatabaseError) {
                    TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                }
            })
        }
        val dialog : AlertDialog = builder.create()
        dialog.show()
    }

    private fun set3(){

        val builder = AlertDialog.Builder(this@LayarKontrolanak)
        builder.setTitle("Konfirmasi kendali mitra")
        builder.setMessage("\n                  Pilih status mitra!" )

        builder.setPositiveButton("NONAKTIF"){dialog, which ->
            Toast.makeText(applicationContext,"Mitra cinemaxxi dinonaktifkan", Toast.LENGTH_SHORT).show()
            cinemaxxi1.setBackgroundColor(Color.parseColor("#ffcc0000"))

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
                        refa.child(msg.trim()).child("kontrolmitra").child("cinemaxxi").child("push").child("status").setValue("0003")
                    }
                }

                override fun onCancelled(p0: DatabaseError) {
                    TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                }
            })
        }

        builder.setNegativeButton("AKTIF"){dialog,which ->
            Toast.makeText(applicationContext,"Mitra cinemaxxi diaktifkan", Toast.LENGTH_SHORT).show()
            cinemaxxi1.setBackgroundColor(Color.parseColor("#38FFFFFF"))

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
                        refa.child(msg.toString().trim()).child("kontrolmitra").child("cinemaxxi").child("push").child("status").setValue("1003")
                    }
                }
                override fun onCancelled(p0: DatabaseError) {
                    TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                }
            })
        }
        val dialog : AlertDialog = builder.create()
        dialog.show()
    }

    private fun set4(){

        val builder = AlertDialog.Builder(this@LayarKontrolanak)
        builder.setTitle("Konfirmasi kendali mitra")
        builder.setMessage("\n                  Pilih status mitra!" )

        builder.setPositiveButton("NONAKTIF"){dialog, which ->
            Toast.makeText(applicationContext,"Mitra cgv dinonaktifkan", Toast.LENGTH_SHORT).show()
            cgv1.setBackgroundColor(Color.parseColor("#ffcc0000"))

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
                        refa.child(msg.trim()).child("kontrolmitra").child("cgv").child("push").child("status").setValue("0004")
                    }
                }

                override fun onCancelled(p0: DatabaseError) {
                    TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                }
            })
        }

        builder.setNegativeButton("AKTIF"){dialog,which ->
            Toast.makeText(applicationContext,"Mitra cgv diaktifkan", Toast.LENGTH_SHORT).show()
            cgv1.setBackgroundColor(Color.parseColor("#38FFFFFF"))

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
                        refa.child(msg.toString().trim()).child("kontrolmitra").child("cgv").child("push").child("status").setValue("1004")
                    }
                }
                override fun onCancelled(p0: DatabaseError) {
                    TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                }
            })
        }
        val dialog : AlertDialog = builder.create()
        dialog.show()
    }

    private fun set5(){

        val builder = AlertDialog.Builder(this@LayarKontrolanak)
        builder.setTitle("Konfirmasi kendali mitra")
        builder.setMessage("\n                  Pilih status mitra!" )

        builder.setPositiveButton("NONAKTIF"){dialog, which ->
            Toast.makeText(applicationContext,"Mitra Alfamart dinonaktifkan", Toast.LENGTH_SHORT).show()
            alfamart1.setBackgroundColor(Color.parseColor("#ffcc0000"))

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
                        refa.child(msg.trim()).child("kontrolmitra").child("alfamart").child("push").child("status").setValue("0005")
                    }
                }

                override fun onCancelled(p0: DatabaseError) {
                    TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                }
            })
        }

        builder.setNegativeButton("AKTIF"){dialog,which ->
            Toast.makeText(applicationContext,"Mitra Alfamart diaktifkan", Toast.LENGTH_SHORT).show()
            alfamart1.setBackgroundColor(Color.parseColor("#38FFFFFF"))

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
                        refa.child(msg.toString().trim()).child("kontrolmitra").child("alfamart").child("push").child("status").setValue("1005")
                    }
                }
                override fun onCancelled(p0: DatabaseError) {
                    TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                }
            })
        }
        val dialog : AlertDialog = builder.create()
        dialog.show()
    }

    private fun set6(){

        val builder = AlertDialog.Builder(this@LayarKontrolanak)
        builder.setTitle("Konfirmasi kendali mitra")
        builder.setMessage("\n                  Pilih status mitra!" )

        builder.setPositiveButton("NONAKTIF"){dialog, which ->
            Toast.makeText(applicationContext,"Mitra Indomaret dinonaktifkan", Toast.LENGTH_SHORT).show()
            indomaret1.setBackgroundColor(Color.parseColor("#ffcc0000"))

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
                        refa.child(msg.trim()).child("kontrolmitra").child("indomaret").child("push").child("status").setValue("0006")
                    }
                }

                override fun onCancelled(p0: DatabaseError) {
                    TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                }
            })
        }

        builder.setNegativeButton("AKTIF"){dialog,which ->
            Toast.makeText(applicationContext,"Mitra Indomaret diaktifkan", Toast.LENGTH_SHORT).show()
            indomaret1.setBackgroundColor(Color.parseColor("#38FFFFFF"))

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
                        refa.child(msg.toString().trim()).child("kontrolmitra").child("indomaret").child("push").child("status").setValue("1006")
                    }
                }
                override fun onCancelled(p0: DatabaseError) {
                    TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                }
            })
        }
        val dialog : AlertDialog = builder.create()
        dialog.show()
    }

    private fun set7(){

        val builder = AlertDialog.Builder(this@LayarKontrolanak)
        builder.setTitle("Konfirmasi kendali mitra")
        builder.setMessage("\n                  Pilih status mitra!" )

        builder.setPositiveButton("NONAKTIF"){dialog, which ->
            Toast.makeText(applicationContext,"Mitra KFC dinonaktifkan", Toast.LENGTH_SHORT).show()
            kfc1.setBackgroundColor(Color.parseColor("#ffcc0000"))

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
                        refa.child(msg.trim()).child("kontrolmitra").child("kfc").child("push").child("status").setValue("0007")
                    }
                }

                override fun onCancelled(p0: DatabaseError) {
                    TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                }
            })
        }

        builder.setNegativeButton("AKTIF"){dialog,which ->
            Toast.makeText(applicationContext,"Mitra KFC diaktifkan", Toast.LENGTH_SHORT).show()
            kfc1.setBackgroundColor(Color.parseColor("#38FFFFFF"))

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
                        refa.child(msg.toString().trim()).child("kontrolmitra").child("kfc").child("push").child("status").setValue("1007")
                    }
                }
                override fun onCancelled(p0: DatabaseError) {
                    TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                }
            })
        }
        val dialog : AlertDialog = builder.create()
        dialog.show()
    }

    private fun set8(){

        val builder = AlertDialog.Builder(this@LayarKontrolanak)
        builder.setTitle("Konfirmasi kendali mitra")
        builder.setMessage("\n                  Pilih status mitra!" )

        builder.setPositiveButton("NONAKTIF"){dialog, which ->
            Toast.makeText(applicationContext,"Mitra Starbucks dinonaktifkan", Toast.LENGTH_SHORT).show()
            starbucks1.setBackgroundColor(Color.parseColor("#ffcc0000"))

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
                        refa.child(msg.trim()).child("kontrolmitra").child("starbucks").child("push").child("status").setValue("0008")
                    }
                }

                override fun onCancelled(p0: DatabaseError) {
                    TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                }
            })
        }

        builder.setNegativeButton("AKTIF"){dialog,which ->
            Toast.makeText(applicationContext,"Mitra Starbucks diaktifkan", Toast.LENGTH_SHORT).show()
            starbucks1.setBackgroundColor(Color.parseColor("#38FFFFFF"))

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
                        refa.child(msg.toString().trim()).child("kontrolmitra").child("starbucks").child("push").child("status").setValue("1008")
                    }
                }
                override fun onCancelled(p0: DatabaseError) {
                    TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                }
            })
        }
        val dialog : AlertDialog = builder.create()
        dialog.show()
    }

    private fun set9(){

        val builder = AlertDialog.Builder(this@LayarKontrolanak)
        builder.setTitle("Konfirmasi kendali mitra")
        builder.setMessage("\n                  Pilih status mitra!" )

        builder.setPositiveButton("NONAKTIF"){dialog, which ->
            Toast.makeText(applicationContext,"Mitra Sunplaza dinonaktifkan", Toast.LENGTH_SHORT).show()
            sunplaza1.setBackgroundColor(Color.parseColor("#ffcc0000"))

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
                        refa.child(msg.trim()).child("kontrolmitra").child("sunplaza").child("push").child("status").setValue("0009")
                    }
                }

                override fun onCancelled(p0: DatabaseError) {
                    TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                }
            })
        }

        builder.setNegativeButton("AKTIF"){dialog,which ->
            Toast.makeText(applicationContext,"Mitra Sunplaza diaktifkan", Toast.LENGTH_SHORT).show()
            sunplaza1.setBackgroundColor(Color.parseColor("#38FFFFFF"))

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
                        refa.child(msg.toString().trim()).child("kontrolmitra").child("sunplaza").child("push").child("status").setValue("1009")
                    }
                }
                override fun onCancelled(p0: DatabaseError) {
                    TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                }
            })
        }
        val dialog : AlertDialog = builder.create()
        dialog.show()
    }

    private fun set10(){

        val builder = AlertDialog.Builder(this@LayarKontrolanak)
        builder.setTitle("Konfirmasi kendali mitra")
        builder.setMessage("\n                  Pilih status mitra!" )

        builder.setPositiveButton("NONAKTIF"){dialog, which ->
            Toast.makeText(applicationContext,"Mitra Uleekareng dinonaktifkan", Toast.LENGTH_SHORT).show()
            uleekareng1.setBackgroundColor(Color.parseColor("#ffcc0000"))

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
                        refa.child(msg.trim()).child("kontrolmitra").child("uleekareng").child("push").child("status").setValue("0010")
                    }
                }

                override fun onCancelled(p0: DatabaseError) {
                    TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                }
            })
        }

        builder.setNegativeButton("AKTIF"){dialog,which ->
            Toast.makeText(applicationContext,"Mitra Uleekareng diaktifkan", Toast.LENGTH_SHORT).show()
            uleekareng1.setBackgroundColor(Color.parseColor("#38FFFFFF"))
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
                        refa.child(msg.toString().trim()).child("kontrolmitra").child("uleekareng").child("push").child("status").setValue("1010")
                    }
                }
                override fun onCancelled(p0: DatabaseError) {
                    TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                }
            })
        }
        val dialog : AlertDialog = builder.create()
        dialog.show()
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

                                    carrefour1.setBackgroundColor(Color.parseColor("#ffcc0000"))
                                }
                                else if (code != msg.trim()){

                                    carrefour1.setBackgroundColor(Color.parseColor("#38FFFFFF"))
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

                                    hillpark1.setBackgroundColor(Color.parseColor("#ffcc0000"))
                                }
                                else if (code != msg.trim()){

                                    hillpark1.setBackgroundColor(Color.parseColor("#38FFFFFF"))
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

                                    cinemaxxi1.setBackgroundColor(Color.parseColor("#ffcc0000"))
                                }
                                else if (code != msg.trim()){

                                    cinemaxxi1.setBackgroundColor(Color.parseColor("#38FFFFFF"))
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

                                    cgv1.setBackgroundColor(Color.parseColor("#ffcc0000"))
                                }
                                else if (code != msg.trim()){

                                    cgv1.setBackgroundColor(Color.parseColor("#38FFFFFF"))
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

                                    alfamart1.setBackgroundColor(Color.parseColor("#ffcc0000"))
                                }
                                else if (code != msg.trim()){

                                    alfamart1.setBackgroundColor(Color.parseColor("#38FFFFFF"))
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

                                    indomaret1.setBackgroundColor(Color.parseColor("#ffcc0000"))
                                }
                                else if (code != msg.trim()){

                                    indomaret1.setBackgroundColor(Color.parseColor("#38FFFFFF"))
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

                                    kfc1.setBackgroundColor(Color.parseColor("#ffcc0000"))
                                }
                                else if (code != msg.trim()){

                                    kfc1.setBackgroundColor(Color.parseColor("#38FFFFFF"))
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

                                    starbucks1.setBackgroundColor(Color.parseColor("#ffcc0000"))
                                }
                                else if (code != msg.trim()){

                                    starbucks1.setBackgroundColor(Color.parseColor("#38FFFFFF"))
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

                                    sunplaza1.setBackgroundColor(Color.parseColor("#ffcc0000"))
                                }
                                else if (code != msg.trim()){

                                    sunplaza1.setBackgroundColor(Color.parseColor("#38FFFFFF"))
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

                                    uleekareng1.setBackgroundColor(Color.parseColor("#ffcc0000"))
                                }
                                else if (code != msg.trim()){

                                    uleekareng1.setBackgroundColor(Color.parseColor("#38FFFFFF"))
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
}
