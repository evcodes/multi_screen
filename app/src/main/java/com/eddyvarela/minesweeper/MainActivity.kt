package com.eddyvarela.minesweeper

import android.app.Activity
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    // static field of a class, can be accessed as a property of the class
    companion object{
        public val KEY_NAME = "KEY_NAME"
        public val KEY_GRADE = "KEY_GRADE"
        public val REQUEST_DETAILS = 1001
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn.setOnClickListener{
            var intentDetails = Intent()

            intentDetails.setClass(this@MainActivity,
                DetailActivity::class.java)
            intentDetails.putExtra(KEY_NAME, etName.text.toString())
            intentDetails.putExtra(KEY_GRADE, etGrade.text.toString())

//            startActivity(intentDetails)
            startActivityForResult(intentDetails, REQUEST_DETAILS)

        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
//        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == REQUEST_DETAILS ){
            if(resultCode == Activity.RESULT_OK){
                Toast.makeText(this@MainActivity,
                    "Comment: ${data?.getStringExtra("KEY_COMMENT")}",
                    Toast.LENGTH_LONG).show()
            }
        }
    }
}
