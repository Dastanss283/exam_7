package com.example.demo.repository;

import com.example.demo.model.Cafe;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CafeRepository extends PagingAndSortingRepository<Cafe, String> {
    Iterable<Cafe> findAll(Sort s);
}
