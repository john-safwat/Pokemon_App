package com.john.contactsandroid

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView

class CardsRecyclerViewAdapter(private var cards: List<Card>) :
    RecyclerView.Adapter<CardsRecyclerViewAdapter.ViewHolder>() {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private var cardView: CardView = itemView.findViewById(R.id.card_view)
        private var name: TextView = itemView.findViewById(R.id.name)
        private var attackRate: TextView = itemView.findViewById(R.id.attack_rate_value)
        private var defenceRate: TextView = itemView.findViewById(R.id.defence_rate_value)
        private var type: TextView = itemView.findViewById(R.id.type)
        private var image: ImageView = itemView.findViewById(R.id.character)

        fun bind(card: Card) {
            name.text = card.name
            attackRate.text = card.attackRate.toString()
            defenceRate.text = card.defenceRate.toString()
            type.text = card.type
            image.setImageResource(card.image)

            val backgroundColor = when (card.type) {
                "grass" -> {
                    type.setBackgroundResource(R.drawable.grass_bg)
                    itemView.resources.getColor(R.color.green)
                }

                "fire" -> {
                    type.setBackgroundResource(R.drawable.fire_bg)
                    itemView.resources.getColor(R.color.red)
                }

                else -> {
                    type.setBackgroundResource(R.drawable.water_bg)
                    itemView.resources.getColor(R.color.blue)
                }
            }
            cardView.setCardBackgroundColor(backgroundColor)
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.activity_card, parent, false)
        )
    }

    override fun getItemCount(): Int {
        return cards.size
    }

    @SuppressLint("ResourceAsColor")
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(cards[position])
        if (onItemClickListener != null) {
            holder.itemView.setOnClickListener {
                onItemClickListener?.onClickListener(
                    cards[position]
                )
            }
        }
    }

    interface OnItemClickListener {
        fun onClickListener(card: Card)
    }

    var onItemClickListener: OnItemClickListener? = null

}