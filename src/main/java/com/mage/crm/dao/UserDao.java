package com.mage.crm.dao;

import com.mage.crm.vo.User;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface UserDao {
  public User queryUserByName(String userName);
  public Integer updatePwd(@Param("id") String id,@Param("userPwd") String userPwd);
  public User queryUserById(String id);

  @Select("select u.true_name as trueName ,u.id from t_user u\n" +
  "LEFT JOIN t_user_role ur ON u.id = ur.user_id\n"+
      "LEFT JOIN t_role r ON r.id = ur.role_id\n"+
      "WHERE r.role_name = '客户经理'\n"+
      "and r.is_valid = 1"
  )
      public List<User> queryAllCustomerManagers();
}
