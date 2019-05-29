package com.mage.crm.dao;

import com.mage.crm.vo.User;

public interface UserDao {
  public User queryUserByName(String userName);
}
