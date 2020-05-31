package com.easyContact.serverapp.dao.repository;

import com.easyContact.serverapp.dao.entity.DeliveryOrder;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface DeliveryOrdersRepo extends CrudRepository<DeliveryOrder, Long> {

//     List<DeliveryOrder> findAllByExecutorId(Long executorId);
     List<DeliveryOrder> findAll();
     List<DeliveryOrder> findAllByPrincipalId(Long principalId);
     List<DeliveryOrder> findAllByFromIdOrToId(Long fromId, Long toId);
     void deleteById(Long id);

   // public List<DeliveryOrders> findAllBy



}
