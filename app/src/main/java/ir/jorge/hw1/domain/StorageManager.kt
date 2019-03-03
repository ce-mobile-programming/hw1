package ir.jorge.hw1.domain

import android.content.Context
import ir.jorge.hw1.system.FileSystem

interface StorageManager : DataLoader {
    fun save(lastNumber: Int)
}

class StorageManagerImpl(private val fileSystem: FileSystem, private val context: Context) : StorageManager {
    private val path = "app.storage"
    private val key = "last number"


    override fun save(lastNumber: Int) {
        val lastSavedNumber = (fileSystem.read(context, path, key))
        if (lastSavedNumber < lastNumber)
            fileSystem.write(context, path, lastNumber, key)
    }

    override fun load(currentMax: Int): List<Int> {
        val lastSavedNumber = (fileSystem.read(context, path, key))
        if (lastSavedNumber <= currentMax)
            return listOf()
        return (1..10).map { it + currentMax }
    }
}
