function openTab(text, url, iconCls){
    if($("#tabs").tabs("exists",text)){
        $("#tabs").tabs("select",text);
    }else{
        var content="<iframe frameborder=0 scrolling='auto' style='width:100%;height:100%' src='" + url + "'></iframe>";
        $("#tabs").tabs("add",{
            title:text,
            iconCls:iconCls,
            closable:true,
            content:content
        });
    }
}

function logout(){
    $.messager.confirm("来自crm","确定要退出系统吗",function (r) {
      if (r){
          $.messager.alert("来自crm系统","两秒后退出","info");
          setTimeout(function () {
                $.removeCookie("userName");
                $.removeCookie("trueName");
                window.location.href = "index";
          },2000)
          //alert("退出");
      }
    })
}
function openPasswordModifyDialog() {
  $("#dlg").dialog("open");
}

function closePasswordModifyDialog() {
  $("#dlg").dialog("close");
}

function modifyPassword() {
  $("#fm").form("submit",{
        url:ctx+"/user/updatePwd",
        onSubmit:function () {
          return $("#fm").form("validate");
        },
    success:function(data){
            data = JSON.parse(data);
            if(data.code==200){
                $.messager.alert("来自crm系统","两秒后跳转","info");
                setTimeout(function () {
                  $.removeCookie("userName");
                  $.removeCookie("trueName");
                  $.removeCookie("userId");
                  window.location.href="index";
                },2000)
            }else {
                $.messager.alert("来自crm系统",data.msg,"info");
            }
  }
  })
}