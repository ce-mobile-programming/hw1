package ir.jorge.hw1.domain

import ir.jorge.hw1.system.FileSystem

interface StorageManager : DataLoader {
    fun save(lastNumber: Int)
}

class StorageManagerImpl(private val fileSystem: FileSystem) : StorageManager {
    private val key = "last number"


    override fun save(lastNumber: Int) {
        if (fileSystem.read(key) < lastNumber)
            fileSystem.write(key, lastNumber)
    }

    override fun load(currentMax: Int): List<Int> {
        return if (fileSystem.read(key) <= currentMax)
            listOf()
        else
            (1..10).map { it + currentMax }
    }
}
