package com.easyContact.serverapp.dao.repository;

import com.easyContact.serverapp.dao.entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends CrudRepository<User, Long> {

//    @Query("select id from User where email=:emailParam")
//    public Iterable<String> getIdByEmail(@Param("email") String email);

    public User findFirstByEmail(String email);

}
