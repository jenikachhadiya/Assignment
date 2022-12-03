package com.example.animation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.dynamicanimation.animation.DynamicAnimation
import androidx.dynamicanimation.animation.SpringAnimation
import com.example.animation.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        val springAnim = findViewById<View>(R.id.img_view).let { img ->
            // Setting up a spring animation to animate the view’s translationY property with the final
            // spring position at 0.
            SpringAnimation(img, DynamicAnimation.TRANSLATION_Y, 0f)
        }
    }
}