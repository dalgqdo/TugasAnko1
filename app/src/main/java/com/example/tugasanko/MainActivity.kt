package com.example.tugasanko

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import org.jetbrains.anko.*

class MainActivity : AppCompatActivity(), AnkoLogger {

    companion object{
        lateinit var et_inputName : EditText
        lateinit var btn : Button
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        ViewLogin().setContentView(this)



    btn.setOnClickListener {
        startActivity(intentFor<AfterLogin>("name" to et_inputName.text.toString()))
        toast("Hello " + et_inputName.text.toString())
    }
    }

    class ViewLogin : AnkoComponent<MainActivity> {
        override fun createView(ui: AnkoContext<MainActivity>) = with(ui) {
            verticalLayout {
                lparams {
                    width = matchParent
                    height = matchParent
                    padding = 30
                    verticalGravity = android.view.Gravity.CENTER
                    backgroundColor = R.color.colorPrimary
//                    background = R.drawable.rounded
                }
                verticalLayout {
                    lparams(width = matchParent, height = wrapContent) {
                        backgroundColor = android.graphics.Color.WHITE
                        margin = 15
                        padding = 20
                    }
                    textView {
                        text = "Hello"
                        textSize = 25.0f
                        textColor = android.graphics.Color.LTGRAY
                        textAlignment = android.widget.TextView.TEXT_ALIGNMENT_CENTER
                    }.lparams(width = matchParent, height = wrapContent) {
                        margin = 15
                    }
                    et_inputName = editText {
                        hint = "input your name"
                        inputType = android.text.InputType.TYPE_CLASS_TEXT
                    }.lparams(width = matchParent, height = wrapContent) {
                        margin = 15
                    }
                    btn = button {
                        textColor = android.graphics.Color.WHITE
                        text = "GO"
                    }.lparams(width = wrapContent, height = wrapContent) {
                        margin = 15
                        gravity = android.view.Gravity.CENTER
                    }
                }
            }
        }
    }

}
