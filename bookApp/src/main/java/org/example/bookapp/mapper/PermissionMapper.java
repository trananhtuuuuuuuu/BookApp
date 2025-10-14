package org.example.bookapp.mapper;

import org.example.bookapp.dto.PermissionDTO;
import org.example.bookapp.model.Permission;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class PermissionMapper {
    public PermissionDTO toDTO(Permission permission) {
        return  new PermissionDTO(
                permission.getEndPointAccess(),
                permission.getDescription(),
                permission.getMethod()
        );
    }

    public List<PermissionDTO> toDTO(List<Permission> permissions) {
        List<PermissionDTO> permissionDTOs = new ArrayList<>();
        for (Permission permission : permissions) {
            permissionDTOs.add(toDTO(permission));
        }
        return permissionDTOs;
    }
}
