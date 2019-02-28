package ir.jorge.hw1

import android.app.Activity
import android.util.EventLog

class NotificationCenter
{
    val dataLoaded : EventLog.Event? = null
    private val channels = ArrayList<Activity>()

    public fun register(a : Activity)
    {
        channels.add(a)
    }

    public fun unresgister(a : Activity)
    {
        channels.remove(a)
    }

    companion object {
        val instance = NotificationCenter()
    }
}