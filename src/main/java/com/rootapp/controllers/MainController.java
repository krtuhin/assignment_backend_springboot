package com.rootapp.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rootapp.entities.Project;
import com.rootapp.repositories.ProjectRepository;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class MainController {

    @Autowired
    private ProjectRepository projectRepository;

    @PostMapping("/save-data")
    public ResponseEntity<?> saveData(@RequestBody Project project) {

        try {

            long id = System.currentTimeMillis();
            project.setId(id);

            Project save = this.projectRepository.save(project);

            return ResponseEntity.ok(save);

        } catch (Exception e) {

            e.printStackTrace();

            return new ResponseEntity<>("Cannot save data, try again..!", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/get-all-data")
    public ResponseEntity<?> getAllData() {
        try {

            List<Project> projects = this.projectRepository.findAll();

            return ResponseEntity.ok(projects);

        } catch (Exception e) {

            e.printStackTrace();

            return new ResponseEntity<>("Cannot find out any data...!", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/delete-data/{id}")
    public ResponseEntity<?> deleteData(@PathVariable("id") long id) {
        try {

            this.projectRepository.deleteById(id);

            return ResponseEntity.ok("Data deleted...!");

        } catch (Exception e) {

            e.printStackTrace();
            return new ResponseEntity<>("Problem occured, try again..!", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
