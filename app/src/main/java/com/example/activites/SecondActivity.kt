package com.example.activites

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class SecondActivity : AppCompatActivity() {
    private lateinit var textViewDataIntent: TextView
    private lateinit var goBackButton: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        textViewDataIntent = findViewById(R.id.textViewData)
        goBackButton = findViewById(R.id.buttonGoBack)
        goBackButton.setOnClickListener {
            val  intent = intent
            intent.putExtra(Constants.INTENT_MESSAGE2_KEY,"Hello from the Second activity")
            setResult(Constants.RESULT_CODE,intent)
            finish()
        }
        val data = intent.extras

        data?.let {
            val message = data.getString(Constants.INTENT_MESSAGE_KEY)
            val message2 = data.getString(Constants.INTENT_MESSAGE2_KEY)
            val number = data.getDouble(Constants.INTENT_DATA_NUMBER)

            textViewDataIntent.text = message + "\n" + message2 + "\n" + number
        }
    }
}