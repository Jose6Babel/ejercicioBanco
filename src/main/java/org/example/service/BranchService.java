package org.example.service;

import org.example.model.Branch;
import org.example.repository.IBranchDB;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BranchService implements IBranchService {

    private final IBranchDB iBranchDB;

    public BranchService(IBranchDB iBranchDB) { this.iBranchDB = iBranchDB; }

    @Override
    public void addBranch(Branch branch) {
        iBranchDB.addBranch(branch);
    }

    @Override
    public void editBranch(Long id) {
        List<Branch> listBranch = listBranch();
        Branch branchEdit = null;

        for (Branch branchFound: listBranch) {
            if (branchFound.getId() == id) {
                branchEdit = branchFound;
            }
        }
        iBranchDB.editBranch(branchEdit);
    }

    @Override
    public List<Branch> listBranch() {
        return iBranchDB.getListBranch();
    }

    @Override
    public void deleteBranch(Long id) {
        List<Branch> listBranch = listBranch();
        Branch branchDelete = null;

        for (Branch branchFound: listBranch) {
            if (branchFound.getId() == id) {
                branchFound = branchDelete;
            }
        }
        iBranchDB.deleteBranch(branchDelete);
    }
}
