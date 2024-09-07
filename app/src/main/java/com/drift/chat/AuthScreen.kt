package com.drift.chat

import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.core.animateDp
import androidx.compose.animation.core.spring
import androidx.compose.animation.core.tween
import androidx.compose.animation.core.updateTransition
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.togetherWith
import androidx.compose.animation.with
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Tab
import androidx.compose.material3.TabPosition
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.zIndex

@OptIn(ExperimentalMaterial3Api::class, ExperimentalFoundationApi::class)
@Composable
fun AuthScreen(){
    val keyboardController = LocalSoftwareKeyboardController.current
    val tabItems = listOf(
        TabItem("Sign in"),
        TabItem("Register")
    )

    var selectedItemIndex by remember {
        mutableStateOf(0)
    }

    val pagerState = rememberPagerState {
        tabItems.size
    }
    LaunchedEffect(selectedItemIndex) {
        pagerState.animateScrollToPage(selectedItemIndex)

    }

    LaunchedEffect(pagerState.currentPage) {
        selectedItemIndex = pagerState.currentPage
    }

    val indicator = @Composable { tabPositions: List<TabPosition> ->
        CustomIndicator(tabPositions, pagerState)
    }

    Scaffold(
        modifier = Modifier
            .imePadding()
            .fillMaxSize(),
        containerColor = Color(0xFF1b202d),

        topBar = {
            TopAppBar(
                title = {
                    AnimatedContent(
                        targetState = if (selectedItemIndex == 0) "Welcome Back 🥳" else "Welcome to Drift 🚀",
                        transitionSpec = {
                            (fadeIn(animationSpec = tween(300)) togetherWith fadeOut(animationSpec = tween(300)))
                        }
                    ) { targetText ->
                        Text(
                            text = targetText,
                            style = TextStyle(
                                fontSize = 28.sp,
                                fontFamily = FontFamily.SansSerif,
                                fontWeight = FontWeight(600),
                                color = Color(0xFFFFFFFF),
                            )
                        )
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color(0xFF1b202d)
                )
            )
        }
    ) {paddingValues->
       Column(
           modifier = Modifier
               .fillMaxSize()
               .padding(paddingValues),
           horizontalAlignment = Alignment.CenterHorizontally,
           verticalArrangement = Arrangement.Bottom
       ){
           TabRow(
               selectedTabIndex = selectedItemIndex,
               indicator = indicator,
               containerColor = Color(0xFFFFFFFF),
               modifier = Modifier
                   .fillMaxWidth(0.8f)
                   .clip(RoundedCornerShape(50)),
               divider = {

               },

           ) {
               tabItems.forEachIndexed() { index, item ->
                   Tab(
                       modifier = Modifier.zIndex(6f),
                       text = {
                           Text(
                               text = item.title,
                               style = TextStyle(
                                   fontSize = 18.sp,
                                   fontFamily = FontFamily.SansSerif,
                                   fontWeight = FontWeight(600),
                                   color = if(selectedItemIndex == index) Color(0xFFFFFFFF) else Color(0xFF545151),
                               )
                           )
                       },
                       selected = selectedItemIndex == index,
                       onClick = {
                           selectedItemIndex = index
                       }
                   )
               }
               
           }
           
           HorizontalPager(
               state = pagerState,
               modifier = Modifier
                   .weight(1f)
           ) { page->
               if(page==0){
                   LazyColumn(
                       modifier = Modifier
                           .fillMaxSize(),
                       horizontalAlignment = Alignment.CenterHorizontally,
                       verticalArrangement = Arrangement.Bottom
                   ){
                       item{
                           Spacer(
                               modifier = Modifier
                                   .weight(1f)
                                   .clickable(onClick = {
                                       keyboardController?.hide()
                                   })
                           )
                           Card(
                               modifier = Modifier
                                   .fillMaxWidth()
                                   .defaultMinSize(minHeight = 80.dp),
                               shape = RoundedCornerShape(topStart = 50.dp, topEnd = 50.dp),
                               colors = CardDefaults.cardColors(
                                   containerColor = Color(0xFF292f3f)
                               )
                           ) {
                               Column(
                                   modifier = Modifier
                                       .fillMaxWidth()
                                       .padding(horizontal = 28.dp, vertical = 30.dp)
                               ) {

                                   DriftChatInputField(
                                       modifier = Modifier
                                           .fillMaxWidth()
                                           .padding(top = 20.dp)

                                   )

                                   DriftChatInputField(
                                       modifier = Modifier
                                           .fillMaxWidth()
                                           .padding(top = 5.dp)
                                   )

                                   Button(
                                       onClick = { /*TODO*/ },
                                       modifier = Modifier
                                           .fillMaxWidth()
                                           .padding(top = 20.dp),
                                       colors = ButtonDefaults.buttonColors(
                                           containerColor = Color(0xFFFFFFFF)
                                       )
                                   ) {
                                       Box(
                                           modifier = Modifier.fillMaxWidth(),
                                           contentAlignment = Alignment.Center
                                       ) {
                                           Text(
                                               text = "Login",
                                               style = TextStyle(
                                                   fontSize = 28.sp,
                                                   fontFamily = FontFamily.SansSerif,
                                                   fontWeight = FontWeight(600),
                                                   color = Color(0xFF545151),
                                               )
                                           )
                                       }
                                   }

                               }
                           }
                       }
                   }
               }
               else{
                   LazyColumn(
                       modifier = Modifier
                           .fillMaxSize(),
                       horizontalAlignment = Alignment.CenterHorizontally,
                       verticalArrangement = Arrangement.Bottom
                   ){
                       item{
                           Spacer(
                               modifier = Modifier
                                   .weight(1f)
                                   .clickable(onClick = {
                                       keyboardController?.hide()
                                   })
                           )
                           Card(
                               modifier = Modifier
                                   .fillMaxWidth()
                                   .defaultMinSize(minHeight = 80.dp),
                               shape = RoundedCornerShape(topStart = 50.dp, topEnd = 50.dp),
                               colors = CardDefaults.cardColors(
                                   containerColor = Color(0xFF292f3f)
                               )
                           ) {
                               Column(
                                   modifier = Modifier
                                       .fillMaxWidth()
                                       .padding(horizontal = 28.dp, vertical = 30.dp)
                               ) {

                                   DriftChatInputField(
                                       modifier = Modifier
                                           .fillMaxWidth()
                                           .padding(top = 20.dp)

                                   )

                                   DriftChatInputField(
                                       modifier = Modifier
                                           .fillMaxWidth()
                                           .padding(top = 5.dp)
                                   )

                                   DriftChatInputField(
                                       modifier = Modifier
                                           .fillMaxWidth()
                                           .padding(top = 5.dp)
                                   )

                                   Button(
                                       onClick = { /*TODO*/ },
                                       modifier = Modifier
                                           .fillMaxWidth()
                                           .padding(top = 20.dp),
                                       colors = ButtonDefaults.buttonColors(
                                           containerColor = Color(0xFFFFFFFF)
                                       )
                                   ) {
                                       Box(
                                           modifier = Modifier.fillMaxWidth(),
                                           contentAlignment = Alignment.Center
                                       ) {
                                           Text(
                                               text = "Login",
                                               style = TextStyle(
                                                   fontSize = 28.sp,
                                                   fontFamily = FontFamily.SansSerif,
                                                   fontWeight = FontWeight(600),
                                                   color = Color(0xFF545151),
                                               )
                                           )
                                       }
                                   }

                               }
                           }
                       }
                   }
               }
           }
       }
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
private fun CustomIndicator(tabPositions: List<TabPosition>, pagerState: PagerState) {
    val transition = updateTransition(pagerState.currentPage)
    val indicatorStart by transition.animateDp(
        transitionSpec = {
            if (initialState < targetState) {
                spring(dampingRatio = 1f, stiffness = 50f)
            } else {
                spring(dampingRatio = 1f, stiffness = 1000f)
            }
        }, label = ""
    ) {
        tabPositions[it].left
    }

    val indicatorEnd by transition.animateDp(
        transitionSpec = {
            if (initialState < targetState) {
                spring(dampingRatio = 1f, stiffness = 1000f)
            } else {
                spring(dampingRatio = 1f, stiffness = 50f)
            }
        }, label = ""
    ) {
        tabPositions[it].right
    }

    Box(
        Modifier
            .offset(x = indicatorStart)
            .wrapContentSize(align = Alignment.BottomStart)
            .width(indicatorEnd - indicatorStart)
            .fillMaxSize()
            .background(color = Color(0xFF292f3f), RoundedCornerShape(50))
            .zIndex(1f)
    )
}

data class TabItem(
    val title: String
)

@Preview
@Composable
fun AuthScreenPreview(){
    AuthScreen()
}
