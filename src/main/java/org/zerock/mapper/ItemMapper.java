package org.zerock.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.zerock.vo.ItemVO;

@Mapper
public interface ItemMapper {
  public List<ItemVO> selectAll();
}
