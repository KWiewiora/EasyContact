package com.easyContact.serverapp.manager;

import com.easyContact.serverapp.models.EntityOrderInfo;
import com.easyContact.serverapp.dao.entity.Warehouse;
import com.easyContact.serverapp.dao.repository.WarehouseRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class WarehouseManager {

    private WarehouseRepo warehouseRepo;

    @Autowired
    public WarehouseManager(WarehouseRepo warehouseRepo) {
        this.warehouseRepo = warehouseRepo;
    }

    public Optional<Warehouse> find(Long id) {
        return warehouseRepo.findById(id);
    }

    public Iterable<Warehouse> findAll() {
        return warehouseRepo.findAll();
    }

    public Warehouse save(Warehouse data) {
        return warehouseRepo.save(data);
    }

    public void deleteById(Long id) {
        warehouseRepo.deleteById(id);
    }

    public Warehouse getContent(Long userId) {
        return warehouseRepo.findFirstByUserId(userId);
    }

    public String getNameById(Long id) {
        return warehouseRepo.findFirstById(id)
                .map(Warehouse::getName)
                .orElse("Nie znaleziono");
    }

    public List<EntityOrderInfo> getEntityWarehouseInfo() {
        return warehouseRepo.findAll().stream().map(this::mapWarehouseToEntityOrderInfo).collect(Collectors.toList());
    }

    private EntityOrderInfo mapWarehouseToEntityOrderInfo(Warehouse warehouse) {
        return EntityOrderInfo.builder()
                .id(warehouse.getId())
                .name(warehouse.getName())
                .build();
    }
}
