package com.example.heroesapp.domain.model

import androidx.annotation.DrawableRes
import com.example.heroesapp.R

sealed class OnBoardngScreens(
    @DrawableRes
    val image: Int,
    val title: String,
    val description: String
) {
    object First : OnBoardngScreens(
        image = R.drawable.greetings,
        title = "Greetings",
        description = "Are you an anime fun? Get ready for an axciting journey"
    )

    object Second : OnBoardngScreens(
        image = R.drawable.explore,
        title = "Explore",
        description = "Find your favourite anime heroes"
    )

    object Third : OnBoardngScreens(
        image = R.drawable.power,
        title = "Power",
        description = "Check out your heroes powers"
    )
}
