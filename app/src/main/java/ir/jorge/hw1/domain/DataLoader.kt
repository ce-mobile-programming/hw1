package ir.jorge.hw1.domain

interface DataLoader {
    fun load(currentMax: Int): List<Int>
}
