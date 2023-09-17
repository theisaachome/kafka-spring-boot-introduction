package com.isaachome.oms.repos;

import com.isaachome.oms.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepos extends JpaRepository<Order,Integer> {
}
