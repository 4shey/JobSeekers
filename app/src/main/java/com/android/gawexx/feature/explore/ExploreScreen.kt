package com.android.gawexx.feature.explore

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.android.gawexx.componen.BottomBar
import com.android.gawexx.componen.JobCard
import com.android.gawexx.model.JobModel

@Composable
fun ExploreScreen(viewModel: ExploreViewModel){
    LaunchedEffect(Unit) {
        viewModel.getJob()
    }
    val job = viewModel.job
    //
    Scaffold(
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
                            onClick = { println("click") }
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