package com.mage.crm.service;

import com.mage.crm.dao.UserDao;
import com.mage.crm.model.UserModel;
import com.mage.crm.util.AssertUtil;
import com.mage.crm.util.Base64Util;
import com.mage.crm.util.Md5Util;
import com.mage.crm.vo.User;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Resource
    private UserDao userDao;
    public UserModel userLogin(String userName,String userPwd){
      User user = userDao.queryUserByName(userName);
      AssertUtil.isTrue(null==user,"用户不存在");
      AssertUtil.isTrue("0".equals(user.getIsValid()),"用户已经失效");
      userPwd = Md5Util.encode(userPwd);
      AssertUtil.isTrue(!userPwd.equals(user.getUserPwd()),"密码错误");
      return createUserModel(user);
    }
    public UserModel createUserModel(User user){
      UserModel userModel = new UserModel();
      userModel.setTrueName(user.getTrueName());
      userModel.setUserName(user.getUserName());
      String userId = Base64Util.encode(user.getId());
      userModel.setUserId(userId);
      return userModel;
    }
}
