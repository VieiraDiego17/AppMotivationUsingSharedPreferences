package com.example.appmotivation.infra

import android.content.Context
import android.content.SharedPreferences

class SaveSharedPreferences(context: Context) {

    private val dados: SharedPreferences =
        context.getSharedPreferences("Motivation", Context.MODE_PRIVATE)

    fun storeString(key: String, str: String) {
        dados.edit().putString(key, str).apply()
    }

    fun getString(key: String): String {
        return dados.getString(key, "") ?: ""
    }
}