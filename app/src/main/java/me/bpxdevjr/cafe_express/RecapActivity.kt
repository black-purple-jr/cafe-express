package me.bpxdevjr.cafe_express

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class RecapActivity : AppCompatActivity() {

    private lateinit var txtNomClient: TextView
    private lateinit var txtNombreCafe: TextView
    private lateinit var txtNombreThe: TextView
    private lateinit var txtNombreCroissant: TextView
    private lateinit var txtTotal: TextView
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

        txtNomClient = findViewById(R.id.nomClient)
        txtNombreCafe = findViewById(R.id.nombreCafe)
        txtNombreThe = findViewById(R.id.nombreThe)
        txtNombreCroissant = findViewById(R.id.nombreCroissant)
        txtTotal = findViewById(R.id.total)

        txtNomClient.text = nom
        txtNombreCafe.text = cafe.toString()
        txtNombreThe.text = the.toString()
        txtNombreCroissant.text = croissant.toString()
        txtTotal.text = "Total : ${total}"

        btnModifier.setOnClickListener {
            finish()
        }
    }
}