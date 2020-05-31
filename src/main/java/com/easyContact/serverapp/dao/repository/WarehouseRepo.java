package com.easyContact.serverapp.dao.repository;

import com.easyContact.serverapp.dao.entity.Warehouse;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface WarehouseRepo extends CrudRepository<Warehouse, Long> {

     Warehouse findFirstByUserId(Long userId);
     Optional<Warehouse> findFirstById(Long Id);

     List<Warehouse> findAll();
}
