package com.login_screen

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import androidx.core.widget.doOnTextChanged

class SignupActivity : AppCompatActivity() {
    lateinit var tvName: TextView
    lateinit var etname: EditText
    lateinit var tvEmail: TextView
    lateinit var etEmail: EditText
    lateinit var tvPhone: TextView
    lateinit var etPhone: EditText
    lateinit var tvPassword: TextView
    lateinit var etPassword: EditText
    lateinit var tvPassword1: TextView
    lateinit var etPassword1: EditText
    lateinit var tvGender: TextView
    lateinit var rgGender: RadioButton
    lateinit var rbHe: RadioButton
    lateinit var rbShe: RadioButton
    lateinit var rbOther: RadioButton
    lateinit var btnSignup : Button
    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_signup)
        tvName=findViewById(R.id.tvname)
        etname=findViewById(R.id.etname)
        tvEmail=findViewById(R.id.tvEmail)
        etEmail=findViewById(R.id.etEmail)
        tvPhone=findViewById(R.id.tvPhone)
        etPhone=findViewById(R.id.etPhone)
        tvPassword=findViewById(R.id.tvPassword)
        etPassword=findViewById(R.id.etPassword)
        tvPassword1=findViewById(R.id.tvPassword1)
        etPassword1=findViewById(R.id.etPassword1)
        tvGender=findViewById(R.id.tvGender)
        rgGender=findViewById(R.id.rgGender)
        rbHe=findViewById(R.id.rbHe)
        rbShe=findViewById(R.id.rbShe)
        rbOther=findViewById(R.id.rbOther)
        btnSignup=findViewById(R.id.btnSignup)

        etPassword.doOnTextChanged { text, start, before, count ->

            if ((text?.length?: 0)<6){
                etPassword.error = resources.getString(R.string.please_enter_password)
            }
            else{
                etPassword.error==null
            }
            btnSignup.setOnClickListener {
                System.out.println("Clicked")
                var name = etname.text.toString()
                var email = etEmail.text.toString()
                var phone = etPhone.text.toString()
                var password = etPassword.text.toString()
                var password1 = etPassword1.text.toString()
                System.out.println("name ; $name")
                if (name.isNullOrEmpty()){
                    var name = etname.text.toString()
                    etname.error="Please enter name"
                }
                else if (email.isNullOrEmpty()){
                    var email = etEmail.text.toString()
                    etEmail.error="Please enter email"
                }
                else if (phone.isNullOrEmpty()) {
                    var phone = etPhone.text.toString()
                    etPhone.error = "Please enter phone number"
                    etPhone.requestFocus()
                }
                else if (password.isNullOrEmpty()){
                    var password =etPassword.text.toString()
                    etPassword.error="Re enter password"
                    etPassword.requestFocus()
                }
                else if (password1!=password){
                    var password =etPassword.text.toString()
                    var password1 = etPassword1.text.toString()
                    etPassword1.error="Password must be same"
                    etPassword.requestFocus()

                }
                else{
                    Toast.makeText(this,resources.getString(R.string.login_successfully), Toast.LENGTH_LONG).show()
                }
            }
        }
    }
}
