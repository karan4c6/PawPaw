package com.example.androiddevchallenge.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.ui.theme.AlphaNearOpaque
import com.example.androiddevchallenge.ui.theme.PupTheme
import dev.chrisbanes.accompanist.insets.statusBarsPadding

@Composable
fun PupTopBar(modifier: Modifier = Modifier) {
    Column(modifier = modifier.statusBarsPadding()) {
        TopAppBar(
            backgroundColor = MaterialTheme.colors.background.copy(alpha = AlphaNearOpaque),
            contentColor = MaterialTheme.colors.secondary,
            elevation = 0.dp
        ) {
            Text(
                text = "Paw Paw",
                style = MaterialTheme.typography.h5,
                color = MaterialTheme.colors.onSecondary,
                textAlign = TextAlign.Start,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
                modifier = Modifier
                    .weight(1f)
                    .padding(start = 16.dp)
                    .align(Alignment.CenterVertically)
            )
        }
        Divider(
            modifier = modifier,
            color = Color.Black.copy(alpha = 0.2f),
            thickness = 1.dp,
            startIndent = 0.dp
        )
    }
}

@Preview(showBackground = true)
@Composable
fun LightPupTopBar() {
    PupTheme {
        PupTopBar()
    }
}
