package com.Project.Controllers;

import java.lang.classfile.ClassFile.Option;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Project.Entities.Image;
import com.Project.Services.ImageService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;



@RestController
@RequestMapping("/image")
public class ImageController {
    
  //  private static final String Optional = null;
        @Autowired
        private ImageService imageService;
    
        @PostMapping("/add")
        public ResponseEntity<Image> uploadImage(@RequestBody Image image) {
           Image savedImage =  imageService.saveImage(image); 
            return new ResponseEntity<>(savedImage ,HttpStatus.CREATED);
           
        }
    
        @GetMapping("/all")
        public ResponseEntity<List<Image>> getAllImages() {
            List<Image> images = imageService.getAllImages();
            return new ResponseEntity<>(images,HttpStatus.CREATED);
        }
        
        @GetMapping("/{id}")
        public ResponseEntity<Image> getImageById(@PathVariable Integer id) 
        {
            Optional<Image> image = imageService.getImageById(id);
            return image.map( value -> new ResponseEntity<>(value,HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

        @DeleteMapping("/delete/{id}")
        public ResponseEntity<Void> deletImage(@PathVariable int id)
        {
            imageService.deleteImage(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

}
