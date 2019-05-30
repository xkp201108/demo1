package com.mage.crm.service;

import com.mage.crm.dao.UserDao;
import com.mage.crm.model.UserModel;
import com.mage.crm.util.AssertUtil;
import com.mage.crm.util.Base64Util;
import com.mage.crm.util.Md5Util;
import com.mage.crm.vo.User;
import com.mysql.jdbc.StringUtils;
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

    public void updatePwd(String userId,String oldPassword,String newPassword,String confirmPasswoord){
      AssertUtil.isTrue(null==userId,"非法用户");
      AssertUtil.isTrue("".equals(newPassword)||null==newPassword,"新密码不能为空");
      AssertUtil.isTrue(!newPassword.equals(confirmPasswoord),"新密码与确认密码不一致");
      User user = userDao.queryUserById(userId);
      AssertUtil.isTrue(null==user,"用户不存在");
      String oldPwd = Md5Util.encode(oldPassword);//解码
      AssertUtil.isTrue(!oldPwd.equals(user.getUserPwd()),"原密码输入错误");
      Integer integer = userDao.updatePwd(userId,newPassword);
      AssertUtil.isTrue(integer<1,"密码修改失败");
    }
}
