function formatterState(val) {
  if (val==0){
    return "未分配";
  }else if(val==1){
    return "已分配";
  }else {
    return "未定义";
  }//val是传过来的状态码

}
