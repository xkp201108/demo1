function formatterState(val) {
  if (val==0){
    return "未分配";
  }else if(val==1){
    return "已分配";
  }else {
    return "未定义";
  }//val是传过来的状态码

}
function searchSaleChances() {
  $("#dg").datagrid("load",{
    createMan:$("#ccreateMan").val(),
    customerName:$('#customerName').val(),
    createDate:$('#createDate').datebox("getValue"),
    state:$("#state").combobox("getValue")
  })
}
$(function () {
  searchSaleChances();
})

function openAddAccountDialog() {
  $("#dlg").dialog("open");
}
function closeDialog() {
  $("#dlg").dialog("close");
}

function saveAccount() {
  $("#fm").form("submit",{
    url:ctx+"/sale_chance/insert",
    onSubmit:function (Params) {
      Params.createMan=$.cookie("trueName");
      return $("#fm").form("validate");
    },
    success:function (data) {
      data=JSON.parse(data);
      if(data.code==200){
        $.messager.alert("来自crm",data.msg,"info");
        closeDialog();
        searchSaleChances();
      }else {
        $.messager.alert("来自crm",data.msg,"info");
      }
    }
  })
}

function openAddAccountDialog() {
  $("#dlg").dialog("open");
}
function closeDialog() {
  $("#dlg").dialog("close");
}

function openModifyAccountDialog() {
  var rows = $("#dg").datagrid("getSelections");
  if(rows.length==0){
    $.messager.alert("crm","请先选中一条记录","info");
    return ;
  }

  if(rows.length>1){
    $.messager.alert("crm","不能同时修改多条记录","info");
  }
  $("#fm").form("load",rows[0]);
  $("#dlg").dialog("open").dialog("setTitle","修改营销机会信息");
}


function deleteAccount() {
  var rows = $("#dg").datagrid("getSelections");
  if(rows.length==0){
    $.messager.alert("crm","请先选择一条记录","info");
    return ;
  }
  var mydata = "ids=";
  for(var i=0;i<rows.length;i++){
    if(i<rows.length-1){
      mydata  =mydata + rows[i].id + "&ids=" ;
    }else {
      mydata = mydata + rows[i].id;
    }
  }
  $.messager.confirm("crm","确定要删除所选中的数据么？",function (r) {
        if(r){
          $.ajax({
                type:"post",
                url:ctx + "/sale_chance/delete",
                data:mydata,
                dataType:"json",
                success:function (data) {
                  $.messager.alert("crm",data.msg,"info");
                  if (data.code == 200) {
                    searchSaleChances();
                  }
                }
          })
        }
      })
}