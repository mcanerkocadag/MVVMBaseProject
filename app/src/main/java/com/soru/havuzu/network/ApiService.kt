package com.soru.havuzu.network

import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import com.soru.havuzu.model.User
import kotlinx.coroutines.Deferred
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.Body
import retrofit2.http.POST

private const val BASE_URL = "https://managersystempanel.azurewebsites.net/"

private val retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create())
    .addCallAdapterFactory(CoroutineCallAdapterFactory())
    .baseUrl(BASE_URL)
    .build()

interface ApiService {

    @POST("api/User/LoginUser")
    fun postLogin(
        @Body user:User
    ): Deferred<User>
//
    //@POST("api/wskullanici/sifremi-unuttum")
    //fun forgotPassword(
    //    @Query("email") username: String
    //): Deferred<Response>
//
//
    //@POST("api/wskullanici/sifre-degistir")
    //fun changePassword(
    //    @Query("username") username: String,
    //    @Query("guid") guid: String,
    //    @Query("oldpassword") oldpassword: String,
    //    @Query("newpassword") newpassword: String
    //): Deferred<Response>
//
    //@GET("api/wsbanka/icons")
    //fun downloadBankaIcons(
    //    @Query("username") username: String,
    //    @Query("guid") guid: String
    //): Deferred<IconList>
//
    //@GET("api/wsbanka/bankalar")
    //fun getBankalar(
    //    @Query("username") username: String,
    //    @Query("guid") guid: String
    //): Deferred<Bankalar>
//
    //@GET("api/wsbanka/hesap-hareketler")
    //fun getHesapHareketleri(
    //    @Query("username") username: String,
    //    @Query("guid") guid: String,
    //    @Query("hesapid") hesapID: Int
    //): Deferred<HesapDetay>
//
    //@GET("api/wsbanka/hesap-hareketler-page")
    //fun getHesapHareketleriPage(
    //    @Query("username") username: String,
    //    @Query("guid") guid: String,
    //    @Query("hesapid") hesapID: Int,
    //    @Query("page") page: Int
    //): Deferred<HesapDetay>
//
    //@GET("api/wsbanka/sube-hesap-hareketler")
    //fun getSubeHareketleri(
    //    @Query("username") username: String,
    //    @Query("guid") guid: String,
    //    @Query("subeid") subeID: Int
    //): Deferred<Sube>
//
    //@GET("api/wsbanka/kurlar")
    //fun getKurlar(
    //): Deferred<Kur>
}

object Api {
    val retrofitService: ApiService by lazy { retrofit.create(ApiService::class.java) }
}
