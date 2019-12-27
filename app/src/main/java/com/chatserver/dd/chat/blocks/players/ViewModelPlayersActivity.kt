package com.chatserver.dd.chat.blocks.players

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.chatserver.dd.chat.repository.AppRepository
import retrofit2.HttpException
import java.io.IOException

class ViewModelPlayersActivity(private val eventManager: UIEventManager) : ViewModel() {
    private val repository = AppRepository()
    val liveData = liveData {
        try {
            eventManager.viewProgressBar()

            val receivedData = repository.getStatus()

            eventManager.stopProgressBar()
            eventManager.viewToast("Successfully done")

            if (receivedData.data.p.isEmpty()) {
                eventManager.viewEmptyText()
            } else {
                eventManager.stopEmptyText()
            }

            emit(receivedData)
        } catch (ioException: IOException) {
            eventManager.viewToast("Network Error")
            eventManager.stopProgressBar()
        } catch (httpException: HttpException) {
            eventManager.viewToast("Generic Error")
            eventManager.stopProgressBar()
        }
    }
}
