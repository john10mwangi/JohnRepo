package com.jwlabs.mygame

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import java.util.*

@Composable
fun Navigation(){
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = Screens.HomeScreen.route){
        composable(route = Screens.HomeScreen.route){Home(navController = navController)}
        composable(
            route = Screens.MainScreen.route + "/{name}",
            arguments = listOf(
                navArgument("name"){
                    type = NavType.StringType
                    defaultValue = "Placeholder"
                    nullable = true
                }
            )
        ){entry ->
            Landing(name = entry.arguments?.getString("name"))
        }
        composable(route = Screens.SettingsScreen.route){GameSettings()}
    }
}

@Composable
private fun Landing(name: String?) {
//        TODO("Not yet implemented")
    Box(modifier = Modifier.fillMaxSize()) {

        Column {
            Row(
                modifier = Modifier
                    .weight(1f)
                    .background(Color.Yellow)
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceAround
            ){

                Text("$name", modifier = Modifier.align(Alignment.CenterVertically),style = TextStyle(color = Color.Cyan, fontSize = 18.sp))
                Text("$name", modifier = Modifier.align(Alignment.CenterVertically),style = TextStyle(color = Color.Cyan, fontSize = 18.sp))

            }
            Row(
                modifier = Modifier
                    .weight(1f)
                    .background(Color.Cyan)
                    .fillMaxWidth()
            ){
                Text("Welcome to MyGame Screen Landing $name".uppercase(Locale.getDefault()), modifier = Modifier
                    .align(Alignment.CenterVertically)
                    .padding(all = 16.dp),
                    style = TextStyle(color = Color.Red, fontSize = 18.sp,)
                )
            }
        }
    }
}

@Composable
private fun GameSettings() {
//        TODO("Not yet implemented")
    Box(modifier = Modifier.fillMaxSize()) {
        Text("Welcome to MyGame Screen Settings".uppercase(Locale.getDefault()), modifier = Modifier
            .align(Alignment.Center)
            .padding(all = 16.dp),
            style = TextStyle(color = Color.Cyan, fontSize = 18.sp,)
        )
    }
}

@Composable
private fun Home(navController: NavHostController) {
    Column(
        modifier = Modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.SpaceBetween

    ) {

        Text("Welcome to MyGame".uppercase(Locale.getDefault()), modifier = Modifier
            .align(Alignment.CenterHorizontally)
            .padding(all = 16.dp),
            style = TextStyle(color = Color.Cyan, fontSize = 24.sp,)
        )

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ) {

            Column(
                modifier = Modifier.fillMaxWidth(),
                verticalArrangement = Arrangement.SpaceBetween,
            ) {
                Button(onClick = { navController.navigate(Screens.MainScreen.withArgs("john")) },
                    modifier = Modifier
                        .align(Alignment.CenterHorizontally)
                        .border(
                            border = BorderStroke(0.dp, Color.Transparent),
                            shape = RectangleShape
                        )
                        .padding(top = 48.dp, start = 0.dp),
                    colors = ButtonDefaults.buttonColors(backgroundColor = Color.Transparent)
                ) {
                    Text(text = "Proceed".uppercase(Locale.getDefault()), color = Color.Green, fontSize = 18.sp)
                }
                Button(onClick = { navController.navigate(Screens.SettingsScreen.route) },
                    modifier = Modifier
                        .align(Alignment.CenterHorizontally)
                        .padding(top = 48.dp, start = 48.dp),
                    colors = ButtonDefaults.buttonColors(backgroundColor = Color.Transparent)
                ) {
                    Text(text = "Configure".uppercase(Locale.getDefault()), color = Color.Green, fontSize = 18.sp)
                }
                Button(onClick = { /* TODO */ },
                    modifier = Modifier
                        .align(Alignment.CenterHorizontally)
                        .padding(top = 48.dp, start = 64.dp),
                    colors = ButtonDefaults.buttonColors(backgroundColor = Color.Transparent)
                ) {
                    Text(text = "Exit".uppercase(Locale.getDefault()), color = Color.Green, fontSize = 18.sp)
                }
            }
        }

        FloatingActionButton(onClick = { /*TODO*/ },
            Modifier
                .align(Alignment.End)
                .padding(all = 12.dp)) {
//                Text(text = "+")
            Icon(imageVector = Icons.Filled.Add, contentDescription = null)
        }
    }
}