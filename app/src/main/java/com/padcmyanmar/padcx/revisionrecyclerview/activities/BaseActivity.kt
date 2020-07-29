package com.padcmyanmar.padcx.revisionrecyclerview.activities

import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.snackbar.Snackbar

abstract class BaseActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


    }

    fun showSnackBar(message : String){
        Snackbar.make(window.decorView,message,Snackbar.LENGTH_LONG).show()
    }

    fun showAlertDialog(message : String){
        val alertDialog=AlertDialog.Builder(this)
        alertDialog.setTitle("Test Base Activity")
        alertDialog.setMessage(message)
        alertDialog.setPositiveButton("Ok"){dialog, which -> this.finish()  }
        alertDialog.setNegativeButton("Cancel"){dialog, which -> dialog.cancel()  }
        alertDialog.show()
    }
}