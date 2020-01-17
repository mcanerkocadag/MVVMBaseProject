package com.soru.havuzu.data

import com.soru.havuzu.data.model.LoggedInUser
import com.soru.havuzu.model.User
import com.soru.havuzu.network.Api
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import java.io.IOException

/**
 * Class that handles authentication w/ login credentials and retrieves user information.
 */
class LoginDataSource {

     suspend fun login(
        username: String,
        password: String
    ): Result<User> {
         var user :User?
        try {
            // TODO: handle loggedInUser authentication
            user = User()
            user.user_email =username
            user.user_password=password
            val response = Api.retrofitService.postLogin(
                user
            )
            try {
                user = response.await()
                return Result.Success(user)

            } catch (t: Throwable) {
               return Result.Error(IOException("Error logging in", t))
            }
        } catch (e: Throwable) {
            return Result.Error(IOException("Error logging in", e))
        }
        return Result.Error(Exception("Giriş yapılamadı"))
    }

    fun logout() {
        // TODO: revoke authentication
    }
}

