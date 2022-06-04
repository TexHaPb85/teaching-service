package edu.study.teachingmoduleservice.controller.thymeleaf;

import edu.study.teachingmoduleservice.domain.study.TheoryMaterial;
import edu.study.teachingmoduleservice.domain.user.User;
import edu.study.teachingmoduleservice.services.TheoryServiceImpl;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class StudyController {

    private final TheoryServiceImpl theoryService;

    public StudyController(TheoryServiceImpl theoryService) {
        this.theoryService = theoryService;
    }

    @GetMapping("/rest/courses/theory/{theoryId}")
    public String homePage(Model model, @AuthenticationPrincipal User user, @PathVariable String theoryId) {
        TheoryMaterial theoryById = theoryService.getTheoryById(theoryId);

        model.addAttribute("theory", theoryById);

        return "theory";
    }

}
