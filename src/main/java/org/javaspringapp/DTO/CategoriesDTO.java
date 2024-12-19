package org.javaspringapp.DTO;


import jakarta.validation.constraints.NotEmpty;

public class CategoriesDTO {
   @NotEmpty(message = "Category's name cannot be empty")
   private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public CategoriesDTO(String name) {
        this.name = name;
    }

    public CategoriesDTO() {
    }

    @Override
    public String toString() {
        return "CategoriesDTO{" +
                "name='" + name + '\'' +
                '}';
    }
}
