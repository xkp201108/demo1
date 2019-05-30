package com.mage.crm.dao;

import com.mage.crm.vo.User;
import org.apache.ibatis.annotations.Param;

public interface UserDao {
  public User queryUserByName(String userName);
  public Integer updatePwd(@Param("id") String id,@Param("userPwd") String userPwd);
  public User queryUserById(String id);
}
