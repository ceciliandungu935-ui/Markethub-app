package com.japa.markethub.screens.scaffold

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.TopAppBarDefaults.topAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.japa.markethub.screens.navigations.ROUT_HOME

 fun Nothing?.titleContentColor() {
    TODO("Not yet implemented")
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ScaffoldScreen(navController: NavController){
    //Scaffold

    var selectedIndex by remember { mutableStateOf(0) }

    Scaffold(

        //TopBar
        topBar = {
            val newyellow = null
            TopAppBar(
                title = { Text("Scaffold Screen") },
                navigationIcon = {
                    IconButton(onClick = { /* Handle back/nav */ }) {
                        Icon(Icons.Default.ArrowBack, contentDescription = "Back")
                    }
                },
                colors = topAppBarColors(
                    containerColor = Color.Yellow,
                    titleContentColor = Color.Black,
                    navigationIconContentColor = Color.Black,
                    actionIconContentColor = Color.Black
                ),
                actions = {
                    IconButton(onClick = {}) { Icon(imageVector = Icons.Default.ShoppingCart, contentDescription ="") }
                    IconButton(onClick = {}) { Icon(imageVector = Icons.Default.Info, contentDescription ="") }
                }

            )
        },



        //BottomBar
        bottomBar = {

            NavigationBar(
                containerColor = Color.Yellow
            ){
                NavigationBarItem(
                    icon = { Icon(Icons.Default.Person, contentDescription = "Home") },
                    label = { Text("Login") },
                    selected = selectedIndex == 0,
                    onClick = {
                        selectedIndex = 0
                        navController.navigate(ROUT_HOME)
                    }
                )

                NavigationBarItem(
                    icon = { Icon(Icons.Default.Favorite, contentDescription = "Favorites") },
                    label = { Text("Favorites") },
                    selected = selectedIndex == 1,
                    onClick = { selectedIndex = 1
                        navController.navigate(ROUT_HOME)
                    }
                )


                NavigationBarItem(
                    icon = { Icon(Icons.Default.Info, contentDescription = "Home") },
                    label = { Text("Info") },
                    selected = selectedIndex == 3,
                    onClick = {
                        selectedIndex = 3
                        navController.navigate(ROUT_HOME)
                    }
                )



            }
        },

        //FloatingActionButton
        floatingActionButton = {
            val newyellow = null
            if (newyellow != null) {
                FloatingActionButton(
                    onClick = { /* Add action */ },
                    containerColor = newyellow
                ) {
                    Icon(Icons.Default.Add, contentDescription = "Add")
                }
            }
        },

        //Contents

        content = { paddingValues ->
            Column(
                modifier = Modifier
                    .padding(paddingValues)
                    .fillMaxSize()
                // .background(newYellow)
            ) {


                //Main Contents of the page














































            }
        }
    )

    //End of scaffold




}


@Preview(showBackground = true)
@Composable
fun ScaffoldScreenPreview() {

    ScaffoldScreen(rememberNavController())

}
