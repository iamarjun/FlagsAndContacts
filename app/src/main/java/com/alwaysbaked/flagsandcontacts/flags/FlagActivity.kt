package com.alwaysbaked.flagsandcontacts.flags

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import com.alwaysbaked.flagsandcontacts.R
import com.alwaysbaked.flagsandcontacts.flags.dependencyinjection.API
import com.alwaysbaked.flagsandcontacts.flags.dependencyinjection.DaggerNetComponent
import com.alwaysbaked.flagsandcontacts.flags.dependencyinjection.NetModule
import com.alwaysbaked.flagsandcontacts.flags.model.Root
import com.alwaysbaked.flagsandcontacts.flags.retrofit.APIService
import com.alwaysbaked.flagsandcontacts.flags.util.Adapter
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_flag.*
import retrofit2.Retrofit
import javax.inject.Inject

class FlagActivity : AppCompatActivity() {
    companion object {
        private const val TAG = "FlagActivity"
    }

    private val apiServe by lazy {
        APIService.create()
    }

    @Inject
    lateinit var retrofit: Retrofit


    private var disposable: Disposable? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_flag)
        Log.d(TAG, "onCreate: started.")

        injectDependency()

        //recycler view
        rvFeed.layoutManager = LinearLayoutManager(this)

        fetch()

    }

    private fun fetch() {
        Log.d(TAG, "fetch: started.")

        val api: API = retrofit.create(API::class.java)
        disposable = api.theWorldPopulation
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe { root ->
                    displayData(root)
                }

    }

    private fun displayData(root: Root) {
        val adapter = Adapter(this, root.worldpopulation)
        rvFeed.adapter = adapter
    }

    override fun onPause() {
        super.onPause()
        disposable?.dispose()
    }

    private fun injectDependency() {
        Log.d(TAG, "injectDependency: started.")

        val  netComponent = DaggerNetComponent
                .builder()
                .netModule(NetModule())
                .build()

        netComponent.inject(this)

    }
}
