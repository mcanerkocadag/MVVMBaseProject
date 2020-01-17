package com.soru.havuzu.model

data class User (
   var user_id: Int? = null,
   var custome_id: Int? = null,
   var user_name: String? = null,
   var user_surname: String? = null,
   var user_email: String? = null,
   var user_password: String? = null,
   var user_createDate: String? = null,
   var user_modifyDate: String? = null,
   var uuid: Any? = null,
   var type: Int? = null,
   var status: Any? = null,
   var user_type: Any? = null,
   var user_photoUrl: Any? = null,
   var user_photoBitmap: Any? = null,
   var code: Any? = null,
   var token: Any? = null,
   var description: Any? = null,
   var deleted: Boolean? = null)
