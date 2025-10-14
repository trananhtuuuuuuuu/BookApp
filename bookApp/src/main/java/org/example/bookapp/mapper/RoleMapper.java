package org.example.bookapp.mapper;

import lombok.AllArgsConstructor;
import org.example.bookapp.dto.RoleDTO;
import org.example.bookapp.model.Role;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class RoleMapper {

    private final PermissionMapper permissionMapper;

    public RoleDTO toDTO(Role role) {
        return new  RoleDTO(
                role.getRoleName(),
                role.getDescription(),
                role.isActive(),
                this.permissionMapper.toDTO(role.getPermissions())
        );
    }
}
