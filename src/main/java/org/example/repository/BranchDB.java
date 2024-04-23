package org.example.repository;

import org.example.model.Branch;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class BranchDB implements IBranchDB {

    private List<Branch> branchRepository;

    public BranchDB() {
        this.branchRepository = new ArrayList<>();
    }

    @Override
    public void addBranch(Branch branch) {
        branchRepository.add(branch);
    }

    @Override
    public void editBranch(Branch branch) {
        int indexList = 0;
        for (int x = 0; x < branchRepository.size()-1; x++) {
            if (branch == branchRepository.get(x)) {
                indexList = x;
            }
        }
        branchRepository.add(indexList, branch);
    }

    @Override
    public void deleteBranch(Branch branch) {
        branchRepository.remove(branch);
    }

    @Override
    public List<Branch> getListBranch() { return branchRepository; }
}
