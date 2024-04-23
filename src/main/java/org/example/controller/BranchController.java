package org.example.controller;

import org.example.model.Branch;
import org.example.model.Client;
import org.example.service.BranchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/branch")
public class BranchController {

    @Autowired
    private final BranchService branchService;

    public BranchController(BranchService branchService) {
        this.branchService = branchService;
    }
    @GetMapping
    public String listBranch(Model model) {
        model.addAttribute("listBranch", branchService.listBranch());
        return "/branch";
    }
    @PostMapping(value = "/add")
    public void addBranch(@ModelAttribute Branch branch) {
        branchService.addBranch(branch);
    }

    @DeleteMapping(value = "/delete/{id}")
    public void deleteBranch( @PathVariable("id") Long id ) {
        branchService.deleteBranch(id);
    }

    @PostMapping(value = "/edit/{id}")
    public void editBranch( @PathVariable("id") Long id,  @RequestBody Branch branch) {
        branchService.editBranch(id, branch);
    }

}
