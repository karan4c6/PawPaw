package com.example.androiddevchallenge.ui.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.androiddevchallenge.model.Pup
import com.example.androiddevchallenge.model.pupsList
import com.example.androiddevchallenge.ui.theme.PupTheme
import dev.chrisbanes.accompanist.coil.CoilImage

@Composable
fun PupDescription(pupId: Long) {

    val pup: Pup = pupsList.first { it.id == pupId }
    Surface(modifier = Modifier.fillMaxWidth(), color = MaterialTheme.colors.surface) {
        Column {
            Spacer(modifier = Modifier.height(2.dp))
            Surface(
                elevation = 8.dp,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(300.dp),
                shape = RectangleShape,
                color = MaterialTheme.colors.surface
            ) {
                CoilImage(
                    data = pup.imageUrl,
                    contentDescription = pup.description,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier.fillMaxSize()
                )
            }
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = pup.title,
                style = MaterialTheme.typography.h4,
                modifier = Modifier.padding(start = 16.dp)
            )
            Text(
                text = pup.description,
                style = MaterialTheme.typography.body1.copy(fontSize = 18.sp),
                modifier = Modifier.padding(start = 16.dp)
            )
            Spacer(modifier = Modifier.height(16.dp))
            PupDetailRow("Gender", pup.pupDetail.gender)
            PupDetailRow("Breed ", pup.pupDetail.breed)
            PupDetailRow("Color", pup.pupDetail.color)
            PupDetailRow("Age", pup.pupDetail.age)
            PupDetailRow("Desexed", if (pup.pupDetail.desexed) "Yes" else "No")
            PupDetailRow("Location", pup.pupDetail.location)
            PupDetailRow("Adoption Fee", pup.pupDetail.adoptionFee)
            PupDetailRow("Micro Chipped", if (pup.pupDetail.microChipped) "Yes" else "No")
            PupDetailRow("Wormed", if (pup.pupDetail.wormed) "Yes" else "No")
            PupDetailRow("Vet Checked", if (pup.pupDetail.vetChecked) "Yes" else "No")
            Spacer(modifier = Modifier.height(16.dp))

        }
    }
}

@Composable
private fun PupDetailRow(title: String, desc: String) {
    Row(modifier = Modifier.padding(start = 16.dp, top = 4.dp)) {
        Text(
            text = title,
            style = MaterialTheme.typography.subtitle1.copy(fontSize = 18.sp),
            modifier = Modifier
                .weight(0.4f)
        )
        Text(
            text = desc,
            style = MaterialTheme.typography.body1.copy(fontSize = 18.sp),
            modifier = Modifier
                .weight(0.6f)
                .wrapContentWidth(Alignment.Start)
        )
    }
}

@Preview("Light Theme", showBackground = true)
@Composable
fun LightThemePupDescription() {
    PupTheme {
        PupDescription(pupsList[0].id)
    }
}

@Preview("Dark Theme", widthDp = 360, heightDp = 640)
@Composable
fun DarkThemePupDescription() {
    PupTheme(darkTheme = true) {
        PupDescription(pupsList[0].id)
    }
}
