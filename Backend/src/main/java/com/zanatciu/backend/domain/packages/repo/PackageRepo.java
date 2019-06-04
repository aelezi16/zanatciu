package com.zanatciu.backend.domain.packages.repo;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.zanatciu.backend.domain.packages.model.Package;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PackageRepo extends MongoRepository<Package, String> {

    List<Package> findAll();

}
