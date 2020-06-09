package com.easyContact.serverapp.manager;

import com.easyContact.serverapp.dao.entity.DeliveryOrder;
import com.easyContact.serverapp.dao.repository.DeliveryOrdersRepo;
import com.easyContact.serverapp.models.exception.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class DeliveryOrdersManager {

    private DeliveryOrdersRepo deliveryOrdersRepo;

    @Autowired
    public DeliveryOrdersManager(DeliveryOrdersRepo deliveryOrdersRepo) {
        this.deliveryOrdersRepo = deliveryOrdersRepo;
    }

    public Optional<DeliveryOrder> find(Long id) {
        return deliveryOrdersRepo.findById(id);
    }


    public DeliveryOrder save(DeliveryOrder data) {
        return deliveryOrdersRepo.save(data);
    }

    public List<DeliveryOrder> getAllOrdersByExecutor(Long id) {
        return deliveryOrdersRepo.findAll().stream()
                .map(this::mapNullToOther)
                .collect(Collectors.toList())
                .stream()
                .filter(deliveryOrder -> deliveryOrder.getExecutorId() == -1 || deliveryOrder.getExecutorId().equals(id))
                .collect(Collectors.toList());
    }

    private DeliveryOrder mapNullToOther(DeliveryOrder deliveryOrder) {
        if (deliveryOrder.getExecutorId() == null) {
            deliveryOrder.setExecutorId(-1L);
        }
        return deliveryOrder;
    }

    public List<DeliveryOrder> getAllOrdersByPrincipal(Long id) {
        return deliveryOrdersRepo.findAllByPrincipalId(id);
    }

    public List<DeliveryOrder> getAllOrdersForWarehouse(Long id1, Long id2) {
        return deliveryOrdersRepo.findAllByFromIdOrToId(id1, id2);
    }

    public void deleteById(Long id2) throws EntityNotFoundException {
        try {
            deliveryOrdersRepo.deleteById(id2);
        } catch (Exception e) {
            throw new EntityNotFoundException("nie znaleziono id");
        }
    }
}
