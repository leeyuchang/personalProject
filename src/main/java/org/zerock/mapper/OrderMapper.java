package org.zerock.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.zerock.vo.OrderVO;

@Mapper
public interface OrderMapper {
  public OrderVO selectById(long id);
  public int insert(OrderVO order);
}
