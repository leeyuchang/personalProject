package org.zerock.vo;

import lombok.Data;

@Data
public class ItemVO {
  private Long id;
  private String name;
  private Long price;
  private Long priceTex;
  private Long type;
  private Long categoryId;
}
