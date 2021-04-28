package com.infosys.junittestmockito.data


import com.infosys.junittestmockito.model.Museum
import com.infosys.junittestmockito.model.MuseumDataSource
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

/**
 * @author Eduardo Medina
 */
class MuseumRemoteDataSource(apiClient: ApiClient) : MuseumDataSource {

    private var call: Call<MuseumResponse>? = null
    private val service = apiClient.build()

    override fun retrieveMuseums(callback: OperationCallback<Museum>) {

        call = service?.museums()
        call?.enqueue(object : Callback<MuseumResponse> {
            override fun onFailure(call: Call<MuseumResponse>, t: Throwable) {
                callback.onError(t.message)
            }

            override fun onResponse(
                call: Call<MuseumResponse>,
                response: Response<MuseumResponse>
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
        call?.let {
            it.cancel()
        }
    }
}