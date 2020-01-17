package com.soru.havuzu.ui.dashboard

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.soru.havuzu.network.Api
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

class DashboardViewModel : ViewModel() {

    private var viewModelJob = Job()
    private val coroutineScope = CoroutineScope(viewModelJob + Dispatchers.Main)
    private val _text = MutableLiveData<String>().apply {
        value = "This is dashboard Fragment"
    }
    val text: LiveData<String> = _text

    /**
    fun changePassword(
        oldPassword: String,
        newPassword: String,
        username: String,
        guid: String
    ) {
        coroutineScope.launch {

            val response = Api.retrofitService.changePassword(
                username = username,
                guid = guid,
                oldpassword = oldPassword,
                newpassword = newPassword
            )

            try {
                _status.value = createMessageModel("Şifre güncelleniyor", ApiStatus.LOADING)
                val listResult = response.await()
                if (listResult.Sonuc) {

                    _status.value = createMessageModel(listResult.Mesaj, ApiStatus.DONE)
                } else {
                    _status.value = createMessageModel(listResult.Mesaj, ApiStatus.ERROR)
                }

            } catch (t: Throwable) {
                _status.value = createMessageModel(t.message!!, ApiStatus.ERROR)
            }
        }
    }

     *
     */

    override fun onCleared() {
        super.onCleared()
        viewModelJob.cancel()
    }
}