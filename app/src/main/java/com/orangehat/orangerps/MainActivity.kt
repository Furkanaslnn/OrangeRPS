package com.orangehat.orangerps

import android.content.pm.ActivityInfo
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.Toast
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    lateinit var user: ImageView
    lateinit var computer: ImageView
    var userPic = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE
        setContentView(R.layout.activity_main)

        user = findViewById(R.id.user)
        computer = findViewById(R.id.computer)
        user.setImageResource(R.drawable.tas)
        computer.setImageResource(R.drawable.tas)

    }

    fun <T> randomElement(vararg elements: T): T? {
        return if (elements.isEmpty()) {
            null
        } else {
            val randomIndex = Random.nextInt(elements.size)
            elements[randomIndex]
        }
    }

    fun tas (view: View) {
        user.setImageResource(R.drawable.tas)
        userPic = "tas"
    }
    fun kagit (view: View) {
        user.setImageResource(R.drawable.kagit)
        userPic = "kagit"
    }
    fun makas (view: View) {
        user.setImageResource(R.drawable.makas)
        userPic = "makas"
    }

    private fun kazandin() {
        showMessage("Kazandın!")
    }
    private fun kaybettin() {
        showMessage("Kaybettin!")
    }
    private fun berabere() {
        showMessage("Berabere!")
    }
    private fun showMessage(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

    fun oyna(view: View) {

        val result = randomElement("tas", "kagit", "makas")

        when (result) {
            "tas" -> computer.setImageResource(R.drawable.tas)
            "kagit" -> computer.setImageResource(R.drawable.kagit)
            "makas" -> computer.setImageResource(R.drawable.makas)
        }

        if (result == userPic) {

            berabere()
        } else if (
            (userPic == "tas" && result == "makas") ||
            (userPic == "kagit" && result == "tas") ||
            (userPic == "makas" && result == "kagit")
        ) {
            kazandin()
        } else {
            kaybettin()
        }
    }



}