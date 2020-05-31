package com.easyContact.serverapp.dao.repository;

import com.easyContact.serverapp.dao.entity.Principal;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface PrincipalRepo extends CrudRepository<Principal, Long> {

     Principal findFirstByUserId(Long userId);

     Optional<Principal> findFirstById(Long id);

     List<Principal> findAll();


}
