package com.japa.markethub.screens.onboarding


import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.japa.markethub.R

@Composable
fun OnBoarding2Screen(navController: NavController){
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Image(
            painter = painterResource(R.drawable.fastdelivery),
            contentDescription = "MarketHub Logo",
            modifier = Modifier
                .height(500.dp)
                .width(300.dp)

        )
        Text(
            text = "Shop Now. Live Better",
            fontSize = 40.sp,
            color = Color.Black


        )

        Text(
            text = "Heha movers always at your service to give you a fresh start in life",
            fontSize = 30.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Black

        )


        Button(
            onClick = {},
            colors = ButtonDefaults.buttonColors(Color.Black),
            shape = RoundedCornerShape(10.dp),

            ) {Text("Get Started")}






    }

}

@Preview(showBackground = true)
@Composable
fun OnBoarding2ScreenPreview(){
    OnBoarding2Screen(rememberNavController())
}