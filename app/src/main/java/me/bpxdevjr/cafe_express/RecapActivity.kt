package me.bpxdevjr.cafe_express

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class RecapActivity : AppCompatActivity() {

    private lateinit var btnModifier: Button
    private lateinit var btnConfirmer: Button
    private var nom: String? = null
    private var cafe: Int = 0
    private var the: Int = 0
    private var croissant: Int = 0
    private var total: Double = 0.0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recap)

        btnModifier = findViewById(R.id.btnModifier)
        btnConfirmer = findViewById(R.id.btnConfirmer)

        nom = intent.getStringExtra("NOM_CLIENT")
        cafe = intent.getIntExtra("QUANTITE_CAFE", 0)
        the = intent.getIntExtra("QUANTITE_THE", 0)
        croissant = intent.getIntExtra("QUANTITE_CROISSANT", 0)
        total = intent.getDoubleExtra("PRIX_TOTAL", 0.0)



        btnModifier.setOnClickListener {
            finish()
        }
    }
}