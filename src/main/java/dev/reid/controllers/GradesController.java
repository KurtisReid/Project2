package dev.reid.controllers;

import com.google.gson.Gson;
import dev.reid.entities.Grade;
import dev.reid.entities.Student;
import dev.reid.services.GradeService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@CrossOrigin
public class GradesController {

    Logger logger = LogManager.getLogger(GradesController.class);

    private Gson gson = new Gson();

    @Autowired
    GradeService gradeService;


    @PostMapping("/grades")
    @ResponseBody
    public Grade createGrade(@RequestBody Grade grade){
        logger.info("POST grade request");
        Grade savedGrade = this.gradeService.createGrade(grade);
        return savedGrade;

    }


    @GetMapping("/grades/{id}")
    @ResponseBody
    public List<Grade> getGradeByStudentId(@PathVariable String id){
        logger.info("GET grade by id request");
        int studentId = Integer.parseInt(id);
        List<Grade> returnGrades = this.gradeService.getGradesByStudentId(studentId);
        return returnGrades;
    }


    @GetMapping("/grades")
    @ResponseBody
    public ResponseEntity<String> getAllGrades(){
        logger.info("GET all grade request");
        return new ResponseEntity<>("Route unavailable", HttpStatus.CONTINUE);
    }


    @PutMapping("/grades")
    @ResponseBody
    public ResponseEntity<String> updateGrade(@RequestBody Grade grade){
        logger.info("PUT grade request");
        return new ResponseEntity<>("PUT request not available\nPlease delete and create new grade", HttpStatus.CONTINUE);
    }


    @DeleteMapping("/grades/{id}")
    @ResponseBody
    public String deleteGrade(@PathVariable String id){
        logger.info("DELETE grade request");
        int gradeId = Integer.parseInt(id);
        if(this.gradeService.deleteGradeById(gradeId)){
            return "Grade with id: " +id+ " successfully deleted";
        }else{
            return "Grade with id: " +id+ " not found";
        }
    }
}
