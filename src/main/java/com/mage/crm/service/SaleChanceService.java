package com.mage.crm.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mage.crm.dao.SaleChanceDao;
import com.mage.crm.query.SaleChanceQuery;
import com.mage.crm.vo.SaleChance;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
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
}
