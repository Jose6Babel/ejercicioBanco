package org.example.service;

import org.example.model.Branch;

import java.util.List;

public interface IBranchService {
    void addBranch(Branch branch);

    void editBranch(Long id);

    List<Branch> listBranch();
    void deleteBranch(Long id);



}
