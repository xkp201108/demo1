package com.mage.crm.controller;

import com.mage.crm.base.BaseController;
import com.mage.crm.base.CrmConstant;
import com.mage.crm.base.exceptions.ParamsException;
import com.mage.crm.model.MessageModel;
import com.mage.crm.model.UserModel;
import com.mage.crm.service.UserService;
import com.mage.crm.util.UserLoginUtil;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("user")
public class UserController extends BaseController{
  @Resource
  private UserService userService;
  @ResponseBody
  @RequestMapping("userLogin")
    public MessageModel userLogin(String userName,String userPwd){
      MessageModel messageModel = new MessageModel();
      try {
        UserModel userModel = userService.userLogin(userName, userPwd);
        messageModel.setResult(userModel);
      }catch (ParamsException p){
        p.printStackTrace();
        messageModel.setCode(p.getCode());
        messageModel.setMsg(p.getMsg());
      }catch (Exception e) {
        e.printStackTrace();
        messageModel.setCode(CrmConstant.OPS_FAILED_DODE);
        messageModel.setMsg(CrmConstant.OPS_FAILED_MSG);
      }
      return messageModel;
    }
    @RequestMapping("updatePwd")
    @ResponseBody
    public MessageModel updatePwd(HttpServletRequest request,String newPassword,String oldPassword,String confirmPassword){
      MessageModel messageModel = new MessageModel();
      String userId = UserLoginUtil.realseUserId(request);
      try {
        userService.updatePwd(userId,oldPassword,newPassword,confirmPassword);

      }catch (ParamsException e){
        e.printStackTrace();
        messageModel.setCode(e.getCode());
        messageModel.setMsg(e.getMsg());
      }catch (Exception e){
        e.printStackTrace();
        messageModel.setCode(CrmConstant.OPS_FAILED_DODE);
        messageModel.setMsg(CrmConstant.OPS_FAILED_MSG);
      }
      return messageModel;
    }
}
