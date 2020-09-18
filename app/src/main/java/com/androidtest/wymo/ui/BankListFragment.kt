package com.androidtest.wymo.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.androidtest.wymo.R
import com.androidtest.wymo.databinding.FragmentBankBinding
import com.androidtest.wymo.model.Data
import com.androidtest.wymo.network.Resource
import com.androidtest.wymo.viewmodel.BankViewModel
import kotlinx.android.synthetic.main.fragment_bank.*

class BankListFragment: Fragment(),BankListAdapter.ItemClickListener {
    private lateinit var binding: FragmentBankBinding
    private val viewModel: BankViewModel by activityViewModels()
    private lateinit var manager: RecyclerView.LayoutManager
    private lateinit var adapter: BankListAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentBankBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        getAllBankList()
    }

    private fun getAllBankList() {
        viewModel.getBankList().observe(viewLifecycleOwner, Observer {
            when(it.status) {
                Resource.Status.ERROR -> {
                    //show error dialog or snack bar
                    Toast.makeText(context,"error",Toast.LENGTH_SHORT).show()
                }
                Resource.Status.LOADING -> {
                    //show progress bar
                    tv_loading.isVisible = true
                    progress_bar.isVisible = true
                }
                Resource.Status.SUCCESS -> {
                    tv_loading.isVisible = false
                    progress_bar.isVisible = false

                    //success state
                    if(it.data != null) {
                        manager = LinearLayoutManager(context)
                        adapter = BankListAdapter(it?.data?.data as ArrayList<Data>,this)
                        rv_bank_list.layoutManager = manager
                        rv_bank_list.setHasFixedSize(true)
                        rv_bank_list.adapter = adapter
                    }
                }
            }
        })
    }

    override fun onItemClick(position: Int,data: Data) {
        this.findNavController().navigate(R.id.action_bank_to_details, bundleOf(getString(R.string.key_transfer) to data))
    }
}