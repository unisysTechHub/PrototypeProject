package com.unisytech.prototypeproject.converters

import android.util.Log
import com.unisytech.prototypeproject.model.EquipmentChildModel
import com.unisytech.prototypeproject.model.EquipmentGroupModel
import com.unisytech.prototypeproject.model.EquipmentModel
import java.util.*
import java.util.concurrent.atomic.AtomicInteger

/**
 * Created by ramesh on 21/01/21.
 */

//fun <GroupId , ChildId ,
//        EquipmentExpandableListGroup ,
//        EquipmentExpandableListChildGroup ,
//        EquipmentExpandableList : MutableMap<GroupId,EquipmentExpandableListChildGroup>> convert(equipmentList : List<EquipmentModel>) : Pair<MutableMap<Int,EquipmentGroupModel>,MutableMap<Int,MutableMap<Int,EquipmentChildModel>>> {

fun  convert(equipmentList : List<EquipmentModel>) : Pair<MutableMap<Int,EquipmentGroupModel>,MutableMap<Int,MutableMap<Int,EquipmentChildModel>>> {
    val equipmentGroup  = mutableMapOf<Int,EquipmentGroupModel>()

    val equipmentExpandableList  = mutableMapOf<Int,MutableMap<Int,EquipmentChildModel>>()
    val groupCount  = AtomicInteger(0)
    equipmentList.forEach( ) {
        equipmentModel ->
        run {
            val groupChildPair = convert(equipment = equipmentModel)
            equipmentGroup[groupCount.get() ] = groupChildPair.first
            equipmentExpandableList[ groupCount.get() ] = groupChildPair.second

        }
        groupCount.getAndIncrement()

    }

    return  Pair(equipmentGroup,equipmentExpandableList)
}

fun convert(equipment : EquipmentModel) : Pair<EquipmentGroupModel,   MutableMap<Int,EquipmentChildModel> > {
    Log.d("@Ramesh", equipment.id.toString())

    var equipmentChildModel  = EquipmentChildModel()
    var equipmentGroupModel  = EquipmentGroupModel()
    var equipmentChildGroup  = mutableMapOf<Int,EquipmentChildModel>()

    equipmentChildModel.apply { id = equipment.id
                                vin = equipment.vin
                                year = equipment.year
                                length = equipment.length
                                value = equipment.value
                                make = equipment.make
    }
    equipmentGroupModel.apply { id = equipment.id
                                make = equipment.make}
    Log.d("@Ramesh1", equipmentGroupModel.id.toString())

    var declaredFiedsInChildModelClass = EquipmentChildModel::class.java.declaredFields
    var noOfPropsInChildModel = declaredFiedsInChildModelClass.size
    Log.d("@Ramesh properties", noOfPropsInChildModel.toString())
    for ( index : Int  in 0 until noOfPropsInChildModel) {

         equipmentChildGroup[index ] = equipmentChildModel
    }
    return  Pair(equipmentGroupModel,equipmentChildGroup)

}



