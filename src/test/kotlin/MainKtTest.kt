import org.junit.Test

import org.junit.Assert.*
import ru.netology.commission

class MainKtTest {

    @Test
    fun commissionTestWithCommission() {
        val type = "MasterCard"
        val transfer = 150000
        val past = 0

        val result = commission(type, transfer, past)

        assertEquals(920.0, result, 0.01)
    }
    @Test
    fun commissionTestNoCommission() {
        val type = "MasterCard"
        val transfer = 50000
        val past = 0

        val result = commission(type, transfer, past)

        assertEquals(0.0, result, 0.01)
    }

    @Test
    fun commissionTestOverLimitDay() {
        val type = "MasterCard"
        val transfer = 500000
        val past = 0

        val result = commission(type, transfer, past)

        assertEquals(-2.0, result, 0.01)
    }

    @Test
    fun commissionTestOverLimitMonth() {
        val type = "MasterCard"
        val transfer = 50000
        val past = 700000

        val result = commission(type, transfer, past)

        assertEquals(-2.0, result, 0.01)
    }
    @Test
    fun commissionTestWrongType() {
        val type = "Visa"
        val transfer = 5000
        val past = 7000

        val result = commission(type, transfer, past)

        assertEquals(-1.0, result, 0.01)
    }
}