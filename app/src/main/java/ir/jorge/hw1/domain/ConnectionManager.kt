package ir.jorge.hw1.domain


object ConnectionManagerImpl : DataLoader {
    override fun load(currentMax: Int): List<Int> {
        Thread.sleep(100)
        return (1..10).map { it + currentMax }
    }
}
