package com.example.heroesapp.screens.welcome


import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.paging.ExperimentalPagingApi
import com.example.heroesapp.R
import com.example.heroesapp.domain.model.OnBoardngScreens
import com.example.heroesapp.ui.theme.welcomeScreenBackgroundColor
import com.example.heroesapp.util.Constants.ON_BOARDING_PAGE_COUNT

@OptIn(ExperimentalFoundationApi::class)
@ExperimentalPagingApi
@Composable
fun WelcomeScreen(navController: NavController) {
    WelcomeScreenDesign()
}

@ExperimentalPagingApi
@OptIn(ExperimentalFoundationApi::class)
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
            .background(color = androidx.compose.material.MaterialTheme.colors.welcomeScreenBackgroundColor)

    ) {

        val pagerState = rememberPagerState(pageCount = { 3 })
        HorizontalPager(state = pagerState, verticalAlignment = Alignment.Top) { page ->
           PagerScreen(onBoardngScreens = screens[page])
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

