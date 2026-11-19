package com.japa.markethub.screens.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults.topAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.japa.markethub.R
import com.japa.markethub.screens.navigations.ROUT_INTENT


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Homescreen(navController: NavController) {
    Column(
        modifier = Modifier.fillMaxSize()
    ) {



//TopAppBar
        TopAppBar(

            title = { Text(text = "Home") },

            navigationIcon = {
                IconButton(onClick = {}) {
                    Icon(imageVector = Icons.Default.Menu, contentDescription = "menu")
                }
            },
            actions = {
                IconButton(onClick = {}) {
                    Icon(
                        imageVector = Icons.Default.ShoppingCart,
                        contentDescription = "shopping cart"
                    )
                }
                IconButton(onClick = { navController.navigate(ROUT_INTENT)}) {
                    Icon(imageVector = Icons.Default.ArrowForward, contentDescription = "assistance")
                }
            },

            colors = topAppBarColors(
                navigationIconContentColor = Color.White,
                containerColor = Color.Magenta,
                titleContentColor = Color.White,
                actionIconContentColor = Color.White
            )
        )

        Spacer(modifier = Modifier.height(20.dp))

        //Row
        Row(
            modifier = Modifier.horizontalScroll(rememberScrollState())
        ) {
            Image(
                painter = painterResource(R.drawable.facecream),
                contentDescription = "MarketHub Logo",
                modifier = Modifier
                    .height(300.dp)
                    .width(200.dp)
                    .clip(shape = RoundedCornerShape(10.dp)),
                contentScale = ContentScale.Crop
            )
            Spacer(modifier = Modifier.height(20.dp))

            Image(
                painter = painterResource(R.drawable.perfume),
                contentDescription = "MarketHub Logo",
                modifier = Modifier
                    .height(300.dp)
                    .width(200.dp)
                    .clip(shape = RoundedCornerShape(10.dp)),
                contentScale = ContentScale.Crop
            )
            Spacer(modifier = Modifier.height(20.dp))
            Image(
                painter = painterResource(R.drawable.facecream),
                contentDescription = "MarketHub Logo",
                modifier = Modifier
                    .height(300.dp)
                    .width(200.dp)
                    .clip(shape = RoundedCornerShape(10.dp)),
                contentScale = ContentScale.Crop
            )
            Spacer(modifier = Modifier.height(20.dp))
            Image(
                painter = painterResource(R.drawable.showergel),
                contentDescription = "MarketHub Logo",
                modifier = Modifier
                    .height(300.dp)
                    .width(200.dp)
                    .clip(shape = RoundedCornerShape(10.dp)),
                contentScale = ContentScale.Crop
            )










        }
        //end of row























































        }



}







@Preview(showBackground = true)
@Composable
fun HomescreenPreview(){
    Homescreen(rememberNavController())
}