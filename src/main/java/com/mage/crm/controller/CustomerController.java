package com.mage.crm.controller;

import com.mage.crm.base.BaseController;
import com.mage.crm.model.MessageModel;
import com.mage.crm.service.CustomerService;
import com.mage.crm.vo.Customer;
import com.mage.crm.vo.SaleChance;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("customer")
public class CustomerController extends BaseController{
  @Resource
  private CustomerService customerService;
  @RequestMapping("queryAllCustomers")
  @ResponseBody
  public List<Customer> queryAllCustomers(){
    return customerService.queryAllCustomers();
  }

}
