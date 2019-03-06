package ir.jorge.hw1.system

import android.content.Context

interface FileSystem {
    fun write(key: String, value: Int)
    fun read(key: String): Int
}

class AndroidFileSystem(private val context: Context) : FileSystem {
    private val path = "app.storage"

    override fun write(key: String, value: Int) {
        val sharedPref = context.getSharedPreferences(path, Context.MODE_PRIVATE)
        with(sharedPref.edit()) {
            putInt(key, value)
            apply()
        }
    }

    override fun read(key: String): Int {
        val sharedPref = context.getSharedPreferences(path, Context.MODE_PRIVATE)
        return sharedPref.getInt(key, 0)
    }
}
