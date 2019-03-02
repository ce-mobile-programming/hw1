package ir.jorge.hw1.domain

import ir.jorge.hw1.system.FileSystem

interface StorageManager {
    fun save(lastNumber: Int)
    fun load(): List<Int>
}

private class StorageManagerImpl(val fileSystem: FileSystem) : StorageManager {
    override fun save(lastNumber: Int) {
        TODO("not implemented")
    }

    override fun load(): List<Int> {
        TODO("not implemented")
    }
}

fun StorageManager(fileSystem: FileSystem): StorageManager {
    return StorageManagerImpl(fileSystem)
}
