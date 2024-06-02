package com.letras.pfc_letras.repositories;

import com.letras.pfc_letras.models.LoanModels.LoanModel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LoanRepository extends MongoRepository<LoanModel, String> {

    List<LoanModel> findByUserId(String userid);
}
