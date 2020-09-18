package com.androidtest.wymo.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.androidtest.wymo.R
import com.androidtest.wymo.databinding.FragmentDetailsBinding
import com.androidtest.wymo.model.Data
import kotlinx.android.synthetic.main.fragment_details.*

class BankDetailFragment: Fragment() {
    private lateinit var binding: FragmentDetailsBinding
    private lateinit var data: Data

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDetailsBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //get with parcelable
        data = arguments?.getParcelable(getString(R.string.key_transfer))!!

        //set up data to view
        tv_bank_name.text = "Bank Name - ${data.name}"
        if(!data.description.isNullOrEmpty()) tv_description.text = "Description - ${data.description}" else tv_description.text = "Description - No data"
        tv_type.text = "Type - ${data.type}"

        if(!data.maxAmount.isNullOrEmpty()) tv_max_amount.text = "Max Amount - ${data.maxAmount} MMK" else tv_max_amount.text = "Max Amount - 0 MMK"
        tv_created_date.text = "Created Date - ${data.created_at}"
        tv_updated_date.text = "Updated Date - ${data.updated_at}"
    }
}