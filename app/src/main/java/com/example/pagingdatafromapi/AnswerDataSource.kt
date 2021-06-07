package com.example.pagingdatafromapi

import androidx.paging.PageKeyedDataSource
import androidx.paging.PagingSource
import com.example.pagingdatafromapi.network.RetrofitSDK
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class AnswerDataSource(private val apiInterface: ApiInterface):PagingSource<Int,Item>() {


    companion object {
        const val PAGE_SIZE=50;
        const val FIRST_PAGE=1;
        const val SITE_NAME = "stackoverflow"
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Item> {
        try {
            val currentLoadingPageKey = params.key ?: 1
            val response = apiInterface.getAnswers(currentLoadingPageKey,pagesize = PAGE_SIZE , site = SITE_NAME)
            val responseData = mutableListOf<Item>()
            val data = response.body()?.items ?: emptyList()
            responseData.addAll(data)

            val prevKey = if (currentLoadingPageKey == 1) null else currentLoadingPageKey - 1

            return LoadResult.Page(
                data = responseData,
                prevKey = prevKey,
                nextKey = currentLoadingPageKey.plus(1)
            )
        } catch (e: Exception) {
            return LoadResult.Error(e)
        }
    }
}