package com.example.unitbasic

import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class LengthActivity : AppCompatActivity() , View.OnClickListener , RadioGroup.OnCheckedChangeListener {

    lateinit var backBtnToMain : Button
    lateinit var fromUnit : TextView
    lateinit var toUnit : TextView
    lateinit var fromValueET : EditText
    lateinit var toValueET : EditText
    lateinit var fromRadioGroup : RadioGroup
    lateinit var toRadioGroup: RadioGroup

    lateinit var fromKmRadio : RadioButton
    lateinit var fromMetersRadio : RadioButton
    lateinit var fromCmRadio : RadioButton
    lateinit var fromMmRadio : RadioButton
    lateinit var fromMilesRadio : RadioButton
    lateinit var fromYardsRadio : RadioButton
    lateinit var fromFeetRadio : RadioButton
    lateinit var fromInchesRadio : RadioButton

    lateinit var toKmRadio : RadioButton
    lateinit var toMetersRadio : RadioButton
    lateinit var toCmRadio : RadioButton
    lateinit var toMmRadio : RadioButton
    lateinit var toMilesRadio : RadioButton
    lateinit var toYardsRadio : RadioButton
    lateinit var toFeetRadio : RadioButton
    lateinit var toInchesRadio : RadioButton
    lateinit var calculateButton : Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_length)

        backBtnToMain = findViewById(R.id.backBtnToMain)
        backBtnToMain.setOnClickListener() {
            finish()
        }

        fromUnit = findViewById(R.id.fromUnitTV)
        toUnit = findViewById(R.id.toUnitTV)
        fromValueET = findViewById(R.id.fromValueET)
        toValueET = findViewById(R.id.toValueET)
        fromRadioGroup = findViewById(R.id.fromRGLength)
        toRadioGroup = findViewById(R.id.toRGLength)
        calculateButton = findViewById(R.id.calculateButton)

        fromKmRadio = findViewById(R.id.fromKmRadio)
        fromMetersRadio = findViewById(R.id.fromMetersRadio)
        fromCmRadio = findViewById(R.id.fromCmRadio)
        fromMmRadio = findViewById(R.id.fromMmRadio)
        fromMilesRadio = findViewById(R.id.fromMilesRadio)
        fromYardsRadio = findViewById(R.id.fromYardsRadio)
        fromFeetRadio = findViewById(R.id.fromFeetRadio)
        fromInchesRadio = findViewById(R.id.fromInchesRadio)

        toKmRadio = findViewById(R.id.fromKmRadio)
        toMetersRadio = findViewById(R.id.fromMetersRadio)
        toCmRadio = findViewById(R.id.fromCmRadio)
        toMmRadio = findViewById(R.id.fromMmRadio)
        toMilesRadio = findViewById(R.id.fromMilesRadio)
        toYardsRadio = findViewById(R.id.fromYardsRadio)
        toFeetRadio = findViewById(R.id.fromFeetRadio)
        toInchesRadio = findViewById(R.id.fromInchesRadio)

        calculateButton.setOnClickListener(this)
        fromRadioGroup.setOnCheckedChangeListener(this)
        toRadioGroup.setOnCheckedChangeListener(this)
    }

    override fun onClick(v: View?) {
        var fromValue = fromValueET.text.toString().toDouble()
        var fromUnit = findViewById<RadioButton>(fromRadioGroup.checkedRadioButtonId).text.toString()
        var toUnit = findViewById<RadioButton>(toRadioGroup.checkedRadioButtonId).text.toString()

        var ratiosInFeet = mapOf(
            "Feet" to 1.0,
            "Kilometers" to 0.0003048,
            "Meters" to 0.3048,
            "Centimeters" to 30.48,
            "Millimeters" to 304.8,
            "Miles" to 0.0001894,
            "Yards" to 0.3333,
            "Inches" to 12.0
        )

        // formula is original unit -> feet -> result unit
        // for original unit -> feet, do original value / ratio (ex: 1 meter to feet is 1 m / 0.3048 = 3.2803 feet)
        // for feet -> result unit, do value in feet * ratios (ex: 3.28 feet to inches is 3.28 ft * 12 = 39.37 inches)
        // so 1 meter equals approximately 39.37 inches
        var toValue = (fromValue / ratiosInFeet[fromUnit]!!) * ratiosInFeet[toUnit]!!
        toValueET.setText(String.format("%.2f", toValue))
    }

    override fun onCheckedChanged(r: RadioGroup?, checkedRadioButtonId: Int) {
        var selectedUnit = (findViewById<RadioButton>(checkedRadioButtonId)).text.toString()
        if (r != null) {
            if (r.id == R.id.fromRGLength) {
                fromUnit.text = selectedUnit
            } else {
                toUnit.text = selectedUnit
            }
        }
    }
}