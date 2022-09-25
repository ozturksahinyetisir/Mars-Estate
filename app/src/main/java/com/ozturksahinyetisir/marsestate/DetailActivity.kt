package com.ozturksahinyetisir.marsestate

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.ozturksahinyetisir.marsestate.databinding.ActivityDetailBinding
import com.squareup.picasso.Picasso

class DetailActivity : AppCompatActivity() {
    lateinit var binding: ActivityDetailBinding

    /**
     * DetailActivity [getStringExtra] command gets items from RecyclerAdapter. via putExtra sends.
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        val id = intent.getStringExtra("id")
        val img = intent.getStringExtra("img")
        val price = intent.getStringExtra("price")
        val type = intent.getStringExtra("type")

        binding.idText.text = "$id"
        binding.priceText.text = "$price"
        binding.typeText.text = "$type"

        Picasso.get().load(img).into(binding.image)

        setContentView(binding.root)
    }
}