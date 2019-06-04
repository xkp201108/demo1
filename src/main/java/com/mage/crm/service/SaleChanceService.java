package com.mage.crm.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mage.crm.base.CrmConstant;
import com.mage.crm.base.exceptions.ParamsException;
import com.mage.crm.dao.SaleChanceDao;
import com.mage.crm.model.MessageModel;
import com.mage.crm.query.SaleChanceQuery;
import com.mage.crm.util.AssertUtil;
import com.mage.crm.vo.SaleChance;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

@Service
public class SaleChanceService {
    @Resource
    private SaleChanceDao saleChanceDao;
    public Map<String,Object> querySaleChancesByParams(SaleChanceQuery saleChanceQuery){
      PageHelper.startPage(saleChanceQuery.getPage(),saleChanceQuery.getRows());
      List<SaleChance> saleChances = saleChanceDao.querySaleChancesByParams(saleChanceQuery);
      PageInfo<SaleChance> saleChancePageInfo = new PageInfo<>(saleChances);
      HashMap<String, Object> map = new HashMap<>();
      map.put("rows",saleChancePageInfo.getList());
      map.put("total",saleChancePageInfo.getTotal());
      return map;
    }

  public void insert(SaleChance saleChance) {
    checkParams(saleChance.getCustomerName(),saleChance.getLinkMan(),saleChance.getLinkPhone());
    saleChance.setCreateDate(new Date());
    saleChance.setUpdateDate(new Date());
    saleChance.setIsValid(1);
    saleChance.setDevResult(0)
    ;saleChance.setState(0);
    if(!StringUtils.isBlank(saleChance.assignMan)){
      saleChance.setState(1);
    }
    AssertUtil.isTrue(saleChanceDao.insert(saleChance)<1,"数据插入失败");
    }
  public void checkParams(String customerName,String linkMan,String phone){
    AssertUtil.isTrue(StringUtils.isBlank(customerName),"客户名称不能为空");
    AssertUtil.isTrue(StringUtils.isBlank(linkMan),"客户名称不能为空");
    AssertUtil.isTrue(StringUtils.isBlank(phone),"联系电话不能为空");
  }

  public void update(SaleChance saleChance) {
    checkParams(saleChance.getCustomerName(),saleChance.getLinkMan(),saleChance.getLinkPhone());
    saleChance.setUpdateDate(new Date());
    saleChance.setState(0);
    if(!StringUtils.isBlank(saleChance.getAssignMan())){
      saleChance.setState(1);
      saleChance.setAssignTime(new Date());
    }
    AssertUtil.isTrue(saleChanceDao.update(saleChance)<1,"数据更新失败");
  }


  public void delete(Integer[] ids) {
    AssertUtil.isTrue(saleChanceDao.delete(ids)<1,"营销机会删除失败");
  }

  public SaleChance querySaleChanceById(String id) {
    return saleChanceDao.querySaleChanceById(id);
  }

  public void updateSaleChanceDevResult(Integer devResult, Integer saleChanceId) {
    AssertUtil.isTrue(saleChanceDao.updateSaleChanceDevResult(devResult,saleChanceId)<1,"修改开发结果失败");
  }
}
