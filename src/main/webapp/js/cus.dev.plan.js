function formatterDevResult (val) {
  if(val==0){
    return "未开发";
  }else if (val==1){
    return "开发中";
  }else if(val==2){
    return "开发成功";
  }else if(val==3){
    return "开发失败";
  }else {
    return "未定义";
  }
}
function formatterOp (val,rowData) {
  if(rowData.devResult==0||rowData.devResult==1){
    var href = "javascript:openCusDevPlanDetailTab('客户开发计划项管理_" +rowData.id
        +"'," + rowData.id+ ")";
    return "<a href = " + href +"> 开发</a>"
  }else if(rowData.devResult==2||rowData.devResult==3){
    var href = "javascript:openCusDevPlanDetailTab('客户开发计划项详情_" +rowData.id
        +"'," + rowData.id+ ")";
    return "<a href = " + href +"> 查看详情</a>"
  }
}

function openCusDevPlanDetailTab(title,id) {
  window.parent.openTab(title,ctx+"/cus_dev_plan/index/?id="+id);
}
$(function () {
  $("#dg").datagrid({
    rowStyler:function (index,rowData) {
      if(rowData.devResult==0||rowData.devResult==1){
        return "background-color:yellow";
      }else if(rowData.devResult==2){
        return "background-color:green";
      }else if(rowData.devResult==3){
        return "background-color:red";
      }
    }
  });
});