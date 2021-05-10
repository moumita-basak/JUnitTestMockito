package com.infosys.junittestmockito.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import com.infosys.junittestmockito.R
import com.infosys.junittestmockito.databinding.ActivityMainBinding
import com.infosys.junittestmockito.di.Injection
import com.infosys.junittestmockito.model.ItemRow
import com.infosys.junittestmockito.viewmodel.ItemViewModel
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.layout_error.*

class MainActivity : AppCompatActivity() {
    private lateinit var activityMainBinding: ActivityMainBinding

    private lateinit var viewModel: ItemViewModel
    private lateinit var adapter: ItemsAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        activityMainBinding = DataBindingUtil.setContentView(this@MainActivity, R.layout.activity_main)

        setupViewModel()
        setupUI()
    }
    private fun setupUI() {
        adapter = ItemsAdapter(viewModel.itemResponse.value ?: emptyList(),this@MainActivity)
        activityMainBinding.recyclerView.layoutManager = LinearLayoutManager(this)
        activityMainBinding.recyclerView.itemAnimator = DefaultItemAnimator()
        activityMainBinding.recyclerView.adapter = adapter
    }
    private fun setupViewModel() {
        viewModel = ViewModelProvider(
            this,
            Injection.provideViewModelFactory()
        ).get(ItemViewModel::class.java)

        viewModel.itemResponse.observe(this,renderItems)

    }

    //observers
    private val renderItems = Observer<List<ItemRow>> {
        Log.v(TAG, "data updated $it")
        layoutError.visibility = View.GONE
        layoutEmpty.visibility = View.GONE
        adapter.update(it)
    }



    override fun onResume() {
        super.onResume()

        viewModel.getItemData()
    }

    companion object {
        const val TAG = "CONSOLE"
    }
}