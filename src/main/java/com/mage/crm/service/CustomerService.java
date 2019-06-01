package com.mage.crm.service;

import com.mage.crm.dao.CustomerDao;
import com.mage.crm.vo.Customer;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {
  @Resource
  private CustomerDao customerDao;
  public List<Customer> queryAllCustomers(){
    return customerDao.queryAllCustomers();
  }
public List<Customer> queryAllCusyomers(){
  List<Customer> customers = customerDao.queryAllCustomers();
  return customers;

}

}
