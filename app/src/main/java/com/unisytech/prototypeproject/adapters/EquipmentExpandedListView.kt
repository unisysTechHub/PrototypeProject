package com.unisytech.prototypeproject.adapters

import android.content.Context
import android.database.DataSetObserver
import android.os.Build
import android.util.Log
import android.view.View
import android.view.ViewGroup
import android.widget.*
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

                var vinValueTextView = customTextView(context=constraintLayout.context)
                vinValueTextView.id = R.id.child_vid_value
                vinValueTextView.text =   equipmentExpandableList[p0]!![p1]!!.vin
                var valuelparams = vinValueTextView.layoutParams as ConstraintLayout.LayoutParams
                 valuelparams.leftToRight = vinTextView.id
                valuelparams.topToTop = constraintLayout.top
                valuelparams.bottomToBottom = constraintLayout.bottom
                vinValueTextView.layoutParams = valuelparams
               constraintLayout.addView(vinValueTextView)



            }
            RowType.YEAR.value ->   {
                var yearTextView = customTextView(context)
                yearTextView.id = R.id.child_year_id_label
                yearTextView.text = context.getString(R.string.YEAR)
                val lparams = yearTextView.layoutParams as ConstraintLayout.LayoutParams
                lparams.startToStart = constraintLayout.left
                lparams.topToTop = constraintLayout.top
                lparams.bottomToBottom = constraintLayout.bottom
                yearTextView.layoutParams = lparams
                constraintLayout.addView(yearTextView)

                var yearValueTextView = customTextView(context)
                yearValueTextView.id = R.id.child_year_id_value
                yearValueTextView.text =   equipmentExpandableList[p0]!![p1]!!.year.toString()
                var valuelparams = yearValueTextView.layoutParams as ConstraintLayout.LayoutParams
                valuelparams.leftToRight = yearTextView.id
                valuelparams.topToTop = constraintLayout.top
                valuelparams.bottomToBottom = constraintLayout.bottom
                yearValueTextView.layoutParams = valuelparams
                constraintLayout.addView(yearValueTextView)
            }

            RowType.Make.value ->   {
                var makeTextView = customTextView(context)
                makeTextView.text = context.getString(R.string.MAKE)
                makeTextView.id = R.id.child_make_label
                val lparams = makeTextView.layoutParams as ConstraintLayout.LayoutParams
                lparams.startToStart = constraintLayout.left
                lparams.topToTop = constraintLayout.top
                lparams.bottomToBottom = constraintLayout.bottom
                makeTextView.layoutParams = lparams
                constraintLayout.addView(makeTextView)

                var makeValueTextView = customTextView(context)
                makeValueTextView.id = R.id.child_make_value
                makeValueTextView.text =   equipmentExpandableList[p0]!![p1]!!.make
                var valuelparams = makeValueTextView.layoutParams as ConstraintLayout.LayoutParams
                valuelparams.leftToRight = makeTextView.id
                valuelparams.topToTop = constraintLayout.top
                valuelparams.bottomToBottom = constraintLayout.bottom
                makeValueTextView.layoutParams = valuelparams
                constraintLayout.addView(makeValueTextView)
            }
            RowType.Value.value ->   {
                var valueTextView = customTextView(context)
                valueTextView.id = R.id.child_eqp_value_label
                valueTextView.text = context.getString(R.string.VALUE)
                val lparams = valueTextView.layoutParams as ConstraintLayout.LayoutParams
                lparams.startToStart = constraintLayout.left
                lparams.topToTop = constraintLayout.top
                lparams.bottomToBottom = constraintLayout.bottom
                valueTextView.layoutParams = lparams
                constraintLayout.addView(valueTextView)

                var valueValueTextView = customTextView(context)
                valueValueTextView.id = R.id.child_eqp_value
                valueValueTextView.text =   equipmentExpandableList[p0]!![p1]!!.value.toString()
                var valuelparams = valueValueTextView.layoutParams as ConstraintLayout.LayoutParams
                valuelparams.leftToRight = valueTextView.id
                valuelparams.topToTop = constraintLayout.top
                valuelparams.bottomToBottom = constraintLayout.bottom
                valueValueTextView.layoutParams = valuelparams
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
        checkbox.isClickable = false
        var checkboxLayoutparams = checkbox.layoutParams as ConstraintLayout.LayoutParams
        checkboxLayoutparams.startToStart = constraintLayout.left
        checkboxLayoutparams.topToTop = constraintLayout.top
        checkboxLayoutparams.bottomToBottom = constraintLayout.bottom
        checkbox.isChecked = false
        constraintLayout.addView(checkbox)

        var idTextView = customTextView(context)
        idTextView.id = R.id.group_id
        idTextView.text = equipmentGroup[p0]!!.id.toString()
        var idTextViewLayoutparams = idTextView.layoutParams as ConstraintLayout.LayoutParams
        idTextViewLayoutparams.leftToRight = checkbox.id
        idTextViewLayoutparams.topToTop = constraintLayout.top
        idTextViewLayoutparams.bottomToBottom = constraintLayout.bottom
        constraintLayout.addView(idTextView)

        var makeTextView = customTextView(context)
        makeTextView.text = equipmentGroup[p0]!!.make
        var makeTextViewLayoutparams = idTextView.layoutParams as ConstraintLayout.LayoutParams
        makeTextViewLayoutparams.leftToRight = idTextView.id
        makeTextViewLayoutparams.topToTop = constraintLayout.top
        makeTextViewLayoutparams.bottomToBottom = constraintLayout.bottom
        constraintLayout.addView(makeTextView)


        var positionTextView = customTextView(context)
        positionTextView.id = R.id.group_position
        var posTextViewLayoutparams = idTextView.layoutParams as ConstraintLayout.LayoutParams
        posTextViewLayoutparams.leftToRight = makeTextView.id
        posTextViewLayoutparams.topToTop = constraintLayout.top
        posTextViewLayoutparams.bottomToBottom = constraintLayout.bottom
        positionTextView.text = p0.toString()
        positionTextView.visibility = View.INVISIBLE
         constraintLayout.addView(positionTextView)

        var imageVIew = imageView(context)
        imageVIew.id = R.id.arrow_group_view
        var imageViewLayoutparams = imageVIew.layoutParams as ConstraintLayout.LayoutParams
        imageViewLayoutparams.rightToRight = constraintLayout.right
        posTextViewLayoutparams.topToTop = constraintLayout.top
        posTextViewLayoutparams.bottomToBottom = constraintLayout.bottom
        imageVIew.setOnClickListener{ imageView ->
            run {
                val expandableListView = imageView.parent.parent as ExpandableListView
                val groupViewLayout = imageVIew.parent as LinearLayout
                val positionTextView =  groupViewLayout.findViewById<TextView>(R.id.group_position)
                val position = positionTextView.text.toString().toInt()
                var checkbox = groupViewLayout.findViewById<CheckBox>(R.id.group_checkbox)
                when (expandableListView.isGroupExpanded(position)) {
                    true -> {
                        Log.d("@RameshT", position.toString())
                        expandableListView.collapseGroup(position)
                        checkbox.isChecked = false
                        imageView.setBackgroundResource(R.drawable.ic_arrow_right)

                    }
                    false -> {

                        Log.d("@RameshT", position.toString())
                        expandableListView.expandGroup(position)
                        checkbox.isChecked = true
                        imageView.setBackgroundResource(R.drawable.ic_arrow_down)

                    }
                }

            }
        }
        constraintLayout.addView(imageVIew)





        return constraintLayout
    }

    override fun unregisterDataSetObserver(p0: DataSetObserver?) {

    }

    override fun getGroupCount(): Int {
        return  equipmentGroup.size
    }

}