package com.john.contactsandroid

import android.content.Intent
import android.os.Bundle
import android.widget.AdapterView.OnItemClickListener
import androidx.appcompat.app.AppCompatActivity
import com.john.contactsandroid.databinding.ActivityHomeBinding
import com.john.contactsandroid.CardDetailsActivity

class HomeActivity : AppCompatActivity() {

    private lateinit var binding : ActivityHomeBinding
    private lateinit var cardsAdapter: CardsRecyclerViewAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        cardsAdapter = CardsRecyclerViewAdapter(createCardsList())
        binding.cardsRv.adapter = cardsAdapter
        cardsAdapter.onItemClickListener = object:CardsRecyclerViewAdapter.OnItemClickListener{
            override fun onClickListener(card: Card) {
                val intent:Intent = Intent(this@HomeActivity , CardDetailsActivity::class.java)
                intent.putExtra("image" , card.image)
                intent.putExtra("name" , card.name)
                startActivity(intent)
            }
        }
    }

    private fun createCardsList():List<Card>{
        return arrayListOf(
            Card(name = "Charmander" , type = "fire" , attackRate = 60 , defenceRate = 50 , R.drawable.charmander),
            Card(name = "Charmeleon" , type = "fire" , attackRate = 80 , defenceRate = 65 , R.drawable.charmeleon),
            Card(name = "Charizard" , type = "fire" , attackRate = 159 , defenceRate = 115 , R.drawable.charizard),
            Card(name = "Bulbasaur" , type = "grass" , attackRate = 65 , defenceRate = 65 , R.drawable.bulbasaur),
            Card(name = "Ivysaur" , type = "grass" , attackRate = 80 , defenceRate = 80 , R.drawable.ivysaur),
            Card(name = "Venusaur" , type = "grass" , attackRate = 122 , defenceRate = 120 , R.drawable.venusaur),
            Card(name = "Squirtle" , type = "water" , attackRate = 60 , defenceRate = 64 , R.drawable.squirtle),
            Card(name = "Wartortle" , type = "water" , attackRate = 65 , defenceRate = 80 , R.drawable.wartortle),
            Card(name = "Blastoise" , type = "water" , attackRate = 136 , defenceRate = 115 , R.drawable.blastoise)
        )
    }
}