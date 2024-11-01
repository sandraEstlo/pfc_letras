package com.letras.pfc_letras.repositories;

import com.letras.pfc_letras.models.users.UserModel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends MongoRepository<UserModel, String> {

    UserModel findByUsername(String userName);
}
