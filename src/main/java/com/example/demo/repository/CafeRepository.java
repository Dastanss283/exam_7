package com.example.demo.repository;

import com.example.exam7.model.Cafe;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CafeRepository extends CrudRepository<Cafe, String> {

}
