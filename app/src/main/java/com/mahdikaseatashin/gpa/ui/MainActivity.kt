package com.mahdikaseatashin.gpa.ui

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.mahdikaseatashin.gpa.adapter.NodesAdapter
import com.mahdikaseatashin.gpa.adapter.RecyclerItemClickListener
import com.mahdikaseatashin.gpa.api.RetrofitService
import com.mahdikaseatashin.gpa.databinding.ActivityMainBinding
import com.mahdikaseatashin.gpa.repository.MainRepository
import com.mahdikaseatashin.gpa.viewmodel.MainViewModel
import com.mahdikaseatashin.gpa.viewmodel.MyViewModelFactory
import timber.log.Timber


class MainActivity : AppCompatActivity() {
    lateinit var viewModel: MainViewModel
    private val adapter = NodesAdapter()
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val retrofitService = RetrofitService.getInstance()
        val mainRepository = MainRepository(retrofitService)

        binding.rvReposMain.adapter = adapter
        viewModel = ViewModelProvider(this, MyViewModelFactory(mainRepository)).get(MainViewModel::class.java)
        viewModel.nodeList.observe(this, {
            adapter.setNodes(it)
            binding.rvReposMain.addOnItemTouchListener(
                RecyclerItemClickListener(
                    this,
                    binding.rvReposMain,
                    object : RecyclerItemClickListener.OnItemClickListener {
                        override fun onItemClick(view: View?, position: Int) {
                            // do whatever
                            val intent = Intent(this@MainActivity,DetailsActivity::class.java)
                            intent.putExtra("selected_node", it[position])
                            startActivity(intent)
                        }

                        override fun onLongItemClick(view: View?, position: Int) {
                            // do whatever
                        }
                    })
            )
        })

        viewModel.errorMessage.observe(this, {
            Toast.makeText(this, it, Toast.LENGTH_SHORT).show()
        })

        viewModel.loading.observe(this, Observer {
            if (it) {
                binding.pbLoadingMain.visibility = View.VISIBLE
            } else {
                binding.pbLoadingMain.visibility = View.GONE
            }
        })

        viewModel.getAllMovies()
    }

//    override fun onResume() {
//        super.onResume()
//        viewModel.getAllMovies()
//    }


}
