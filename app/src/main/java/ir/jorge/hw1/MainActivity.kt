package ir.jorge.hw1

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView


class MainActivity : AppCompatActivity() {

    var binding : ActivityMainBinding = null
    val list = ArrayList<TextView>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)


        binding.btn_clear.setOnClickListener{ clear() }
        binding.btn_get.setOnClickListener{get()}
        binding.btn_refresh.setOnClickListener{refresh()}

    }

    private fun clear()
    {
       binding.layout_list.removeAllViews()
    }

    private fun refresh()
    {
        for (view in list)
            binding.layout_list.addAllViews(view)
    }

    private fun get()
    {
        val size = list.size
        for (i in 1..10) {
            val textView = TextView(this)
            textView.text = (size+i).toString()
            list.add(textView)
            binding.layout_list.addView(textView)
        }
    }

}
