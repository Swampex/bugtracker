package ru.tropin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
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

    @GetMapping(value = "/info", params = "id")
    public String getBug(ModelMap modelMap, @RequestParam long id) {
        Project project = projectRepository.getOne(id);
        modelMap.addAttribute("project", project);
        modelMap.addAttribute("bugs", bugRepository.fetchById(project));
        return "projectInfo";
    }

    @GetMapping(value = "/delete", params = "id")
    public ModelAndView deleteProjectById(ModelMap modelMap, @RequestParam long id) {
        projectRepository.delete(id);
        modelMap.addAttribute("bug", bugRepository.findAll() );
        modelMap.addAttribute("projects", projectRepository.findAll() );
        return new ModelAndView("redirect:/projects", modelMap);
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

    @RequestMapping(value = "/update", params = "id", method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public ModelAndView updateProject(ModelMap modelMap, @RequestParam Map<String, String> body, @RequestParam long id) {
        Project project = projectRepository.getOne(Long.valueOf(body.get("id")) );
        project.setName(body.get("project_name"));
        projectRepository.save(project);
        modelMap.addAttribute("bug", bugRepository.getOne(Long.valueOf(body.get("id"))) );
        modelMap.addAttribute("projects", projectRepository.findAll());
        return new ModelAndView("redirect:/projects", modelMap);
    }
}
