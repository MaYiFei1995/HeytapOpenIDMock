package com.heytap.openid

import android.app.Activity
import android.os.Bundle
import com.heytap.openid.databinding.ActivityMainBinding

class MainActivity : Activity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        getOAID().apply {
            binding.currOaid.text = ifEmpty {
                resetOAID()
            }
        }

        binding.reset.setOnClickListener { binding.currOaid.text = resetOAID() }
    }


}