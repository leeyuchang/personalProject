package org.zerock.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.zerock.mapper.CustomerMapper;
import org.zerock.mapper.ItemMapper;
import org.zerock.mapper.OrderMapper;
import org.zerock.vo.CustomerVO;
import org.zerock.vo.Order;
import org.zerock.vo.OrderForm;
import org.zerock.vo.OrderVO;

import lombok.extern.java.Log;

@Log
@Controller
public class MenuController {

  @Autowired
  private ItemMapper items;

  @Autowired
  private CustomerMapper customerMapper;

  @Autowired
  private OrderMapper orderMapper;

  @GetMapping("/menu")
  public String showMunu(Model model) {
    model.addAttribute("items", items.selectAll());
    return "menu";
  }

  @PostMapping("/order")
  public String orderMenu(OrderForm form, RedirectAttributes redir) {
    log.info("" + form);

    CustomerVO customerVO = new CustomerVO();
    customerVO.setName(form.getName());
    customerVO.setPhone(form.getPhone());
    customerMapper.insert(customerVO);

    List<Order> orders = form.getOrders();
    orders.stream().map(order -> {
      return createOrder(customerVO, order);
    }).forEach(orderVO -> orderMapper.insert(orderVO));

    redir.addFlashAttribute("result", form.getName() + "様の注文を完了しました。");
    return "redirect:menu";
  }

  private OrderVO createOrder(CustomerVO customerVO, Order order) {
    OrderVO orderVO = new OrderVO();
    orderVO.setCustomerId(customerVO.getId());
    orderVO.setItemId(order.getItemId());
    orderVO.setQuantity(order.getQuantity());
    return orderVO;
  }

}
