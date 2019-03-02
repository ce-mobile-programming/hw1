package ir.jorge.hw1.domain

interface Observer {
    fun update()
}

enum class EventType {
    DATA_LOADED
}

interface NotificationCenter {
    fun addObserver(observer: Observer, eventType: EventType)
    fun removeObserver(observer: Observer)
    fun getState(): List<Int>
    fun setState(state: List<Int>)
}

private class NotificationCenterImpl : NotificationCenter {
    private val dataLoadedObservers: ArrayList<Observer> = ArrayList()

    override fun addObserver(observer: Observer, eventType: EventType) {
        TODO("not implemented")
    }

    override fun getState(): List<Int> {
        TODO("not implemented")
    }

    override fun setState(state: List<Int>) {
        TODO("not implemented")
    }

    override fun removeObserver(observer: Observer) {
        TODO("not implemented")
    }

    private fun notifyObservers() {

    }
}

fun NotificationCenter(): NotificationCenter = NotificationCenterImpl()