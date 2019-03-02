package ir.jorge.hw1.domain

interface MessageController {
    fun fetch(fromCache: Boolean): List<Int>
}

private class MessageControllerImpl(
        val storageManager: StorageManager,
        val connectionManager: ConnectionManager
) : MessageController {
    override fun fetch(fromCache: Boolean): List<Int> {
        TODO("not implemented")
    }
}

fun MessageController(storageManager: StorageManager, connectionManager: ConnectionManager): MessageController {
    return MessageControllerImpl(storageManager, connectionManager)
}
