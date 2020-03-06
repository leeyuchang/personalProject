package org.zerock;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.zerock.mapper.CustomerMapper;
import org.zerock.mapper.ItemCategoryMapper;
import org.zerock.mapper.ItemMapper;
import org.zerock.mapper.OrderMapper;
import org.zerock.vo.CustomerVO;
import org.zerock.vo.ItemCategoryVO;
import org.zerock.vo.ItemVO;
import org.zerock.vo.OrderVO;

import lombok.extern.java.Log;

@SpringBootTest
@Log
class ApplicationTests {

  @Autowired
  private ItemCategoryMapper itemCategoryMapper;

  @Autowired
  private ItemMapper itemMapper;
  
  @Autowired
  private CustomerMapper customerMapper;

  @Test
  void contextLoads() {
    ItemCategoryVO itemCategory = itemCategoryMapper.findById(1L);
    log.info(itemCategory.toString());
  }

  @Test
  void itemMapperTest() {
    List<ItemVO> items = itemMapper.selectAll();
    items.forEach(item -> log.info(item.toString()));
  }
  
  @Test
  void customerInsertTest() {
    CustomerVO customer = new CustomerVO();
    customer.setName("LYC");
    customer.setPhone("08037007271");
    customerMapper.insert(customer);
  }
  
  @Test
  void customerSelectTest() {
    CustomerVO customer = customerMapper.selectById(4L);
    log.info(customer.toString());
  }
  
  @Autowired
  OrderMapper orderMapper;
  
  @Test
  void orderInsertTest() {
    OrderVO orderVo = new OrderVO();
    orderVo.setItemId(1L);
    orderVo.setQuantity(1L);
    orderVo.setCustomerId(4L);
    
    long result = orderMapper.insert(orderVo);
    assertEquals(1, result);
  }
  
  @Test
  void orderSelectTest() {
    OrderVO orderVO = orderMapper.selectById(3L);
    log.info(orderVO.toString());
  }
  
  

}
