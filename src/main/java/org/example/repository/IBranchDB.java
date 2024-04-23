package org.example.repository;

import org.example.model.Branch;

import java.util.ArrayList;
import java.util.List;

public interface IBranchDB {
    void addBranch(Branch branch);

    void editBranch(Branch branch);

    void deleteBranch(Branch branch);

    List<Branch> getListBranch();
}
