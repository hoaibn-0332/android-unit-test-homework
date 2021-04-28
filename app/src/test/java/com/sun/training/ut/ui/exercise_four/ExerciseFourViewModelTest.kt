package com.sun.training.ut.ui.exercise_four

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.sun.training.ut.data.Constant
import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.MatcherAssert.assertThat
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class ExerciseFourViewModelTest {

    private lateinit var viewModel: ExerciseFourViewModel

    @get:Rule
    var instantExecutorRule = InstantTaskExecutorRule()

    @Before
    fun setupTest() {
        viewModel = ExerciseFourViewModel()
    }

    @Test
    fun calculateColor_normalDayAndNotHoliday_returnBlack() {
        // That mean: 19/04/2021 - Monday
        viewModel.onDateChanged(3, 19, 2021)

        viewModel.calculateColor()

        val value = viewModel.colorLiveData.getOrAwaitValue()

        assertThat(value, `is`("${Constant.Color.BLACK}"))
    }

    @Test
    fun calculateColor_normalDayAndHoliday_returnRed() {
        // That mean: 30/04/2021 - Friday
        viewModel.onDateChanged(3, 30, 2021)

        viewModel.calculateColor()

        val value = viewModel.colorLiveData.getOrAwaitValue()

        assertThat(value, `is`("${Constant.Color.RED}"))
    }

    @Test
    fun calculateColor_sundayAndNotHoliday_returnRed() {
        // That mean: 18/04/2021 - Sunday
        viewModel.onDateChanged(3, 18, 2021)

        viewModel.calculateColor()

        val value = viewModel.colorLiveData.getOrAwaitValue()

        assertThat(value, `is`("${Constant.Color.RED}"))
    }

    @Test
    fun calculateColor_sundayAndIsHoliday_returnRed() {
        // That mean: 01/05/2022 - Sunday
        viewModel.onDateChanged(4, 1, 2022)

        viewModel.calculateColor()

        val value = viewModel.colorLiveData.getOrAwaitValue()

        assertThat(value, `is`("${Constant.Color.RED}"))
    }

    @Test
    fun calculateColor_saturdayAndNotHoliday_returnBlue() {
        // That mean: 17/04/2021 - Saturday
        viewModel.onDateChanged(3, 17, 2021)

        viewModel.calculateColor()

        val value = viewModel.colorLiveData.getOrAwaitValue()

        assertThat(value, `is`("${Constant.Color.BLUE}"))
    }

    @Test
    fun calculateColor_saturdayAndIsHoliday_returnRed() {
        // That mean: 01/05/2021 - Saturday
        viewModel.onDateChanged(4, 1, 2021)

        viewModel.calculateColor()

        val value = viewModel.colorLiveData.getOrAwaitValue()

        assertThat(value, `is`("${Constant.Color.RED}"))
    }
}
