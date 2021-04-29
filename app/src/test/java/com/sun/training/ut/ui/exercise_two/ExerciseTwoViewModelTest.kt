package com.sun.training.ut.ui.exercise_two

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.sun.training.ut.data.Constant
import com.sun.training.ut.ui.exercise_one.ExerciseOneViewModel
import io.mockk.spyk
import org.junit.Assert
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.rules.TestRule

class ExerciseTwoViewModelTest {

    @Rule
    @JvmField
    val instantTaskExecutorRule: TestRule = InstantTaskExecutorRule()

    private lateinit var viewModel: ExerciseTwoViewModel

    @Before
    fun setup() {
        viewModel = spyk(ExerciseTwoViewModel())
    }

    @Test
    fun onVipChecked_Case01() {
        //Given
        val isChecked = true

        //When
        viewModel.onVipChecked(isChecked)

        //Then
        Assert.assertEquals(isChecked, viewModel.isVip)
    }

    @Test
    fun onTimeChanged_Case01() {
        //Given
        val hour = 1
        val minute = 2

        //When
        viewModel.onTimeChanged(hour, minute)

        //Then
        Assert.assertEquals(hour, viewModel.hour)
        Assert.assertEquals(minute, viewModel.minute)
    }

    @Test
    fun onDateChanged_Case01() {
        //Given
        val dayOfMonth = 1
        val monthOfYear = 2

        //When
        viewModel.onDateChanged(dayOfMonth, monthOfYear)

        //Then
        Assert.assertEquals(monthOfYear + 1, viewModel.monthOfYear)
        Assert.assertEquals(dayOfMonth, viewModel.dayOfMonth)
    }

    @Test
    fun validateDate_Case01() {
        //Given
        val dayOfMonth = 1
        val monthOfYear = 5

        //When
        val result = viewModel.validateDate(dayOfMonth, monthOfYear)

        //Then
        Assert.assertTrue(result)
    }

    @Test
    fun calculateFee_Case01() {
        //Given
        viewModel.isVip = true

        //When
        viewModel.calculateFee()

        //Then
        Assert.assertEquals(0, viewModel.feeLiveData.value)
    }

    @Test
    fun calculateFee_Case02() {
        //Given
        viewModel.dayOfMonth = 1
        viewModel.monthOfYear = 5

        //When
        viewModel.calculateFee()

        //Then
        Assert.assertEquals(Constant.FEE_110, viewModel.feeLiveData.value)
    }

    @Test
    fun calculateFee_Case03() {
        //Given
        viewModel.dayOfMonth = 2
        viewModel.monthOfYear = 5
        viewModel.hour = 9
        viewModel.minute = 0

        //When
        viewModel.calculateFee()

        //Then
        Assert.assertEquals(0, viewModel.feeLiveData.value)
    }

    @Test
    fun validateHourRegularDay_Case01() {
        //Given
        val hour = 9
        val minute = 0

        //When
        val result = viewModel.validateHourRegularDay(hour, minute)

        //Then
        Assert.assertEquals(0, result)
    }

    @Test
    fun validateHourRegularDay_Case02() {
        //Given
        val hour = 8
        val minute = 0

        //When
        val result = viewModel.validateHourRegularDay(hour, minute)

        //Then
        Assert.assertEquals(Constant.FEE_110, result)
    }

    @Test
    fun validateHourRegularDay_Case03() {
        //Given
        val hour = 18
        val minute = 0

        //When
        val result = viewModel.validateHourRegularDay(hour, minute)

        //Then
        Assert.assertEquals(Constant.FEE_110, result)
    }
}