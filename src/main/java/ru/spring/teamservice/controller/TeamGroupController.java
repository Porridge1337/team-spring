package ru.spring.teamservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.spring.teamservice.model.Group;
import ru.spring.teamservice.service.GroupService;

import java.util.List;

@RestController
@RequestMapping("/api")
public class TeamGroupController {

    private final GroupService groupService;

    @Autowired
    public TeamGroupController(GroupService groupService) {
        this.groupService = groupService;
    }

    @GetMapping("/group/all")
    public List<Group> getAllGroups() {
        return groupService.findAllGroups();
    }

    @PostMapping("/group/create")
    public boolean createGroup(@RequestBody Group group) {
        return groupService.saveGroup(group);
    }

    @PatchMapping("/group/update/{id}")
    public boolean updateGroup(@RequestBody Group group, @PathVariable int id) {
        return groupService.updateGroup(group, id);
    }

    @DeleteMapping("/group/delete/{id}")
    public boolean deleteGroup(@PathVariable int id) {
        return groupService.deleteGroupById(id);
    }

}
