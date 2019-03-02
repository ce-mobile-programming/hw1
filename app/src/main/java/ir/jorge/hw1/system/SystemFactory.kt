package ir.jorge.hw1.system


interface SystemFactory {
    fun newFileSystem(): FileSystem
}

private object SystemFactoryImpl : SystemFactory {
    override fun newFileSystem(): FileSystem = FileSystem()
}

var systemFactory: SystemFactory = SystemFactoryImpl

