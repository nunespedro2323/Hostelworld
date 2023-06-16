package com.pedronunes.hostelworld.util

import android.content.Context
import com.pedronunes.hostelworld.R
import java.util.*

fun Double.toStringDecimal(decimal: Int): String =
    String.format(Locale.getDefault(), "%." + decimal + "f", this)

fun Double.convertUSToEur(): Double = this * 0.95

fun Double.getRatingValueString(): String = (this / 10).toStringDecimal(1)

fun Double.getPriceValueString(): String = this.convertUSToEur().toStringDecimal(0)

fun Double.convertToStringRatingMeaning(context: Context): String {
    return when {
        this < 60 -> context.getString(R.string.empty)
        this < 70 -> context.getString(R.string.good)
        this < 80 -> context.getString(R.string.very_good)
        this < 90 -> context.getString(R.string.fabulous)
        this >= 90 -> context.getString(R.string.superb)
        else -> context.getString(R.string.empty)
    }
}