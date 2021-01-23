package com.unisytech.prototypeproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ExpandableListView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.unisytech.prototypeproject.adapters.EquipmentExpandedListViewAdapter
import com.unisytech.prototypeproject.converters.convert
import com.unisytech.prototypeproject.viewModels.EquipmentListViewModel
import com.unisytech.prototypeproject.model.EquipmentModel
import com.unisytech.prototypeproject.viewModels.Result
import com.unisytech.prototypeproject.viewmodelproviders.AppViewModelProviderFactory


class MainActivity : AppCompatActivity() {
    private var equipmentListViewModel : EquipmentListViewModel? = null
    private lateinit var expandableListView : ExpandableListView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        expandableListView = findViewById<ExpandableListView>(R.id.expandable_list_view)

        Log.d("@Ramesh ", "oncreate")
        getReferenceToEquipmentListViewModel()
        addObserverToEquipmentListLiveData()
    }
    private  fun getReferenceToEquipmentListViewModel() {
        equipmentListViewModel = ViewModelProvider(this, AppViewModelProviderFactory()).get(EquipmentListViewModel::class.java)

    }

    private  fun addObserverToEquipmentListLiveData() {
        equipmentListViewModel?.equipmentModelLivdata?.observe(this, equipmentModelListObserver())
    }
    private fun equipmentModelListObserver() = Observer<Result<List<EquipmentModel>>> { result ->
        Log.d("@Ramesh", "Livedata observer")
        when (result) {
           is Result.Success -> {
               Log.d("@Ramesh", "success")
               val equipmentListPair = convert(equipmentList =  result.data )
               val adapter  =  EquipmentExpandedListViewAdapter(context = this,equipmentGroup = equipmentListPair.first, equipmentExpandableList = equipmentListPair.second )
               expandableListView.setAdapter(adapter)
           }
           is Result.Error  ->  print("Error")

        }
    }

}





