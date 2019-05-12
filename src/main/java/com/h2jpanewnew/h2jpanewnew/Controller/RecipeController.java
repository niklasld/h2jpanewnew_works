package com.h2jpanewnew.h2jpanewnew.Controller;

import com.h2jpanewnew.h2jpanewnew.Model.Recipe;
import com.h2jpanewnew.h2jpanewnew.Repository.RecipeRepo;
import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Optional;

@Controller
public class RecipeController {

    @Autowired
    private RecipeRepo recipeRepo;

    @GetMapping("/")
    private String home() {
        Optional<Recipe> recipe = recipeRepo.findByDescription("Perfekt guac");
        if(recipe.isPresent()) {
            System.out.println("Fandt; "+recipe.get().getDescription());
            System.out.println(recipe.get().getNotes());
            System.out.println(recipe.get().getIngredients());
        }
        else {
            System.out.println("Fandt ingen opskrift");
        }
        return "index";
    }

}
