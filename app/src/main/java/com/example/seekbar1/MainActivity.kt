package com.example.seekbar1

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.SeekBar
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        alpha.max = 225
        red.max = 225
        green.max = 225
        blue.max = 225

        class CommonListener: SeekBar.OnSeekBarChangeListener{
            var al = 0
            var redCol = 0
            var greenCol = 0
            var blueCol = 0

            override fun onProgressChanged(p0: SeekBar?, p1: Int, p2: Boolean) {
                when(p0?.id)
                {
                    R.id.alpha->{
                        al = p1
                    }
                    R.id.red->{
                        redCol = p1
                    }
                    R.id.green->{
                        greenCol = p1
                    }
                    R.id.blue->{
                        blueCol = p1
                    }
                }
                var myCol = Color.argb(al, redCol, greenCol, blueCol)
                myPage.setBackgroundColor(myCol)
            }

            override fun onStartTrackingTouch(p0: SeekBar?) {}

            override fun onStopTrackingTouch(p0: SeekBar?) {}

        }

        var commonListener = CommonListener()
        alpha.setOnSeekBarChangeListener(commonListener)
        red.setOnSeekBarChangeListener(commonListener)
        green.setOnSeekBarChangeListener(commonListener)
        blue.setOnSeekBarChangeListener(commonListener)
    }
}
