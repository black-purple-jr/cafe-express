package me.bpxdevjr.cafe_express

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var decrementCafeQuantite: ImageButton
    private lateinit var incrementCafeQuantite: ImageButton
    private lateinit var cafeNumber: TextView

    private lateinit var decrementTheQuantite: ImageButton
    private lateinit var incrementTheQuantite: ImageButton
    private lateinit var theNumber: TextView

    private lateinit var decrementCroissantQuantite: ImageButton
    private lateinit var incrementCroissantQuantite: ImageButton
    private lateinit var croissantNumber: TextView

    private lateinit var edtNomClient: EditText
    private lateinit var prixTotal: TextView

    private lateinit var btnVider: Button
    private lateinit var btnCommander: Button

    private var total: Double = 0.0
    private var countCafe: Int = 0
    private var countThe: Int = 0
    private var countCroissant: Int = 0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        decrementCafeQuantite = findViewById(R.id.btnMoinsCafe)
        incrementCafeQuantite = findViewById(R.id.btnPlusCafe)
        cafeNumber = findViewById(R.id.txtCountCafe)

        decrementTheQuantite = findViewById(R.id.btnMoinsThe)
        incrementTheQuantite = findViewById(R.id.btnPlusThe)
        theNumber = findViewById(R.id.txtCountThe)

        decrementCroissantQuantite = findViewById(R.id.btnMoinsCroissant)
        incrementCroissantQuantite = findViewById(R.id.btnPlusCroissant)
        croissantNumber = findViewById(R.id.txtCountCroissant)

        edtNomClient = findViewById(R.id.edtNomClient)
        prixTotal = findViewById(R.id.prixTotal)

        btnVider = findViewById(R.id.btnVider)
        btnCommander = findViewById(R.id.btnCommander)

        incrementQuantite(incrementCafeQuantite, cafeNumber, 10.0, "cafe")
        decrementQantite(decrementCafeQuantite, cafeNumber, 10.0, "cafe")

        incrementQuantite(incrementTheQuantite, theNumber, 8.0, "the")
        decrementQantite(decrementTheQuantite, theNumber, 8.0, "the")

        incrementQuantite(incrementCroissantQuantite, croissantNumber, 6.0, "croissant")
        decrementQantite(decrementCroissantQuantite, croissantNumber, 6.0, "croissant")



        btnVider.setOnClickListener {
            cafeNumber.text = "0"
            theNumber.text = "0"
            croissantNumber.text = "0"
            countThe = 0
            countCafe = 0
            countCroissant = 0
            total = 0.0
            prixTotal.text = "0.0"
            Toast.makeText(this, "Commande annulée", Toast.LENGTH_SHORT).show()
        }

        btnCommander.setOnClickListener {
            if (edtNomClient.text.toString().trim().isEmpty()) {
                edtNomClient.requestFocus()
                edtNomClient.error = "Veuillez entrer votre Nom"
            } else if (countCroissant == 0 && countCafe == 0 && countThe == 0) {
                Toast.makeText(this, "Le panier est vide", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "Commande faite avec succès", Toast.LENGTH_SHORT).show()
                val intent = Intent(this, RecapActivity::class.java)

                intent.putExtra("NOM_CLIENT", edtNomClient.text.toString())
                intent.putExtra("QUANTITE_CAFE", countCafe)
                intent.putExtra("QUANTITE_THE", countThe)
                intent.putExtra("QUANTITE_CROISSANT", countCroissant)
                intent.putExtra("PRIX_TOTAL", total)
                startActivity(intent)
            }
        }
    }

    fun incrementQuantite(btn: ImageButton, label: TextView, prix: Double, type: String) {
        btn.setOnClickListener {
            var number = label.text.toString().trim().toInt()
            number++
            total += prix
            label.text = number.toString()

            when (type) {
                "cafe" -> countCafe++
                "the" -> countThe++
                "croissant" -> countCroissant++
            }
            prixTotal.text = total.toString()
        }
    }

    fun decrementQantite(btn: ImageButton, label: TextView, prix: Double, type: String) {
        btn.setOnClickListener {
            var number = label.text.toString().trim().toInt()
            if (number > 0) {
                number--
                total -= prix
                label.text = number.toString()

                when (type) {
                    "cafe" -> countCafe--
                    "the" -> countThe--
                    "croissant" -> countCroissant--
                }
                prixTotal.text = total.toString()
            }
        }
    }

}