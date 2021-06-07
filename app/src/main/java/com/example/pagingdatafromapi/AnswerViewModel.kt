package com.example.pagingdatafromapi

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.*


class AnswerViewModel(private val apiService: ApiInterface) : ViewModel(){
    val listData = Pager(PagingConfig(pageSize = 50)) {
        AnswerDataSource(apiService)
    }.flow.cachedIn(viewModelScope)
}