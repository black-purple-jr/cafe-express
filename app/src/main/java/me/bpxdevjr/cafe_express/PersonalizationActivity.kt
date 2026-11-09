package me.bpxdevjr.cafe_express

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.CheckBox
import android.widget.RadioGroup
import android.widget.Spinner
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SwitchCompat as Switch

class PersonalizationActivity : AppCompatActivity() {


    private lateinit var rgTaille: RadioGroup

    private lateinit var cbSucre: CheckBox
    private lateinit var cbCreme: CheckBox
    private lateinit var cbCaramelle: CheckBox

    private lateinit var aEmporter: Switch
    private lateinit var spnLait: Spinner

    private lateinit var txtResultPhrase: TextView
    private lateinit var txtPrixTotal: TextView

    private lateinit var btnCalculer: Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_personalization)

        rgTaille = findViewById(R.id.rgTaille)

        cbSucre = findViewById(R.id.cbSucre)
        cbCreme = findViewById(R.id.cbCreme)
        cbCaramelle = findViewById(R.id.cbCaramelle)

        aEmporter = findViewById(R.id.swEmporter)

        spnLait = findViewById(R.id.spnLait)

        txtResultPhrase = findViewById(R.id.txtResultPhrase)
        txtPrixTotal = findViewById(R.id.txtPrixTotal)

        btnCalculer = findViewById(R.id.btnCalculer)

        val laits: List<String> =
            listOf("Lait entier", "Lait écrémé", "Lait d'amandes (+3 DH)", "Sans lait")
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, laits)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spnLait.adapter = adapter

    }
}