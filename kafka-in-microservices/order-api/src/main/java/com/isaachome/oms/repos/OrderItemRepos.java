package com.isaachome.oms.repos;

import com.isaachome.oms.entity.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemRepos extends JpaRepository<OrderItem,Integer> {
}
