package ir.jorge.hw1.system

import android.content.Context


interface SystemFactory {
    fun newFileSystem(context: Context): FileSystem
}

private object SystemFactoryImpl : SystemFactory {
    override fun newFileSystem(context: Context): FileSystem = AndroidFileSystem(context)
}

var systemFactory: SystemFactory = SystemFactoryImpl

