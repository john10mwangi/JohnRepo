package com.jwlabs.mygame

sealed class Screens(val route: String){
    object HomeScreen: Screens("home_screen")
    object MainScreen: Screens("main_screen")
    object SettingsScreen: Screens("settings_screen")

    fun withArgs(vararg args: String): String{
        return buildString {
            append(route)
            args.forEach { arg->
                append("/$arg")
            }
        }
    }
}
