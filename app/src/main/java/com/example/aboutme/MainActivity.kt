package com.example.aboutme

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import androidx.databinding.DataBindingUtil
import com.example.aboutme.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    val myName: MyName = MyName("Akwa Peter")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        binding.myName = myName

        binding.btnAddName.setOnClickListener {
            addANickName(it)
        }
    }

    private fun addANickName(view: View) {
        binding.apply {
            //Add the nickname
            myName?.nickname = txtNickName.text.toString();
            invalidateAll()
            editText.visibility = View.GONE
            btnAddName.visibility = View.GONE
            txtNickName.visibility = View.VISIBLE
        }

        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(view.windowToken, 0)
    }
}