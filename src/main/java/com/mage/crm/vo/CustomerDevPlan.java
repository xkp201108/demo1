package com.mage.crm.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

public class CustomerDevPlan extends BaseVO {
  private Integer id;
  private Integer saleChanceId;
  private String planItem;
  @JsonFormat(pattern="yyyy-MM-dd",timezone="GMT+8")
  @DateTimeFormat(pattern="yyyy-MM-dd")
  private Date planDate;

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public Integer getSaleChanceId() {
    return saleChanceId;
  }

  public void setSaleChanceId(Integer saleChanceId) {
    this.saleChanceId = saleChanceId;
  }

  public String getPlanItem() {
    return planItem;
  }

  public void setPlanItem(String planItem) {
    this.planItem = planItem;
  }

  public Date getPlanDate() {
    return planDate;
  }

  public void setPlanDate(Date planDate) {
    this.planDate = planDate;
  }

  public String getExeAffect() {
    return exeAffect;
  }

  public void setExeAffect(String exeAffect) {
    this.exeAffect = exeAffect;
  }

  private String exeAffect;
}
