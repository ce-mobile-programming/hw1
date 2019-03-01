package ir.jorge.hw1

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.TextView
import ir.jorge.hw1.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    val list = ArrayList<TextView>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        binding.btnClear.setOnClickListener { clear() }
        binding.btnGet.setOnClickListener { get() }
        binding.btnRefresh.setOnClickListener { refresh() }


        NotificationCenter.instance.register(this)

    }

    private fun clear() {
        binding.layoutList.removeAllViews()
    }

    private fun refresh() {
        for (view in list)
            binding.layoutList.addView(view)
    }

    private fun get() {
        val size = list.size
        for (i in 1..10) {
            val textView = TextView(this)
            textView.text = (size + i).toString()
            list.add(textView)
            binding.layoutList.addView(textView)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        NotificationCenter.instance.unresgister(this)
    }

}
