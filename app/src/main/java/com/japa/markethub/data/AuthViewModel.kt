package com.japa.markethub.data

import android.content.Context
import android.widget.Toast
import androidx.navigation.NavController
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase
import com.japa.markethub.models.User
import com.japa.markethub.screens.navigations.ROUT_HOME
import com.japa.markethub.screens.navigations.ROUT_REGISTER

class AuthViewModel(
    private val navController: NavController,
    private val context: Context
) {
    private val auth: FirebaseAuth by lazy { FirebaseAuth.getInstance() }

    fun signup(username: String, email: String, password: String, confirmPassword: String) {
        if (username.isBlank() || email.isBlank() || password.isBlank() || confirmPassword.isBlank()) {
            Toast.makeText(context, "Please fill in all fields", Toast.LENGTH_LONG).show()
            return
        }
        if (password != confirmPassword) {
            Toast.makeText(context, "Passwords do not match", Toast.LENGTH_LONG).show()
            return
        }

        auth.createUserWithEmailAndPassword(email.trim(), password)
            .addOnCompleteListener { task ->
                if (!task.isSuccessful) {
                    Toast.makeText(
                        context,
                        task.exception?.localizedMessage ?: "Registration failed",
                        Toast.LENGTH_LONG
                    ).show()
                    return@addOnCompleteListener
                }

                val uid = auth.currentUser?.uid
                if (uid == null) {
                    Toast.makeText(context, "Could not get the new user account", Toast.LENGTH_LONG).show()
                    return@addOnCompleteListener
                }

                // Firebase Authentication stores the credential; never save the password in Realtime Database.
                val user = User(
                    username = username.trim(),
                    email = email.trim(),
                    uid = uid,
                    role = "user"
                )
                FirebaseDatabase.getInstance().getReference("Users").child(uid)
                    .setValue(user)
                    .addOnCompleteListener { saveTask ->
                        if (saveTask.isSuccessful) {
                            Toast.makeText(context, "Registered successfully", Toast.LENGTH_LONG).show()
                            navController.navigate(ROUT_HOME) {
                                popUpTo(ROUT_REGISTER) { inclusive = true }
                                launchSingleTop = true
                            }
                        } else {
                            Toast.makeText(
                                context,
                                saveTask.exception?.localizedMessage ?: "Could not save user profile",
                                Toast.LENGTH_LONG
                            ).show()
                        }
                    }
            }
    }

    fun login(email: String, password: String) {
        if (email.isBlank() || password.isBlank()) {
            Toast.makeText(context, "Please enter your email and password", Toast.LENGTH_LONG).show()
            return
        }

        auth.signInWithEmailAndPassword(email.trim(), password)
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    navController.navigate(ROUT_HOME) {
                        popUpTo(ROUT_REGISTER) { inclusive = true }
                        launchSingleTop = true
                    }
                } else {
                    Toast.makeText(
                        context,
                        task.exception?.localizedMessage ?: "Sign in failed",
                        Toast.LENGTH_LONG
                    ).show()
                }
            }
    }

    fun logout() {
        auth.signOut()
        navController.navigate(ROUT_HOME) {
            popUpTo(0) { inclusive = true }
            launchSingleTop = true
        }
    }

    fun isLoggedIn(): Boolean = auth.currentUser != null
}
