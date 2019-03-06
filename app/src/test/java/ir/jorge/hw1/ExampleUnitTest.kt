package ir.jorge.hw1

import ir.jorge.hw1.domain.ConnectionManagerImpl
import org.junit.Test

import org.junit.Assert.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    fun ConnManTest() {
        val cm = ConnectionManagerImpl
        val result = cm.load(10)
        assertEquals(10, result.size)
        for (i in 0 until 10){
            assertEquals(i+10+1,result[i])
        }
        println(this.javaClass.canonicalName+" TEST SUCCESS!")
    }
    
}
