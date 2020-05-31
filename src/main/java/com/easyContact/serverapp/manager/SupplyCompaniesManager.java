package com.easyContact.serverapp.manager;

import com.easyContact.serverapp.models.EntityOrderInfo;
import com.easyContact.serverapp.dao.entity.SupplyCompanies;
import com.easyContact.serverapp.dao.repository.SupplyCompaniesRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class SupplyCompaniesManager {

    private SupplyCompaniesRepo supplyCompaniesRepo;

    @Autowired
    public SupplyCompaniesManager(SupplyCompaniesRepo supplyCompaniesRepo) {
        this.supplyCompaniesRepo = supplyCompaniesRepo;
    }

    public Optional<SupplyCompanies> find(Long id) {
        return supplyCompaniesRepo.findById(id);
    }

    public Iterable<SupplyCompanies> findAll() {
        return supplyCompaniesRepo.findAll();
    }

    public SupplyCompanies save(SupplyCompanies data) {
        return supplyCompaniesRepo.save(data);
    }

    public void deleteById(Long id) {
        supplyCompaniesRepo.deleteById(id);
    }

    public SupplyCompanies getContent(Long userId) {
        return supplyCompaniesRepo.findFirstByUserId(userId);
    }

    public String getNameById(Long id) {
        return supplyCompaniesRepo.findFirstById(id)
                .map(SupplyCompanies::getName)
                .orElse("Nie znaleziono");
    }

    public List<EntityOrderInfo> getEntitySupplyCompaniesInfo() {
        return supplyCompaniesRepo.findAll().stream().map(this::mapSupplyCompaniesToEntityOrderInfo).collect(Collectors.toList());
    }

    private EntityOrderInfo mapSupplyCompaniesToEntityOrderInfo(SupplyCompanies supplyCompanies) {
        return EntityOrderInfo.builder()
                .id(supplyCompanies.getId())
                .name(supplyCompanies.getName())
                .build();
    }
}
