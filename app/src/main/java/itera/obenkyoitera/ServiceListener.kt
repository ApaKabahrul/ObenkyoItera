package itera.obenkyoitera

import java.io.File

interface ServiceListener {
    fun loggedIn() //Authentikasi Pengguna Sukses
    fun fileDownloaded(file: File) //File sukses dipiilih dan di-download
    fun cancelled() //Login dan file di cancel
    fun handleError(exception: Exception) //Jika error
}