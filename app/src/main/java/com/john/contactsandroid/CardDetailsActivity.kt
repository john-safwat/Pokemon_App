package com.john.contactsandroid

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.john.contactsandroid.databinding.ActivityCardDetailsBinding
import com.john.contactsandroid.databinding.ActivityHomeBinding

class CardDetailsActivity : AppCompatActivity() {

    private lateinit var binding : ActivityCardDetailsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCardDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.imageDetails.setImageResource(intent.extras!!.getInt("image"))
        binding.characterName.text = intent.extras!!.getString("name")
        binding.backButton.setOnClickListener { finish() }
    }
}
