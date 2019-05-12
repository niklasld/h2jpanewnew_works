package com.h2jpanewnew.h2jpanewnew.Model;

import javax.persistence.*;

@Entity
public class UnitOfMeasure {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String unitType;

    @OneToOne(cascade = CascadeType.ALL)
    private Ingredient ingredient;

    public UnitOfMeasure() {
    }

    public Ingredient getIngredient() {
        return ingredient;
    }

    public void setIngredient(Ingredient ingredient) {
        this.ingredient = ingredient;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUnitType() {
        return unitType;
    }

    public void setUnitType(String unitType) {
        this.unitType = unitType;
    }

    @Override
    public String toString() {
        return "UnitOfMeasure{" +
                "unitType='" + unitType + '\'' +
                '}';
    }
}
