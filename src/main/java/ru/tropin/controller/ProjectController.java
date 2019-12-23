package ru.tropin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import ru.tropin.model.Bug;
import ru.tropin.model.Project;
import ru.tropin.repository.BugRepository;
import ru.tropin.repository.ProjectRepository;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/projects")
public class ProjectController {

    @Autowired
    BugRepository bugRepository;

    @Autowired
    ProjectRepository projectRepository;

    @GetMapping
    public String getProjects(ModelMap modelMap) {
        modelMap.addAttribute("bugs", projectRepository.findAll());
        modelMap.addAttribute("projects", projectRepository.findAll());
        return "projects";
    }

    @RequestMapping(method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public String saveProject(ModelMap modelMap, @RequestParam Map<String, String> body) {
        Project newProject = Project.builder().name(body.get("name")).build();
        projectRepository.save(newProject);
        modelMap.addAttribute("bugs", bugRepository.findAll());
        modelMap.addAttribute("projects", projectRepository.findAll());
        return "projects";
    }
}
