package com.lschaan.poc.batchmongo.repository;

import com.lschaan.poc.batchmongo.dto.TransactionDTO;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionRepository extends MongoRepository<TransactionDTO, String> {}
