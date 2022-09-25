package com.ozturksahinyetisir.marsestate.views


import android.content.Context
import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import com.ozturksahinyetisir.marsestate.DetailActivity
import com.ozturksahinyetisir.marsestate.R
import com.ozturksahinyetisir.marsestate.databinding.RecyclerItemBinding

import com.squareup.picasso.Picasso


class RecyclerAdapter(val context: Context, val realEstateModel: List<RealEstateModel>) :
    RecyclerView.Adapter<RecyclerAdapter.RealEstateModelViewHolder>() {
    val TAG = "RecyclerAdapter"


    /**
     * onCreateViewHolder get recycler_item layout & items recyclerview.
     */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RealEstateModelViewHolder {
        val realEstateBinding = DataBindingUtil.inflate<ViewDataBinding>(
            LayoutInflater.from(context), R.layout.recycler_item, parent, false
        )
        return RealEstateModelViewHolder(RecyclerItemBinding.inflate(LayoutInflater.from(parent.context)))
    }

    /**
     * onBindViewHolder function getItem and binds it.
     * holder marsText.text & marsPrice.text set new prices and "id" with position.
     *
     * Picasso gget img_src from realEstateModel & placeholder loading icon at loading, error icon if failure. If successful set img_src into marsImage.
     */
    override fun onBindViewHolder(holder: RealEstateModelViewHolder, position: Int) {

        val item = realEstateModel[position]
        holder.marsText.text = item.id.toString()
        holder.marsPrice.text = item.price.toString()

        Picasso.get()
            .load(item.img_src)
            .placeholder(R.drawable.loading)
            .error(R.drawable.error)
            .into(holder.marsImage)


        /**
         * @param setOnClickListener click at itemView open new fragment "detailFragment" front of firstFragment.
         * @param putExtra sends item types to MainActivity or getting another Activity.
         * startActivity(intent) starts DetailActivity.
         */

        holder.itemView.setOnClickListener {
            Log.e(TAG, "onBindViewHolder: click ${item.id}")
            val intent = Intent(context, DetailActivity::class.java)
            val intprice = item.price.toString()

            intent.putExtra("id",item.id)
            intent.putExtra("img",item.img_src)
            intent.putExtra("price",intprice)
            intent.putExtra("type",item.type)
            context.startActivity(intent)

        }


    }


    override fun getItemCount(): Int {
        return realEstateModel.count()
    }

    /**
     * [marsImage] & [marsText] & [marsPrice] binding items using at onBindViewHolder
     */
    inner class RealEstateModelViewHolder(recyclerItemBinding: RecyclerItemBinding) :
        RecyclerView.ViewHolder(recyclerItemBinding.root) {

        val marsImage = recyclerItemBinding.marsImage
        val marsText = recyclerItemBinding.marsText
        val marsPrice = recyclerItemBinding.marsPrice



    }

}

