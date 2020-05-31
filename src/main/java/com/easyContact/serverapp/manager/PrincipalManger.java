package com.easyContact.serverapp.manager;

import com.easyContact.serverapp.models.EntityOrderInfo;
import com.easyContact.serverapp.dao.entity.Principal;
import com.easyContact.serverapp.dao.repository.PrincipalRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PrincipalManger {

    private PrincipalRepo principalRepo;

    @Autowired
    public PrincipalManger(PrincipalRepo principalRepo) {
        this.principalRepo = principalRepo;
    }

    public Optional<Principal> find(Long id) {
        return principalRepo.findById(id);
    }

    public Iterable<Principal> findAll() {
        return principalRepo.findAll();
    }

    public Principal save(Principal data) {
        return principalRepo.save(data);
    }

    public void deleteById(Long id) {
        principalRepo.deleteById(id);
    }

    public Principal getContent(Long userId) {
        return principalRepo.findFirstByUserId(userId);
    }

    public String getNameById(Long id) {
        return principalRepo.findFirstById(id)
                .map(Principal::getName)
                .orElse("Nie znaleziono");
    }

    public List<EntityOrderInfo> getEntityPrincipalInfo() {
        return principalRepo.findAll().stream().map(this::mapPrincipalToEntityOrderInfo).collect(Collectors.toList());
    }

    private EntityOrderInfo mapPrincipalToEntityOrderInfo(Principal principal) {
        return EntityOrderInfo.builder()
                .id(principal.getId())
                .name(principal.getName())
                .build();
    }
}
