package com.example.tugasanko

import android.graphics.Color
import android.os.Bundle
import android.os.Handler
import android.support.v7.app.AppCompatActivity
import android.view.Gravity
import android.widget.TextView
import org.jetbrains.anko.*

class Splash :AppCompatActivity(), AnkoLogger{

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        ViewSplash().setContentView(this)

        Handler().postDelayed({
            startActivity(intentFor<MainActivity>())
            finish()
        }, 4000)

    }

    class ViewSplash : AnkoComponent<Splash> {
        override fun createView(ui: AnkoContext<Splash>) = with(ui) {
            verticalLayout {
                lparams {
                    width = matchParent
                    height = matchParent
                    verticalGravity = Gravity.CENTER
                }
                textView {
                    text = "Welcome to Anko Training"
                    textColor = Color.LTGRAY
                    textSize = 40.0f
                    textAlignment = TextView.TEXT_ALIGNMENT_CENTER
                }.lparams {
                    width = matchParent
                    height = wrapContent
                    gravity = Gravity.CENTER
                }
            }
        }
    }
}