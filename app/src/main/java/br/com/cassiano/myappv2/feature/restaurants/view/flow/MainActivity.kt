package br.com.cassiano.myappv2.feature.restaurants.view.flow

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import br.com.cassiano.myappv2.R
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    private val viewModel: MainViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        viewModel.setup()
    }
}