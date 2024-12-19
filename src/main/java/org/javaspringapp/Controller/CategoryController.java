package org.javaspringapp.Controller;

import jakarta.validation.Valid;
import org.javaspringapp.DTO.CategoriesDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/categories")
//@Validated
public class CategoryController {
    @RequestMapping("")
    public ResponseEntity<String> getAllCategories(@RequestParam("page")  int page, @RequestParam("limit")  int  limit){
        return ResponseEntity.ok(String.format("Successfully"));
    }
    @PostMapping("")
    public ResponseEntity<?>  insertCategories(@Valid @RequestBody CategoriesDTO categoriesDTO, BindingResult result) {
        if (result.hasErrors()) {
            List<String> errorMessages =  result.getFieldErrors().stream().map(FieldError::getDefaultMessage).toList();
            return ResponseEntity.badRequest().body(errorMessages);
        }
        return ResponseEntity.ok("Insert Successfully" + categoriesDTO);
    }
    @PutMapping("/{id}")
    public ResponseEntity<String> updateCategories(@PathVariable Long id) {
        return ResponseEntity.ok("Update Successfully");
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String>  deleteCategories(@PathVariable Long id) {
        return ResponseEntity.ok("Delete Successfully");
    }
}
