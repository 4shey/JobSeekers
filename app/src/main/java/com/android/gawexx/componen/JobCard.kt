package com.android.gawexx.componen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.android.gawexx.model.JobApplyModel
import com.android.gawexx.model.JobModel
import com.android.gawexx.ui.theme.GaweXXTheme


@Composable
fun JobCard(
    job: JobModel?,
    onClick: (Int) -> Unit
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 5.dp),
        onClick = {

        },
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color.White
        ),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 10.dp
        ),
    ) {
        Column(
            modifier = Modifier.padding(20.dp)
        ) {
            Text(
                "${job?.name}",
                fontSize = 16.sp,
                color = Color.Black,
                fontWeight = FontWeight.Black
            )
            Text(
                "${job?.company?.name}",
                fontSize = 16.sp,
                color = Color.Gray,
                fontWeight = FontWeight.Medium
            )
            Spacer(modifier = Modifier.height(12.dp))
            Text(
                "${job?.locationType} (${job?.locationRegion})",
                fontSize = 16.sp,
                color = Color.Gray,
                fontWeight = FontWeight.Medium
            )
            Text(
                "Min. ${job?.yearOfExperience} years of experience",
                fontSize = 16.sp,
                color = Color.Gray,
                fontWeight = FontWeight.Medium
            )
            Spacer(modifier = Modifier.height(18.dp))
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Button(
                    modifier = Modifier.weight(7f),
                    onClick = {

                    }
                ) {
                    Text("Apply")
                }
                Spacer(modifier = Modifier.width(16.dp))
                Button(
                    shape = CircleShape,
                    contentPadding = PaddingValues(6.dp),
                    modifier = Modifier.weight(1f),
                    onClick = {

                    }
                ) {
                    Icon(
                        imageVector = Icons.Default.AddCircle,
                        contentDescription = "Added Save"
                    )
                }
            }
        }

    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    GaweXXTheme {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 5.dp),
            onClick = {

            },
            shape = RoundedCornerShape(16.dp),
            colors = CardDefaults.cardColors(
                containerColor = Color.White
            ),
            elevation = CardDefaults.cardElevation(
                defaultElevation = 10.dp
            ),
        ) {
            Column(
                modifier = Modifier.padding(20.dp)
            ) {
                Text(
                    "lorem",
                    fontSize = 16.sp,
                    color = Color.Black,
                    fontWeight = FontWeight.Black
                )
                Text(
                    "lorem",
                    fontSize = 16.sp,
                    color = Color.Black
                )
                Spacer(modifier = Modifier.height(12.dp))
                Text(
                    "lorem",
                    fontSize = 16.sp,
                    color = Color.Black,
                    fontWeight = FontWeight.Black
                )
                Text(
                    "lorem",
                    fontSize = 16.sp,
                    color = Color.Black
                )
                Spacer(modifier = Modifier.height(18.dp))
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Button(
                        modifier = Modifier.weight(7f),
                        onClick = {

                        }
                    ) {
                        Text("Waiting for confirmation")
                    }
                    Spacer(modifier = Modifier.width(16.dp))
                    Button(
                        shape = CircleShape,
                        contentPadding = PaddingValues(6.dp),
                        modifier = Modifier.weight(1f),
                        onClick = {

                        }
                    ) {
                        Icon(
                            imageVector = Icons.Default.AddCircle,
                            contentDescription = "Added Save"
                        )
                    }
                }
            }
        }
    }
}