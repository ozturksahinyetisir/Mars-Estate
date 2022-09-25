package com.ozturksahinyetisir.marsestate.views

import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import com.ozturksahinyetisir.marsestate.BR
import com.ozturksahinyetisir.marsestate.databinding.RecyclerItemBinding


class RealEstateModelViewHolder(realEstateBinding: ViewDataBinding): RecyclerView.ViewHolder(realEstateBinding.root) {

    fun onBind(realEstateModel: RealEstateModel){
        val binding = realEstateModel as RecyclerItemBinding
        binding.setVariable(BR.RealEstateModel,realEstateModel)
    }

}