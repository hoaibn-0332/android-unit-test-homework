package com.sun.training.ut.ui.exercise_one

import androidx.annotation.VisibleForTesting
import androidx.lifecycle.MutableLiveData
import com.sun.training.ut.data.Constant
import com.sun.training.ut.data.model.Beer
import com.sun.training.ut.ui.base.BaseViewModel

class ExerciseOneViewModel : BaseViewModel() {

    @VisibleForTesting(otherwise = VisibleForTesting.PRIVATE)
    var isTimeCoupon: Boolean = false

    @VisibleForTesting(otherwise = VisibleForTesting.PRIVATE)
    var isVoucher: Boolean = false

    var numberBeer = 0
    val priceLiveData: MutableLiveData<Int> = MutableLiveData()

    fun calculatePrice() {
        val beer = Beer(isVoucher, isTimeCoupon, numberBeer)
        val priceOfBeer = when {
            beer.isVoucher -> {
                Constant.VOUCHER_PRICE
            }
            beer.isTimeCoupon -> {
                Constant.TIME_PRICE
            }
            else -> Constant.REGULAR_PRICE
        }
        val total = priceOfBeer * beer.numberBeer
        priceLiveData.postValue(total)
    }

    fun onTimeCouponChecked(isChecked: Boolean) {
        isTimeCoupon = isChecked
    }

    fun onVoucherChecked(isChecked: Boolean) {
        isVoucher = isChecked
    }

}