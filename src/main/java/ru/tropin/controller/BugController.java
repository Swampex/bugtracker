package ru.tropin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import ru.tropin.model.Bug;
import ru.tropin.dto.BugCreationDto;
import ru.tropin.repository.BugRepository;
import ru.tropin.repository.ProjectRepository;
import ru.tropin.util.DTO;

import java.util.Map;

@Controller
@RequestMapping("/bugs")
public class BugController {

    @Autowired
    BugRepository bugRepository;

    @Autowired
    ProjectRepository projectRepository;

    @GetMapping
    public String getBugsPage(ModelMap modelMap) {
        modelMap.addAttribute("bugs", bugRepository.findAll());
        modelMap.addAttribute("projects", projectRepository.findAll());
        return "bugs";
    }

    @PostMapping(consumes = "application/json")
    public String saveBugJson(@RequestBody @DTO(BugCreationDto.class) Bug bug) {
        System.out.println("Bug from browser: " + bug.toString());
        bugRepository.save(bug);
        return "bugs";
    }

    @RequestMapping(method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public String saveBugFormEncoded(ModelMap modelMap, @RequestParam Map<String, String> body) {
        bugRepository.save(new Bug(body, projectRepository));
        modelMap.addAttribute("bugs", bugRepository.findAll());
        modelMap.addAttribute("projects", projectRepository.findAll());
        return "bugs";
    }

    @GetMapping(value = "/info", params = "id")
    public String getBugById(ModelMap modelMap, @RequestParam long id) {
        modelMap.addAttribute("bug", bugRepository.getOne(id));
        modelMap.addAttribute("projects", projectRepository.findAll());
        return "bugInfo";
    }

    @RequestMapping(value = "/update", params = "id", method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public ModelAndView updateBugById(ModelMap modelMap, @RequestParam Map<String, String> body, @RequestParam long id) {
        Bug bug = bugRepository.getOne(Long.valueOf(body.get("id")));
        bug.setTitle(body.get("title"));
        bug.setDescription(body.get("description"));
        bug.setProject(projectRepository.findOne(Long.valueOf(body.get("project_id_name"))));
        bugRepository.save(bug);
        modelMap.addAttribute("bug", bugRepository.getOne(Long.valueOf(body.get("id"))));
        modelMap.addAttribute("projects", projectRepository.findAll());
        return new ModelAndView("redirect:/bugs", modelMap);
    }

    @GetMapping(value = "/delete", params = "id")
    public ModelAndView deleteBugById(ModelMap modelMap, @RequestParam long id) {
        bugRepository.delete(id);
        modelMap.addAttribute("bug", bugRepository.findAll());
        modelMap.addAttribute("projects", projectRepository.findAll());
        return new ModelAndView("redirect:/bugs", modelMap);
    }
}