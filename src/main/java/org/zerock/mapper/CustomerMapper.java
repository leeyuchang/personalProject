package org.zerock.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.zerock.vo.CustomerVO;

@Mapper
public interface CustomerMapper {
  public CustomerVO selectById(long id);
  public int insert(CustomerVO customer);
}
