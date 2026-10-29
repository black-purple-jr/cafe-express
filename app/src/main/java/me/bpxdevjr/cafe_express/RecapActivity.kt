package me.bpxdevjr.cafe_express

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class RecapActivity : AppCompatActivity() {

    private lateinit var btnModifier: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recap)

        btnModifier = findViewById(R.id.btnModifier)

        btnModifier.setOnClickListener {
            finish()
        }
    }
}