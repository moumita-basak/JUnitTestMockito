package com.infosys.junittestmockito.data


import com.infosys.junittestmockito.model.ItemRow
import com.infosys.junittestmockito.model.ItemDataSource
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class ItemRemoteDataSource(apiClient: ApiClient) : ItemDataSource {

    private var call: Call<ItemResponse>? = null
    private val service = apiClient.build()

    override fun retrieveItems(callback: OperationCallback<ItemRow>) {

        call = service.items()
        call?.enqueue(object : Callback<ItemResponse> {
            override fun onFailure(call: Call<ItemResponse>, t: Throwable) {
                callback.onError(t.message)
            }

            override fun onResponse(
                call: Call<ItemResponse>,
                response: Response<ItemResponse>
            ) {
                response.body()?.let {
                    if (response.isSuccessful && (it.isSuccess())) {
                        callback.onSuccess(it.data)
                    } else {
                        callback.onError(it.msg)
                    }
                }
            }
        })
    }

    override fun cancel() {
        call?.cancel()
    }
}