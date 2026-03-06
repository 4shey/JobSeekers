package com.android.gawexx

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.android.gawexx.feature.explore.ExploreViewModel
import com.android.gawexx.feature.jobdetail.JobDetailViewModel
import com.android.gawexx.feature.login.LoginViewModel
import com.android.gawexx.feature.myjob.MyJobViewModel
import com.android.gawexx.feature.profile.ProfileViewModel
import com.android.gawexx.feature.register.RegisterViewModel
import com.android.gawexx.feature.splash.SplashScreen
import com.android.gawexx.helper.AppScreen
import com.android.gawexx.helper.AppState
import com.android.gawexx.helper.Screen
import com.android.gawexx.ui.theme.GaweXXTheme
import kotlinx.coroutines.delay

class MainActivity : ComponentActivity() {
    var showSplash by mutableStateOf(true)
    private val exploreViewModel = ExploreViewModel()
    private val jobDetailViewModel = JobDetailViewModel()
    private val loginViewModel = LoginViewModel()
    private val myJobViewModel = MyJobViewModel()
    private val profileViewModel = ProfileViewModel()
    private val registerViewModel = RegisterViewModel()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        if (AppState.isLogin(this)) {
            AppState.currentScreen.value = Screen.EXPLORE
        } else {
            AppState.currentScreen.value = Screen.LOGIN
        }
        enableEdgeToEdge()
        setContent {
            GaweXXTheme {
                when(showSplash){
                    true -> {
                        SplashScreen()

                        LaunchedEffect(Unit) {
                            delay(2000)
                            showSplash = false
                        }

                    }
                    false -> {
                        AppScreen(
                            exploreViewModel,
                            jobDetailViewModel,
                            loginViewModel,
                            myJobViewModel,
                            profileViewModel,
                            registerViewModel
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    GaweXXTheme {
        Greeting("Android")
    }
}