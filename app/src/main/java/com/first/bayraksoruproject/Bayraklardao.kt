package com.first.bayraksoruproject

import android.annotation.SuppressLint

class Bayraklardao {

    fun rasgele5BayrakGetir(vt:VeritabaniYardimcisi) : ArrayList<Bayrak> {
        val bayraklarListe = ArrayList<Bayrak>()
        val db = vt.writableDatabase
        val c = db.rawQuery("SELECT * FROM bayraklar ORDER BY RANDOM() LIMIT 5",null)

        while(c.moveToNext()){
            val bayraklar = Bayrak(c.getInt(c.getColumnIndex("bayrak_id"))
                ,c.getString(c.getColumnIndex("bayrak_ad"))
                ,c.getString(c.getColumnIndex("bayrak_resim")))
            bayraklarListe.add(bayraklar)
        }

        return bayraklarListe
    }

    fun rasgele3YanlisSecenekGetir(vt:VeritabaniYardimcisi, bayrak_id:Int) : ArrayList<Bayrak> {
        val bayraklarListe = ArrayList<Bayrak>()
        val db = vt.writableDatabase
        val c = db.rawQuery("SELECT * FROM bayraklar WHERE bayrak_id != $bayrak_id ORDER BY RANDOM() LIMIT 3",null)

        while(c.moveToNext()){
            val bayraklar = Bayrak(c.getInt(c.getColumnIndex("bayrak_id"))
                ,c.getString(c.getColumnIndex("bayrak_ad"))
                ,c.getString(c.getColumnIndex("bayrak_resim")))
            bayraklarListe.add(bayraklar)
        }

        return bayraklarListe
    }
}