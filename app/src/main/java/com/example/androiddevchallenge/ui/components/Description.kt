package com.example.androiddevchallenge.ui.components

import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Button
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.Layout
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.clearAndSetSemantics
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.heading
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.semantics.text
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Constraints
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.lerp
import androidx.compose.ui.unit.sp
import com.example.androiddevchallenge.R
import com.example.androiddevchallenge.model.Pup
import com.example.androiddevchallenge.model.pupsList
import com.example.androiddevchallenge.ui.theme.PupTheme
import dev.chrisbanes.accompanist.coil.CoilImage
import dev.chrisbanes.accompanist.insets.statusBarsPadding
import kotlin.math.max
import kotlin.math.min
import kotlin.math.roundToInt

private val TitleHeight = 128.dp
private val GradientScroll = 180.dp
private val ImageOverlap = 115.dp
private val MinTitleOffset = 56.dp
private val MinImageOffset = 12.dp
private val MaxTitleOffset = ImageOverlap + MinTitleOffset + GradientScroll
private val ExpandedImageSize = 300.dp
private val CollapsedImageSize = 150.dp
private val HzPadding = Modifier.padding(horizontal = 24.dp)

@Composable
fun PupDescription(pupId: Long, upPress: () -> Unit) {
    val pup: Pup = remember { pupsList.first { it.id == pupId } }

    Box(Modifier.fillMaxSize()) {
        val scroll = rememberScrollState(0)
        Header()
        PupDetailBody(pup, scroll)
        PupDetailTitle(pup, scroll.value)
        PupDetailImage(pup.imageUrl, scroll.value, title = pup.title)
        Up(upPress)
    }
}

@Composable
private fun Header() {
    Spacer(
        modifier = Modifier
            .height(280.dp)
            .fillMaxWidth()
            .background(color = MaterialTheme.colors.primary)
    )
}

@Composable
fun Up(upPress: () -> Unit) {
    IconButton(
        onClick = upPress,
        modifier = Modifier
            .statusBarsPadding()
            .padding(horizontal = 16.dp, vertical = 10.dp)
            .size(36.dp)
            .background(
                color = MaterialTheme.colors.primary.copy(alpha = 0.8f),
                shape = CircleShape
            )
            .semantics { contentDescription = "Back" }
    ) {
        Icon(
            imageVector = Icons.Outlined.ArrowBack,
            tint = MaterialTheme.colors.onPrimary,
            contentDescription = null,
            modifier = Modifier.clearAndSetSemantics { }
        )
    }
}

@Composable
fun PupDetailImage(imageUrl: String, scroll: Int, title: String) {

    val collapseRange = with(LocalDensity.current) { (MaxTitleOffset - MinTitleOffset).toPx() }
    val collapseFraction = (scroll / collapseRange).coerceIn(0f, 1f)

    CollapsingImageLayout(
        collapseFraction = collapseFraction,
        modifier = HzPadding.then(Modifier.statusBarsPadding())
    ) {
        PupSurface(
            color = Color.LightGray,
            elevation = 4.dp,
            shape = CircleShape,
            modifier = Modifier.semantics { contentDescription = "Image of puppy $title" }
        ) {
            CoilImage(
                data = imageUrl,
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier.fillMaxSize()
            )
        }
    }
}

@Composable
private fun CollapsingImageLayout(
    collapseFraction: Float,
    modifier: Modifier = Modifier,
    content: @Composable () -> Unit
) {
    Layout(
        modifier = modifier,
        content = content
    ) { measurables, constraints ->
        check(measurables.size == 1)

        val imageMaxSize = min(ExpandedImageSize.roundToPx(), constraints.maxWidth)
        val imageMinSize = max(CollapsedImageSize.roundToPx(), constraints.minWidth)
        val imageWidth = lerp2(imageMaxSize, imageMinSize, collapseFraction)
        val imagePlaceable = measurables[0].measure(Constraints.fixed(imageWidth, imageWidth))

        val imageY = lerp(MinTitleOffset, MinImageOffset, collapseFraction).roundToPx()
        val imageX = lerp1(
            (constraints.maxWidth - imageWidth).toFloat() / 2, // centered when expanded
            constraints.maxWidth - imageWidth.toFloat(), // right aligned when collapsed
            collapseFraction
        )
        layout(
            width = constraints.maxWidth,
            height = imageY + imageWidth
        ) {
            imagePlaceable.place(imageX.toInt(), imageY)
        }
    }
}

@Composable
private fun PupDetailTitle(pup: Pup, scroll: Int) {
    val maxOffset = with(LocalDensity.current) { MaxTitleOffset.toPx() }
    val minOffset = with(LocalDensity.current) { MinTitleOffset.toPx() }
    val offset = (maxOffset - scroll).coerceAtLeast(minOffset)
    Column(
        verticalArrangement = Arrangement.Bottom,
        modifier = Modifier
            .heightIn(min = TitleHeight)
            .statusBarsPadding()
            .graphicsLayer { translationY = offset }
            .background(color = MaterialTheme.colors.background)
    ) {
        Spacer(Modifier.height(16.dp))
        Text(
            text = pup.title,
            color = MaterialTheme.colors.onBackground,
            style = MaterialTheme.typography.h4,
            modifier = Modifier
                .padding(start = 16.dp)
                .semantics {
                    contentDescription = "Name of Puppy is ${pup.title}"
                    heading()
                }
        )
        Text(
            text = pup.description,
            color = MaterialTheme.colors.onBackground,
            style = MaterialTheme.typography.body1.copy(fontSize = 18.sp),
            modifier = Modifier
                .padding(start = 16.dp)
                .semantics {
                    contentDescription = "About Puppy ${pup.description}"
                }
        )
        Spacer(Modifier.height(8.dp))
        PupDivider()
    }
}

@Composable
fun PupDetailBody(pup: Pup, scroll: ScrollState) {
    Column {
        Spacer(
            modifier = Modifier
                .fillMaxWidth()
                .statusBarsPadding()
                .height(MinTitleOffset)
        )
        Column(
            modifier = Modifier.verticalScroll(scroll)
        ) {
            Spacer(Modifier.height(GradientScroll))
            PupSurface(Modifier.fillMaxWidth()) {
                Column {
                    Spacer(Modifier.height(ImageOverlap + TitleHeight))
                    Body(pup = pup)
                }
            }
        }
    }
}

@Composable
private fun Body(pup: Pup) {
    PupDetailRow(stringResource(R.string.gender), pup.pupDetail.gender)
    PupDetailRow(stringResource(R.string.breed), pup.pupDetail.breed)
    PupDetailRow(stringResource(R.string.color), pup.pupDetail.color)
    PupDetailRow(stringResource(R.string.age), pup.pupDetail.age)
    PupDetailRow(stringResource(R.string.desexed), if (pup.pupDetail.desexed) "Yes" else "No")
    PupDetailRow(stringResource(R.string.location), pup.pupDetail.location)
    PupDetailRow(stringResource(R.string.adoption_fee), pup.pupDetail.adoptionFee)
    PupDetailRow(
        stringResource(R.string.micro_chipped),
        if (pup.pupDetail.microChipped) stringResource(R.string.yes) else stringResource(R.string.no)
    )
    PupDetailRow(
        stringResource(R.string.wormed),
        if (pup.pupDetail.wormed) stringResource(R.string.yes) else stringResource(R.string.no)
    )
    PupDetailRow(
        stringResource(R.string.vet_checked),
        if (pup.pupDetail.vetChecked) stringResource(R.string.yes) else stringResource(R.string.no)
    )
    Spacer(modifier = Modifier.height(16.dp))
    Row(modifier = Modifier.padding(start = 16.dp, top = 4.dp, end = 16.dp)) {
        Button(
            onClick = { /*TODO*/ }, modifier = Modifier
                .weight(0.5f)
                .padding(end = 8.dp)
        ) {
            Text(text = stringResource(R.string.adopt_me), color = MaterialTheme.colors.onBackground)
        }
        Button(
            onClick = { /*TODO*/ }, modifier = Modifier
                .weight(0.5f)
                .padding(
                    start = 8.dp
                )
        ) {
            Text(text = stringResource(R.string.share), color = MaterialTheme.colors.onBackground)
        }
    }
    Spacer(modifier = Modifier.height(56.dp))
}

@Composable
private fun PupDetailRow(title: String, desc: String) {
    Row(modifier = Modifier
        .padding(start = 16.dp, top = 4.dp)
        .semantics(mergeDescendants = true) { contentDescription = "$title is $desc" }) {
        Text(
            text = title,
            color = MaterialTheme.colors.onSecondary,
            style = MaterialTheme.typography.subtitle1.copy(fontSize = 18.sp),
            modifier = Modifier
                .weight(0.4f)
        )
        Text(
            text = desc,
            color = MaterialTheme.colors.onSecondary,
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
        PupDescription(pupsList[0].id, upPress = {})
    }
}

@Preview("Dark Theme", widthDp = 360, heightDp = 640)
@Composable
fun DarkThemePupDescription() {
    PupTheme(darkTheme = true) {
        PupDescription(pupsList[0].id, upPress = {})
    }
}

fun lerp2(start: Int, stop: Int, fraction: Float): Int {
    return start + ((stop - start) * fraction.toDouble()).roundToInt()
}

fun lerp1(start: Float, stop: Float, fraction: Float): Float {
    return (1 - fraction) * start + fraction * stop
}
