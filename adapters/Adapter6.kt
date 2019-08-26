package com.example.e_wallet12021996ver1.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageButton
import android.widget.TextView
import com.example.e_wallet12021996ver1.R
import com.example.e_wallet12021996ver1.databaseSqlite.Database
import com.example.e_wallet12021996ver1.models.model6

class  Adapter6 (var mCtx : Context, var resource : Int, var items : List<model6>)
    : ArrayAdapter<model6>(mCtx, resource, items){

    internal var db = Database(mCtx)

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {

        val layout : LayoutInflater = LayoutInflater.from(mCtx)
        val view : View = layout.inflate(resource, null)


        val kirim : TextView = view.findViewById(R.id.elv6_1kirim)
        val dana : TextView = view.findViewById(R.id.elv6_2dana)
        val tgl : TextView = view.findViewById(R.id.elv6_3tgl)
        val jam : TextView = view.findViewById(R.id.elv6_4jam)


        val hapus : ImageButton = view.findViewById(R.id.elv6_5hapus)

        val data : model6 = items[position]


        kirim.text = data.kirim
        dana.text = data.dana
        tgl.text = data.tgl
        jam.text = data.jam

        hapus.setOnClickListener {
            delete(data)
            // build()
        }
        return view
    }

    fun delete(data : model6){
        db.deleteData6(data.id)
    }

    //fun build(){
    //val builder = AlertDialog.Builder(mCtx)

    //}

}