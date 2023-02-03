package com.example.appmotivation.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.view.View
import android.widget.Toast
import androidx.core.content.ContextCompat
import com.example.appmotivation.infra.MotivationConstants
import com.example.appmotivation.R
import com.example.appmotivation.infra.SaveSharedPreferences
import com.example.appmotivation.databinding.ActivityMainBinding
import com.example.appmotivation.model.NewPhrases
import com.example.appmotivation.model.Phrases

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityMainBinding
    private var categoryId = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        handleUserName()
        handleFilter(R.id.all)
        handleNextPhrase()

        //EVENTOS
        binding.buttonNewSentence.setOnClickListener(this)
        binding.all.setOnClickListener(this)
        binding.sunny.setOnClickListener(this)
        binding.happy.setOnClickListener(this)

        //setButtonCLicked()
    }


//    fun setButtonCLicked() {
//        binding.buttonNewSentence.setOnClickListener {
//            Toast.makeText(this, "Clicado!!!!", Toast.LENGTH_LONG).show()
//        }
//    }

    override fun onClick(view: View) {
        if(view.id == R.id.button_new_sentence){
            handleNextPhrase()
        }else if(view.id in listOf(R.id.all,R.id.sunny,R.id.happy,)){
            handleFilter(view.id)
        }
    }

    private fun handleNextPhrase() {
       binding.textMensagem.text = Phrases().getNewPhrases(categoryId)
    }

    private fun handleFilter(id: Int) {
        binding.all.setColorFilter(ContextCompat.getColor(this,R.color.icon))
        binding.sunny.setColorFilter(ContextCompat.getColor(this,R.color.icon))
        binding.happy.setColorFilter(ContextCompat.getColor(this,R.color.icon))
        when (id) {
            R.id.all -> {
                binding.all.setColorFilter(ContextCompat.getColor(this,R.color.white))
                categoryId = MotivationConstants.FILTER.ALL
            }
            R.id.sunny -> {
                binding.sunny.setColorFilter(ContextCompat.getColor(this,R.color.white))
                categoryId = MotivationConstants.FILTER.SUNNY
            }
            R.id.happy -> {
                binding.happy.setColorFilter(ContextCompat.getColor(this,R.color.white))
                categoryId = MotivationConstants.FILTER.HAPPY
            }
        }
    }

    private fun handleUserName() {
        val name= SaveSharedPreferences(this).getString(MotivationConstants.KEY.USER_NAME)
        binding.textName.text = "Olá, ${name}"    }
}