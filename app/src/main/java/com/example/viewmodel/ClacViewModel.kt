package com.example.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ClacViewModel : ViewModel() {
     private val _average = MutableLiveData<Int>()
     val average  : LiveData<Int>
     get() = _average

     fun calcAverage(value1 : Int ,value2 : Int , value3 : Int ){
          _average.value = (value1+value2+value3)/3

     }
  
}