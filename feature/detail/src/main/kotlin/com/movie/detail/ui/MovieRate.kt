package com.movie.detail.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.movie.fridaymovie.core.designsystem.R

@Composable
internal fun MovieRate(uiState: MovieDetailUiState) {
    Row(
        modifier = Modifier
            .padding(horizontal = 16.dp, vertical = 8.dp)
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            imageVector = Icons.Default.Star,
            tint = colorResource(id = R.color.yellow700),
            contentDescription = null
        )

        Spacer(modifier = Modifier.width(8.dp))

        Column(verticalArrangement = Arrangement.spacedBy(0.dp)) {
            Row(verticalAlignment = Alignment.Bottom) {
                Text(
                    text = uiState.movie.voteAverage.toString(),
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,
                    color = colorResource(id = R.color.gray50)
                )
                Text(
                    text = "/10",
                    fontSize = 12.sp,
                    color = colorResource(id = R.color.gray500)
                )
            }

            Text(
                text = "(" + uiState.movie.voteCount.toString() + ")",
                fontSize = 12.sp,
                color = colorResource(id = R.color.gray50)
            )
        }

        Spacer(modifier = Modifier.weight(1f))

        if (uiState.movie.status == "Released") {
            Text(
                modifier = Modifier
                    .clip(RoundedCornerShape(6.dp))
                    .background(
                        color = colorResource(id = R.color.green40),
                        shape = RoundedCornerShape(6.dp)
                    )
                    .padding(horizontal = 8.dp, vertical = 4.dp),
                text = uiState.movie.status,
                fontSize = 14.sp,
                color = colorResource(id = R.color.gray50)
            )
        } else {
            Text(
                modifier = Modifier
                    .clip(RoundedCornerShape(6.dp))
                    .background(
                        color = colorResource(id = R.color.orange20),
                        shape = RoundedCornerShape(6.dp)
                    )
                    .padding(horizontal = 8.dp, vertical = 4.dp),
                text = uiState.movie.status,
                fontSize = 14.sp,
                color = colorResource(id = R.color.gray50)
            )
        }
    }
}
