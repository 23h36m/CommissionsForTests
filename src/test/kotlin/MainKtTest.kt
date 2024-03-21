import org.junit.Test

import org.junit.Assert.*
import ru.netology.commission

class MainKtTest {

    @Test
    fun commissionTestMcOver75k() {
        val type = "MasterCard"
        val transfer = 150000
        val past = 0

        val result = commission(type, transfer, past)

        assertEquals(920.0, result, 0.01)
    }
    @Test
    fun commissionTestMcUnder75k() {
        val type = "MasterCard"
        val transfer = 50000
        val past = 0

        val result = commission(type, transfer, past)

        assertEquals(0.0, result, 0.01)
    }
    @Test
    fun commissionTestVisaCommissionOver35() {
        val type = "Visa"
        val transfer = 50000
        val past = 0

        val result = commission(type, transfer, past)

        assertEquals(375.0, result, 0.01)
    }
    @Test
    fun commissionTestVisaCommissionUnder35() {
        val type = "Visa"
        val transfer = 500
        val past = 0

        val result = commission(type, transfer, past)

        assertEquals(35.0, result, 0.01)
    }

    @Test
    fun commissionTestVKPay() {
        val type = "VKPay"
        val transfer = 500
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

        assertEquals(-1.0, result, 0.01)
    }
    @Test
    fun commissionTestWrongType() {
        val type = "Mir"
        val transfer = 5000
        val past = 7000

        val result = commission(type, transfer, past)

        assertEquals(-1.0, result, 0.01)
    }
}