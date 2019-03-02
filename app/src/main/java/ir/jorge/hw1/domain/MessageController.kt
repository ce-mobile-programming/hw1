package ir.jorge.hw1.domain

interface MessageController {
    fun fetch(fromCache: Boolean)
}

private class MessageControllerImpl(
        val storageManager: StorageManager,
        val connectionManager: ConnectionManager
) : MessageController {
    override fun fetch(fromCache: Boolean) {
        TODO("Starts coroutines, fetches lists and calls notification center so that views are updated")
    }
}

fun MessageController(storageManager: StorageManager, connectionManager: ConnectionManager): MessageController {
    return MessageControllerImpl(storageManager, connectionManager)
}
