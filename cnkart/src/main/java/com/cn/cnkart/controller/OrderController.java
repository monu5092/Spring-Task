package com.cn.cnkart.controller;

import com.cn.cnkart.entity.Order;
import com.cn.cnkart.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

      @Autowired
      OrderService orderService;

      @GetMapping("id/{id}")
      public Order getOrderByid(@PathVariable int id){return orderService.getOrderById(id);}

      @PostMapping("/save")
      public void saveOrder(@RequestBody Order order){orderService.saveOrder(order);}

      @DeleteMapping("/delete/id/{id}")
      public String deleteOrder(@PathVariable int id){
            orderService.delete(id);
            return "Order has been deleted by id: "+id;
      }
}
