package com.sun.training.ut.ui.exercise_five

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.sun.training.ut.data.Constant
import io.mockk.spyk
import junit.framework.Assert.assertEquals
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.rules.TestRule

/**
 * Created by dong.thi.hien (01EJ5AJ523JK82ZVF3CS1WEN34) on 22/04/2021.
 */
class ExerciseFiveViewModelTest {

    @Rule
    @JvmField
    val instantTaskExecutorRule: TestRule = InstantTaskExecutorRule()

    private lateinit var viewModel: ExerciseFiveViewModel

    @Before
    fun setup() {
        viewModel = spyk(ExerciseFiveViewModel())
    }

    /**
     * Test for calculateCouponWithPizza() method in case 01.
     * Test condition: totalPrice > 1500, isDelivery == true, isVoucher = true.
     * Expected result: discountLiveData.value == POTATO_PROMOTION && OFF_20.
     * Pass method calculateCouponWithPizza().
     */
    @Test
    fun calculateCouponWithPizza_case01() {
        //Given
        viewModel.totalPrice = 1600
        viewModel.onChangedDelivery(true)
        viewModel.onChangedVoucher(true)

        //When
        viewModel.calculateCouponWithPizza()

        //Then
        assertEquals(Constant.Coupon.POTATO_PROMOTION.coupon.plus(Constant.Coupon.OFF_20.coupon), viewModel.discountLiveData.value)
    }

    /**
     * Test for calculateCouponWithPizza() method in case 02.
     * Test condition: totalPrice > 1500, isDelivery == true, isVoucher = false.
     * Expected result: discountLiveData.value == POTATO_PROMOTION && REGULAR_FEE.
     * Pass method calculateCouponWithPizza().
     */
    @Test
    fun calculateCouponWithPizza_case02() {
        //Given
        viewModel.totalPrice = 1600
        viewModel.onChangedDelivery(true)
        viewModel.onChangedVoucher(false)

        //When
        viewModel.calculateCouponWithPizza()

        //Then
        assertEquals(Constant.Coupon.POTATO_PROMOTION.coupon.plus(Constant.Coupon.REGULAR_FEE.coupon), viewModel.discountLiveData.value)
    }

    /**
     * Test for calculateCouponWithPizza() method in case 03.
     * Test condition: totalPrice > 1500, isDelivery == false.
     * Expected result: discountLiveData.value == POTATO_PROMOTION && PIZZA_SECOND_FREE.
     * Pass method calculateCouponWithPizza().
     */
    @Test
    fun calculateCouponWithPizza_case03() {
        //Given
        viewModel.totalPrice = 1600
        viewModel.onChangedDelivery(false)

        //When
        viewModel.calculateCouponWithPizza()

        //Then
        assertEquals(Constant.Coupon.POTATO_PROMOTION.coupon.plus(Constant.Coupon.PIZZA_SECOND_FREE.coupon), viewModel.discountLiveData.value)
    }

    /**
     * Test for calculateCouponWithPizza() method in case 04.
     * Test condition: totalPrice < 1500, isDelivery == true, isVoucher = true.
     * Expected result: discountLiveData.value == OFF_20.
     * Pass method calculateCouponWithPizza().
     */
    @Test
    fun calculateCouponWithPizza_case04() {
        //Given
        viewModel.totalPrice = 1400
        viewModel.onChangedDelivery(true)
        viewModel.onChangedVoucher(true)

        //When
        viewModel.calculateCouponWithPizza()

        //Then
        assertEquals(Constant.Coupon.OFF_20.coupon, viewModel.discountLiveData.value)
    }

    /**
     * Test for calculateCouponWithPizza() method in case 05.
     * Test condition: totalPrice < 1500, isDelivery == true, isVoucher = false.
     * Expected result: discountLiveData.value == REGULAR_FEE.
     * Pass method calculateCouponWithPizza().
     */
    @Test
    fun calculateCouponWithPizza_case05() {
        //Given
        viewModel.totalPrice = 1400
        viewModel.onChangedDelivery(true)
        viewModel.onChangedVoucher(false)

        //When
        viewModel.calculateCouponWithPizza()

        //Then
        assertEquals(Constant.Coupon.REGULAR_FEE.coupon, viewModel.discountLiveData.value)
    }

    /**
     * Test for calculateCouponWithPizza() method in case 06.
     * Test condition: totalPrice < 1500, isDelivery == false.
     * Expected result: discountLiveData.value == PIZZA_SECOND_FREE.
     * Pass method calculateCouponWithPizza().
     */
    @Test
    fun calculateCouponWithPizza_case06() {
        //Given
        viewModel.totalPrice = 1400
        viewModel.onChangedDelivery(false)

        //When
        viewModel.calculateCouponWithPizza()

        //Then
        assertEquals(Constant.Coupon.PIZZA_SECOND_FREE.coupon, viewModel.discountLiveData.value)
    }

    /**
     * Test for onChangedDelivery() method in case 01.
     * Test condition: N/A
     * Expected result: Run method test success.
     * Pass method onChangedDelivery().
     */
    @Test
    fun onChangedDelivery_Case01() {
        //Given

        //When
        viewModel.onChangedDelivery(isChecked = true)

        //Then
        assertEquals(true, viewModel.getDelivery())
    }

    /**
     * Test for onChangedVoucher() method in case 01.
     * Test condition: N/A
     * Expected result: Run method test success.
     * Pass method onChangedVoucher().
     */
    @Test
    fun onChangedVoucher_Case01() {
        //Given

        //When
        viewModel.onChangedVoucher(isChecked = true)

        //Then
        assertEquals(true, viewModel.getVoucher())
    }
}
