package ir.jorge.hw1.view

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import ir.jorge.hw1.R
import ir.jorge.hw1.databinding.ActivityMainBinding
import ir.jorge.hw1.domain.*


class MainActivity : Observer, AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    lateinit var messageController: MessageController
    lateinit var notificationCenter: NotificationCenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        messageController = domainFactory.newMessageController()
        notificationCenter = domainFactory.newNotificationCenter()
        notificationCenter.addObserver(this, EventType.DATA_LOADED)
        setOnClickListeners()
    }

    private fun setOnClickListeners() {
        binding.btnClear.setOnClickListener { clear() }
        binding.btnGet.setOnClickListener { get() }
        binding.btnRefresh.setOnClickListener { refresh() }
    }


    private fun clear() {
        binding.layoutList.removeAllViews()
    }

    private fun refresh() {

    }

    override fun onDestroy() {
        super.onDestroy()
        notificationCenter.removeObserver(this)
    }

    private fun get() {

    }

    override fun update() {
        TODO("not implemented")
    }
}
