package com.android.gawexx.helper

import androidx.compose.runtime.Composable
import com.android.gawexx.feature.explore.ExploreScreen
import com.android.gawexx.feature.explore.ExploreViewModel
import com.android.gawexx.feature.jobdetail.JobDetailScreen
import com.android.gawexx.feature.jobdetail.JobDetailViewModel
import com.android.gawexx.feature.login.LoginScreen
import com.android.gawexx.feature.login.LoginViewModel
import com.android.gawexx.feature.myjob.MyJobScreen
import com.android.gawexx.feature.myjob.MyJobViewModel
import com.android.gawexx.feature.profile.ProfileScreen
import com.android.gawexx.feature.profile.ProfileViewModel
import com.android.gawexx.feature.register.RegisterScreen
import com.android.gawexx.feature.register.RegisterViewModel

@Composable
fun AppScreen(
    exploreViewModel: ExploreViewModel,
    jobDetailViewModel: JobDetailViewModel,
    loginViewModel: LoginViewModel,
    myJobViewModel: MyJobViewModel,
    profileViewModel: ProfileViewModel,
    registerViewModel: RegisterViewModel
){
    when (AppState.currentScreen.value){
        Screen.EXPLORE -> ExploreScreen(viewModel = exploreViewModel)
        Screen.JOBDETAIL -> JobDetailScreen(viewModel = jobDetailViewModel)
        Screen.LOGIN -> LoginScreen(viewModel = loginViewModel)
        Screen.MYJOB -> MyJobScreen(viewModel = myJobViewModel)
        Screen.PROFILE -> ProfileScreen(viewModel = profileViewModel)
        Screen.REGISTER -> RegisterScreen(viewModel = registerViewModel)
    }
}