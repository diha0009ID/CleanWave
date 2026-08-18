package com.example.cleanwave01

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.cleanwave01.databinding.ActivityDonationBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDonationBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        
        // View Binding භාවිතා කර Layout එක සම්බන්ධ කිරීම
        binding = ActivityDonationBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // පින්තූර (img1-6) සහ අයිකන (ico1-6) කාඩ්පත් වලට ඇතුළත් කිරීම
        setupCards()
    }

    private fun setupCards() {
        // Card 1: img1 සහ ico1
        binding.card1.cardImage.setImageResource(R.drawable.img1)
        binding.card1.cardIcon.setImageResource(R.drawable.ico1)
        binding.card1.cardTitle.text = "Cleaner Oceans"

        // Card 2: img2 සහ ico2
        binding.card2.cardImage.setImageResource(R.drawable.img2)
        binding.card2.cardIcon.setImageResource(R.drawable.ico2)
        binding.card2.cardTitle.text = "Cleaner Oceans"

        // Card 3: img3 සහ ico3
        binding.card3.cardImage.setImageResource(R.drawable.img3)
        binding.card3.cardIcon.setImageResource(R.drawable.ico3)
        binding.card3.cardTitle.text = "Cleaner Oceans"

        // Card 4: img4 සහ ico4
        binding.card4.cardImage.setImageResource(R.drawable.img4)
        binding.card4.cardIcon.setImageResource(R.drawable.ico4)
        binding.card4.cardTitle.text = "Cleaner Oceans"

        // Card 5: img5 සහ ico5
        binding.card5.cardImage.setImageResource(R.drawable.img5)
        binding.card5.cardIcon.setImageResource(R.drawable.ico5)
        binding.card5.cardTitle.text = "Cleaner Oceans"

        // Card 6: img6 සහ ico6
        binding.card6.cardImage.setImageResource(R.drawable.img6)
        binding.card6.cardIcon.setImageResource(R.drawable.ico6)
        binding.card6.cardTitle.text = "Cleaner Oceans"

        // Description සැකසීම
        val description = "Lorem ipsum dolor sit amet consectetur. Malesuada habitant aliquam enim a."
        binding.card1.cardDescription.text = description
        binding.card2.cardDescription.text = description
        binding.card3.cardDescription.text = description
        binding.card4.cardDescription.text = description
        binding.card5.cardDescription.text = description
        binding.card6.cardDescription.text = description
    }
}
