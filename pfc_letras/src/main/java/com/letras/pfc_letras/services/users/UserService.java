package com.letras.pfc_letras.services.users;

import com.letras.pfc_letras.models.UsersModels.UserModel;
import java.util.Optional;

public interface UserService {

     Optional<UserModel> findUserByUsername(String username);
     Optional<UserModel> saveUser(UserModel userModel);
}
