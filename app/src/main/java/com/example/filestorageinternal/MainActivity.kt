package com.example.filestorageinternal

import android.content.Context
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import java.io.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btnSave.setOnClickListener{
            val filename1 = filename.text.toString()
            val filedata1 = filedata.text.toString()

            val fileOutputStream:FileOutputStream
           // Only this application will be able to use this data
           try {
               fileOutputStream = openFileOutput(filename1, Context.MODE_PRIVATE)
               fileOutputStream.write(filedata1.toByteArray())
           }
            catch (e:FileNotFoundException){e.printStackTrace()}
            catch (e:Exception){e.printStackTrace()}
            Toast.makeText(this,"Data Saved to file Succesfully",Toast.LENGTH_SHORT).show()
            filedata.text.clear()
        }
        btnShow.setOnClickListener {
            val filename1 = filename.text.toString()
            if(filename1.toString()!=null && filename1.trim()!="") {

                var fileInputStream: FileInputStream? = null
                fileInputStream = openFileInput(filename1)
                var inputStreaReader: InputStreamReader = InputStreamReader(fileInputStream)
                var bufferedReader: BufferedReader = BufferedReader(inputStreaReader)
                val stringBuilder: StringBuilder = StringBuilder()
                var text: String? = null
                while ({ text = bufferedReader.readLine(); text }() != null) {
                    stringBuilder.append(text)
                }
                filedata.setText(stringBuilder.toString()).toString()
            }

            else
                Toast.makeText(this,"Name of the file can not be blank",Toast.LENGTH_SHORT).show()
            }

            }



        }



