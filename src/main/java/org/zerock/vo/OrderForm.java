package org.zerock.vo;

import java.util.List;

import lombok.Data;

@Data
public class OrderForm {

  private String name;
  private String phone;
  private List<Order> orders;
  
}
