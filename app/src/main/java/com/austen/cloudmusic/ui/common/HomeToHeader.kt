package com.austen.cloudmusic.ui.common

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import com.austen.cloudmusic.R

/**
 * Company: TAO_LE
 * ================================================
 * Description:
 *
 *
 * Created by austenYang on 2021/10/24-16:33
 * ================================================
 */
@Preview(backgroundColor = 0xFFDADBDF, showBackground = true)
@Composable
fun HomeTopHeader() {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .height(70.dp)
            .background(color = Color(0xFFDADBDF))

    ) {
        Spacer(modifier = Modifier.width(10.dp))
        ConstraintLayout {
            val (img, text) = createRefs()
            Image(
                painter = painterResource(id = R.drawable.home_ic_header_more),
                contentDescription = "更多",
                modifier = Modifier
                    .size(36.dp)
                    .constrainAs(img) {
                        centerTo(parent)
                    }
            )

            Text(text = " 99 ",
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .wrapContentSize()
                    .constrainAs(text) {
                        end.linkTo(img.end, margin = 0.dp)
                    }
                    .clip(CircleShape)
                    .background(color = Color.Red),
                color = Color.White
            )
        }
        Spacer(modifier = Modifier.width(10.dp))
        Box(
            modifier = Modifier
                .weight(1.0F)
                .height(50.dp)
                .clip(RoundedCornerShape(size = 28.dp))
                .background(color = Color.White),
            contentAlignment = Alignment.CenterStart
        ) {
            Row(verticalAlignment = Alignment.CenterVertically) {


                var name by remember { mutableStateOf("RadioHead") }


                Spacer(modifier = Modifier.width(10.dp))
                Image(
                    painter = painterResource(id = R.drawable.home_ic_header_search),
                    contentDescription = "更多",
                    modifier = Modifier
                        .size(36.dp)
                        .padding(4.dp)
                )
                Spacer(modifier = Modifier.width(4.dp))


                TextField(
                    value = name,
                    onValueChange = { name = it },
                    textStyle = TextStyle(fontSize = 20.sp),
                    colors = TextFieldDefaults.textFieldColors(
                        textColor = Color(0xFF838383),
                        backgroundColor = Color.White,
                        disabledTextColor = Color.Transparent,
                        focusedIndicatorColor = Color.Transparent,
                        unfocusedIndicatorColor = Color.Transparent,
                        disabledIndicatorColor = Color.Transparent
                    ), singleLine = true,
                    modifier = Modifier.fillMaxHeight()
                )

//
            }

        }
        Spacer(modifier = Modifier.width(10.dp))
        Image(

            painter = painterResource(id = R.drawable.home_ic_header_more),
            contentDescription = "更多",
            modifier = Modifier.size(36.dp)
        )
        Spacer(modifier = Modifier.width(10.dp))

    }
}