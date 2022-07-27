package com.udacity.shoestore.fragment

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.LinearLayout
import androidx.databinding.DataBindingUtil
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.ItemShoeListBindingImpl
import com.udacity.shoestore.models.Shoe
import kotlinx.android.synthetic.main.item_shoe_list.view.*

class ShoeLayout:LinearLayout {
    constructor(context: Context?) : super(context)
    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs)
    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr)

    private val binding: ItemShoeListBindingImpl = DataBindingUtil.inflate(LayoutInflater.from(context), R.layout.item_shoe_list, this, false)
    fun loadShoes(shoe: Shoe) {
        binding.apply {
            addView(this.root)
            shoe_name.text = shoe.name
            company_name.text = shoe.company
            shoe_size.text = shoe.size.toString()
            description.text = shoe.description
        }
    }
}