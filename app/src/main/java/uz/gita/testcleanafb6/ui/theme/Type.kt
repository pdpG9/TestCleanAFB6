package uz.gita.testcleanafb6.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import uz.gita.testcleanafb6.R

// Set of Material typography styles to start with
val Typography = Typography(
    bodyLarge = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.5.sp
    ),
    displayLarge = TextStyle(
        fontFamily = FontFamily(Font(R.font.dmsans_bold)),
        fontWeight = FontWeight.W700,
        fontSize = 32.sp,
        lineHeight = 32.sp,
        letterSpacing = 20.sp,
        color = WhiteColor,
        textAlign = TextAlign.Center
    ),
    titleLarge = TextStyle(
        fontFamily = FontFamily(Font(R.font.dmsans_regular)),
        fontWeight = FontWeight.W700,
        fontSize = 35.sp,
        lineHeight = 46.sp,
        color = BaseColor,
        textAlign = TextAlign.Center
    ),
    labelLarge = TextStyle(
        fontFamily = FontFamily(Font(R.font.dmsans_medium)),
        fontWeight = FontWeight.W400,
        fontSize = 15.sp,
        lineHeight = 25.sp,
        color = LabelTextColor,
        textAlign = TextAlign.Center
    ),
    labelMedium  = TextStyle(
        fontFamily = FontFamily(Font(R.font.dmsans_regular)),
        fontWeight = FontWeight.W700,
        fontSize = 17.sp,
        lineHeight = 22.sp,
        color = WhiteColor,
        textAlign = TextAlign.Center
    )
    /* Other default text styles to override
    titleLarge = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 22.sp,
        lineHeight = 28.sp,
        letterSpacing = 0.sp
    ),
    labelSmall = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Medium,
        fontSize = 11.sp,
        lineHeight = 16.sp,
        letterSpacing = 0.5.sp
    )
    */
)