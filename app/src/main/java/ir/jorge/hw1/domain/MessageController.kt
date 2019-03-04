package ir.jorge.hw1.domain

import android.content.Context
import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors

interface MessageController {
    fun fetch(fromCache: Boolean)
    fun clear()
}

class MessageControllerImpl(
        private val storageManager: StorageManager,
        private val connectionManager: DataLoader,
        private val notificationCenter: NotificationCenter,
        private val uiRunner: UIRunner
) : MessageController {
    private val storageExecutor = Executors.newSingleThreadExecutor()
    private val cloudExecutor = Executors.newSingleThreadExecutor()

    private fun currentMax(): Int {
        val numbers = notificationCenter.getState().numbers
        return if (numbers.isEmpty()) 0 else numbers.last()
    }

    private fun findDataLoader(fromCache: Boolean): DataLoader {
        return if (!fromCache) storageManager else connectionManager
    }

    fun findExecutor(fromCache: Boolean): ExecutorService {
        return if (fromCache) storageExecutor else cloudExecutor
    }

    override fun fetch(fromCache: Boolean) {
        withLoading {
            findExecutor(fromCache).submit {
                val fetchedNumbers = findDataLoader(fromCache).load(currentMax())
                uiRunner.runOnUiThread { updateNumbersState(fetchedNumbers) }
                if (fromCache)
                    storageManager.save(fetchedNumbers.last())
            }
        }
    }

    private fun updateNumbersState(fetchedNumbers: List<Int>) {
        val oldState = notificationCenter.getState()
        val newNumbers = ArrayList<Int>()
        newNumbers.addAll(oldState.numbers)
        newNumbers.addAll(fetchedNumbers)
        notificationCenter.setNumbersState(newNumbers)
    }

    private fun withLoading(someFun: () -> Unit) {
        notificationCenter.setLoadingState(true)
        someFun()
        notificationCenter.setLoadingState(false)
    }

    override fun clear() {
        withLoading { notificationCenter.setNumbersState(listOf()) }
    }

}
