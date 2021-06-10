package com.mahdikaseatashin.gpa.ui

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.mahdikaseatashin.gpa.BuildConfig
import com.mahdikaseatashin.gpa.adapter.NodesAdapter
import com.mahdikaseatashin.gpa.adapter.RecyclerItemClickListener
import com.mahdikaseatashin.gpa.databinding.ActivityMainBinding
import com.mahdikaseatashin.gpa.utils.ConnectionType
import com.mahdikaseatashin.gpa.utils.Constants
import com.mahdikaseatashin.gpa.utils.NetworkMonitorUtil
import com.mahdikaseatashin.gpa.viewmodel.MainViewModel
import com.mahdikaseatashin.gpa.viewmodel.MyViewModelFactory
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.dsl.module
import timber.log.Timber

val activityModule = module {
    factory { MainActivity() }
}

class MainActivity : AppCompatActivity() {
    private val networkMonitor = NetworkMonitorUtil(this)
    val mainViewModel: MainViewModel by viewModel()
    private val adapter = NodesAdapter()
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
//        val retrofitService = RetrofitService.getInstance()
//        val mainRepository = MainRepository(retrofitService)

        binding.rvReposMain.adapter = adapter
        mainViewModel.nodeList.observe(this, {
            adapter.setNodes(it)
            binding.rvReposMain.addOnItemTouchListener(
                RecyclerItemClickListener(
                    this,
                    binding.rvReposMain,
                    object : RecyclerItemClickListener.OnItemClickListener {
                        override fun onItemClick(view: View?, position: Int) {
                            // do whatever
                            val intent = Intent(this@MainActivity, DetailsActivity::class.java)
                            intent.putExtra(Constants.SELECTED_NODE_KEY, it[position])
                            startActivity(intent)
                        }

                        override fun onLongItemClick(view: View?, position: Int) {
                            // do whatever
                        }
                    })
            )
        })

        mainViewModel.errorMessage.observe(this, {
            Toast.makeText(this, it, Toast.LENGTH_SHORT).show()
        })

        mainViewModel.loading.observe(this, {
            if (it) {
                binding.pbLoadingMain.visibility = View.VISIBLE
            } else {
                binding.pbLoadingMain.visibility = View.GONE
            }
        })
        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }
        Timber.e("timber test")

        checkInternetConnection()
    }

    private fun checkInternetConnection() {
        networkMonitor.result = { isAvailable, type ->
            when (isAvailable) {
                true -> {
                    when (type) {
                        ConnectionType.Wifi -> {
                            Timber.e("Wifi Connection")
                            mainViewModel.getAllNodes()
                            networkMonitor.unregister()
                        }

                        ConnectionType.Cellular -> {
                            Timber.e("Cellular Connection")
                            mainViewModel.getAllNodes()
                            networkMonitor.unregister()
                        }
                        else -> {}
                    }
                }
                false -> {
                    Toast.makeText(this, "No internet!", Toast.LENGTH_SHORT).show()
                    Timber.e("No Connection")
                }
            }
        }
    }

    override fun onResume() {
        super.onResume()
        networkMonitor.register()
    }

}
