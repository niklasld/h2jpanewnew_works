package com.h2jpanewnew.h2jpanewnew.Repository;

import com.h2jpanewnew.h2jpanewnew.Model.Recipe;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface RecipeRepo extends CrudRepository<Recipe, Long> {
    Optional<Recipe> findByDescription(String description);
}
