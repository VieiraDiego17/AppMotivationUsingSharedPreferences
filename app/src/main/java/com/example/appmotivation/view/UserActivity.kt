package com.example.appmotivation.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.view.View
import android.widget.Toast
import com.example.appmotivation.infra.MotivationConstants
import com.example.appmotivation.R
import com.example.appmotivation.infra.SaveSharedPreferences
import com.example.appmotivation.databinding.ActivityUserBinding

class UserActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityUserBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user)
        binding = ActivityUserBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //verifyUserName()

        binding.buttonSave.setOnClickListener(this)
    }
//
//    private fun verifyUserName() {
//        val name= SaveSharedPreferences(this).getString(MotivationConstants.KEY.USER_NAME)
//        if(name != ""){
//            startActivity(Intent(this, MainActivity::class.java))
//            finish()
//        }
//    }

    override fun onClick(view: View) {
        if (view.id == R.id.button_save) {
            handleSave()
        }
    }

    private fun handleSave() {
        val name = binding.editAddName.text.toString()
        if (name != "") {
            SaveSharedPreferences(this).storeString(MotivationConstants.KEY.USER_NAME, name)
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        } else {
            var toast = Toast.makeText(this,
                "Obrigatorio digitar o nome",
                Toast.LENGTH_LONG)

            toast.setGravity(Gravity.CENTER,0,40)
            toast.show()
        }
    }
    }
