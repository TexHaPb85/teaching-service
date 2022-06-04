package edu.study.teachingmoduleservice.controller.rest;

import edu.study.teachingmoduleservice.domain.study.TheoryMaterial;
import edu.study.teachingmoduleservice.services.TheoryServiceImpl;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("rest/theories")
public class TheoryControllerREST {

    private final TheoryServiceImpl theoryService;

    public TheoryControllerREST(TheoryServiceImpl theoryService) {
        this.theoryService = theoryService;
    }
    @GetMapping
    public List<TheoryMaterial> getAllTheories(){
        return theoryService.getAllTheories();
    }
}
