package com.pasandevin.android.androidprofileviewer

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.pasandevin.android.androidprofileviewer.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.buttonSearch.setOnClickListener {
            this.goToViewActivity()
        }
    }

    fun goToViewActivity() {
        val intent = Intent(this, ViewActivity::class.java)
        intent.putExtra("id", binding.textId.text.toString())
        startActivity(intent)
    }

}