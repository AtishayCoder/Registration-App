package com.example.registrationapp

import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.Spinner
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.textfield.TextInputEditText

class MainActivity : AppCompatActivity() {
    private lateinit var textViewFirstName: TextInputEditText
    private lateinit var textViewLastName: TextInputEditText
    private lateinit var textViewEmail: TextInputEditText
    private lateinit var textViewPhone: TextInputEditText
    private lateinit var textViewPassword: TextInputEditText
    private lateinit var spinnerTitle: Spinner
    private lateinit var buttonConfirm: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initViews()
        setupTitleSpinner()
        initButtonListener()
    }

    private fun setupTitleSpinner() {
        val values = arrayOf("Mr", "Mrs", "Miss", "Ms", "Dr", "Prof")
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, values)
        spinnerTitle.adapter = adapter
    }

    private fun initButtonListener() {
        buttonConfirm.setOnClickListener {
            val intent1 = Intent(this, PreviewDetails::class.java).apply {
                putExtra(
                    "Details", Details(
                        firstName = textViewFirstName.text.toString(),
                        lastName = textViewLastName.text.toString(),
                        email = textViewEmail.text.toString(),
                        phoneNumber = textViewPhone.text.toString(),
                        password = textViewPassword.text.toString(),
                        title = spinnerTitle.selectedItem.toString()
                    )
                )
            }
            startActivity(intent1)
        }
    }

    private fun initViews() {
        textViewFirstName = findViewById(R.id.edit_text_first_name)
        textViewLastName = findViewById(R.id.edit_text_last_name)
        textViewEmail = findViewById(R.id.edit_text_email)
        textViewPhone = findViewById(R.id.edit_text_phone_number)
        textViewPassword = findViewById(R.id.edit_text_password)
        spinnerTitle = findViewById(R.id.spinner_title)
        buttonConfirm = findViewById(R.id.button_confirm)
    }
}