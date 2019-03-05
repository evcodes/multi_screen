package com.eddyvarela.minesweeper

import android.app.Activity
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_detail.*

class DetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        if (intent.extras.containsKey(MainActivity.KEY_GRADE) and intent.extras.containsKey(MainActivity.KEY_NAME)){
            val name = intent.getStringExtra(MainActivity.KEY_NAME)
            val grade = intent.getStringExtra(MainActivity.KEY_GRADE)

            tv_data.text = getString(R.string.text_grade, name, grade) // injects values into String resource
        }

        btn_cancel.setOnClickListener{
            finish()
        }

        btnOk.setOnClickListener{
            var intentGradeResult = Intent()
            intentGradeResult.putExtra("KEY_COMMENT", etComment.text.toString())
            setResult(Activity.RESULT_OK, intentGradeResult)
            finish()
        }

    }
}
