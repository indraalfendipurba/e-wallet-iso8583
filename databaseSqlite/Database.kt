package com.example.e_wallet12021996ver1.databaseSqlite

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import com.google.firebase.auth.FirebaseAuth

class  Database (context: Context)
    : SQLiteOpenHelper(context, "${FirebaseAuth.getInstance().currentUser!!.uid}.db", null, 1){


    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db?.execSQL("DROP TABLE IF EXISTS" + TABLE_NAME1)

        db?.execSQL("DROP TABLE IF EXISTS" + TABLE_NAME2)
        db?.execSQL("DROP TABLE IF EXISTS" + TABLE_NAME3)
        db?.execSQL("DROP TABLE IF EXISTS" + TABLE_NAME4)
        db?.execSQL("DROP TABLE IF EXISTS" + TABLE_NAME5)
        db?.execSQL("DROP TABLE IF EXISTS" + TABLE_NAME6)

    }

    override fun onCreate(db: SQLiteDatabase?) {
        db?.execSQL("create table $TABLE_NAME1 (ID INTEGER PRIMARY KEY AUTOINCREMENT,"
                +"$COL_2 TEXT, $COL_3 TEXT, $COL_4 TEXT, $COL_5 TEXT)")

        db?.execSQL("create table $TABLE_NAME2 (ID INTEGER PRIMARY KEY AUTOINCREMENT,"
                +"$COL2_2 TEXT, $COL2_3 TEXT, $COL2_4 TEXT, $COL2_5 TEXT) ")
        db?.execSQL("create table $TABLE_NAME3 (ID INTEGER PRIMARY KEY AUTOINCREMENT,"
                +"$COL3_2 TEXT, $COL3_3 TEXT, $COL3_4 TEXT, $COL3_5 TEXT) ")
        db?.execSQL("create table $TABLE_NAME4 (ID INTEGER PRIMARY KEY AUTOINCREMENT,"
                +"$COL4_2 TEXT, $COL4_3 TEXT, $COL4_4 TEXT, $COL4_5 TEXT) ")
        db?.execSQL("create table $TABLE_NAME5 (ID INTEGER PRIMARY KEY AUTOINCREMENT,"
                +"$COL5_2 TEXT, $COL5_3 TEXT, $COL5_4 TEXT, $COL5_5 TEXT) ")
        db?.execSQL("create table $TABLE_NAME6 (ID INTEGER PRIMARY KEY AUTOINCREMENT,"
                +"$COL6_2 TEXT, $COL6_3 TEXT, $COL6_4 TEXT, $COL6_5 TEXT) ")

    }

    fun inserData1 (kirim : String, dana :String, tgl : String, jam :String){
        val db = this.writableDatabase
        val values = ContentValues()
        values.put(COL_2, kirim)
        values.put(COL_3, dana)
        values.put(COL_4, tgl)
        values.put(COL_5, jam)
        db.insert(TABLE_NAME1, null, values)
    }

    fun inserData2 (kirim : String, dana :String, tgl : String, jam :String){
        val db = this.writableDatabase
        val values = ContentValues()
        values.put(COL2_2, kirim)
        values.put(COL2_3, dana)
        values.put(COL2_4, tgl)
        values.put(COL2_5, jam)
        db.insert(TABLE_NAME2, null, values)
    }

    fun inserData3 (kirim : String, dana :String, tgl : String, jam :String){
        val db = this.writableDatabase
        val values = ContentValues()
        values.put(COL3_2, kirim)
        values.put(COL3_3, dana)
        values.put(COL3_4, tgl)
        values.put(COL3_5, jam)
        db.insert(TABLE_NAME3, null, values)
    }

    fun inserData4 (kirim : String, dana :String, tgl : String, jam :String){
        val db = this.writableDatabase
        val values = ContentValues()
        values.put(COL4_2, kirim)
        values.put(COL4_3, dana)
        values.put(COL4_4, tgl)
        values.put(COL4_5, jam)
        db.insert(TABLE_NAME4, null, values)
    }

    fun inserData5 (kirim : String, dana :String, tgl : String, jam :String){
        val db = this.writableDatabase
        val values = ContentValues()
        values.put(COL5_2, kirim)
        values.put(COL5_3, dana)
        values.put(COL5_4, tgl)
        values.put(COL5_5, jam)
        db.insert(TABLE_NAME5, null, values)
    }

    fun inserData6 (kirim : String, dana :String, tgl : String, jam :String){
        val db = this.writableDatabase
        val values = ContentValues()
        values.put(COL6_2, kirim)
        values.put(COL6_3, dana)
        values.put(COL6_4, tgl)
        values.put(COL6_5, jam)
        db.insert(TABLE_NAME6, null, values)
    }

    val Data1 : Cursor
        get() {
            val db = this.readableDatabase
            val res = db.rawQuery("SELECT * FROM $TABLE_NAME1 WHERE ID = (SELECT MAX(ID) FROM $TABLE_NAME1)", null)

            return res
        }
    val allData1 : Cursor
        get() {
            val db = this.readableDatabase
            val res = db.rawQuery("SELECT * FROM $TABLE_NAME1", null)
            return res
        }

    val allData2 : Cursor
        get() {
            val db = this.readableDatabase
            val res = db.rawQuery("SELECT * FROM $TABLE_NAME2", null)
            return res
        }

    val allData3 : Cursor
        get() {
            val db = this.readableDatabase
            val res = db.rawQuery("SELECT * FROM $TABLE_NAME3", null)
            return res
        }

    val allData4 : Cursor
        get() {
            val db = this.readableDatabase
            val res = db.rawQuery("SELECT * FROM $TABLE_NAME4", null)
            return res
        }

    val allData5 : Cursor
        get() {
            val db = this.readableDatabase
            val res = db.rawQuery("SELECT * FROM $TABLE_NAME5", null)
            return res
        }

    val allData6 : Cursor
        get() {
            val db = this.readableDatabase
            val res = db.rawQuery("SELECT * FROM $TABLE_NAME6", null)
            return res
        }


    fun deleteData1(id :String):Int {
        val db = this.writableDatabase
        return  db.delete(TABLE_NAME1, "ID=?", arrayOf(id))
    }

    fun deleteData2(id :String):Int {
        val db = this.writableDatabase
        return  db.delete(TABLE_NAME2, "ID=?", arrayOf(id))
    }

    fun deleteData3(id :String):Int {
        val db = this.writableDatabase
        return  db.delete(TABLE_NAME3, "ID=?", arrayOf(id))
    }

    fun deleteData4(id :String):Int {
        val db = this.writableDatabase
        return  db.delete(TABLE_NAME4, "ID=?", arrayOf(id))
    }

    fun deleteData5(id :String):Int {
        val db = this.writableDatabase
        return  db.delete(TABLE_NAME5, "ID=?", arrayOf(id))
    }

    fun deleteData6(id :String):Int {
        val db = this.writableDatabase
        return  db.delete(TABLE_NAME6, "ID=?", arrayOf(id))
    }


    companion object {


        val TABLE_NAME1  = "Database_1"
        val COL_1       = "ID"
        val COL_2       = "kirim"
        val COL_3       = "dana"
        val COL_4       = "tgl"
        val COL_5       = "jam"

        val TABLE_NAME2 = "Database_2"
        val COL2_1       = "ID"
        val COL2_2       = "kirim2"
        val COL2_3       = "dana2"
        val COL2_4       = "tgl2"
        val COL2_5       = "jam2"

        val TABLE_NAME3 = "Database_3"
        val COL3_1       = "ID"
        val COL3_2       = "kirim3"
        val COL3_3       = "dana3"
        val COL3_4       = "tgl3"
        val COL3_5       = "jam3"

        val TABLE_NAME4  = "Database_4"
        val COL4_1       = "ID"
        val COL4_2       = "kirim4"
        val COL4_3       = "dana4"
        val COL4_4       = "tgl4"
        val COL4_5       = "jam4"

        val TABLE_NAME5 = "Database_5"
        val COL5_1       = "ID"
        val COL5_2       = "kirim5"
        val COL5_3       = "dana5"
        val COL5_4       = "tgl5"
        val COL5_5       = "jam5"

        val TABLE_NAME6 = "Database_6"
        val COL6_1       = "ID"
        val COL6_2       = "kirim6"
        val COL6_3       = "dana6"
        val COL6_4       = "tgl6"
        val COL6_5       = "jam6"
    }

}