package com.sun.training.ut.ui

import android.content.res.Resources
import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.example.exercise_ten.R
import com.sun.training.ut.exercise_ten.data.model.MemberClassType
import com.sun.training.ut.exercise_ten.ui.ExerciseTenViewModel
import io.mockk.MockKAnnotations
import io.mockk.every
import io.mockk.impl.annotations.MockK
import io.mockk.spyk
import org.junit.Assert
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.rules.TestRule
import org.mockito.MockitoAnnotations

class ExerciseTenViewModelTest {

    @Rule
    @JvmField
    val instantTaskExecutorRule: TestRule = InstantTaskExecutorRule()

    @MockK
    private lateinit var resource: Resources

    private lateinit var viewModel: ExerciseTenViewModel

    @Before
    @Throws(Exception::class)
    fun setup() {
        MockitoAnnotations.initMocks(this)
        MockKAnnotations.init(this, relaxUnitFun = true)

        // mock resource
        every { resource.getString(R.string.ex_10_user_name_default) } answers { "Bach Ngoc Hoai" }
        every { resource.getString(R.string.ex_10_class_type_black) } answers { "Hạng Đen" }
        every { resource.getString(R.string.ex_10_class_type_gold) } answers { "Hạng Vàng" }
        every { resource.getString(R.string.ex_10_class_type_silver) } answers { "Hạng Bạc" }

        viewModel = spyk(ExerciseTenViewModel(resource))
    }

    @Test
    fun testInitialUserData() {
        Assert.assertEquals(viewModel.user.value?.userId, 1)
        Assert.assertEquals(viewModel.user.value?.userName, "Bach Ngoc Hoai")
        Assert.assertEquals(viewModel.user.value?.classType, MemberClassType.GOLD_CLASS)
    }

    @Test
    fun testGiftAcceptedWithPayment5000() {
        val result = viewModel.giftAccepted(5000.0)
        Assert.assertEquals(result, true)
    }

    @Test
    fun testGiftAcceptedWithPayment10000() {
        val result = viewModel.giftAccepted(10000.0)
        Assert.assertEquals(result, true)
    }

    @Test
    fun testGiftAcceptedWithOtherPayment() {
        val result = viewModel.giftAccepted(123456.0)
        Assert.assertEquals(result, false)
    }

    @Test
    fun testDiscountCalculation_Case01_Silver_No_Discount() {
        val newUser = viewModel.user.value
        newUser?.classType = MemberClassType.SILVER_CLASS
        viewModel.user.value = newUser

        val totalPrice = 1000.0
        val expectedDiscount = totalPrice * 0.0
        val finalDiscount = viewModel.discountCalculation(totalPrice)

        Assert.assertEquals(expectedDiscount == finalDiscount, true)
    }

    @Test
    fun testDiscountCalculation_Case02_Silver_3K() {
        val newUser = viewModel.user.value
        newUser?.classType = MemberClassType.SILVER_CLASS
        viewModel.user.value = newUser

        val totalPrice = 3456.0
        val expectedDiscount = totalPrice * 1 / 100
        val finalDiscount = viewModel.discountCalculation(totalPrice)

        Assert.assertEquals(
            Math.round(expectedDiscount * 10).toDouble() / 10 == Math.round(finalDiscount * 10)
                .toDouble() / 10, true
        )
    }

    @Test
    fun testDiscountCalculation_Case02_Silver_5K() {
        val newUser = viewModel.user.value
        newUser?.classType = MemberClassType.SILVER_CLASS
        viewModel.user.value = newUser

        val totalPrice = 5678.0
        val expectedDiscount = totalPrice * 2 / 100
        val finalDiscount = viewModel.discountCalculation(totalPrice)

        Assert.assertEquals(
            Math.round(expectedDiscount * 10).toDouble() / 10 == Math.round(finalDiscount * 10)
                .toDouble() / 10, true
        )
    }

    @Test
    fun testDiscountCalculation_Case02_Silver_10K() {
        val newUser = viewModel.user.value
        newUser?.classType = MemberClassType.SILVER_CLASS
        viewModel.user.value = newUser

        val totalPrice = 11111.0
        val expectedDiscount = totalPrice * 4 / 100
        val finalDiscount = viewModel.discountCalculation(totalPrice)

        Assert.assertEquals(
            Math.round(expectedDiscount * 10).toDouble() / 10 == Math.round(finalDiscount * 10)
                .toDouble() / 10, true
        )
    }

    @Test
    fun testDiscountCalculation_Case01_Gold_No_Discount() {
        val newUser = viewModel.user.value
        newUser?.classType = MemberClassType.GOLD_CLASS
        viewModel.user.value = newUser

        val totalPrice = 1234.0
        val expectedDiscount = totalPrice * 0.0
        val finalDiscount = viewModel.discountCalculation(totalPrice)

        Assert.assertEquals(
            Math.round(expectedDiscount * 10).toDouble() / 10 == Math.round(finalDiscount * 10)
                .toDouble() / 10, true
        )
    }

    @Test
    fun testDiscountCalculation_Case02_Gold_3K() {
        val newUser = viewModel.user.value
        newUser?.classType = MemberClassType.GOLD_CLASS
        viewModel.user.value = newUser

        val totalPrice = 3456.0
        val expectedDiscount = totalPrice * 3.0 / 100.0
        val finalDiscount = viewModel.discountCalculation(totalPrice)

        Assert.assertEquals(
            Math.round(expectedDiscount * 10).toDouble() / 10 == Math.round(finalDiscount * 10)
                .toDouble() / 10,
            true
        )
    }

    @Test
    fun testDiscountCalculation_Case02_Gold_5K() {
        val newUser = viewModel.user.value
        newUser?.classType = MemberClassType.GOLD_CLASS
        viewModel.user.value = newUser

        val totalPrice = 5678.0
        val expectedDiscount = totalPrice * 5 / 100
        val finalDiscount = viewModel.discountCalculation(totalPrice)


        Assert.assertEquals(
            Math.round(expectedDiscount * 10).toDouble() / 10 == Math.round(finalDiscount * 10)
                .toDouble() / 10,
            true
        )
    }

    @Test
    fun testDiscountCalculation_Case02_Gold_10K() {
        val newUser = viewModel.user.value
        newUser?.classType = MemberClassType.GOLD_CLASS
        viewModel.user.value = newUser

        val totalPrice = 11111.0
        val expectedDiscount = totalPrice * 10 / 100
        val finalDiscount = viewModel.discountCalculation(totalPrice)

        Assert.assertEquals(
            Math.round(expectedDiscount * 10).toDouble() / 10 == Math.round(finalDiscount * 10)
                .toDouble() / 10,
            true
        )
    }

    @Test
    fun testDiscountCalculation_Case02_Black_3K() {
        val newUser = viewModel.user.value
        newUser?.classType = MemberClassType.BLACK_CLASS
        viewModel.user.value = newUser

        val totalPrice = 3456.0
        val expectedDiscount = totalPrice * 5.0 / 100.0
        val finalDiscount = viewModel.discountCalculation(totalPrice)

        Assert.assertEquals(
            Math.round(expectedDiscount * 10).toDouble() / 10 == Math.round(finalDiscount * 10)
                .toDouble() / 10,
            true
        )
    }

    @Test
    fun testDiscountCalculation_Case02_Black_5K() {
        val newUser = viewModel.user.value
        newUser?.classType = MemberClassType.BLACK_CLASS
        viewModel.user.value = newUser

        val totalPrice = 5678.0
        val expectedDiscount = totalPrice * 7 / 100
        val finalDiscount = viewModel.discountCalculation(totalPrice)


        Assert.assertEquals(
            Math.round(expectedDiscount * 10).toDouble() / 10 == Math.round(finalDiscount * 10)
                .toDouble() / 10,
            true
        )
    }

    @Test
    fun testDiscountCalculation_Case02_Black_10K() {
        val newUser = viewModel.user.value
        newUser?.classType = MemberClassType.BLACK_CLASS
        viewModel.user.value = newUser

        val totalPrice = 11111.0
        val expectedDiscount = totalPrice * 15 / 100
        val finalDiscount = viewModel.discountCalculation(totalPrice)

        Assert.assertEquals(
            Math.round(expectedDiscount * 10).toDouble() / 10 == Math.round(finalDiscount * 10)
                .toDouble() / 10,
            true
        )
    }

    @Test
    fun testGiftAccepted_CaseNotAccept() {
        val isAccept = viewModel.giftAccepted(3000.0)
        Assert.assertEquals(isAccept, false)
    }

    @Test
    fun testGiftAccepted_CaseAccept_5K() {
        val isAccept = viewModel.giftAccepted(5000.0)
        Assert.assertEquals(isAccept, true)
    }

    @Test
    fun testGiftAccepted_CaseAccept_10K() {
        val isAccept = viewModel.giftAccepted(10000.0)
        Assert.assertEquals(isAccept, true)
    }

    @Test
    fun testPrintInvoice_Case_Silver_No_Discount() {
        val newUser = viewModel.user.value
        newUser?.classType = MemberClassType.SILVER_CLASS
        viewModel.user.value = newUser
        viewModel.subTotal.value = "2000"

        viewModel.printInvoice()

        Assert.assertEquals(viewModel.invoice.value?.discount, 0.0)
        Assert.assertEquals(viewModel.invoice.value?.giftAccepted, false)
        Assert.assertEquals(viewModel.invoice.value?.total, 2000.0)
    }

    @Test
    fun testPrintInvoice_Case_Silver_3K() {
        val newUser = viewModel.user.value
        newUser?.classType = MemberClassType.SILVER_CLASS
        viewModel.user.value = newUser
        viewModel.subTotal.value = "3000"

        viewModel.printInvoice()

        Assert.assertEquals(viewModel.invoice.value?.discount, 30.0)
        Assert.assertEquals(viewModel.invoice.value?.giftAccepted, false)
        Assert.assertEquals(viewModel.invoice.value?.total, 2970.0)
    }

    @Test
    fun testPrintInvoice_Case_Silver_5K() {
        val newUser = viewModel.user.value
        newUser?.classType = MemberClassType.SILVER_CLASS
        viewModel.user.value = newUser
        viewModel.subTotal.value = "5000"

        viewModel.printInvoice()

        Assert.assertEquals(viewModel.invoice.value?.discount, 100.0)
        Assert.assertEquals(viewModel.invoice.value?.giftAccepted, true)
        Assert.assertEquals(viewModel.invoice.value?.total, 4900.0)
    }

    @Test
    fun testPrintInvoice_Case_Silver_10K() {
        val newUser = viewModel.user.value
        newUser?.classType = MemberClassType.SILVER_CLASS
        viewModel.user.value = newUser
        viewModel.subTotal.value = "10000"

        viewModel.printInvoice()

        Assert.assertEquals(viewModel.invoice.value?.discount, 400.0)
        Assert.assertEquals(viewModel.invoice.value?.giftAccepted, true)
        Assert.assertEquals(viewModel.invoice.value?.total, 9600.0)
    }

    @Test
    fun testPrintInvoice_Case_Gold_No_Discount() {
        val newUser = viewModel.user.value
        newUser?.classType = MemberClassType.GOLD_CLASS
        viewModel.user.value = newUser
        viewModel.subTotal.value = "2345"

        viewModel.printInvoice()

        Assert.assertEquals(viewModel.invoice.value?.discount, 0.0)
        Assert.assertEquals(viewModel.invoice.value?.giftAccepted, false)
        Assert.assertEquals(viewModel.invoice.value?.total, 2345.0)
    }

    @Test
    fun testPrintInvoice_Case_Gold_3K() {
        val newUser = viewModel.user.value
        newUser?.classType = MemberClassType.GOLD_CLASS
        viewModel.user.value = newUser
        viewModel.subTotal.value = "3000"

        viewModel.printInvoice()

        Assert.assertEquals(viewModel.invoice.value?.discount, 90.0)
        Assert.assertEquals(viewModel.invoice.value?.giftAccepted, false)
        Assert.assertEquals(viewModel.invoice.value?.total, 2910.0)
    }

    @Test
    fun testPrintInvoice_Case_Gold_5K() {
        val newUser = viewModel.user.value
        newUser?.classType = MemberClassType.GOLD_CLASS
        viewModel.user.value = newUser
        viewModel.subTotal.value = "5000"

        viewModel.printInvoice()

        Assert.assertEquals(viewModel.invoice.value?.discount, 250.0)
        Assert.assertEquals(viewModel.invoice.value?.giftAccepted, true)
        Assert.assertEquals(viewModel.invoice.value?.total, 4750.0)
    }

    @Test
    fun testPrintInvoice_Case_Gold_10K() {
        val newUser = viewModel.user.value
        newUser?.classType = MemberClassType.GOLD_CLASS
        viewModel.user.value = newUser
        viewModel.subTotal.value = "10000"

        viewModel.printInvoice()

        Assert.assertEquals(viewModel.invoice.value?.discount, 1000.0)
        Assert.assertEquals(viewModel.invoice.value?.giftAccepted, true)
        Assert.assertEquals(viewModel.invoice.value?.total, 9000.0)
    }

    @Test
    fun testPrintInvoice_Case_Black_No_Discount() {
        val newUser = viewModel.user.value
        newUser?.classType = MemberClassType.BLACK_CLASS
        viewModel.user.value = newUser
        viewModel.subTotal.value = "2345"

        viewModel.printInvoice()

        Assert.assertEquals(viewModel.invoice.value?.discount, 0.0)
        Assert.assertEquals(viewModel.invoice.value?.giftAccepted, false)
        Assert.assertEquals(viewModel.invoice.value?.total, 2345.0)
    }

    @Test
    fun testPrintInvoice_Case_Black_3K() {
        val newUser = viewModel.user.value
        newUser?.classType = MemberClassType.BLACK_CLASS
        viewModel.user.value = newUser
        viewModel.subTotal.value = "3000"

        viewModel.printInvoice()

        Assert.assertEquals(viewModel.invoice.value?.discount, 150.0)
        Assert.assertEquals(viewModel.invoice.value?.giftAccepted, false)
        Assert.assertEquals(viewModel.invoice.value?.total, 2850.0)
    }

    @Test
    fun testPrintInvoice_Case_Black_5K() {
        val newUser = viewModel.user.value
        newUser?.classType = MemberClassType.BLACK_CLASS
        viewModel.user.value = newUser
        viewModel.subTotal.value = "5000"

        viewModel.printInvoice()

        Assert.assertEquals(viewModel.invoice.value?.discount, 350.0)
        Assert.assertEquals(viewModel.invoice.value?.giftAccepted, true)
        Assert.assertEquals(viewModel.invoice.value?.total, 4650.0)
    }

    @Test
    fun testPrintInvoice_Case_Black_10K() {
        val newUser = viewModel.user.value
        newUser?.classType = MemberClassType.BLACK_CLASS
        viewModel.user.value = newUser
        viewModel.subTotal.value = "10000"

        viewModel.printInvoice()

        Assert.assertEquals(viewModel.invoice.value?.discount, 1500.0)
        Assert.assertEquals(viewModel.invoice.value?.giftAccepted, true)
        Assert.assertEquals(viewModel.invoice.value?.total, 8500.0)
    }
}