package com.mage.crm.controller;

import com.mage.crm.base.BaseController;
import com.mage.crm.query.SaleChanceQuery;
import com.mage.crm.service.SaleChanceService;
import java.util.Map;
import javax.annotation.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("sale_chance")
public class SaleChanceController extends BaseController{
  @Resource
  private SaleChanceService saleChanceService;
  @RequestMapping("index/{type}")
  public String index(@PathVariable("type") String type){
      switch (type){
        case "1":return "sale_chance";
        case "2":return "cus_dev_plan";
        default:return "error";
      }
    }

    @RequestMapping("querySaleChancesByParams")
    @ResponseBody
    public Map<String,Object>  querySaleChancesByParams(SaleChanceQuery saleChanceQuery){
      Map<String, Object> map = saleChanceService.querySaleChancesByParams(saleChanceQuery);
      return map;
  }
}