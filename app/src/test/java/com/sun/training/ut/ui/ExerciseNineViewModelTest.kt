package com.sun.training.ut.ui

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.sun.training.ut.ui.exercise_nine.ExerciseNineViewModel
import io.mockk.spyk
import org.junit.Assert
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.rules.TestRule
import kotlin.jvm.Throws

/**
 * Created by nguyen.dinh.trung (01EJ5AJ523JK82ZVF3CS1WEN34) on 22/04/2021.
 */
class ExerciseNineViewModelTest {

    @get:Rule
    val instantTaskExecutorRule: TestRule = InstantTaskExecutorRule()

    private lateinit var viewModel: ExerciseNineViewModel

    @Before
    @Throws(Exception::class)
    fun setup() {
        viewModel = spyk(ExerciseNineViewModel())
    }

    /**
     *  NUMBER TEST        1    2   3   4   5   6   7   8   9   10  11  12  13  14  15  16
     *  hasMagicWand       T    T   T   T   T   T   T   T   F   F   F   F   F   F   F   F
     *  hasMaster          T    T   T   T   F   F   F   F   T   T   T   T   F   F   F   F
     *  hasKey             T    T   F   F   T   T   F   F   T   T   F   F   T   T   F   F
     *  hasLightSword      T    F   T   F   T   F   T   F   T   F   T   F   T   F   T   F
     * ------------------------------------------------------------------------------------
     * findRoom            T    T   T   T   T   T   T   T   T   T   T   T   F   F   F   F
     * enterRoom           T    T   F   F   T   T   F   F   T   T   F   F   F   F   F   F
     * beatBigBoss         T    F   F   F   T   F   F   F   T   F   F   F   F   F   F   F
     * */

    // 1
    @Test
    fun with_hasMagicWandIsTrue_hasMasterIsTrue_hasKeyIsTrue_hasLightSwordIsTrue_ThenReturned_findRoomIsTrue_enterRoomIsTrue_beatBigBossIsTrue(){
        //Given
        viewModel.onMagicWandChecked(true)
        viewModel.onMasterChecked(true)
        viewModel.onKeyChecked(true)
        viewModel.onLightSwordChecked(true)

        //When
        viewModel.checkResultExerciseNine()

        //Then
        Assert.assertEquals(true, viewModel.resultBeatBoss.value?.findRoom)
        Assert.assertEquals(true, viewModel.resultBeatBoss.value?.inputRoom)
        Assert.assertEquals(true, viewModel.resultBeatBoss.value?.beatBoss)
    }

    // 2
    @Test
    fun with_hasMagicWandIsTrue_hasMasterIsTrue_hasKeyIsTrue_hasLightSwordIsFalse_ThenReturned_findRoomIsTrue_enterRoomIsTrue_beatBigBossIsFalse(){
        //Given
        viewModel.onMagicWandChecked(true)
        viewModel.onMasterChecked(true)
        viewModel.onKeyChecked(true)
        viewModel.onLightSwordChecked(false)

        //When
        viewModel.checkResultExerciseNine()

        //Then
        Assert.assertEquals(true, viewModel.resultBeatBoss.value?.findRoom)
        Assert.assertEquals(true, viewModel.resultBeatBoss.value?.inputRoom)
        Assert.assertEquals(false, viewModel.resultBeatBoss.value?.beatBoss)
    }

    // 3
    @Test
    fun with_hasMagicWandIsTrue_hasMasterIsTrue_hasKeyIsFalse_hasLightSwordIsTrue_ThenReturned_findRoomIsTrue_enterRoomIsFalse_beatBigBossIsFalse(){
        //Given
        viewModel.onMagicWandChecked(true)
        viewModel.onMasterChecked(true)
        viewModel.onKeyChecked(false)
        viewModel.onLightSwordChecked(true)

        //When
        viewModel.checkResultExerciseNine()

        //Then
        Assert.assertEquals(true, viewModel.resultBeatBoss.value?.findRoom)
        Assert.assertEquals(false, viewModel.resultBeatBoss.value?.inputRoom)
        Assert.assertEquals(false, viewModel.resultBeatBoss.value?.beatBoss)
    }

    // 4
    @Test
    fun with_hasMagicWandIsTrue_hasMasterIsTrue_hasKeyIsFalse_hasLightSwordIsFalse_ThenReturned_findRoomIsTrue_enterRoomIsFalse_beatBigBossIsFalse(){
        //Given
        viewModel.onMagicWandChecked(true)
        viewModel.onMasterChecked(true)
        viewModel.onKeyChecked(false)
        viewModel.onLightSwordChecked(false)

        //When
        viewModel.checkResultExerciseNine()

        //Then
        Assert.assertEquals(true, viewModel.resultBeatBoss.value?.findRoom)
        Assert.assertEquals(false, viewModel.resultBeatBoss.value?.inputRoom)
        Assert.assertEquals(false, viewModel.resultBeatBoss.value?.beatBoss)
    }

    // 5
    @Test
    fun with_hasMagicWandIsTrue_hasMasterIsFalse_hasKeyIsTrue_hasLightSwordIsTrue_ThenReturned_findRoomIsTrue_enterRoomIsTrue_beatBigBossIsTrue(){
        //Given
        viewModel.onMagicWandChecked(true)
        viewModel.onMasterChecked(false)
        viewModel.onKeyChecked(true)
        viewModel.onLightSwordChecked(true)

        //When
        viewModel.checkResultExerciseNine()

        //Then
        Assert.assertEquals(true, viewModel.resultBeatBoss.value?.findRoom)
        Assert.assertEquals(true, viewModel.resultBeatBoss.value?.inputRoom)
        Assert.assertEquals(true, viewModel.resultBeatBoss.value?.beatBoss)
    }

    // 6
    @Test
    fun with_hasMagicWandIsTrue_hasMasterIsFalse_hasKeyIsTrue_hasLightSwordIsFalse_ThenReturned_findRoomIsTrue_enterRoomIsTrue_beatBigBossIsFalse(){
        //Given
        viewModel.onMagicWandChecked(true)
        viewModel.onMasterChecked(false)
        viewModel.onKeyChecked(true)
        viewModel.onLightSwordChecked(false)

        //When
        viewModel.checkResultExerciseNine()

        //Then
        Assert.assertEquals(true, viewModel.resultBeatBoss.value?.findRoom)
        Assert.assertEquals(true, viewModel.resultBeatBoss.value?.inputRoom)
        Assert.assertEquals(false, viewModel.resultBeatBoss.value?.beatBoss)
    }


    // 7
    @Test
    fun with_hasMagicWandIsTrue_hasMasterIsFalse_hasKeyIsFalse_hasLightSwordIsTrue_ThenReturned_findRoomIsTrue_enterRoomIsFalse_beatBigBossIsFalse(){
        //Given
        viewModel.onMagicWandChecked(true)
        viewModel.onMasterChecked(false)
        viewModel.onKeyChecked(false)
        viewModel.onLightSwordChecked(true)

        //When
        viewModel.checkResultExerciseNine()

        //Then
        Assert.assertEquals(true, viewModel.resultBeatBoss.value?.findRoom)
        Assert.assertEquals(false, viewModel.resultBeatBoss.value?.inputRoom)
        Assert.assertEquals(false, viewModel.resultBeatBoss.value?.beatBoss)
    }

    // 8
    @Test
    fun with_hasMagicWandIsTrue_hasMasterIsFalse_hasKeyIsFalse_hasLightSwordIsFalse_ThenReturned_findRoomIsTrue_enterRoomIsFalse_beatBigBossIsFalse(){
        //Given
        viewModel.onMagicWandChecked(true)
        viewModel.onMasterChecked(false)
        viewModel.onKeyChecked(false)
        viewModel.onLightSwordChecked(false)

        //When
        viewModel.checkResultExerciseNine()

        //Then
        Assert.assertEquals(true, viewModel.resultBeatBoss.value?.findRoom)
        Assert.assertEquals(false, viewModel.resultBeatBoss.value?.inputRoom)
        Assert.assertEquals(false, viewModel.resultBeatBoss.value?.beatBoss)
    }

    // 9
    @Test
    fun with_hasMagicWandIsFalse_hasMasterIsTrue_hasKeyIsTrue_hasLightSwordIsTrue_ThenReturned_findRoomIsTrue_enterRoomIsTrue_beatBigBossIsTrue(){
        //Given
        viewModel.onMagicWandChecked(false)
        viewModel.onMasterChecked(true)
        viewModel.onKeyChecked(true)
        viewModel.onLightSwordChecked(true)

        //When
        viewModel.checkResultExerciseNine()

        //Then
        Assert.assertEquals(true, viewModel.resultBeatBoss.value?.findRoom)
        Assert.assertEquals(true, viewModel.resultBeatBoss.value?.inputRoom)
        Assert.assertEquals(true, viewModel.resultBeatBoss.value?.beatBoss)
    }

    // 10
    @Test
    fun with_hasMagicWandIsFalse_hasMasterIsTrue_hasKeyIsTrue_hasLightSwordIsFalse_ThenReturned_findRoomIsTrue_enterRoomIsTrue_beatBigBossIsFalse(){
        //Given
        viewModel.onMagicWandChecked(false)
        viewModel.onMasterChecked(true)
        viewModel.onKeyChecked(true)
        viewModel.onLightSwordChecked(false)

        //When
        viewModel.checkResultExerciseNine()

        //Then
        Assert.assertEquals(true, viewModel.resultBeatBoss.value?.findRoom)
        Assert.assertEquals(true, viewModel.resultBeatBoss.value?.inputRoom)
        Assert.assertEquals(false, viewModel.resultBeatBoss.value?.beatBoss)
    }

    // 11
    @Test
    fun with_hasMagicWandIsFalse_hasMasterIsTrue_hasKeyIsFalse_hasLightSwordIsTrue_ThenReturned_findRoomIsTrue_enterRoomIsFalse_beatBigBossIsFalse(){
        //Given
        viewModel.onMagicWandChecked(false)
        viewModel.onMasterChecked(true)
        viewModel.onKeyChecked(false)
        viewModel.onLightSwordChecked(true)

        //When
        viewModel.checkResultExerciseNine()

        //Then
        Assert.assertEquals(true, viewModel.resultBeatBoss.value?.findRoom)
        Assert.assertEquals(false, viewModel.resultBeatBoss.value?.inputRoom)
        Assert.assertEquals(false, viewModel.resultBeatBoss.value?.beatBoss)
    }

    // 12
    @Test
    fun with_hasMagicWandIsFalse_hasMasterIsTrue_hasKeyIsFalse_hasLightSwordIsFalse_ThenReturned_findRoomIsTrue_enterRoomIsFalse_beatBigBossIsFalse(){
        //Given
        viewModel.onMagicWandChecked(false)
        viewModel.onMasterChecked(true)
        viewModel.onKeyChecked(false)
        viewModel.onLightSwordChecked(false)

        //When
        viewModel.checkResultExerciseNine()

        //Then
        Assert.assertEquals(true, viewModel.resultBeatBoss.value?.findRoom)
        Assert.assertEquals(false, viewModel.resultBeatBoss.value?.inputRoom)
        Assert.assertEquals(false, viewModel.resultBeatBoss.value?.beatBoss)
    }

    // 13
    @Test
    fun with_hasMagicWandIsFalse_hasMasterIsFalse_hasKeyIsTrue_hasLightSwordIsTrue_ThenReturned_findRoomIsFalse_enterRoomIsFalse_beatBigBossIsFalse(){
        //Given
        viewModel.onMagicWandChecked(false)
        viewModel.onMasterChecked(false)
        viewModel.onKeyChecked(true)
        viewModel.onLightSwordChecked(true)

        //When
        viewModel.checkResultExerciseNine()

        //Then
        Assert.assertEquals(false, viewModel.resultBeatBoss.value?.findRoom)
        Assert.assertEquals(false, viewModel.resultBeatBoss.value?.inputRoom)
        Assert.assertEquals(false, viewModel.resultBeatBoss.value?.beatBoss)
    }

    // 14
    @Test
    fun with_hasMagicWandIsFalse_hasMasterIsFalse_hasKeyIsTrue_hasLightSwordIsFalse_ThenReturned_findRoomIsFalse_enterRoomIsFalse_beatBigBossIsFalse(){
        //Given
        viewModel.onMagicWandChecked(false)
        viewModel.onMasterChecked(false)
        viewModel.onKeyChecked(true)
        viewModel.onLightSwordChecked(false)

        //When
        viewModel.checkResultExerciseNine()

        //Then
        Assert.assertEquals(false, viewModel.resultBeatBoss.value?.findRoom)
        Assert.assertEquals(false, viewModel.resultBeatBoss.value?.inputRoom)
        Assert.assertEquals(false, viewModel.resultBeatBoss.value?.beatBoss)
    }

    // 15
    @Test
    fun with_hasMagicWandIsFalse_hasMasterIsFalse_hasKeyIsFalse_hasLightSwordIsTrue_ThenReturned_findRoomIsFalse_enterRoomIsFalse_beatBigBossIsFalse(){
        //Given
        viewModel.onMagicWandChecked(false)
        viewModel.onMasterChecked(false)
        viewModel.onKeyChecked(false)
        viewModel.onLightSwordChecked(true)

        //When
        viewModel.checkResultExerciseNine()

        //Then
        Assert.assertEquals(false, viewModel.resultBeatBoss.value?.findRoom)
        Assert.assertEquals(false, viewModel.resultBeatBoss.value?.inputRoom)
        Assert.assertEquals(false, viewModel.resultBeatBoss.value?.beatBoss)
    }

    // 16
    @Test
    fun with_hasMagicWandIsFalse_hasMasterIsFalse_hasKeyIsFalse_hasLightSwordIsFalse_ThenReturned_findRoomIsFalse_enterRoomIsFalse_beatBigBossIsFalse(){
        //Given
        viewModel.onMagicWandChecked(false)
        viewModel.onMasterChecked(false)
        viewModel.onKeyChecked(false)
        viewModel.onLightSwordChecked(false)

        //When
        viewModel.checkResultExerciseNine()

        //Then
        Assert.assertEquals(false, viewModel.resultBeatBoss.value?.findRoom)
        Assert.assertEquals(false, viewModel.resultBeatBoss.value?.inputRoom)
        Assert.assertEquals(false, viewModel.resultBeatBoss.value?.beatBoss)
    }

}
