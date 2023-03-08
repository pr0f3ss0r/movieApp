package com.example.moviedatabaseapp.presentation.tvshow

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.moviedatabaseapp.R
import com.example.moviedatabaseapp.data.model.tvshow.TvShow
import com.example.moviedatabaseapp.databinding.ActivityTvShowBinding
import com.example.moviedatabaseapp.presentation.di.Injector
import javax.inject.Inject

class TvShowActivity : AppCompatActivity() {
    @Inject
    lateinit var factory: TvShowViewModelFactory
    lateinit var tvShowViewModel: TvShowViewModel
    private lateinit var binding: ActivityTvShowBinding
    private lateinit var adapter: TvShowAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_tv_show)
        (application as Injector).createTvShowSubcomponent().inject(this)
        tvShowViewModel = ViewModelProvider(this, factory)
            .get(TvShowViewModel::class.java)
        initRecyclerView()
    }

    private fun initRecyclerView(){
        binding.tvShowRecyclerView.layoutManager = LinearLayoutManager(this)
        adapter = TvShowAdapter()
        binding.tvShowRecyclerView.adapter = adapter
        displayPopularTvShows()
    }

    private fun displayPopularTvShows(){

        val responseLiveDate: LiveData<List<TvShow>?> = tvShowViewModel.getTvShow()
        responseLiveDate.observe(this, Observer {
            if (it != null){
                adapter.setlist(it)
                adapter.notifyDataSetChanged()
            }else{
                Toast.makeText(this, "No Data Available", Toast.LENGTH_SHORT).show()

            }
        })
    }
}