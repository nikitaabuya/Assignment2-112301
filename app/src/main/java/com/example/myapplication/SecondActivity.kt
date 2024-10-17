package com.example.myapplication

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class SecondActivity : AppCompatActivity() {
    private lateinit var editText: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        title = "Sending Data - Second"

        // Initialize UI elements
        val receivedMessageView: TextView = findViewById(R.id.receivedMessage)
        editText = findViewById(R.id.editTextSecond)
        val sendButton: Button = findViewById(R.id.sendButtonSecond)

        // Get the URI from the intent
        intent?.data?.let { data: Uri ->
            val message = data.schemeSpecificPart // Extract the message
            receivedMessageView.text = "Received: $message"
        }

        // Set up the send button listener
        sendButton.setOnClickListener {
            val replyMessage = editText.text.toString()
            // Sending the data back to MainActivity using intent extras
            val replyIntent = Intent().apply {
                putExtra("reply", replyMessage) // Using intent extras to send data
            }
            setResult(RESULT_OK, replyIntent) // Set the result with the reply
            finish() // Close the SecondActivity to return to MainActivity
        }
    }
}