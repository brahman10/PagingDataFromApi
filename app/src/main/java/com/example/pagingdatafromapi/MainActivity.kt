package com.example.pagingdatafromapi

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch


class MainActivity : AppCompatActivity() {
    lateinit var answerViewModel:AnswerViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        answerViewModel =
            ViewModelProvider(
                this,
                AnswerViewModelFactory(ApiInterface.getApiService()!!)
            )[AnswerViewModel::class.java]
        val itemadapter = ItemAdapter()
        recycler.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = itemadapter

        }

        lifecycleScope.launch {
            answerViewModel.listData.collect {
                itemadapter.submitData(it)
            }
        }


    }
}