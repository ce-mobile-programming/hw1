package ir.jorge.hw1.system

interface FileSystem {
    fun write(path: String, content: String)
    fun read(path: String): String
}

private class AndroidFileSystem : FileSystem {
    override fun write(path: String, content: String) {
        TODO("not implemented")
    }

    override fun read(path: String): String {
        TODO("not implemented")
    }
}

fun FileSystem(): FileSystem = AndroidFileSystem()
