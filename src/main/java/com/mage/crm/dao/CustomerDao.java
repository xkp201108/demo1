package com.mage.crm.dao;

import com.mage.crm.vo.Customer;
import java.util.List;
import org.apache.ibatis.annotations.Select;

public interface CustomerDao {
  @Select("select id,name from t_customer where is_valid = 1")
  public List<Customer> queryAllCustomers();
}
