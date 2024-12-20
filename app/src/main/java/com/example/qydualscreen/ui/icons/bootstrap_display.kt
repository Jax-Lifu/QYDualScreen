package com.example.qydualscreen.ui.icons

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PathFillType
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.StrokeJoin
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp

object QYIcons {
    object Default
}


val QYIcons.Default.Display: ImageVector
    get() {
        if (_Display != null) {
            return _Display!!
        }
        _Display = ImageVector.Builder(
            name = "Display",
            defaultWidth = 16.dp,
            defaultHeight = 16.dp,
            viewportWidth = 16f,
            viewportHeight = 16f
        ).apply {
            path(
                fill = SolidColor(Color(0xFF000000)),
                fillAlpha = 1.0f,
                stroke = null,
                strokeAlpha = 1.0f,
                strokeLineWidth = 1.0f,
                strokeLineCap = StrokeCap.Butt,
                strokeLineJoin = StrokeJoin.Miter,
                strokeLineMiter = 1.0f,
                pathFillType = PathFillType.NonZero
            ) {
                moveTo(0f, 4f)
                reflectiveCurveToRelative(0f, -2f, 2f, -2f)
                horizontalLineToRelative(12f)
                reflectiveCurveToRelative(2f, 0f, 2f, 2f)
                verticalLineToRelative(6f)
                reflectiveCurveToRelative(0f, 2f, -2f, 2f)
                horizontalLineToRelative(-4f)
                quadToRelative(0f, 1f, 0.25f, 1.5f)
                horizontalLineTo(11f)
                arcToRelative(0.5f, 0.5f, 0f, isMoreThanHalf = false, isPositiveArc = true, 0f, 1f)
                horizontalLineTo(5f)
                arcToRelative(0.5f, 0.5f, 0f, isMoreThanHalf = false, isPositiveArc = true, 0f, -1f)
                horizontalLineToRelative(0.75f)
                quadTo(6f, 13f, 6f, 12f)
                horizontalLineTo(2f)
                reflectiveCurveToRelative(-2f, 0f, -2f, -2f)
                close()
                moveToRelative(1.398f, -0.855f)
                arcToRelative(
                    0.76f,
                    0.76f,
                    0f,
                    isMoreThanHalf = false,
                    isPositiveArc = false,
                    -0.254f,
                    0.302f
                )
                arcTo(1.5f, 1.5f, 0f, isMoreThanHalf = false, isPositiveArc = false, 1f, 4.01f)
                verticalLineTo(10f)
                curveToRelative(0f, 0.325f, 0.078f, 0.502f, 0.145f, 0.602f)
                quadToRelative(0.105f, 0.156f, 0.302f, 0.254f)
                arcToRelative(
                    1.5f,
                    1.5f,
                    0f,
                    isMoreThanHalf = false,
                    isPositiveArc = false,
                    0.538f,
                    0.143f
                )
                lineTo(2.01f, 11f)
                horizontalLineTo(14f)
                curveToRelative(0.325f, 0f, 0.502f, -0.078f, 0.602f, -0.145f)
                arcToRelative(
                    0.76f,
                    0.76f,
                    0f,
                    isMoreThanHalf = false,
                    isPositiveArc = false,
                    0.254f,
                    -0.302f
                )
                arcToRelative(
                    1.5f,
                    1.5f,
                    0f,
                    isMoreThanHalf = false,
                    isPositiveArc = false,
                    0.143f,
                    -0.538f
                )
                lineTo(15f, 9.99f)
                verticalLineTo(4f)
                curveToRelative(0f, -0.325f, -0.078f, -0.502f, -0.145f, -0.602f)
                arcToRelative(
                    0.76f,
                    0.76f,
                    0f,
                    isMoreThanHalf = false,
                    isPositiveArc = false,
                    -0.302f,
                    -0.254f
                )
                arcTo(1.5f, 1.5f, 0f, isMoreThanHalf = false, isPositiveArc = false, 13.99f, 3f)
                horizontalLineTo(2f)
                curveToRelative(-0.325f, 0f, -0.502f, 0.078f, -0.602f, 0.145f)
            }
        }.build()
        return _Display!!
    }

private var _Display: ImageVector? = null
