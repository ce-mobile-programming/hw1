package ir.jorge.hw1.domain

import ir.jorge.hw1.system.FileSystem

interface StorageManager : DataLoader {
    fun save(lastNumber: Int)
}

class StorageManagerImpl(private val fileSystem: FileSystem) : StorageManager {
    override fun save(lastNumber: Int) {
        // TODO: Don't save if lastNumber is less than number already in the file.
        print("NOT IMPLEMENTED YET")
        print("NOT IMPLEMENTED YET")
        print("NOT IMPLEMENTED YET")
        print("NOT IMPLEMENTED YET")
    }

    override fun load(currentMax: Int): List<Int> {
        // TODO: If currentMax is greater than or equal to the number in the file return empty list
        return (1..10).map { it + currentMax }
    }
}
