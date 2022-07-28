package com.login_screen

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.core.widget.doOnTextChanged

class MainActivity : AppCompatActivity() {
    lateinit var tvLogin: TextView
    lateinit var etUsername: EditText
    lateinit var etPassword: EditText
    lateinit var tvForgetPassword: TextView
    lateinit var btnLogin: Button
    lateinit var tvSignup: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        tvLogin=findViewById(R.id.tvLogin)
        etUsername=findViewById(R.id.etUsername)
        etPassword=findViewById(R.id.etPassword)
        tvForgetPassword=findViewById(R.id.etForgetpassword)
        btnLogin=findViewById(R.id.btnLogin)
        tvSignup=findViewById(R.id.tvSignup)
        etPassword.doOnTextChanged { text, start, before, count ->
            if ((text?.length?:0)<6){
                etPassword.error=resources.getString(R.string.please_enter_password)
            }
            else{
                etPassword.error=null
            }
        }
        btnLogin.setOnClickListener {
            System.out.println("Clicked")
            var name = etUsername.text.toString()
            var password = etPassword.text.toString()
            System.out.println("name $name")
            if (name.isNullOrEmpty()){
                etUsername.error=resources.getString(R.string.please_enter_name)
                etUsername.requestFocus()
            }
            else if (password.isNullOrEmpty()){
                etPassword.error=resources.getString(R.string.please_enter_password)
                etPassword.requestFocus()
            }
            else{
                Toast.makeText(this,resources.getString(R.string.login_successfully), Toast.LENGTH_LONG).show()
                tvSignup.setOnClickListener {
                    var intent = Intent(this, SignupActivity::class.java)
                    startActivity(intent)
                }
            }
        }
    }
}