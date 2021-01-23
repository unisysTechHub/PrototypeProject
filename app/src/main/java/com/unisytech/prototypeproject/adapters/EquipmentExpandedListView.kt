package com.unisytech.prototypeproject.adapters

import android.content.Context
import android.database.DataSetObserver
import android.os.Build
import android.util.Log
import android.view.View
import android.view.ViewGroup
import android.widget.ExpandableListAdapter
import android.widget.ExpandableListView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.constraintlayout.widget.ConstraintLayout
import com.unisytech.prototypeproject.R
import com.unisytech.prototypeproject.model.EquipmentChildModel
import com.unisytech.prototypeproject.model.EquipmentGroupModel
import com.unisytech.prototypeproject.views.checkBox
import com.unisytech.prototypeproject.views.constraintLayout
import com.unisytech.prototypeproject.views.customTextView
import com.unisytech.prototypeproject.views.imageView


/**
 * Created by ramesh on 21/01/21.
 */
enum  class RowType (public val value : Int)
{ ID(0),VID(1),YEAR(2),Make(3),Value(4), Length(5) }

@Suppress("TYPE_INFERENCE_ONLY_INPUT_TYPES_WARNING")
class EquipmentExpandedListViewAdapter  (private  val context : Context, private val equipmentGroup: MutableMap<Int, EquipmentGroupModel> = mutableMapOf(), private val  equipmentExpandableList : MutableMap<Int,MutableMap<Int,EquipmentChildModel>> = mutableMapOf()): ExpandableListAdapter {

    var i  : Long = 100
    var j : Long = 1000
    override fun getChildrenCount(p0: Int): Int {
       return equipmentExpandableList[0]!!.size
    }

    override fun getGroup(p0: Int): EquipmentGroupModel {

     return   equipmentGroup[p0]!!
    }

    override fun onGroupCollapsed(p0: Int) {
    }

    override fun isEmpty(): Boolean {
        return  false
    }

    override fun registerDataSetObserver(p0: DataSetObserver?) {
    }

    override fun getChild(p0: Int, p1: Int): EquipmentChildModel {
     return  equipmentExpandableList[p0]!![p1]!!
    }

    override fun onGroupExpanded(p0: Int) {
    }

    override fun getCombinedChildId(p0: Long, p1: Long): Long {
        var mutableList : MutableMap<Int,MutableMap<Int,EquipmentChildModel>> = mutableMapOf<Int,MutableMap<Int,EquipmentChildModel>>()
         j++
       // return mutableList.get(key = 1)!!.get(key = 1)!!.id.toLong()
    return  j
    }

    override fun getGroupId(p0: Int): Long {
        return equipmentGroup[p0]?.id?.toLong() ?: 0
    }

    override fun isChildSelectable(p0: Int, p1: Int): Boolean {
       return false
    }

    override fun hasStableIds(): Boolean  = true

    override fun getChildView(p0: Int, p1: Int, p2: Boolean, p3: View?, p4: ViewGroup?): View {
        var constraintLayout = constraintLayout(context)

        when (p1)
        {
            RowType.VID.value ->   {
                var vinTextView = customTextView(context)
                vinTextView.id = R.id.child_vid
                vinTextView.text = context.getString(R.string.VIN)
                val lparams = vinTextView.layoutParams as ConstraintLayout.LayoutParams
                lparams.startToStart = constraintLayout.left
                lparams.topToTop = constraintLayout.top
                lparams.bottomToBottom = constraintLayout.bottom
                 vinTextView.layoutParams = lparams
                constraintLayout.addView(vinTextView)


               //  var vinValueTextView = customTextView(context=constraintLayout.context)
                  vinTextView.id = R.id.child_vid_value
               // vinValueTextView.text =   equipmentExpandableList[p0]!![p1]!!.vin
                var valuelparams = vinValueTextView.layoutParams as ConstraintLayout.LayoutParams
                val id  = constraintLayout.findViewById<TextView>(R.id.child_vid).id
                Log.d("Ramesh",id .toString())
                 valuelparams.endToStart = id
//                lparams.topToTop = constraintLayout.top
//                lparams.bottomToBottom = constraintLayout.bottom
//                vinTextView.layoutParams = valuelparams
//
//                constraintLayout.addView(vinValueTextView)



            }
            RowType.YEAR.value ->   {
                var yearTextView = customTextView(context)
                yearTextView.text = context.getString(R.string.YEAR)
                constraintLayout.addView(yearTextView)

                var yearValueTextView = customTextView(context)
                yearValueTextView.text =   equipmentExpandableList[p0]!![p1]!!.year.toString()
                constraintLayout.addView(yearValueTextView)
            }

            RowType.Make.value ->   {
                var makeTextView = customTextView(context)
                makeTextView.text = context.getString(R.string.MAKE)
                constraintLayout.addView(makeTextView)

                var makeValueTextView = customTextView(context)
                makeValueTextView.text =   equipmentExpandableList[p0]!![p1]!!.make
                constraintLayout.addView(makeValueTextView)
            }
            RowType.Value.value ->   {
                var valueTextView = customTextView(context)

                valueTextView.text = context.getString(R.string.VALUE)
                constraintLayout.addView(valueTextView)

                var valueValueTextView = customTextView(context)
                valueValueTextView.text =   equipmentExpandableList[p0]!![p1]!!.value.toString()
                constraintLayout.addView(valueValueTextView)
            }
            RowType.Length.value ->   {
                var lengthTextView = customTextView(context)

                lengthTextView.text = context.getString(R.string.Length)
                constraintLayout.addView(lengthTextView)

                var lengthValueTextView = customTextView(context)
                lengthValueTextView.text =
                    equipmentExpandableList[p0]!![p1]!!.length.toString() +  context.getString(R.string.ft)
                constraintLayout.addView(lengthValueTextView)
            }
        }



        return constraintLayout

    }

    override fun areAllItemsEnabled(): Boolean {
        return  true
    }

    override fun getChildId(p0: Int, p1: Int): Long =
            (equipmentExpandableList[p0]?.get(p1)?.id?.toLong() ?: 0) + (equipmentExpandableList[p0]!![p1]?.id?.toLong()
                    ?: 0)

    override fun getCombinedGroupId(p0: Long): Long {
            var mutableList : MutableMap<Int,MutableMap<Int,EquipmentChildModel>> = mutableMapOf<Int,MutableMap<Int,EquipmentChildModel>>()
        i++
        return   i + 100

    }

    @RequiresApi(Build.VERSION_CODES.O)
    override fun getGroupView(p0: Int, p1: Boolean, p2: View?, p3: ViewGroup?): View {
        //var linearLayout = linerLayout(context)
        var constraintLayout = constraintLayout(context)
        val checkbox = checkBox(context);

        checkbox.setOnCheckedChangeListener{buttonView,  isChecked ->
            run {
                when (isChecked) {
                    true -> {
                        val expandableListView = buttonView.parent.parent as ExpandableListView
                        val groupViewLayout = buttonView.parent as LinearLayout
                        val positionTextView =  groupViewLayout.findViewById<TextView>(R.id.position_group_view)
                        val position = positionTextView.text.toString().toInt()
                        Log.d("@RameshT", position.toString())
                        expandableListView.expandGroup(position)


                    }
                    false -> {
                        val expandableListView = buttonView.parent.parent as ExpandableListView
                        val groupViewLayout = buttonView.parent as LinearLayout
                        val positionTextView =  groupViewLayout.findViewById<TextView>(R.id.position_group_view)
                        val position = positionTextView.text.toString().toInt()
                        Log.d("@RameshT", position.toString())
                        expandableListView.collapseGroup(position)
                    }
                }

            }
        }

        constraintLayout.addView(checkbox,0)
        var idTextView = customTextView(context)
        idTextView.text = equipmentGroup[p0]!!.id.toString()
        constraintLayout.addView(idTextView,1)

        var makeTextView = customTextView(context)
        makeTextView.text = equipmentGroup[p0]!!.make
        constraintLayout.addView(makeTextView,2)

        var positionTextView = customTextView(context)
        positionTextView.text = p0.toString()
        positionTextView.visibility = View.INVISIBLE
        positionTextView.id = R.id.position_group_view
         constraintLayout.addView(positionTextView,3)

        var imageVIew = imageView(context)
        imageVIew.id = R.id.arrow_group_view

        constraintLayout.addView(imageVIew)





        return constraintLayout
    }

    override fun unregisterDataSetObserver(p0: DataSetObserver?) {

    }

    override fun getGroupCount(): Int {
        return  equipmentGroup.size
    }

}