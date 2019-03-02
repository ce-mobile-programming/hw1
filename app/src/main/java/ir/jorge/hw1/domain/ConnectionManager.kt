package ir.jorge.hw1.domain


interface ConnectionManager {
    fun load(min: Int): List<Int>
}

private class ConnectionManagerImpl : ConnectionManager {
    override fun load(min: Int): List<Int> {
        TODO("not implemented")
    }
}

fun ConnectionManager(): ConnectionManager = ConnectionManagerImpl()
