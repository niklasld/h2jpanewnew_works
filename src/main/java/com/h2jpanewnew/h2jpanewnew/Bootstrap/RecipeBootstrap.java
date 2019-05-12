package com.h2jpanewnew.h2jpanewnew.Bootstrap;

import com.h2jpanewnew.h2jpanewnew.Model.Ingredient;
import com.h2jpanewnew.h2jpanewnew.Model.Notes;
import com.h2jpanewnew.h2jpanewnew.Model.Recipe;
import com.h2jpanewnew.h2jpanewnew.Model.UnitOfMeasure;
import com.h2jpanewnew.h2jpanewnew.Repository.RecipeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Component
public class RecipeBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    @Autowired
    private RecipeRepo recipeRepo;

    private List<Recipe> createRecipes() {
        List<Recipe> recipes = new ArrayList<>();
        Set<Ingredient> ingredients = new HashSet<>();

        Recipe r1 = new Recipe();
        r1.setDescription("Perfekt guac");

        Notes notes = new Notes();
        notes.setNote("Avocado, hvidløg, citron, salt, peber");
        notes.setRecipe(r1);

        r1.setNotes(notes);

        Ingredient ingredient = new Ingredient();
        ingredient.setName("Avocado");
        ingredient.setAmount(BigDecimal.valueOf(500));

        UnitOfMeasure unitOfMeasure = new UnitOfMeasure();
        unitOfMeasure.setUnitType("Gram");
        unitOfMeasure.setIngredient(ingredient);

        ingredient.setUnitOfMeasure(unitOfMeasure);
        ingredient.setRecipe(r1);
        ingredients.add(ingredient);

        r1.setIngredients(ingredients);

        recipes.add(r1);

        return recipes;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        System.out.println("context refreshed");
        recipeRepo.saveAll(createRecipes());
    }


}
