package com.example.e_wallet12021996ver1.adapters

import android.app.AlertDialog
import android.content.Context
import android.content.Intent
import android.support.v4.content.ContextCompat.startActivity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageButton
import android.widget.TextView
import android.widget.Toast
import com.example.e_wallet12021996ver1.R
import com.example.e_wallet12021996ver1.databaseSqlite.Database
import com.example.e_wallet12021996ver1.ewallet.LayarKontrolanak
import com.example.e_wallet12021996ver1.ewallet.LayarSendfund
import com.example.e_wallet12021996ver1.models.model2
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import java.text.SimpleDateFormat
import java.util.*

class  Adapter2 (var mCtx : Context, var resource : Int, var items : List<model2>)
    : ArrayAdapter<model2>(mCtx, resource, items){

    internal var db = Database(mCtx)
    var ref1 = FirebaseAuth.getInstance().currentUser
    var ref3 = ref1!!.uid
    var fb = FirebaseDatabase.getInstance()
    var ref = fb.getReference("userortu").child(ref3)
    var refa = fb.getReference("infoanak")
    var refd = fb.getReference("userortu").child(ref3)
    var reff = fb.getReference("infoanak")
    var refb = fb.getReference("userortub").child(ref3)
    var refc = fb.getReference("infoortu")



    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {

        val layout : LayoutInflater = LayoutInflater.from(mCtx)
        val view : View = layout.inflate(resource, null)


        val kirim : TextView = view.findViewById(R.id.elv2_1kirim)
        val dana : TextView = view.findViewById(R.id.elv2_2dana)
        val tgl : TextView = view.findViewById(R.id.elv2_3tgl)
        val jam : TextView = view.findViewById(R.id.elv2_4jam)

        val terima : ImageButton = view.findViewById(R.id.elv2_5terima)
        val hapus : ImageButton = view.findViewById(R.id.elv2_6hapus)

        val data : model2 = items[position]


        kirim.text = data.kirim
        dana.text = data.dana
        tgl.text = data.tgl
        jam.text = data.jam

        hapus.setOnClickListener {
            delete(data)
            jalan2(data)
            // build()
        }

        terima.setOnClickListener {
            terima(data)
        }
        return view
    }

    fun delete(data : model2){
        db.deleteData2(data.id)
    }
    fun terima(data : model2){
        val psn = data.dana
        val builder = AlertDialog.Builder(mCtx)
        builder.setTitle("Permintahan dana")
        builder.setMessage("Apakah anda ingin memberikan dana sebesar Rp ${psn} kepada anak anda?")

        builder.setPositiveButton("terima"){dialog, which ->
            db.deleteData2(data.id)
            jalan1(data)
            //startActivity(Intent(this, LayarKontrolanak::class.java))
            //setDropDownViewResource(R.layout.activity_layar_sendfund)

        }

        builder.setNegativeButton("tolak"){dialog, which ->
            db.deleteData2(data.id)

            jalan2(data)
        }

        builder.setNeutralButton("kembali"){dialog, which ->
            null
    }
        builder.show()

    }
    fun jalan1(data: model2){

            val psn = data.dana
            ref.addListenerForSingleValueEvent(object : ValueEventListener {

                override fun onDataChange(p0: DataSnapshot)  {

                    var it : Iterable<DataSnapshot> = p0!!.children

                    it.forEach{
                        var msg = ""
                        var itr = it.children
                        itr.forEach{
                            msg = msg+"\n"+it.value
                        }

                        //refa.child(msg.trim()).child("database1").child("push").child("iso").setValue()
                        refa.child(msg.trim()).child("saldo").addListenerForSingleValueEvent(object :
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
                                    val saldo = msg.trim().toInt()
                                    val nilai = saldo + psn.toInt()
                                    val panjang = psn.length
                                    val date_1 = SimpleDateFormat("ddMMyyyy")
                                    val date_2 = date_1.format(Date())
                                    val time_1 = SimpleDateFormat("hhmmss")
                                    val time_2 = time_1.format(Date())
                                    val date_1a = SimpleDateFormat("dd/MM/yyyy")
                                    val date_2a = date_1.format(Date())
                                    val time_1a = SimpleDateFormat("hh:mm:ss")
                                    val time_2a = time_1.format(Date())
                                    val dataiso = "1210201A001000000000000011${time_2}${date_2}"
                                    if (panjang == 1) {

                                        val data = "${dataiso}0000000${psn}"
                                       refd.addListenerForSingleValueEvent(object : ValueEventListener {

                                            override fun onDataChange(p0: DataSnapshot)  {
                                                var list1 = mutableListOf<String>()
                                                var it : Iterable<DataSnapshot> = p0!!.children

                                                it.forEach{
                                                    var msg = ""
                                                    var itr = it.children
                                                    itr.forEach{
                                                        msg = msg+"\n"+it.value
                                                    }

                                                    reff.child(msg.trim()).child("saldo").child("push").child("nilai").setValue(nilai.toString().trim())
                                                    refb.addListenerForSingleValueEvent(object : ValueEventListener {

                                                        override fun onDataChange(p0: DataSnapshot)  {

                                                            var it : Iterable<DataSnapshot> = p0!!.children

                                                            it.forEach{
                                                                var msg = ""
                                                                var itr = it.children
                                                                itr.forEach{
                                                                    msg = msg+"\n"+it.value
                                                                }
                                                                refc.child(msg.trim()).child("database1").push().child("iso").setValue(data)


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

                                        db.inserData1( "Kirim dana", "${psn.trim()}", "${date_2a}", "${time_2a}")
                                        Toast.makeText(mCtx, "terkirim", Toast.LENGTH_LONG).show()




                                    }
                                    else if (panjang == 2) {

                                        val data = "${dataiso}000000${psn}"
                                        refd.addListenerForSingleValueEvent(object : ValueEventListener {

                                            override fun onDataChange(p0: DataSnapshot)  {
                                                var list1 = mutableListOf<String>()
                                                var it : Iterable<DataSnapshot> = p0!!.children

                                                it.forEach{
                                                    var msg = ""
                                                    var itr = it.children
                                                    itr.forEach{
                                                        msg = msg+"\n"+it.value
                                                    }
                                                    reff.child(msg.trim()).child("saldo").child("push").child("nilai").setValue(nilai.toString().trim())
                                                    refb.addListenerForSingleValueEvent(object : ValueEventListener {

                                                        override fun onDataChange(p0: DataSnapshot)  {

                                                            var it : Iterable<DataSnapshot> = p0!!.children

                                                            it.forEach{
                                                                var msg = ""
                                                                var itr = it.children
                                                                itr.forEach{
                                                                    msg = msg+"\n"+it.value
                                                                }
                                                                refc.child(msg.trim()).child("database1").push().child("iso").setValue(data)


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

                                        db.inserData1( "Kirim dana", "${psn.trim()}", "${date_2a}", "${time_2a}")
                                        Toast.makeText(mCtx, "terkirim", Toast.LENGTH_LONG).show()




                                    }
                                    else if (panjang == 3) {

                                        val data = "${dataiso}00000${psn}"
                                        refd.addListenerForSingleValueEvent(object : ValueEventListener {

                                            override fun onDataChange(p0: DataSnapshot)  {
                                                var list1 = mutableListOf<String>()
                                                var it : Iterable<DataSnapshot> = p0!!.children

                                                it.forEach{
                                                    var msg = ""
                                                    var itr = it.children
                                                    itr.forEach{
                                                        msg = msg+"\n"+it.value
                                                    }
                                                    reff.child(msg.trim()).child("saldo").child("push").child("nilai").setValue(nilai.toString().trim())
                                                    refb.addListenerForSingleValueEvent(object : ValueEventListener {

                                                        override fun onDataChange(p0: DataSnapshot)  {

                                                            var it : Iterable<DataSnapshot> = p0!!.children

                                                            it.forEach{
                                                                var msg = ""
                                                                var itr = it.children
                                                                itr.forEach{
                                                                    msg = msg+"\n"+it.value
                                                                }
                                                                refc.child(msg.trim()).child("database1").push().child("iso").setValue(data)


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

                                        db.inserData1( "Kirim dana", "${psn.trim()}", "${date_2a}", "${time_2a}")
                                        Toast.makeText(mCtx, "terkirim", Toast.LENGTH_LONG).show()




                                    }
                                    else if (panjang == 4) {

                                        val data = "${dataiso}0000${psn}"
                                        refd.addListenerForSingleValueEvent(object : ValueEventListener {

                                            override fun onDataChange(p0: DataSnapshot)  {
                                                var list1 = mutableListOf<String>()
                                                var it : Iterable<DataSnapshot> = p0!!.children

                                                it.forEach{
                                                    var msg = ""
                                                    var itr = it.children
                                                    itr.forEach{
                                                        msg = msg+"\n"+it.value
                                                    }
                                                    reff.child(msg.trim()).child("saldo").child("push").child("nilai").setValue(nilai.toString().trim())
                                                    refb.addListenerForSingleValueEvent(object : ValueEventListener {

                                                        override fun onDataChange(p0: DataSnapshot)  {

                                                            var it : Iterable<DataSnapshot> = p0!!.children

                                                            it.forEach{
                                                                var msg = ""
                                                                var itr = it.children
                                                                itr.forEach{
                                                                    msg = msg+"\n"+it.value
                                                                }
                                                                refc.child(msg.trim()).child("database1").push().child("iso").setValue(data)


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

                                        db.inserData1( "Kirim dana", "${psn.trim()}", "${date_2a}", "${time_2a}")
                                        Toast.makeText(mCtx, "terkirim", Toast.LENGTH_LONG).show()




                                    }
                                    else if (panjang == 5) {

                                        val data = "${dataiso}000${psn}"
                                        refd.addListenerForSingleValueEvent(object : ValueEventListener {

                                            override fun onDataChange(p0: DataSnapshot)  {
                                                var list1 = mutableListOf<String>()
                                                var it : Iterable<DataSnapshot> = p0!!.children

                                                it.forEach{
                                                    var msg = ""
                                                    var itr = it.children
                                                    itr.forEach{
                                                        msg = msg+"\n"+it.value
                                                    }
                                                    reff.child(msg.trim()).child("saldo").child("push").child("nilai").setValue(nilai.toString().trim())
                                                    refb.addListenerForSingleValueEvent(object : ValueEventListener {

                                                        override fun onDataChange(p0: DataSnapshot)  {

                                                            var it : Iterable<DataSnapshot> = p0!!.children

                                                            it.forEach{
                                                                var msg = ""
                                                                var itr = it.children
                                                                itr.forEach{
                                                                    msg = msg+"\n"+it.value
                                                                }
                                                                refc.child(msg.trim()).child("database1").push().child("iso").setValue(data)


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

                                        db.inserData1( "Kirim dana", "${psn.trim()}", "${date_2a}", "${time_2a}")
                                        Toast.makeText(mCtx, "terkirim", Toast.LENGTH_LONG).show()




                                    }
                                    else if (panjang == 6) {

                                        val data = "${dataiso}00${psn}"
                                        refd.addListenerForSingleValueEvent(object : ValueEventListener {

                                            override fun onDataChange(p0: DataSnapshot)  {
                                                var list1 = mutableListOf<String>()
                                                var it : Iterable<DataSnapshot> = p0!!.children

                                                it.forEach{
                                                    var msg = ""
                                                    var itr = it.children
                                                    itr.forEach{
                                                        msg = msg+"\n"+it.value
                                                    }
                                                    reff.child(msg.trim()).child("saldo").child("push").child("nilai").setValue(nilai.toString().trim())
                                                    refb.addListenerForSingleValueEvent(object : ValueEventListener {

                                                        override fun onDataChange(p0: DataSnapshot)  {

                                                            var it : Iterable<DataSnapshot> = p0!!.children

                                                            it.forEach{
                                                                var msg = ""
                                                                var itr = it.children
                                                                itr.forEach{
                                                                    msg = msg+"\n"+it.value
                                                                }
                                                                refc.child(msg.trim()).child("database1").push().child("iso").setValue(data)


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

                                        db.inserData1( "Kirim dana", "${psn.trim()}", "${date_2a}", "${time_2a}")
                                        Toast.makeText(mCtx, "terkirim", Toast.LENGTH_LONG).show()




                                    }
                                    else if (panjang == 7) {

                                        val data = "${dataiso}0${psn}"
                                        refd.addListenerForSingleValueEvent(object : ValueEventListener {

                                            override fun onDataChange(p0: DataSnapshot)  {
                                                var list1 = mutableListOf<String>()
                                                var it : Iterable<DataSnapshot> = p0!!.children

                                                it.forEach{
                                                    var msg = ""
                                                    var itr = it.children
                                                    itr.forEach{
                                                        msg = msg+"\n"+it.value
                                                    }
                                                    reff.child(msg.trim()).child("saldo").child("push").child("nilai").setValue(nilai.toString().trim())
                                                    refb.addListenerForSingleValueEvent(object : ValueEventListener {

                                                        override fun onDataChange(p0: DataSnapshot)  {

                                                            var it : Iterable<DataSnapshot> = p0!!.children

                                                            it.forEach{
                                                                var msg = ""
                                                                var itr = it.children
                                                                itr.forEach{
                                                                    msg = msg+"\n"+it.value
                                                                }
                                                                refc.child(msg.trim()).child("database1").push().child("iso").setValue(data)


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

                                        db.inserData1( "Kirim dana", "${psn.trim()}", "${date_2a}", "${time_2a}")
                                        Toast.makeText(mCtx, "terkirim", Toast.LENGTH_LONG).show()




                                    }
                                    else if (panjang == 8) {

                                        val data = "${dataiso}${psn}"
                                        refd.addListenerForSingleValueEvent(object : ValueEventListener {

                                            override fun onDataChange(p0: DataSnapshot)  {
                                                var list1 = mutableListOf<String>()
                                                var it : Iterable<DataSnapshot> = p0!!.children

                                                it.forEach{
                                                    var msg = ""
                                                    var itr = it.children
                                                    itr.forEach{
                                                        msg = msg+"\n"+it.value
                                                    }
                                                    reff.child(msg.trim()).child("saldo").child("push").child("nilai").setValue(nilai.toString().trim())
                                                    refb.addListenerForSingleValueEvent(object : ValueEventListener {

                                                        override fun onDataChange(p0: DataSnapshot)  {

                                                            var it : Iterable<DataSnapshot> = p0!!.children

                                                            it.forEach{
                                                                var msg = ""
                                                                var itr = it.children
                                                                itr.forEach{
                                                                    msg = msg+"\n"+it.value
                                                                }
                                                                refc.child(msg.trim()).child("database1").push().child("iso").setValue(data)


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

                                        db.inserData1( "Kirim dana", "${psn.trim()}", "${date_2a}", "${time_2a}")
                                        Toast.makeText(mCtx, "terkirim", Toast.LENGTH_LONG).show()




                                    }

                                }
                               // refb.child(msg.trim()).child("database1").removeValue()
                                //open1()
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
            refb.addListenerForSingleValueEvent(object : ValueEventListener {

            override fun onDataChange(p0: DataSnapshot)  {

                var it : Iterable<DataSnapshot> = p0!!.children

                it.forEach{
                    var msg = ""
                    var itr = it.children
                    itr.forEach{
                        msg = msg+"\n"+it.value
                    }

                    //refa.child(msg.trim()).child("database1").child("push").child("iso").setValue()
                    refc.child(msg.trim()).child("saldo").addListenerForSingleValueEvent(object :
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
                                val saldo = msg.trim().toInt()
                                val nilai = saldo - psn.toInt()

                                //refc.child(msg.trim()).child("saldo").child("push").child("nilai").setValue(nilai.toString().trim())
                                refb.addListenerForSingleValueEvent(object : ValueEventListener {

                                    override fun onDataChange(p0: DataSnapshot)  {

                                        var it : Iterable<DataSnapshot> = p0!!.children

                                        it.forEach{
                                            var msg = ""
                                            var itr = it.children
                                            itr.forEach{
                                                msg = msg+"\n"+it.value
                                            }
                                            refc.child(msg.trim()).child("saldo").child("push").child("nilai").setValue(nilai.toString().trim())
                                            //refa.child(msg.trim()).child("database1").child("push").child("iso").setValue()


                                        }
                                    }
                                    override fun onCancelled(p0: DatabaseError) {
                                        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                                    }
                                })
                            }
                            // refb.child(msg.trim()).child("database1").removeValue()
                            //open1()
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
    fun jalan2(data: model2){

        val psn = data.dana
        val panjang = psn.length
        val date_1 = SimpleDateFormat("ddMMyyyy")
        val date_2 = date_1.format(Date())
        val time_1 = SimpleDateFormat("hhmmss")
        val time_2 = time_1.format(Date())
        val dataiso = "1210201A001000000000000010${time_2}${date_2}"
        if (panjang == 1) {

            val data = "${dataiso}0000000${psn}"
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
                        refc.child(msg.trim()).child("database1").push().child("iso").setValue(data)
                        Toast.makeText(mCtx, "Permintaan ditolak", Toast.LENGTH_LONG).show()
                    }
                }
                override fun onCancelled(p0: DatabaseError) {
                    TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                }
            })
            Toast.makeText(mCtx, "permintaan ditolak", Toast.LENGTH_LONG).show()
        }
        else if (panjang == 2) {

            val data = "${dataiso}000000${psn}"
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
                        refc.child(msg.trim()).child("database1").push().child("iso").setValue(data)
                        Toast.makeText(mCtx, "Permintaan ditolak", Toast.LENGTH_LONG).show()
                    }
                }
                override fun onCancelled(p0: DatabaseError) {
                    TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                }
            })

            Toast.makeText(mCtx, "permintaan ditolak", Toast.LENGTH_LONG).show()
        }
        else if (panjang == 3) {

            val data = "${dataiso}00000${psn}"
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
                        refc.child(msg.trim()).child("database1").push().child("iso").setValue(data)
                        Toast.makeText(mCtx, "Permintaan ditolak", Toast.LENGTH_LONG).show()
                    }
                }
                override fun onCancelled(p0: DatabaseError) {
                    TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                }
            })
            Toast.makeText(mCtx, "permintaan ditolak", Toast.LENGTH_LONG).show()
        }
        else if (panjang == 4) {

            val data = "${dataiso}0000${psn}"
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
                        refc.child(msg.trim()).child("database1").push().child("iso").setValue(data)
                        Toast.makeText(mCtx, "Permintaan ditolak", Toast.LENGTH_LONG).show()

                    }
                }
                override fun onCancelled(p0: DatabaseError) {
                    TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                }
            })
            Toast.makeText(mCtx, "permintaan ditolak", Toast.LENGTH_LONG).show()
        }
        else if (panjang == 5) {

            val data = "${dataiso}000${psn}"
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
                        refc.child(msg.trim()).child("database1").push().child("iso").setValue(data)
                        Toast.makeText(mCtx, "Permintaan ditolak", Toast.LENGTH_LONG).show()
                    }
                }
                override fun onCancelled(p0: DatabaseError) {
                    TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                }
            })

        }
        else if (panjang == 6) {

            val data = "${dataiso}00${psn}"
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
                        refc.child(msg.trim()).child("database1").push().child("iso").setValue(data)
                        Toast.makeText(mCtx, "Permintaan ditolak", Toast.LENGTH_LONG).show()
                    }
                }
                override fun onCancelled(p0: DatabaseError) {
                    TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                }
            })

        }
        else if (panjang == 7) {

            val data = "${dataiso}0${psn}"
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
                        refc.child(msg.trim()).child("database1").push().child("iso").setValue(data)
                        Toast.makeText(mCtx, "Permintaan ditolak", Toast.LENGTH_LONG).show()

                    }
                }
                override fun onCancelled(p0: DatabaseError) {
                    TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                }
            })

            Toast.makeText(mCtx, "permintaan ditolak", Toast.LENGTH_LONG).show()
        }
        else if (panjang == 8) {

            val data = "${dataiso}${psn}"
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
                        refc.child(msg.trim()).child("database1").push().child("iso").setValue(data)
                        Toast.makeText(mCtx, "Permintaan ditolak", Toast.LENGTH_LONG).show()

                    }
                }
                override fun onCancelled(p0: DatabaseError) {
                    TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                }
            })
            Toast.makeText(mCtx, "permintaan ditolak", Toast.LENGTH_LONG).show()
        }


    }
}