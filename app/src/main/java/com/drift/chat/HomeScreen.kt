package com.drift.chat

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.blur
import androidx.compose.ui.geometry.Rect
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.boundsInParent
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(){

    Scaffold(
        modifier = Modifier
            .fillMaxSize(),
        containerColor = Color(0xFF1b202d),
        topBar = {
            TopAppBar(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 5.dp),
                title = {
                    Text(
                        text = "Messages",
                        style = TextStyle(
                            fontSize = 28.sp,
                            fontFamily = FontFamily.SansSerif,
                            fontWeight = FontWeight(600),
                            color = Color(0xFFFFFFFF),
                            )
                    )
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color(0xFF1b202d)
                ),
                actions = {
                    IconButton(onClick = { /*TODO*/ }) {
                        Image(painterResource(id = R.drawable.icon_search), contentDescription =null )
                        
                    }
                }
            )
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .padding(paddingValues)
                .fillMaxSize()
                .background(Color(0xFF1b202d)),
            verticalArrangement = Arrangement.Bottom,
            horizontalAlignment = Alignment.CenterHorizontally

        ) {
            Surface(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f),
                color = Color(0xFF1b202d)
            ) {

                Column {
                    Text(
                        modifier = Modifier
                            .padding(top = 10.dp, start = 20.dp),
                        text = "Favourites",
                        style = TextStyle(
                            fontSize = 13.sp,
                            fontFamily = FontFamily.SansSerif,
                            fontWeight = FontWeight(500),
                            color = Color(0x94FFFFFF),
                            letterSpacing = 3.9.sp,
                        )
                    )

                    LazyRow(
                        modifier = Modifier
                            .padding(top = 10.dp)
                    ){
                        item{
                            Spacer(modifier = Modifier.width(20.dp))
                        }

                        items(20){
                            Column(
                                horizontalAlignment = Alignment.CenterHorizontally,
                                modifier = Modifier
                            ) {
                                Card(
                                    modifier = Modifier
                                        .padding(end = 10.dp)
                                        .size(65.dp),
                                    shape = RoundedCornerShape(50),
                                    colors = CardDefaults.cardColors(
                                        containerColor = Color(0xFF292f3f)
                                    )
                                ) {

                                }

                                Text(
                                    modifier = Modifier
                                        .padding(top = 5.dp, end = 10.dp),
                                    text = "Barry",
                                    style = TextStyle(
                                        fontSize = 16.sp,
                                        fontFamily = FontFamily.SansSerif,
                                        fontWeight = FontWeight(400),
                                        color = Color(0xFFFFFFFF),

                                        textAlign = TextAlign.Center,
                                    )
                                )


                            }
                        }
                    }
                }
//                Card(
//                    modifier = Modifier
//                        .fillMaxWidth()
//                        .padding(horizontal = 25.dp),
//                    shape = RoundedCornerShape(0.dp),
//                    colors = CardDefaults.cardColors(
//                        containerColor = Color(0xFF1b202d)
//                    )
//                ) {
//
//                }
            }

            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight(0.8f),
                shape = RoundedCornerShape(topStart = 50.dp, topEnd = 50.dp),
                colors = CardDefaults.cardColors(
                    containerColor = Color(0xFF292f3f)
                )
            ) {
                LazyColumn(
                    modifier = Modifier
                        .padding(top = 25.dp)
                ) {
                    items(10){
                        ChatItem()
                    }
                }
            }
        }
    }


}

@Preview
@Composable
fun HomeScreenPreview(){
    HomeScreen()
}