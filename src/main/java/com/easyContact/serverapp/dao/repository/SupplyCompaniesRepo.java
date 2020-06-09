package com.easyContact.serverapp.dao.repository;

import com.easyContact.serverapp.dao.entity.SupplyCompanies;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface SupplyCompaniesRepo extends CrudRepository<SupplyCompanies, Long> {

    SupplyCompanies findFirstByUserId( Long userId);
    Optional<SupplyCompanies> findFirstById(Long id);
    List<SupplyCompanies> findAll();
}
