package com.example.androiddevchallenge.ui.views

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import com.example.androiddevchallenge.model.pupsList
import com.example.androiddevchallenge.ui.components.PupDescription
import com.example.androiddevchallenge.ui.theme.PupTheme

class DetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val pupId = intent?.getLongExtra("pupId", 0L)

        setContent {
            PupTheme {
                PupDescription(pup = pupsList[pupId!!.toInt()])
            }
        }
    }

}