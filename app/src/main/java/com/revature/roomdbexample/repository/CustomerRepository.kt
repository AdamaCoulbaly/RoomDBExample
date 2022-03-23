package com.revature.roomdbexample.repository

import android.app.Application
import androidx.lifecycle.LiveData
import com.revature.roomdbexample.dao.CustomerData
import com.revature.roomdbexample.datamodels.AppDatabase
import com.revature.roomdbexample.datamodels.Customer


class CustomerRepository(application: Application) {
    private lateinit var customerDao:CustomerData
    init{
        var database=AppDatabase.getDatabase(application)
        customerDao = database.customerDao()
    }
    //List all customer
    val readAllCustomers: LiveData<List<Customer>> = customerDao.fetchAllCustomer()

    //Delete customer by Id
    suspend fun deleteCustomerById(id:Int){
        customerDao.deleteCustomerById(id)
    }
    //Insert New Customer
    suspend fun insertCustomer(customer: Customer){
        customerDao.insertCustomer(customer)
    }
}