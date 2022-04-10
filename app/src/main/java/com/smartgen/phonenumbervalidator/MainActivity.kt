package com.smartgen.phonenumbervalidator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.EditText
import java.util.regex.Pattern

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val phoneNumber=findViewById<EditText>(R.id.phoneNumber)

        phoneNumber.addTextChangedListener(object :TextWatcher{
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
              val x=checkPhoneNumber(p0.toString())
                if (!x){
                    phoneNumber.error="invalid Phone Number"
                }
            }

            override fun afterTextChanged(p0: Editable?) {

            }

        })




    }

    private fun checkPhoneNumber(phoneNumber: String): Boolean {
        val pattern = Pattern.compile("[6-9][0-9]{9}")
        return pattern.matcher(phoneNumber).matches()
    }

}