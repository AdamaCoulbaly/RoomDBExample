package com.revature.roomdbexample.viewmodels

import android.app.Application
import androidx.lifecycle.*
import com.revature.roomdbexample.MainActivity
import com.revature.roomdbexample.dao.CustomerData
import com.revature.roomdbexample.datamodels.Customer
import com.revature.roomdbexample.repository.CustomerRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.lang.IllegalArgumentException

class CustomerViewModel(appObj: Application): AndroidViewModel(appObj){
    private val customerRepository: CustomerRepository = CustomerRepository(appObj)

    fun fetchAllCustomer(): LiveData<List<Customer>> {
        return customerRepository.readAllCustomers
    }
    fun insertCustomer(customer: Customer){
        viewModelScope.launch{
            customerRepository.insertCustomer(customer)
        }
    }
    fun deleteCustomerById(id:Int){
        viewModelScope.launch{
            customerRepository.deleteCustomerById(id)
        }
    }
}