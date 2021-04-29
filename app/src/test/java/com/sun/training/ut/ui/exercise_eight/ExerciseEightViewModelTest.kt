package com.sun.training.ut.ui.exercise_eight

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.sun.training.ut.data.Constant
import com.sun.training.ut.data.model.No8Member
import io.mockk.spyk
import org.junit.Assert
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.rules.TestRule

class ExerciseEightViewModelTest {
    @get:Rule
    val instantTaskExecutorRule: TestRule = InstantTaskExecutorRule()


    private lateinit var viewModel: ExerciseEightViewModel

    @Before
    fun setUp() {
        viewModel = spyk(ExerciseEightViewModel())
    }

    /**
     * Test for validateMemberAge() method
     * Test condition: member.age == 20
     * Expected result: Run method test success.
     * Branch "viewModel.validateMemberAge" return true.
     */
    @Test
    fun testValidateMemberAge_Case_01() {
        //given
        viewModel.member.value = No8Member(age = 20,)

        //when
        val result = viewModel.validateMemberAge()

        //then
        Assert.assertTrue(result)
    }

    /**
     * Test for validateMemberAge() method
     * Test condition: member.age < 0
     * Expected result: Run method test success.
     * Branch "viewModel.validateMemberAge" return false.
     */
    @Test
    fun testValidateMemberAge_Case_02() {
        //given
        viewModel.member.value = No8Member(age = -1,)

        //when
        val result = viewModel.validateMemberAge()

        //then
        Assert.assertFalse(result)
    }

    /**
     * Test for validateMemberAge() method
     * Test condition: member.age > 120
     * Expected result: Run method test success.
     * Branch "viewModel.validateMemberAge" return false.
     */
    @Test
    fun testValidateMemberAge_Case_03() {
        //given
        viewModel.member.value = No8Member(age = 121,)

        //when
        val result = viewModel.validateMemberAge()

        //then
        Assert.assertFalse(result)
    }

    /**
     * Test for genderChangedMale() method
     * Test condition: isChecked = true, member.gender = Constant.Gender.MALE
     * Expected result: member.gender == Constance.Gender.MALE.
     */
    @Test
    fun testGenderChangedMale_Case_04() {
        //given
        viewModel.member.value = No8Member(gender = Constant.Gender.MALE,)

        //when
        viewModel.genderChangedMale(true)

        //then
        Assert.assertTrue(viewModel.member.value?.gender == Constant.Gender.MALE)
    }

    /**
     * Test for genderChangedMale() method
     * Test condition: isChecked = true, member.gender = Constant.Gender.FEMALE
     * Expected result: member.gender == Constance.Gender.MALE.
     */
    @Test
    fun testGenderChangedMale_Case_05() {
        //given
        viewModel.member.value = No8Member(gender = Constant.Gender.FEMALE,)

        //when
        viewModel.genderChangedMale(true)

        //then
        Assert.assertTrue(viewModel.member.value?.gender == Constant.Gender.MALE)
    }

    /**
     * Test for genderChangedMale() method
     * Test condition: isChecked = false, member.gender = Constant.Gender.MALE
     * Expected result: member.gender == Constance.Gender.MALE.
     */
    @Test
    fun testGenderChangedMale_Case_06() {
        //given
        viewModel.member.value = No8Member(gender = Constant.Gender.MALE,)

        //when
        viewModel.genderChangedMale(true)

        //then
        Assert.assertTrue(viewModel.member.value?.gender == Constant.Gender.MALE)
    }

    /**
     * Test for genderChangedMale() method
     * Test condition: isChecked = false, member.gender = Constant.Gender.FEMALE
     * Expected result: member.gender == Constance.Gender.FEMALE.
     */
    @Test
    fun testGenderChangedMale_Case_07() {
        //given
        viewModel.member.value = No8Member(gender = Constant.Gender.FEMALE)

        //when
        viewModel.genderChangedMale(false)

        //then
        Assert.assertTrue(viewModel.member.value?.gender == Constant.Gender.FEMALE)
    }

    /**
     * Test for genderChangedFemale() method
     * Test condition: isChecked = true, member.gender = Constant.Gender.FEMALE
     * Expected result: member.gender == Constance.Gender.MALE.
     */
    @Test
    fun testGenderChangedMale_Case_08() {
        //given
        viewModel.member.value = No8Member(gender = Constant.Gender.FEMALE,)

        //when
        viewModel.genderChangedFemale(true)

        //then
        Assert.assertTrue(viewModel.member.value?.gender == Constant.Gender.FEMALE)
    }

    /**
     * Test for genderChangedFemale() method
     * Test condition: isChecked = true, member.gender = Constant.Gender.MALE
     * Expected result: member.gender == Constance.Gender.MALE.
     */
    @Test
    fun testGenderChangedMale_Case_09() {
        //given
        viewModel.member.value = No8Member(gender = Constant.Gender.MALE,)

        //when
        viewModel.genderChangedFemale(true)

        //then
        Assert.assertTrue(viewModel.member.value?.gender == Constant.Gender.FEMALE)
    }

    /**
     * Test for genderChangedFemale() method
     * Test condition: isChecked = false, member.gender = Constant.Gender.MALE
     * Expected result: member.gender == Constance.Gender.MALE.
     */
    @Test
    fun testGenderChangedMale_Case_10() {
        //given
        viewModel.member.value = No8Member(gender = Constant.Gender.FEMALE,)

        //when
        viewModel.genderChangedFemale(false)

        //then
        Assert.assertTrue(viewModel.member.value?.gender == Constant.Gender.FEMALE)
    }

    /**
     * Test for testGenderChangedMale_Case_11() method
     * Test condition: isChecked = false, member.gender = Constant.Gender.FEMALE
     * Expected result: member.gender == Constance.Gender.FEMALE.
     */
    @Test
    fun testGenderChangedMale_Case_11() {
        //given
        viewModel.member.value = No8Member(gender = Constant.Gender.FEMALE,)

        //when
        viewModel.genderChangedMale(false)

        //then
        Assert.assertTrue(viewModel.member.value?.gender == Constant.Gender.FEMALE)
    }


    /**
     * Test for ageChanged() method
     * Test condition: age = 20
     * Expected result: member.gender == 20.
     */
    @Test
    fun testAgeChanged_Case_12() {
        //given
        viewModel.member.value = No8Member(gender = Constant.Gender.FEMALE, age = 25)

        //when
        viewModel.ageChanged(20)

        //then
        Assert.assertTrue(viewModel.member.value?.age == 20)
    }


    /**
     * Test for calculateBadmintonFee() method
     * Test condition: dayOfWeek = null
     * Expected result: Constant.DAY_OF_WEEK_EXCEPTION
     */
    @Test
    fun testCalculateBadmintonFee_Case_13() {
        //given
        viewModel.dayOfWeek = null

        //when
        val result = viewModel.calculateBadmintonFee()

        //then
        Assert.assertTrue(result == Constant.DAY_OF_WEEK_EXCEPTION)
    }

    /**
     * Test for calculateBadmintonFee() method
     * Test condition: age < 0
     * Expected result: Constant.AGE_EXCEPTION
     */
    @Test
    fun testCalculateBadmintonFee_Case_14() {
        //given
        viewModel.member.value  = No8Member(age = -1)
        viewModel.dayOfWeek = Constant.DayOfWeek.MONDAY

        //when
        val result = viewModel.calculateBadmintonFee()

        //then
        Assert.assertTrue(result == Constant.AGE_EXCEPTION)
    }

    /**
     * Test for calculateBadmintonFee() method
     * Test condition: age > 120
     * Expected result: Constant.DAY_OF_WEEK_EXCEPTION
     */
    @Test
    fun testCalculateBadmintonFee_Case_15() {
        //given
        viewModel.member.value?.age = 121

        //when
        val result = viewModel.calculateBadmintonFee()

        //then
        Assert.assertTrue(result == Constant.DAY_OF_WEEK_EXCEPTION)
    }

    /**
     * Test for calculateBadmintonFee() method
     * Test condition: dayOfWeek = null,0 < age <=  120
     * Expected result: Constant.DAY_OF_WEEK_EXCEPTION
     */
    @Test
    fun testCalculateBadmintonFee_Case_16() {
        //given
        viewModel.member.value?.age = 20
        viewModel.dayOfWeek = null

        //when
        val result = viewModel.calculateBadmintonFee()

        //then
        Assert.assertTrue(result == Constant.DAY_OF_WEEK_EXCEPTION)
    }

    /**
     * Test for calculateBadmintonFee() method
     * Test condition: dayOfWeek = null, age < 0
     * Expected result: Constant.DAY_OF_WEEK_EXCEPTION
     */
    @Test
    fun testCalculateBadmintonFee_Case_17() {
        //given
        viewModel.member.value?.age = -1
        viewModel.dayOfWeek = null

        //when
        val result = viewModel.calculateBadmintonFee()

        //then
        Assert.assertTrue(result == Constant.DAY_OF_WEEK_EXCEPTION)
    }

    /**
     * Test for calculateBadmintonFee() method
     * Test condition: dayOfWeek = null, age > 120
     * Expected result: Constant.DAY_OF_WEEK_EXCEPTION
     */
    @Test
    fun testCalculateBadmintonFee_Case_18() {
        //given
        viewModel.member.value?.age = 121
        viewModel.dayOfWeek = null

        //when
        val result = viewModel.calculateBadmintonFee()

        //then
        Assert.assertTrue(result == Constant.DAY_OF_WEEK_EXCEPTION)
    }

    /**
     * Test for calculateBadmintonFee() method
     * Test condition: age < 0 , dayOfWeek valid
     * Expected result: Constant.AGE_EXCEPTION
     */
    @Test
    fun testCalculateBadmintonFee_Case_19() {
        //given
        viewModel.member.value?.age = -1
        viewModel.dayOfWeek = Constant.DayOfWeek.MONDAY

        //when
        val result = viewModel.calculateBadmintonFee()

        //then
        Assert.assertTrue(result == Constant.AGE_EXCEPTION)
    }

    /**
     * Test for calculateBadmintonFee() method
     * Test condition: age >120 , dayOfWeek valid
     * Expected result: Constant.AGE_EXCEPTION
     */
    @Test
    fun testCalculateBadmintonFee_Case_20() {
        //given
        viewModel.member.value?.age = 121
        viewModel.dayOfWeek = Constant.DayOfWeek.MONDAY

        //when
        val result = viewModel.calculateBadmintonFee()

        //then
        Assert.assertTrue(result == Constant.AGE_EXCEPTION)
    }

    /**
     * Test for calculateBadmintonFee() method
     * Test condition: 0 < age <= 13 , dayOfWeek = normal day, gender = FEMALE
     * Expected result: viewModel.calculateBadmintonFee() = 900
     */
    @Test
    fun testCalculateBadmintonFee_Case_21() {
        //given
        viewModel.member.value = No8Member(age = 10, gender = Constant.Gender.FEMALE)
        viewModel.dayOfWeek = Constant.DayOfWeek.MONDAY

        //when
        val result = viewModel.calculateBadmintonFee()
        //then
        Assert.assertTrue(result == 900)
    }

    /**
     * Test for calculateBadmintonFee() method
     * Test condition: 0 < age <= 13 , dayOfWeek = normal day, gender = MALE
     * Expected result: viewModel.calculateBadmintonFee() = 900
     */
    @Test
    fun testCalculateBadmintonFee_Case_22() {
        //given
        viewModel.member.value = No8Member(age = 10, gender = Constant.Gender.MALE)
        viewModel.dayOfWeek = Constant.DayOfWeek.MONDAY

        //when
        val result = viewModel.calculateBadmintonFee()
        //then
        Assert.assertTrue(result == 900)
    }

    /**
     * Test for calculateBadmintonFee() method
     * Test condition: 13 < age < 66 , dayOfWeek = normal day, gender = MALE
     * Expected result: viewModel.calculateBadmintonFee() = 1800
     */
    @Test
    fun testCalculateBadmintonFee_Case_23() {
        //given
        viewModel.member.value = No8Member(age = 20, gender = Constant.Gender.MALE)
        viewModel.dayOfWeek = Constant.DayOfWeek.MONDAY

        //when
        val result = viewModel.calculateBadmintonFee()
        //then
        Assert.assertTrue(result == 1800)
    }

    /**
     * Test for calculateBadmintonFee() method
     * Test condition: 13 < age < 66 , dayOfWeek = normal day, gender = FEMALE
     * Expected result: viewModel.calculateBadmintonFee() = 1800
     */
    @Test
    fun testCalculateBadmintonFee_Case_24() {
        //given
        viewModel.member.value = No8Member(age = 20, gender = Constant.Gender.FEMALE)
        viewModel.dayOfWeek = Constant.DayOfWeek.MONDAY

        //when
        val result = viewModel.calculateBadmintonFee()
        //then
        Assert.assertTrue(result == 1800)
    }

    /**
     * Test for calculateBadmintonFee() method
     * Test condition: 65 < age <= 120 , dayOfWeek = normal day, gender = MALE
     * Expected result: viewModel.calculateBadmintonFee() = 1600
     */
    @Test
    fun testCalculateBadmintonFee_Case_25() {
        //given
        viewModel.member.value = No8Member(age = 70, gender = Constant.Gender.MALE)
        viewModel.dayOfWeek = Constant.DayOfWeek.MONDAY

        //when
        val result = viewModel.calculateBadmintonFee()
        //then
        Assert.assertTrue(result == 1600)
    }

    /**
     * Test for calculateBadmintonFee() method
     * Test condition: 65 < age <= 120 , dayOfWeek = normal day, gender = FEMALE
     * Expected result: viewModel.calculateBadmintonFee() = 1600
     */
    @Test
    fun testCalculateBadmintonFee_Case_26() {
        //given
        viewModel.member.value = No8Member(age = 70, gender = Constant.Gender.FEMALE)
        viewModel.dayOfWeek = Constant.DayOfWeek.MONDAY

        //when
        val result = viewModel.calculateBadmintonFee()
        //then
        Assert.assertTrue(result == 1600)
    }

    /**
     * Test for calculateBadmintonFee() method
     * Test condition: 0 < age <= 13 , dayOfWeek = TUESDAY, gender = FEMALE
     * Expected result: viewModel.calculateBadmintonFee() = 900
     */
    @Test
    fun testCalculateBadmintonFee_Case_27() {
        //given
        viewModel.member.value = No8Member(age = 10, gender = Constant.Gender.FEMALE)
        viewModel.dayOfWeek = Constant.DayOfWeek.TUESDAY

        //when
        val result = viewModel.calculateBadmintonFee()
        //then
        Assert.assertTrue(result == 900)
    }

    /**
     * Test for calculateBadmintonFee() method
     * Test condition: 0 < age <= 13 , dayOfWeek = TUESDAY, gender = MALE
     * Expected result: viewModel.calculateBadmintonFee() = 900
     */
    @Test
    fun testCalculateBadmintonFee_Case_28() {
        //given
        viewModel.member.value = No8Member(age = 10, gender = Constant.Gender.FEMALE)
        viewModel.dayOfWeek = Constant.DayOfWeek.TUESDAY

        //when
        val result = viewModel.calculateBadmintonFee()
        //then
        Assert.assertTrue(result == 900)
    }

    /**
     * Test for calculateBadmintonFee() method
     * Test condition: 13 < age <= 65 , dayOfWeek = TUESDAY, gender = MALE
     * Expected result: viewModel.calculateBadmintonFee() = 1200
     */
    @Test
    fun testCalculateBadmintonFee_Case_29() {
        //given
        viewModel.member.value = No8Member(age = 20, gender = Constant.Gender.MALE)
        viewModel.dayOfWeek = Constant.DayOfWeek.TUESDAY

        //when
        val result = viewModel.calculateBadmintonFee()
        //then
        Assert.assertTrue(result == 1200)
    }

    /**
     * Test for calculateBadmintonFee() method
     * Test condition: 13 < age <= 65 , dayOfWeek = TUESDAY, gender = MALE
     * Expected result: viewModel.calculateBadmintonFee() = 1200
     */
    @Test
    fun testCalculateBadmintonFee_Case_30() {
        //given
        viewModel.member.value = No8Member(age = 20, gender = Constant.Gender.MALE)
        viewModel.dayOfWeek = Constant.DayOfWeek.TUESDAY

        //when
        val result = viewModel.calculateBadmintonFee()
        //then
        Assert.assertTrue(result == 1200)
    }

    /**
     * Test for calculateBadmintonFee() method
     * Test condition: 65 < age <= 20 , dayOfWeek = TUESDAY, gender = MALE
     * Expected result: viewModel.calculateBadmintonFee() = 1200
     */
    @Test
    fun testCalculateBadmintonFee_Case_31() {
        //given
        viewModel.member.value = No8Member(age = 20, gender = Constant.Gender.MALE)
        viewModel.dayOfWeek = Constant.DayOfWeek.TUESDAY

        //when
        val result = viewModel.calculateBadmintonFee()
        //then
        Assert.assertTrue(result == 1200)
    }

    /**
     * Test for calculateBadmintonFee() method
     * Test condition: 65 < age <= 120 , dayOfWeek = TUESDAY, gender = FEMALE
     * Expected result: viewModel.calculateBadmintonFee() = 1200
     */
    @Test
    fun testCalculateBadmintonFee_Case_32() {
        //given
        viewModel.member.value = No8Member(age = 20, gender = Constant.Gender.FEMALE)
        viewModel.dayOfWeek = Constant.DayOfWeek.TUESDAY

        //when
        val result = viewModel.calculateBadmintonFee()
        //then
        Assert.assertTrue(result == 1200)
    }

    /**
     * Test for calculateBadmintonFee() method
     * Test condition: 0 < age <= 13 , dayOfWeek = FRIDAY, gender = FEMALE
     * Expected result: viewModel.calculateBadmintonFee() = 900
     */
    @Test
    fun testCalculateBadmintonFee_Case_33() {
        //given
        viewModel.member.value = No8Member(age = 10, gender = Constant.Gender.FEMALE)
        viewModel.dayOfWeek = Constant.DayOfWeek.FRIDAY

        //when
        val result = viewModel.calculateBadmintonFee()
        //then
        Assert.assertTrue(result == 900)
    }

    /**
     * Test for calculateBadmintonFee() method
     * Test condition: 0 < age <= 13 , dayOfWeek = FRIDAY, gender = MALE
     * Expected result: viewModel.calculateBadmintonFee() = 900
     */
    @Test
    fun testCalculateBadmintonFee_Case_34() {
        //given
        viewModel.member.value = No8Member(age = 10, gender = Constant.Gender.MALE)
        viewModel.dayOfWeek = Constant.DayOfWeek.FRIDAY

        //when
        val result = viewModel.calculateBadmintonFee()
        //then
        Assert.assertTrue(result == 900)
    }

    /**
     * Test for calculateBadmintonFee() method
     * Test condition: 13 < age <= 65 , dayOfWeek = FRIDAY, gender = MALE
     * Expected result: viewModel.calculateBadmintonFee() = 1800
     */
    @Test
    fun testCalculateBadmintonFee_Case_35() {
        //given
        viewModel.member.value = No8Member(age = 20, gender = Constant.Gender.MALE)
        viewModel.dayOfWeek = Constant.DayOfWeek.FRIDAY

        //when
        val result = viewModel.calculateBadmintonFee()
        //then
        Assert.assertTrue(result == 1800)
    }

    /**
     * Test for calculateBadmintonFee() method
     * Test condition: 13 < age <= 65 , dayOfWeek = FRIDAY, gender = FEMALE
     * Expected result: viewModel.calculateBadmintonFee() = 1400
     */
    @Test
    fun testCalculateBadmintonFee_Case_36() {
        //given
        viewModel.member.value = No8Member(age = 20, gender = Constant.Gender.FEMALE)
        viewModel.dayOfWeek = Constant.DayOfWeek.FRIDAY

        //when
        val result = viewModel.calculateBadmintonFee()
        //then
        Assert.assertTrue(result == 1400)
    }

    /**
     * Test for calculateBadmintonFee() method
     * Test condition: 65 < age <= 120 , dayOfWeek = FRIDAY, gender = MALE
     * Expected result: viewModel.calculateBadmintonFee() = 1600
     */
    @Test
    fun testCalculateBadmintonFee_Case_37() {
        //given
        viewModel.member.value = No8Member(age = 70, gender = Constant.Gender.MALE)
        viewModel.dayOfWeek = Constant.DayOfWeek.FRIDAY

        //when
        val result = viewModel.calculateBadmintonFee()
        //then
        Assert.assertTrue(result == 1600)
    }

    /**
     * Test for calculateBadmintonFee() method
     * Test condition: 65 < age <= 120 , dayOfWeek = FRIDAY, gender = FEMALE
     * Expected result: viewModel.calculateBadmintonFee() = 1400
     */
    @Test
    fun testCalculateBadmintonFee_Case_38() {
        //given
        viewModel.member.value = No8Member(age = 70, gender = Constant.Gender.FEMALE)
        viewModel.dayOfWeek = Constant.DayOfWeek.FRIDAY

        //when
        val result = viewModel.calculateBadmintonFee()
        //then
        Assert.assertTrue(result == 1400)
    }

}