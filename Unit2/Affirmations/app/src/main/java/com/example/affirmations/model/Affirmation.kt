package com.example.affirmations.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

// @代表型態註解
data class Affirmation (
    @StringRes var stringResourceId: Int,
    @DrawableRes var imageResourceID: Int)