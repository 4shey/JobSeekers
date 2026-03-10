package com.android.gawexx.feature.explore

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.android.gawexx.componen.BottomBar
import com.android.gawexx.componen.JobCard
import com.android.gawexx.helper.AppState
import com.android.gawexx.model.JobModel
import com.android.gawexx.ui.theme.PurpleGrey80

@Composable
fun ExploreScreen(viewModel: ExploreViewModel){
    LaunchedEffect(Unit) {
        viewModel.getJob()
    }

    val job = viewModel.job
    val snackbarHostState = remember { SnackbarHostState() }

    LaunchedEffect(viewModel.applyStatus) {
        if (viewModel.applyStatus != "") {
            snackbarHostState.showSnackbar(viewModel.applyStatus)
            viewModel.applyStatus = ""
        }
    }
    //
    Scaffold(
        snackbarHost = { SnackbarHost(snackbarHostState) },
        topBar = {
            Column (
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(20.dp,40.dp,20.dp,20.dp)
            ) {
                Text(
                    "Explore",
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Black,
                    color = Color.Black
                )
                Text(
                    "Search your dream jobs here",
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Medium,
                    color = Color.Gray
                )
                Spacer(modifier = Modifier.height(10.dp))
                OutlinedTextField(
                    value = viewModel.search,
                    onValueChange = {
                        viewModel.updateSearch(it)
                    },
                    placeholder = {Text("search here...")},
                    modifier = Modifier.fillMaxWidth()
                )
                Spacer(modifier = Modifier.height(10.dp))
                val tabs = listOf("All", "Onsite", "Remote")
                var selectedIndex by remember { mutableStateOf(0) }

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {

                    tabs.forEachIndexed { index, title ->

                        Button(
                            onClick = {
                                selectedIndex = index

                                viewModel.location = when (index) {
                                    0 -> ""
                                    1 -> "Onsite"
                                    2 -> "Remote"
                                    else -> ""
                                }
                                viewModel.search()
                            },
                            colors = ButtonDefaults.buttonColors(
                                containerColor =
                                    if (selectedIndex == index)
                                        MaterialTheme.colorScheme.primary
                                    else
                                        MaterialTheme.colorScheme.surfaceVariant
                            ),
                            modifier = Modifier.weight(1f)
                        ) {
                            Text(title)
                        }

                    }
                }
            }
        },
        bottomBar = {
            NavigationBar(
                containerColor = Color.White
            ) {
                BottomBar()
            }
        }
    ) { innerPadding ->
        when (viewModel.loading){
            true -> {
                Column(
                    modifier = Modifier.fillMaxSize(),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    CircularProgressIndicator(color = Color.Black)
                }
            }
            false -> {
                Column(
                    modifier = Modifier
                        .padding(innerPadding)
                        .fillMaxSize()
                        .padding(horizontal = 20.dp),
                ) {
                    if (job == emptyList<JobModel>()) {
                        Text("Data not found")
                    } else {
                        LazyColumn() {
                            items(job) { jobs ->
                                JobCard (
                                    job = jobs,
                                    applyOnClick = { id ->
                                        viewModel.applyJob(id)
                                    },
                                    bookMarkOnClick = { id ->
                                        val job = viewModel.job.find { it?.id == id }
                                        job?.let {
                                            AppState.favoriteJobs.value.add(it)
                                        }
                                    },
                                )
                            }
                            item{
                                Spacer(modifier = Modifier.height(20.dp))
                            }
                        }
                    }
                }
            }
        }
    }
}