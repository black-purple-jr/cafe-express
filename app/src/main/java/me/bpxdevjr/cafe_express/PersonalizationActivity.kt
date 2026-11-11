package me.bpxdevjr.cafe_express

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.CheckBox
import android.widget.RadioGroup
import android.widget.Spinner
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SwitchCompat

class PersonalizationActivity : AppCompatActivity() {

    private lateinit var rgTaille: RadioGroup
    private lateinit var cbSucre: CheckBox
    private lateinit var cbCreme: CheckBox
    private lateinit var cbCaramelle: CheckBox

    private lateinit var aEmporter: SwitchCompat
    private lateinit var spnLait: Spinner

    private lateinit var txtResultPhrase: TextView
    private lateinit var txtPrixTotal: TextView

    private lateinit var btnCalculer: Button
    private lateinit var btnRetour: Button

    private var total: Int = 0


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
        btnRetour = findViewById(R.id.btnRetour)

        val laits: List<String> = listOf("Lait entier", "Lait écrémé", "Lait d'amandes (+3 DH)", "Sans lait")
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, laits)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spnLait.adapter = adapter

        // implémentation du logic du calcul

        btnCalculer.setOnClickListener {
            val rbTailleChoisi = rgTaille.checkedRadioButtonId

            val taille = when (rbTailleChoisi) {
                R.id.rbPetit -> "Petit"
                R.id.rbMoyen -> "Moyen"
                R.id.rbGrand -> "Grand"
                else -> "aucune"
            }

            var prixTaille = when (taille) {
                "Petit" -> 8
                "Moyen" -> 10
                "Grand" -> 12
                else -> 0
            }

            total += prixTaille

            val supplements: MutableList<String> = mutableListOf()



            if (cbSucre.isChecked) {
                supplements.add("Sucre")
            }

            var prixCreme = 0
            if (cbCreme.isChecked) {
                supplements.add("Creme")
                prixCreme = 2
            }

            var prixCaramelle = 0
            if (cbCaramelle.isChecked) {
                supplements.add("Caramelle")
                prixCaramelle = 1
            }

            var txtAEmporter: String = ""
            var prixEmporter = 0

            if (aEmporter.isChecked) {
                prixEmporter = 2
                txtAEmporter = "à emporter"
            }

            val prixLaits: List<Int> = listOf(0, 0, 3, 0)

            val position = spnLait.selectedItemPosition
            val spinnerItem = spnLait.selectedItem.toString()

            var prixLait = when (spinnerItem) {
                "Lait entier" -> 0
                "Lait écrémé" -> 0
                "Lait d'amandes (+3 DH)" -> 3
                "Sans lait" -> 0
                else -> 0
            }


            if (position == 2) {
                total += 3
            }

            total = prixTaille + prixCreme + prixCaramelle + prixEmporter + prixLait

            txtResultPhrase.text = "${taille}, ${supplements.joinToString(", ")}, ${spinnerItem} ${txtAEmporter}."
            txtPrixTotal.text = "Prix ${total} DH"


        }

        btnRetour.setOnClickListener {
            finish()
        }

    }

}