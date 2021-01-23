package com.unisytech.prototypeproject.viewmodelproviders

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.unisytech.prototypeproject.viewModels.EquipmentListViewModel

/**
 * Created by ramesh on 20/01/21.
 */

class AppViewModelProviderFactory : ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel?> create(modelClass: Class<T>) : T {
        try {
            if (modelClass.isAssignableFrom(EquipmentListViewModel::class.java)) {
                return modelClass.newInstance()
            }
        } catch (e: IllegalAccessException) {
            e.printStackTrace()
        } catch (e: InstantiationException) {
            e.printStackTrace()
        }
        return this.create(modelClass)
    }
}
