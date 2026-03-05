package com.android.gawexx.feature.myjob

import androidx.compose.foundation.layout.Arrangement
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
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.android.gawexx.componen.BottomBar
import com.android.gawexx.componen.JobApplyCard
import com.android.gawexx.model.JobApplyModel

@Composable
fun MyJobScreen(viewModel: MyJobViewModel){
    LaunchedEffect(Unit) {
        viewModel.getJobApply()
    }
    val jobApply = viewModel.jobApply
    val tabs = listOf("Saved Jobs", "Applications List")
    var selectedTabIndex by remember { mutableStateOf(0) }
    //
    Scaffold(
        topBar = {
            Column (
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(20.dp,40.dp,20.dp,0.dp)
            ) {
                Text(
                    "My Job",
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Black,
                    color = Color.Black
                )
                Spacer(modifier = Modifier.height(20.dp))
                TabRow(selectedTabIndex = selectedTabIndex) {
                    tabs.forEachIndexed { index, title ->
                        Tab(
                            selected = selectedTabIndex == index,
                            onClick = { selectedTabIndex = index },
                            text = { Text(title) }
                        )
                    }
                }
            }
        },
        bottomBar = {
            BottomBar()
        }
    ) { innerPadding ->
        when (selectedTabIndex){
            0 -> {

            }
            1 -> {
                Column(
                    modifier = Modifier
                        .padding(innerPadding)
                        .fillMaxSize()
                        .padding(horizontal = 20.dp),
                ) {
                    if (jobApply == emptyList<JobApplyModel>()) {
                        Text("Data not found")
                    } else {
                        LazyColumn() {
                            item{
                                Spacer(modifier = Modifier.height(20.dp))
                            }
                            items(jobApply) { jobApplys ->
                                JobApplyCard(
                                    jobApply = jobApplys,
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
    }
}