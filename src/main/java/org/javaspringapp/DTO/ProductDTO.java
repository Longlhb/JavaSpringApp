package org.javaspringapp.DTO;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import org.springframework.web.multipart.MultipartFile;

import java.io.Serializable;
import java.util.List;

public class ProductDTO implements Serializable {

    private static final long serialVersionUID = 1L;
    @NotBlank(message = "Title is required")
    @Size(min = 3, max = 200, message = "Title must be between 3  and  200 characters")
    private String name;

    @Min(value = 0, message = "Price must be greater than or equal to 0")
    @Max(value = 100000000, message = "Price must be less than or equal to 10,000,000")
    private Float price;
    private String thumbnail;
    private String descrtiption;

    @JsonProperty("category_id")
    private String categoryId;

    private List<MultipartFile> files;

    public ProductDTO() {
    }

    public ProductDTO(List<MultipartFile> file, String name, String thumbnail, Float price, String descrtiption, String categoryId) {
        this.files = file;
        this.name = name;
        this.thumbnail = thumbnail;
        this.price = price;
        this.descrtiption = descrtiption;
        this.categoryId = categoryId;
    }

    public @NotBlank(message = "Title is required") @Size(min = 3, max = 200, message = "Title must be between 3  and  200 characters") String getName() {
        return name;
    }

    public void setName(@NotBlank(message = "Title is required") @Size(min = 3, max = 200, message = "Title must be between 3  and  200 characters") String name) {
        this.name = name;
    }

    public @Min(value = 0, message = "Price must be greater than or equal to 0") @Max(value = 100000000, message = "Price must be less than or equal to 10,000,000") Float getPrice() {
        return price;
    }

    public void setPrice(@Min(value = 0, message = "Price must be greater than or equal to 0") @Max(value = 100000000, message = "Price must be less than or equal to 10,000,000") Float price) {
        this.price = price;
    }

    public String getDescrtiption() {
        return descrtiption;
    }

    public void setDescrtiption(String descrtiption) {
        this.descrtiption = descrtiption;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public String getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
    }

    public List<MultipartFile> getFiles() {
        return files;
    }

    public void setFiles(List<MultipartFile> file) {
        this.files = file;
    }
}
