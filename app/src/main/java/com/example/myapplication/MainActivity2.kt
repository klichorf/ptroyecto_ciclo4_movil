package com.example.myapplication

import android.animation.Animator
import android.animation.AnimatorListenerAdapter
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.EditText
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.airbnb.lottie.LottieAnimationView
import kotlinx.android.synthetic.main.activity_main2.*

class MainActivity2 : AppCompatActivity() {

    private var edtsusario: EditText? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)




        var like = false

        likeImageView.setOnClickListener {
            like = likeAnimation(likeImageView, R.raw.bandai_dokkan, like)

        }
        var like2 = false

        like2ImageView.setOnClickListener {
            like2 = likeAnimation(like2ImageView, R.raw.meditating_man, like2)
        }


        var like4 = false

        like4ImageView.setOnClickListener {
            like4 = likeAnimation(like4ImageView, R.raw.spooky_pumpkin, like4)
        }

        var like5 = false

        like5ImageView.setOnClickListener {
            like5 = likeAnimation(like5ImageView, R.raw.hmm, like5)
        }


    }







    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_bar, menu)
        return super.onCreateOptionsMenu(menu)

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean = when (item.itemId) {
        R.id.itm_buscar -> {
            Toast.makeText(this, "Entró al item buscar", Toast.LENGTH_LONG).show()
            true
        }
        R.id.itm_ayuda -> {
            Toast.makeText(this, "Entró al item ayuda", Toast.LENGTH_LONG).show()
            true
        }
        R.id.itm_borrar -> {
            Toast.makeText(this, "Entró al item borrar", Toast.LENGTH_LONG).show()
            true
        }
        R.id.itm_enviar -> {
            Toast.makeText(this, "Entró al item enviar", Toast.LENGTH_LONG).show()
            true
        }
        R.id.itm_contactar -> {
            Toast.makeText(this, "Entró al item contactar", Toast.LENGTH_LONG).show()
            true
        }

        R.id.itm_versión -> {
            val intento = Intent(this, MainActivity::class.java)
            startActivity(intento)
            true
        }


        else -> {
            super.onOptionsItemSelected(item)
        }
    }


    private fun likeAnimation(
        imageView: LottieAnimationView,
        animation: Int,
        like: Boolean
    ): Boolean {

        if (!like) {
            imageView.setAnimation(animation)
            imageView.playAnimation()
        } else {
            imageView.animate()
                .alpha(0f)
                .setDuration(200)
                .setListener(object : AnimatorListenerAdapter() {

                    override fun onAnimationEnd(animator: Animator) {

                        imageView.setImageResource(R.drawable.twitter_like)
                        imageView.alpha = 1f
                    }

                })

        }

        return !like
    }



    fun reciclervista(btnrecicler: View) {
        val vistareciclerview = Intent(this, MainActivity3::class.java)
        startActivity(vistareciclerview)
    }


    fun actividadrawing(cuatro: View) {
        val objeto4 = Intent(this,MainActivity4::class.java)
        startActivity(objeto4)
    }










}