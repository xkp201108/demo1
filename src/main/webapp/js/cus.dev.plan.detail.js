$(function () {
  $("#dg").edatagrid({
    url:ctx+"/cus_dev_plan/queryCusDevPlans?salChanceId="+$("#saleChanceId").val(),
    saveUrl:ctx + "/cus_dev_plan/insert?saleChanceId=" + $("#saleChanceId").val(),
    updateUrl: ctx + "/cus_dev_plan/update?saleChanceId=" + $("#saleChanceId").val()
  })
})


$(function () {
  var devresult = $("#devResult").val();
  if(devresult==2||devresult==3){
    $("#toolbar").remove();
  }
  $("#dg").edatagrid({
    url:ctx+"/cus_dev_plan/queryCusDevPlans?saleChanceId="+$("#saleChanceId").val(),
  saveUrl: ctx + "/cus_dev_plan/insert?saleChanceId=" + $("#saleChanceId").val(),
      updateUrl: ctx + "/cus_dev_plan/update?saleChanceId=" + $("#saleChanceId").val()
})
})

function saveCusDevPlan() {
  $("#dg").edatagrid("saveRow");
  $("#dg").edatagrid("load");
}


function updateCusDevPlan() {
  $("#dg").edatagrid("saveRow");
  $("#dg").edatagrid("load");
}