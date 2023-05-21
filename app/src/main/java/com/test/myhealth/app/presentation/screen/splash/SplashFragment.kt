package com.test.myhealth.app.presentation.screen.splash

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.navigation.Navigation
import com.test.myhealth.R
import com.test.myhealth.app.app.App
import com.test.myhealth.databinding.FragmentSplashBinding
import com.test.myhealth.domain.model.Gender
import com.test.myhealth.domain.model.Role
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject

class SplashFragment : Fragment() {

    @Inject
    lateinit var splashViewModelFactory: SplashViewModelFactory

    private lateinit var binding: FragmentSplashBinding
    lateinit var splashViewModel: SplashViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        (activity?.applicationContext as App).appComponent.injectSplashFragment(
            splashFragment = this
        )
        splashViewModel = ViewModelProvider(
            owner = this,
            factory = splashViewModelFactory
        )[SplashViewModel::class.java]
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSplashBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        addAnim()
        lifecycleScope.launch {
            splashViewModel.apply {
                getUser(getUserId())
                getArticles()
                if (getUserId() == 0L) {
                    delay(1000)
                    Navigation.findNavController(view)
                        .navigate(R.id.action_splashFragment_to_singInFragment)
                } else {
                    setData()
                    delay(3000)
                    Navigation.findNavController(view)
                        .navigate(R.id.action_splashFragment_to_rootFragment)
                }
            }
        }
    }

    private fun addAnim() {
        val rotate = AnimationUtils.loadAnimation(context, R.anim.loading_rotate)
        binding.imgLoading.animation = rotate
    }

    private fun setData() {
        splashViewModel.apply {
            val roles = listOf(Role(1, "USER"), Role(2, "PREMIUM"), Role(3, "ADMIN"))
            for (role in roles)
                upsertRole(role)
            val genders = listOf(Gender(0, "Male"), Gender(1, "Female"))
            for (gender in genders)
                upsertGender(gender)
            observeUser()
            observeUserParameter()
            observeRating()
            observeUserFavoriteArticle()
            observeDream()
            observeDreamInfo()
            observePhysicalCondition()
            observePhysicalInfo()
            observeMentalCondition()
            observeMentalInfo()
            observeWater()
            observeFood()
            observeMedicine()
            observeMedicineInfo()
            observeMedicineInfoTime()
            observeWeight()
            observePressure()
            observeArticles()
        }
    }

    private fun observeUser() {
        splashViewModel.apply {
            observerUser().observe(viewLifecycleOwner) { user ->
                upsertUser(user = user)
            }
        }
    }

    private fun observeUserParameter() {
        splashViewModel.apply {
            observerUserParameter().observe(viewLifecycleOwner) { userParameter ->
                upsertUserParameter(userParameter = userParameter)
            }
        }
    }

    private fun observeRating() {
        splashViewModel.apply {
            observerRating().observe(viewLifecycleOwner) { ratingList ->
                ratingList.forEach { rating ->
                    upsertRating(rating = rating)
                }
            }
        }
    }

    private fun observeUserFavoriteArticle() {
        splashViewModel.apply {
            observerUserFavoriteArticle().observe(viewLifecycleOwner) { userFavoriteArticle ->
                upsertUserFavoriteArticle(userFavoriteArticle = userFavoriteArticle)
            }
        }
    }

    private fun observeDream() {
        splashViewModel.apply {
            observerDream().observe(viewLifecycleOwner) { dreamList ->
                dreamList.forEach { dream ->
                    upsertDream(dream = dream)
                }
            }
        }
    }

    private fun observeDreamInfo() {
        splashViewModel.apply {
            observerDreamInfo().observe(viewLifecycleOwner) { dreamInfoList ->
                dreamInfoList.forEach { dreamInfo ->
                    upsertDreamInfo(dreamInfo = dreamInfo)
                }
            }
        }
    }

    private fun observePhysicalCondition() {
        splashViewModel.apply {
            observerPhysicalCondition().observe(viewLifecycleOwner) { physicalConditionList ->
                physicalConditionList.forEach { physicalCondition ->
                    upsertPhysicalCondition(physicalCondition = physicalCondition)
                }
            }
        }
    }

    private fun observePhysicalInfo() {
        splashViewModel.apply {
            observerPhysicalInfo().observe(viewLifecycleOwner) { physicalInfoList ->
                physicalInfoList.forEach { physicalInfo ->
                    upsertPhysicalInfo(physicalInfo = physicalInfo)
                }
            }
        }
    }

    private fun observeMentalCondition() {
        splashViewModel.apply {
            observerMentalCondition().observe(viewLifecycleOwner) { mentalConditionList ->
                mentalConditionList.forEach { mentalCondition ->
                    upsertMentalCondition(mentalCondition = mentalCondition)
                }
            }
        }
    }

    private fun observeMentalInfo() {
        splashViewModel.apply {
            observerMentalInfo().observe(viewLifecycleOwner) { mentalInfoList ->
                mentalInfoList.forEach { mentalInfo ->
                    upsertMentalInfo(mentalInfo = mentalInfo)
                }
            }
        }
    }

    private fun observeWater() {
        splashViewModel.apply {
            observerWater().observe(viewLifecycleOwner) { water ->
                upsertWater(water = water)
            }
        }
    }

    private fun observeFood() {
        splashViewModel.apply {
            observerFood().observe(viewLifecycleOwner) { food ->
                upsertFood(food = food)
            }
        }
    }

    private fun observeMedicine() {
        splashViewModel.apply {
            observerMedicine().observe(viewLifecycleOwner) { medicine ->
                upsertMedicine(medicine = medicine)
            }
        }
    }

    private fun observeMedicineInfo() {
        splashViewModel.apply {
            observerMedicineInfo().observe(viewLifecycleOwner) { medicineInfoList ->
                medicineInfoList.forEach { medicineInfo ->
                    upsertMedicineInfo(medicineInfo = medicineInfo)
                }
            }
        }
    }

    private fun observeMedicineInfoTime() {
        splashViewModel.apply {
            observerMedicineInfoTime().observe(viewLifecycleOwner) { medicineInfoTimeList ->
                medicineInfoTimeList.forEach { medicineInfoTime ->
                    upsertMedicineInfoTime(medicineInfoTime = medicineInfoTime)
                }
            }
        }
    }

    private fun observeWeight() {
        splashViewModel.apply {
            observerWeight().observe(viewLifecycleOwner) { weight ->
                upsertWeight(weight = weight)
            }
        }
    }

    private fun observePressure() {
        splashViewModel.apply {
            observerPressure().observe(viewLifecycleOwner) { pressure ->
                upsertPressure(pressure = pressure)
            }
        }
    }

    private fun observeArticles() {
        splashViewModel.apply {
            observerArticles().observe(viewLifecycleOwner) { articleList ->
                articleList.forEach { article ->
                    upsertArticles(article)
                }
            }
        }
    }
}