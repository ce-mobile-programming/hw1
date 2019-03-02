package ir.jorge.hw1.domain

interface UIRunner {
    fun runOnUiThread(someFun: () -> Unit)
}