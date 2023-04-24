package org.example.store.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.store.entity.Role;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {
    private String username;
    private String password;
    private Role role;
}
