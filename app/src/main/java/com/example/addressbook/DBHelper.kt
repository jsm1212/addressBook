package com.example.addressbook

import android.annotation.SuppressLint
import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DBHelper(context: Context, filename:String) : SQLiteOpenHelper(context, filename, null, 1){

    companion object{
        private  var dbHelper:DBHelper? = null
        fun getInstance(context: Context, filename: String) : DBHelper {
            if(dbHelper == null){
                dbHelper = DBHelper(context, filename)
            }
            return dbHelper!!
        }
    }
    override fun onCreate(db: SQLiteDatabase?) {
        var sql:String = " CREATE TABLE if not exists ADDRESS( " +
                         " seq integer primary key autoincrement, " +
                         " name string , " +
                         " address string, " +
                         " tel string, " +
                         " email string )"
        db?.execSQL(sql)
    }

    override fun onUpgrade(db: SQLiteDatabase?, p1: Int, p2: Int) {

    }

    fun insert(vo:Address) {
        var sql = " INSERT INTO ADDRESS(name, address, tel, email) " +
                  " VALUES('${vo.name}', '${vo.address}', '${vo.tel}', '${vo.email}') "
        var db = this.writableDatabase
        db.execSQL(sql)
    }

    @SuppressLint("Range")
    fun select() : MutableList<Address> {
        val list = mutableListOf<Address>()
        var sql = " SELECT * FROM ADDRESS  "
        var db = this.readableDatabase
        var cursor = db.rawQuery(sql, null)

        while(cursor. moveToNext()){
            val name = cursor.getString(cursor.getColumnIndex("name"))
            val address = cursor.getString(cursor.getColumnIndex("address"))
            val tel = cursor.getString(cursor.getColumnIndex("tel"))
            val email = cursor.getString(cursor.getColumnIndex("email"))

            list.add(Address(0, name, address, tel, email))
        }
        cursor.close()

        return list
    }

    fun delete(tel:String){
        val sql = " delete from ADDRESS where tel = '${tel}' "
        val db = this.writableDatabase
        db.execSQL(sql)
    }
    fun update(name:String, tel:String, address:String, email:String) {
        val sql = " update ADDRESS set name='${name}', tel='${tel}', address='${address}', email='${email}' "
        val db = this.writableDatabase
        db.execSQL(sql)

    }


}