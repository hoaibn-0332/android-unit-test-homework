package com.sun.training.ut.ui.exercise_one

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import io.mockk.spyk
import org.junit.Assert
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.rules.TestRule

/**
 *  Create by thanhva on 16/04/2021
 *  Class ExerciseOneViewModelTest
 */
class ExerciseOneViewModelTest {

    @Rule
    @JvmField
    val instantTaskExecutorRule: TestRule = InstantTaskExecutorRule()

    private lateinit var viewModel: ExerciseOneViewModel

    @Before
    fun setup() {
        viewModel = spyk(ExerciseOneViewModel())
    }

    /**
     * Test for calculatePrice() method in case 01.
     * Test condition: beer.isVoucher == true
     * Expected result: Run method test success.
     * Branch "beer.isVoucher == true" is executed.
     * Pass method calculatePrice().
     */
    @Test
    fun calculatePrice_Case01() {
        //Given
        viewModel.isVoucher = true

        //When
        viewModel.calculatePrice()

        //Then
        Assert.assertEquals(0, viewModel.priceLiveData.value)
    }

    /**
     * Test for calculatePrice() method in case 02.
     * Test condition: beer.isVoucher == false
     * beer.isTimeCoupon == true
     * Expected result: Run method test success.
     * Branch "beer.isTimeCoupon == true" is executed.
     * Pass method calculatePrice().
     */
    @Test
    fun calculatePrice_Case02() {
        //Given
        viewModel.isTimeCoupon = true

        //When
        viewModel.calculatePrice()

        //Then
        Assert.assertEquals(0, viewModel.priceLiveData.value)
    }

    /**
     * Test for calculatePrice() method in case 03.
     * Test condition: beer.isVoucher == false
     * beer.isTimeCoupon == false
     * Expected result: Run method test success.
     * Branch "beer.isVoucher == false && beer.isTimeCoupon == false" is executed.
     * Pass method calculatePrice().
     */
    @Test
    fun calculatePrice_Case03() {
        //Given
        viewModel.isVoucher = false
        viewModel.isTimeCoupon = false

        //When
        viewModel.calculatePrice()

        //Then
        Assert.assertEquals(0, viewModel.priceLiveData.value)
    }

    /**
     * Test for onTimeCouponChecked() method in case 01.
     * Test condition: N/A
     * Expected result: Run method test success.
     * Pass method onTimeCouponChecked().
     */
    @Test
    fun onTimeCouponChecked_Case01() {
        //Given

        //When
        viewModel.onTimeCouponChecked(isChecked = true)

        //Then
        Assert.assertEquals(true, viewModel.isTimeCoupon)
    }

    /**
     * Test for onVoucherChecked() method in case 01.
     * Test condition: N/A
     * Expected result: Run method test success.
     * Pass method onVoucherChecked().
     */
    @Test
    fun onVoucherChecked_Case01() {
        //Given

        //When
        viewModel.onVoucherChecked(isChecked = true)

        //Then
        Assert.assertEquals(true, viewModel.isVoucher)
    }
}