package com.kgb.kronometre

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.SystemClock
import android.view.View
import com.kgb.kronometre.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    var zamaniDurdur: Long = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

    }

    fun start(view: View) {

        binding.kronometre.base = SystemClock.elapsedRealtime() + zamaniDurdur
        binding.kronometre.start()
        binding.btnStart.visibility = View.GONE
        binding.btnPause.visibility = View.VISIBLE
        binding.imageView.setImageDrawable(getDrawable(R.drawable.pause))
    }

    fun pause(view: View) {
        zamaniDurdur = binding.kronometre.base - SystemClock.elapsedRealtime()
        binding.kronometre.stop()
        binding.btnStart.visibility = View.VISIBLE
        binding.btnPause.visibility = View.GONE
        binding.imageView.setImageDrawable(getDrawable(R.drawable.start))

    }

    fun reset(view: View) {
        binding.kronometre.base = SystemClock.elapsedRealtime()
        binding.kronometre.stop()
        zamaniDurdur = 0
        binding.btnPause.visibility = View.GONE
        binding.btnStart.visibility = View.VISIBLE
        binding.imageView.setImageDrawable(getDrawable(R.drawable.start))


    }
}