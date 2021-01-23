package com.unisytech.prototypeproject.viewModels

import android.util.Log
import androidx.lifecycle.*
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.google.gson.reflect.TypeToken
import com.unisytech.prototypeproject.loaders.loadApplicationJSON
import com.unisytech.prototypeproject.model.EquipmentListModel
import com.unisytech.prototypeproject.model.EquipmentModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json


/**
 * Created by ramesh on 20/01/21.
 */
sealed class Result<out R> {
    data class Success<out T>(val data: T) : Result<T>()
    data class Error(val exception: Exception) : Result<Nothing>()
}

class EquipmentListViewModel : ViewModel()  {
     var equipmentModelLivdata : LiveData<Result<List<EquipmentModel>>> =  liveData {
         val data = executeEquipmentsAPI()
          emit(data)
     }

   private suspend  fun executeEquipmentsAPI() : Result<List<EquipmentModel>>{
     return  viewModelScope.async(Dispatchers.IO) {
           var equipmentAPIDeferred = async { callEquipmentApi()}
            return@async equipmentAPIDeferred.await()
       }.await()

   }

    private fun callEquipmentApi() : Result<List<EquipmentModel>> {

        return try {
            val jsonString  = loadApplicationJSON()

            val gson = GsonBuilder().create()

            val response = gson.fromJson<EquipmentListModel>(jsonString, EquipmentListModel::class.java)

            Result.Success(data = response.equipmentList)
        } catch (e: Exception) {
            Log.d("@Ramesh",e.localizedMessage)
            Result.Error(Exception("Json Decode error"))
        }
    }


}