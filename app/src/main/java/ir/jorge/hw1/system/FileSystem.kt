package ir.jorge.hw1.system

import android.content.Context

interface FileSystem {
    fun write(context: Context, path: String, content: Int, key : String)
    fun read(context : Context, path: String, key: String): Int
}

private class AndroidFileSystem : FileSystem {
    override fun write(context: Context, path: String, content: Int, key : String) {
        val sharedPref = context.getSharedPreferences(
                path, Context.MODE_PRIVATE)
        with (sharedPref.edit()) {
            putInt(key, content)
            apply()
        }
    }

    override fun read(context: Context, path: String, key: String): Int {
        val sharedPref = context.getSharedPreferences(
                path, Context.MODE_PRIVATE)
        return sharedPref.getInt(key, 0)
    }
}

fun FileSystem(): FileSystem = AndroidFileSystem()
