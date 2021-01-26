package com.unisytech.prototypeproject.model

import androidx.annotation.Keep
import com.google.gson.annotations.SerializedName
import kotlinx.serialization.Serializable

/**
 * Created by ramesh on 20/01/21.
 */

 class EquipmentListModel {
    var equipmentList : List<EquipmentModel> = listOf(EquipmentModel())
}

 data class EquipmentModel (
     var  id: Int = 0,
     var  vin : String = "",
   var year : Int = 0,
   var make: String = "",
   var value : Double = 0.0,
   var length: Double = 0.0)
 class EquipmentGroupModel{
        var id: Int = 0
        var make: String = ""

 }

 class EquipmentChildModel() {
     var id: Int = 0
     var vin: String = ""
     var year: Int = 0
     var make: String = ""
     var value: Double? = 0.0
     var length: Double? = 0.0
 }