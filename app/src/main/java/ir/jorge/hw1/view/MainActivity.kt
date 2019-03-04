package ir.jorge.hw1.view

import android.app.ProgressDialog
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.TextView
import ir.jorge.hw1.R
import ir.jorge.hw1.databinding.ActivityMainBinding
import ir.jorge.hw1.domain.*
import ir.jorge.hw1.system.systemFactory


@Suppress("DEPRECATION")
class MainActivity : UIRunner, Observer, AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var messageController: MessageController
    private lateinit var notificationCenter: NotificationCenter
    private lateinit var progressDialog: ProgressDialog
    private var textList = ArrayList<TextView>()
    private var numberList = ArrayList<Int>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        messageController = domainFactory.newMessageController(this, systemFactory.newFileSystem(), this)
        notificationCenter = domainFactory.newNotificationCenter()
        notificationCenter.addObserver(this)
        progressDialog = newProgressBar()
        setOnClickListeners()
    }

    private fun newProgressBar(): ProgressDialog {
        val result = ProgressDialog(this)
        result.isIndeterminate = true
        result.setTitle("Loading")
        result.setMessage("Please wait")
        return result
    }

    private fun setOnClickListeners() {
        binding.btnClear.setOnClickListener { clear() }
        binding.btnGet.setOnClickListener { get() }
        binding.btnRefresh.setOnClickListener { refresh() }

    }


    private fun clear() {
        if (notificationCenter.getState().isLoading)
            return
        messageController.clear()
    }

    private fun refresh() {
        if (notificationCenter.getState().isLoading)
            return
        messageController.fetch(false)
    }

    private fun get() {
        if (notificationCenter.getState().isLoading)
            return
        messageController.fetch(true)
    }

    override fun onDestroy() {
        super.onDestroy()
        notificationCenter.removeObserver(this)
    }

    override fun update() {
        val state = notificationCenter.getState()
        updateProgress(state.isLoading)
        updateList(state.numbers)
    }

    private fun updateProgress(isLoading: Boolean) {
        if (isLoading == progressDialog.isShowing)
            return
        if (isLoading) progressDialog.show() else progressDialog.hide()
    }

    private fun updateList(numbers: List<Int>) {
        binding.layoutList.removeAllViews()
        for (num in numbers)
        {
            val item = TextView(this)
            item.text = num.toString()
            binding.layoutList.addView(item)
        }
    }

    override fun runOnUiThread(someFun: () -> Unit) {
        runOnUiThread(Runnable { someFun() })
    }
}
