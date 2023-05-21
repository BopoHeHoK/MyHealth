package com.test.myhealth.app.di

import com.test.myhealth.app.presentation.screen.root.RootFragment
import com.test.myhealth.app.presentation.screen.signin.SingInFragment
import com.test.myhealth.app.presentation.screen.signup.SingUpFragment
import com.test.myhealth.app.presentation.screen.splash.SplashFragment
import com.test.myhealth.app.presentation.screen.tab.article.ArticleFragment
import com.test.myhealth.app.presentation.screen.tab.article.article_page.ArticlePageFragment
import com.test.myhealth.app.presentation.screen.tab.article.statistics.StatisticsFragment
import com.test.myhealth.app.presentation.screen.tab.calc.CalcFragment
import com.test.myhealth.app.presentation.screen.tab.calc.body_mass_index.BmiFragment
import com.test.myhealth.app.presentation.screen.tab.calc.body_muscle_mass.BmmFragment
import com.test.myhealth.app.presentation.screen.tab.calc.ideal_body_weight.IbwFragment
import com.test.myhealth.app.presentation.screen.tab.calc.total_body_blood.TbbFragment
import com.test.myhealth.app.presentation.screen.tab.calc.total_body_water.TbwFragment
import com.test.myhealth.app.presentation.screen.tab.calc.waist_to_height_ratio.WthFragment
import com.test.myhealth.app.presentation.screen.tab.main.MainFragment
import com.test.myhealth.app.presentation.screen.tab.main.edit_dream.EditDreamFragment
import com.test.myhealth.app.presentation.screen.tab.main.edit_mental.EditMentalFragment
import com.test.myhealth.app.presentation.screen.tab.main.edit_physical.EditPhysicalFragment
import com.test.myhealth.app.presentation.screen.tab.profile.ProfileFragment
import com.test.myhealth.app.presentation.screen.tab.profile.menu.biometrics.BiometricsFragment
import com.test.myhealth.app.presentation.screen.tab.profile.menu.get_premium.GetPremiumFragment
import com.test.myhealth.app.presentation.screen.tab.profile.menu.user_setup.UserSetupFragment
import com.test.myhealth.app.presentation.screen.tab.schedule.ScheduleFragment
import com.test.myhealth.app.presentation.screen.tab.schedule.edit_medicine.EditMedicineFragment
import dagger.Component

@Component(modules = [AppModule::class, DomainModule::class, DataModule::class])
interface AppComponent {

    fun injectRootFragment(rootFragment: RootFragment)

    fun injectSingInFragment(signInFragment: SingInFragment)

    fun injectSingUpFragment(signUpFragment: SingUpFragment)

    fun injectSplashFragment(splashFragment: SplashFragment)

    fun injectArticlePageFragment(articlePageFragment: ArticlePageFragment)

    fun injectStatisticsFragment(statisticsFragment: StatisticsFragment)

    fun injectArticleFragment(articleFragment: ArticleFragment)

    fun injectBmiFragment(bmiFragment: BmiFragment)

    fun injectBmmFragment(bmmFragment: BmmFragment)

    fun injectIbwFragment(ibwFragment: IbwFragment)

    fun injectTbbFragment(tbbFragment: TbbFragment)

    fun injectTbwFragment(tbwFragment: TbwFragment)

    fun injectWthFragment(wthFragment: WthFragment)

    fun injectCalcFragment(calcFragment: CalcFragment)

    fun injectEditDreamFragment(editDreamFragment: EditDreamFragment)

    fun injectEditMentalFragment(editMentalFragment: EditMentalFragment)

    fun injectEditPhysicalFragment(editPhysicalFragment: EditPhysicalFragment)

    fun injectMainFragment(mainFragment: MainFragment)

    fun injectBiometricsFragment(biometricsFragment: BiometricsFragment)

    fun injectGetPremiumFragment(getPremiumFragment: GetPremiumFragment)

    fun injectUserSetupFragment(userSetupFragment: UserSetupFragment)

    fun injectProfileFragment(profileFragment: ProfileFragment)

    fun injectEditMedicineFragment(editMedicineFragment: EditMedicineFragment)

    fun injectScheduleFragment(scheduleFragment: ScheduleFragment)
}