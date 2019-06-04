package com.mage.crm.dao;

import com.mage.crm.query.SaleChanceQuery;
import com.mage.crm.vo.SaleChance;
import java.util.List;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface SaleChanceDao {

  public List<SaleChance> querySaleChancesByParams(SaleChanceQuery saleChanceQuery);

  @Insert(
      "insert into t_sale_chance(chance_source,customer_name,cgjl,overview,link_man,link_phone,\n"
          + "description,create_man,assign_man,assign_time,state,dev_result,is_valid,create_date,update_date)\n"
          + "values(#{chanceSource},#{customerName},#{cgjl},#{overview},#{linkMan},#{linkPhone},\n"
          + "#{description},#{createMan},#{assignMan},#{assignTime},#{state},#{devResult},#{isValid},\n"
          + "#{createDate},#{updateDate})")
  public int insert(SaleChance saleChance);

  @Update("update t_sale_chance set chance_source=#{chanceSource},customer_name=#{customerName},"
      + "cgjl=#{cgjl},overview=#{overview},link_man=#{linkMan},link_phone=#{linkPhone},"
      + "description=#{description},assign_man=#{assignMan},assign_time=#{assignTime},state=#{state},"
      + "update_date=#{updateDate} where id=#{id} and is_valid=1")
    public Integer update(SaleChance saleChance);

  public Integer delete(Integer[] ids);

  @Select("select id,chance_source as chanceSource,customer_name as customerName,"
      + "cgjl,overview,link_man as linkMan,link_phone as linkPhone,"
      + " description,create_man as createMan,assign_man as  assignMan,"
      + " assign_time as assignTime,state,dev_result as devResult,create_date as createDate"
      + " from t_sale_chance where id=#{id} and is_valid=1")
  public SaleChance querySaleChanceById(String id);

  public Integer updateSaleChanceDevResult(int i, Integer saleChanceId);
}
