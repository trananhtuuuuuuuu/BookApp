package org.example.bookapp.service;

import lombok.AllArgsConstructor;
import org.example.bookapp.exception.AlreadyExistsException;
import org.example.bookapp.exception.ResourceNotFoundException;
import org.example.bookapp.model.Role;
import org.example.bookapp.repository.RoleRepository;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class RoleService {

    private final RoleRepository roleRepository;

    public boolean checkExists(String roleName) {
        boolean exists = this.roleRepository.existsByRoleName(roleName);
        if(!exists){
            throw new ResourceNotFoundException("Role does not exist");
        }
        return true;
    }


    public Role getRoleByRoleName(String roleName){
        if(!this.roleRepository.existsByRoleName(roleName)){
            throw new ResourceNotFoundException("Role does not exist");
        }
        return this.roleRepository.findByRoleName(roleName);
    }

}
