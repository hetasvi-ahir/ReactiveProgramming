package com.ims.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

import com.ims.entity.Admin;

@Repository
public interface AdminRepository extends ReactiveMongoRepository<Admin, Long> {

}
