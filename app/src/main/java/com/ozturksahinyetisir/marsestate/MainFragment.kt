package com.ozturksahinyetisir.marsestate

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ozturksahinyetisir.marsestate.databinding.FragmentMainBinding
import com.ozturksahinyetisir.marsestate.views.RealEstateModel
import com.ozturksahinyetisir.marsestate.views.RecyclerAdapter
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class MainFragment() : Fragment() {
    private val marsApi = MarsApi()
    private var recyclerAdapter: RecyclerAdapter? = null
    private lateinit var binding: FragmentMainBinding
    private var realEstateModel: ArrayList<RealEstateModel>? = null
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentMainBinding.inflate(layoutInflater)

        return binding.root

    }

    /**
     * onViewCreated function create GridLayout recyclerView and change spanCounts & Vertical-Horizontal from here.
     * activity?let{ activity -> get activity and after run this function.
     */
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        getData()
        activity?.let{
            activity->
            val layoutManager: RecyclerView.LayoutManager = GridLayoutManager(
                activity.applicationContext,
                2,
                GridLayoutManager.VERTICAL,
                false
            )
            binding.grids.layoutManager = layoutManager

        }

    }

    /**
     * [getData] get api data and call it. if response is successful let all recyclerview items run.
     * if response is failure gets Error LOG.
     */
    fun getData() {
        val call = marsApi.getMarsData()
        call.enqueue(object : Callback<List<RealEstateModel>> {
            override fun onResponse(
                call: Call<List<RealEstateModel>>,
                response: Response<List<RealEstateModel>>
            ) {
                if (response.isSuccessful) {
                    response.body().let {
                        realEstateModel = ArrayList(it)
                        realEstateModel?.let {
                            activity?.let { activity->
                                recyclerAdapter = RecyclerAdapter(activity,realEstateModel!!)
                                binding.grids.adapter = recyclerAdapter
                            }


                        }
                    }
                }
            }

            override fun onFailure(call: Call<List<RealEstateModel>>, t: Throwable) {
                Log.v("API Failure", t.message.toString())
            }

        })


    }
}

