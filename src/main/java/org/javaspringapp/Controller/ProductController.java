package org.javaspringapp.Controller;

import jakarta.validation.Valid;
import org.javaspringapp.DTO.ProductDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("api/v1/products")
public class ProductController {
    @PostMapping(value = "", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<?> createProduct(@Valid @ModelAttribute ProductDTO productDTO,
//                                           @RequestParam("file") MultipartFile file,
                                           BindingResult result) {
        try {
//            productService.createProduct(productDTO);
            if(result.hasErrors()) {
                List<String> errorMessages = result.getFieldErrors().stream().map(FieldError::getDefaultMessage).toList();
                return ResponseEntity.badRequest().body(errorMessages);
            }
            List<MultipartFile> files = productDTO.getFiles();
            files =  files == null ? new ArrayList<MultipartFile>() :  files;
            for (MultipartFile file :  files) {
                if (file.getSize() == 0) {
                    continue;
                }
                //Kiểm tra kích thước file và định dạng file
                if  (file.getSize() > 10 * 1024 *1024) { // kích thước > 10  mb
                    return ResponseEntity.status(HttpStatus.PAYLOAD_TOO_LARGE).body("File is too large! Maximum size is 10MB");
                }
                String contentType = file.getContentType();
                if (contentType == null || !contentType.startsWith("image/")) {
                    return ResponseEntity.status(HttpStatus.UNSUPPORTED_MEDIA_TYPE).body("File must be an image");
                }
                //Lưu file và cập nhật thumbnail trong DTO
                String fileName = storeFile(file);
                //Lưu  vào đối tượng product trong DB
                //Lưu vaào bảng product_images
            }
            return ResponseEntity.ok("Product created successfully");
        }catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    private String storeFile(MultipartFile file) throws IOException {
        String filename = StringUtils.cleanPath(file.getOriginalFilename());
        //thêm  UUID vào trước tên file để đảm bảo tên file là duy nhất
        String uniqueFilename = UUID.randomUUID().toString() + "_" + filename;
        //Đường dẫn đến thư mục mà bạn  muốn  lưu file
        Path uploadDir = Paths.get("uploads");
        //Kiểm tra và tạo thư mục nếu nó  không tồn tại
        if (!Files.exists(uploadDir)) {
            Files.createDirectories(uploadDir);
        }
        //Đường dẫn đày đủ đến file
        Path destination = Paths.get(uploadDir.toString(), uniqueFilename);
        //sao chép file vào thư mục đích
        Files.copy(file.getInputStream(), destination, StandardCopyOption.REPLACE_EXISTING);
        return uniqueFilename;
    }
    @GetMapping("")
    public ResponseEntity<String> getProducts(@RequestParam("page") int page, @RequestParam("limit") int limit) {
        return ResponseEntity.ok(String.format("getAllProducts, page = %d, limit= %d", page, limit));
    }
    @GetMapping("/{id}")
    public ResponseEntity<String> getProductById(@PathVariable("id") String  productId) {
        return ResponseEntity.ok("Product with ID: " +  productId);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String>  deleteProduct(@PathVariable long id) {
        return ResponseEntity.status(HttpStatus.OK).body(String.format("Delete product with ID= %d is successfully", id));
    }
}
