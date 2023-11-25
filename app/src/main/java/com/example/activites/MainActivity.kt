package com.example.activites

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.result.contract.ActivityResultContracts

class MainActivity : AppCompatActivity() {
    private lateinit var goToButton: Button
    private lateinit var textViewData: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val getResult =
            registerForActivityResult(ActivityResultContracts.StartActivityForResult()){
                if (it.resultCode == Constants.RESULT_CODE){
                    val  message = it.data?.getStringExtra(Constants.INTENT_MESSAGE2_KEY)
                    textViewData.text = message
                }
            }

        textViewData = findViewById(R.id.textView)
        goToButton = findViewById(R.id.button_go_to_act)
        goToButton.setOnClickListener {
            val intent = Intent(this@MainActivity,SecondActivity::class.java)
            intent.putExtra(Constants.INTENT_MESSAGE_KEY,"Hello from First Activity")
            intent.putExtra(Constants.INTENT_MESSAGE2_KEY,"How was your day2")
            intent.putExtra(Constants.INTENT_DATA_NUMBER,3.14)
            getResult.launch(intent)

            startActivity(intent)
        }
    }

}