package com.example.heroesapp.screens.welcome


import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.paging.ExperimentalPagingApi
import com.example.heroesapp.R
import com.example.heroesapp.domain.model.OnBoardngScreens
import com.example.heroesapp.ui.theme.activeIndicatorColor
import com.example.heroesapp.ui.theme.buttonBackgroundColor
import com.example.heroesapp.ui.theme.buttonTextColor
import com.example.heroesapp.ui.theme.inActiveIndicatorColor
import com.example.heroesapp.ui.theme.welcomeScreenBackgroundColor
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPagerIndicator

@OptIn(ExperimentalFoundationApi::class)
@ExperimentalPagingApi
@Composable
fun WelcomeScreen(navController: NavController) {
    WelcomeScreenDesign()
}

@ExperimentalPagingApi
@OptIn(
    ExperimentalFoundationApi::class, ExperimentalAnimationApi::class,
    ExperimentalPagerApi::class
)
@Composable
fun WelcomeScreenDesign() {
    val screens = listOf(
        OnBoardngScreens.First,
        OnBoardngScreens.Second,
        OnBoardngScreens.Third
    )

    Column(

        modifier = Modifier
            .fillMaxSize()
            .background(color = MaterialTheme.colorScheme.welcomeScreenBackgroundColor)

    ) {

        val pagerState = rememberPagerState(pageCount = { 3 })

        HorizontalPager(
            modifier = Modifier.weight(10f),
            state = pagerState,
            verticalAlignment = Alignment.Top
        ) { page ->
            PagerScreen(onBoardngScreens = screens[page])
        }

        HorizontalPagerIndicator(
            modifier = Modifier
                .weight(1f)
                .align(Alignment.CenterHorizontally),
            pagerState = pagerState,
            pageCount = 3,
            activeColor = MaterialTheme.colorScheme.activeIndicatorColor,
            inactiveColor = MaterialTheme.colorScheme.inActiveIndicatorColor,
            indicatorWidth = 12.dp,
            spacing = 8.dp
        )

        FinishButton(modifier = Modifier.weight(1f), pagerState = pagerState) {

        }
    }
}

@OptIn(ExperimentalFoundationApi::class)
@ExperimentalAnimationApi
@ExperimentalPagerApi
@Composable
fun FinishButton(
    modifier: Modifier,
    pagerState: PagerState,
    onClick: () -> Unit
) {
    Row(
        modifier = modifier
            .padding(horizontal = 50.dp),
        verticalAlignment = Alignment.Top,
        horizontalArrangement = Arrangement.Center
    ) {
        AnimatedVisibility(
            modifier = Modifier.fillMaxWidth(),
            visible = pagerState.currentPage == 2
        ) {
            Button(
                onClick = onClick,
                colors = ButtonDefaults.buttonColors(
                    containerColor = MaterialTheme.colorScheme.buttonBackgroundColor,
                    contentColor = Color.White
                )
            ) {
                Text(
                    text = "Finish",
                    fontWeight = FontWeight.Bold,
                    style = MaterialTheme.typography.titleLarge,
                    color = MaterialTheme.colorScheme.buttonTextColor
                )
            }
        }
    }
}

@Composable
fun PagerScreen(onBoardngScreens: OnBoardngScreens) {

    Column(
        modifier = Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top

    ) {
        Image(
            modifier = Modifier
                .fillMaxWidth(0.5f)
                .fillMaxHeight(0.7f),
            painter = painterResource(onBoardngScreens.image),
            contentDescription = stringResource(id = R.string.welcome_greeting)
        )
        Text(
            modifier = Modifier
                .fillMaxWidth(),
            text = onBoardngScreens.title,
            style = MaterialTheme.typography.headlineMedium,
            color = MaterialTheme.colorScheme.onSurface,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center
        )
        Text(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 5.dp)
                .padding(top = 10.dp),
            text = onBoardngScreens.description,
            style = MaterialTheme.typography.bodyLarge,
            color = MaterialTheme.colorScheme.onSurface,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center
        )
    }
}

