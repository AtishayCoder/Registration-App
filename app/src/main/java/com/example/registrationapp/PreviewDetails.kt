package com.example.registrationapp

import android.annotation.SuppressLint
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class PreviewDetails : AppCompatActivity() {
    private lateinit var summaryTextView: TextView
    private lateinit var emailTextView: TextView
    private lateinit var phoneTextView: TextView
    private lateinit var previewDetails: Details

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_preview_details)
        setPreviewTextViews()
        previewDetails = intent.getSerializableExtra("Details") as Details
        setDetails()
        setListeners()
    }

    private fun setListeners() {
        emailTextView.setOnClickListener {
            val intent = Intent(Intent.ACTION_SENDTO).apply {
                data = Uri.parse("mailto:")
            }
            startActivity(intent)
        }

        phoneTextView.setOnClickListener {
            val intent = Intent(Intent.ACTION_DIAL).apply {
                data = Uri.parse("tel:")
            }
            startActivity(intent)
        }
    }

    @SuppressLint("SetTextI18n")
    private fun setDetails() {
        summaryTextView.text = "First Name : ${ previewDetails.firstName }\nLast Name : ${ previewDetails.lastName }\nTitle: ${ previewDetails.title }.\nPassword: ${ previewDetails.password }"
        emailTextView.text = "Email: ${ previewDetails.email }"
        phoneTextView.text = "Phone Number: ${ previewDetails.phoneNumber }"
    }

    private fun setPreviewTextViews() {
        summaryTextView = findViewById(R.id.text_view_summary)
        emailTextView = findViewById(R.id.text_view_email)
        phoneTextView = findViewById(R.id.text_view_phone_number)
    }
}