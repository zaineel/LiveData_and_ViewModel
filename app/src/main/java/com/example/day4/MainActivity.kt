package com.example.day4

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class MainActivity : AppCompatActivity() {
    var count = 0
    private lateinit var viewModel: MainActivityViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        viewModel = ViewModelProvider(this).get(MainActivityViewModel::class.java)

        val countText = findViewById<TextView>(R.id.tvCount)
        val countBtn = findViewById<Button>(R.id.btnCount)

        viewModel.count.observe(this, Observer{
            countText.text = it.toString()
        })

        //countText.text = viewModel.count.toString()

        countBtn.setOnClickListener{
//            count++
//            countText.text = count.toString()
            viewModel.updateCount()
            //countText.text = viewModel.count.toString()
        }
    }
}