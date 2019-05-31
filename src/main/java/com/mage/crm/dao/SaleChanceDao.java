package com.mage.crm.dao;

import com.mage.crm.query.SaleChanceQuery;
import com.mage.crm.vo.SaleChance;
import java.util.List;

public interface SaleChanceDao {
  public List<SaleChance> querySaleChancesByParams(SaleChanceQuery saleChanceQuery);
}
