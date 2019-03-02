package ir.jorge.hw1.domain

interface Observer {
    fun update()
}

data class State(val isLoading: Boolean, val numbers: List<Int>)

interface NotificationCenter {
    fun addObserver(observer: Observer)
    fun removeObserver(observer: Observer)
    fun getState(): State
    fun setNumbersState(state: List<Int>)
    fun setLoadingState(isLoading: Boolean)
}

object NotificationCenterImpl : NotificationCenter {
    private val observers: ArrayList<Observer> = ArrayList()
    private var state: State = State(false, listOf())

    override fun addObserver(observer: Observer) {
        observers.add(observer)
    }

    override fun removeObserver(observer: Observer) {
        observers.remove(observer)
    }

    override fun getState(): State {
        return state
    }

    override fun setNumbersState(numbers: List<Int>) {
        state = State(state.isLoading, numbers)
        notifyObservers()
    }

    override fun setLoadingState(isLoading: Boolean) {
        state = State(isLoading, state.numbers)
        notifyObservers()
    }

    private fun notifyObservers() {
        observers.forEach { it.update() }
    }
}

