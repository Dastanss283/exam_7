package com.example.demo.repository;
import com.example.demo.model.Food;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FoodRepository extends PagingAndSortingRepository<Food, String> {
}
