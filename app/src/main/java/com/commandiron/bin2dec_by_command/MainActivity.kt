package com.commandiron.bin2dec_by_command

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.DeadObjectException
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main. activity_main.*


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        clear_btn.setOnClickListener {
            binary_number_et.setText("")
            result_tv.setText("Decimal Number:")
        }

        convert_btn.setOnClickListener {

            if(binary_number_et.text.toString() != ""){

                val binaryNumberList = binary_number_et.text.toString().map { it.toString().toInt() }

                if(binaryNumberList.all{ it < 2 }){

                    var binaryPow = binaryNumberList.size.toDouble() - 1

                    var result = 0.0

                    for (b in binaryNumberList){
                        var sum = b * Math.pow(2.0, binaryPow)
                        binaryPow--
                        result += sum
                    }

                    result_tv.text = "Decimal Number: " + result.toInt().toString()
                }else{
                    Toast.makeText(this,"0 ve 1 dışında değer girdiniz", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
}