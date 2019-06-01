package com.mage.crm.dao;

import com.mage.crm.query.SaleChanceQuery;
import com.mage.crm.vo.SaleChance;
import java.util.List;
import org.apache.ibatis.annotations.Insert;

public interface SaleChanceDao {
  public List<SaleChance> querySaleChancesByParams(SaleChanceQuery saleChanceQuery);

  @Insert("insert into t_sale_chance(chance_source,customer_name,cgjl,overview,link_man,link_phone,\n"
      + "description,create_man,assign_man,assign_time,state,dev_result,is_valid,create_date,update_date)\n"
      + "values(#{chanceSource},#{customerName},#{cgjl},#{overview},#{linkMan},#{linkPhone},\n"
      + "#{description},#{createMan},#{assignMan},#{assignTime},#{state},#{devResult},#{isValid},\n"
      + "#{createDate},#{updateDate})")
  public int insert(SaleChance saleChance);
}
