package com.first.bayraksoruproject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import kotlinx.android.synthetic.main.activity_soru_sayfasi.*

class SoruSayfasi : AppCompatActivity() {
    private lateinit var sorular:ArrayList<Bayrak>
    private lateinit var yanlisSecenekler:ArrayList<Bayrak>
    private lateinit var dogruSoru:Bayrak
    private lateinit var tumSecenekler:HashSet<Bayrak>
    private lateinit var vt:VeritabaniYardimcisi

    private var soruSayac = 0
    private var dogruSayac = 0
    private var yanlisSayac = 0




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_soru_sayfasi)
        vt= VeritabaniYardimcisi(this@SoruSayfasi)
        sorular=Bayraklardao().rasgele5BayrakGetir(vt)
        soruyukle()



        button1.setOnClickListener {
            dogruKontrol(button1)
            soruSayacKontrol()

        }
        button2.setOnClickListener {
            dogruKontrol(button2)
            soruSayacKontrol()

        }
        button3.setOnClickListener {
            dogruKontrol(button3)
            soruSayacKontrol()

        }
        button4.setOnClickListener {
            dogruKontrol(button4)
            soruSayacKontrol()

        }
    }
    fun soruyukle(){
        textView3.text="${soruSayac+1}.Soru"
        dogruSoru=sorular.get(soruSayac)
        imageView1.setImageResource(resources.getIdentifier(dogruSoru.bayrak_resim,"drawable",packageName))
        yanlisSecenekler=Bayraklardao().rasgele3YanlisSecenekGetir(vt,dogruSoru.bayrak_id)
        tumSecenekler= HashSet()
        tumSecenekler.add(dogruSoru)
        tumSecenekler.add(yanlisSecenekler.get(0))
        tumSecenekler.add(yanlisSecenekler.get(1))
        tumSecenekler.add(yanlisSecenekler.get(2))

        button1.text=tumSecenekler.elementAt(0).bayrak_ad
        button2.text=tumSecenekler.elementAt(1).bayrak_ad
        button3.text=tumSecenekler.elementAt(2).bayrak_ad
        button4.text=tumSecenekler.elementAt(3).bayrak_ad



    }
    fun soruSayacKontrol(){
        soruSayac++

        if(soruSayac != 5){
            soruyukle()
        }else{
            val intent = Intent(this@SoruSayfasi,MainActivity2::class.java)
            intent.putExtra("dogruSayac",dogruSayac)
            startActivity(intent)
            finish()
        }
    }
    fun dogruKontrol(button: Button){
        val buttonYazi=button.text.toString()
        val dogruCevap=dogruSoru.bayrak_ad

        if (buttonYazi==dogruCevap){
            dogruSayac++

        }else{
            yanlisSayac++

        }
        textView.text="${dogruSayac} Doğru"
        textView2.text="${yanlisSayac} Yanlıs"
    }
}