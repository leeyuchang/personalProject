package org.zerock.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.zerock.vo.ItemCategoryVO;

@Mapper
public interface ItemCategoryMapper {
  public ItemCategoryVO findById(long id);
}
