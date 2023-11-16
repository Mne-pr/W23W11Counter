package kr.ac.kumoh.ce.s20190622.w23w11counter

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class CounerViewModel : ViewModel() {
    private val _count = MutableLiveData(0)
    val count: LiveData<Int> = _count

    fun onAdd(){
        if((_count.value ?: 0) > 0) // !!와 비슷한처리
            _count.value = _count.value!! + 1
    }
}