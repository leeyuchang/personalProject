package org.zerock.vo;

import lombok.Data;

@Data
public class OrderVO {
  private Long id;
  private Long quantity;
  private Long itemId;
  private Long customerId;
}
