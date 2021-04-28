package com.sun.training.ut

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.sun.training.ut.data.Constant
import com.sun.training.ut.ui.exercise_three.ExerciseThreeViewModel
import org.hamcrest.CoreMatchers.`is`
import org.junit.Assert.assertThat
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class ExerciseThreeViewModelTest {
    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()
    lateinit var viewModel: ExerciseThreeViewModel

    @Before
    fun setUp() {
        viewModel = ExerciseThreeViewModel()
    }

    @Test
    fun test_less7ItemsAndIsTieIsShirt() {
        viewModel.onChangedShirt(true)
        viewModel.onChangedTie(true)
        viewModel.numberOfItems = 6
        viewModel.calculate()
        val value = viewModel.discountLiveData.getOrAwaitValue()
        assertThat(value, `is`(5))
    }

    @Test
    fun test_more7ItemsAndNotTieIsShirt() {
        viewModel.onChangedShirt(true)
        viewModel.onChangedTie(false)
        viewModel.numberOfItems = 7
        viewModel.calculate()
        val value = viewModel.discountLiveData.getOrAwaitValue()
        assertThat(value, `is`(Constant.DISCOUNT_7))
    }

    @Test
    fun test_more7ItemsAndIsTieNotShirt() {
        viewModel.onChangedShirt(false)
        viewModel.onChangedTie(true)
        viewModel.numberOfItems = 7
        viewModel.calculate()
        val value = viewModel.discountLiveData.getOrAwaitValue()
        assertThat(value, `is`(Constant.DISCOUNT_7))
    }

    @Test
    fun test_more7ItemsAndNotTieNotShirt() {
        viewModel.onChangedShirt(false)
        viewModel.onChangedTie(false)
        viewModel.numberOfItems = 7
        viewModel.calculate()
        val value = viewModel.discountLiveData.getOrAwaitValue()
        assertThat(value, `is`(Constant.DISCOUNT_7))
    }

    @Test
    fun test_more7ItemsAndIsTieIsShirt() {
        viewModel.onChangedShirt(true)
        viewModel.onChangedTie(true)
        viewModel.numberOfItems = 7
        viewModel.calculate()
        val value = viewModel.discountLiveData.getOrAwaitValue()
        assertThat(value, `is`(Constant.DISCOUNT_12))
    }

    @Test
    fun test_7ItemsAndNotTieNotShirt() {
        viewModel.onChangedShirt(false)
        viewModel.onChangedTie(false)
        viewModel.numberOfItems = 7
        viewModel.calculate()
        val value = viewModel.discountLiveData.getOrAwaitValue()
        assertThat(value, `is`(Constant.DISCOUNT_7))
    }

    @Test
    fun test_isTieAndIsShirtNot7Items_checkValue() {
        viewModel.onChangedShirt(true)
        viewModel.onChangedTie(true)
        viewModel.numberOfItems = 0
        viewModel.calculate()
        val value = viewModel.discountLiveData.getOrAwaitValue()
        assertThat(value, `is`(Constant.DISCOUNT_5))
    }

    @Test
    fun test_notTieAndNotShirtLess7Items_checkValue() {
        viewModel.onChangedShirt(false)
        viewModel.onChangedTie(false)
        viewModel.calculate()
        val value = viewModel.discountLiveData.getOrAwaitValue()
        assertThat(value, `is`(0))
    }
}
