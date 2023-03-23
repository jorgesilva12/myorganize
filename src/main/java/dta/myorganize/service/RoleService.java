package dta.myorganize.service;

import dta.myorganize.enums.RoleName;
import dta.myorganize.model.Role;
import dta.myorganize.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RoleService {
    @Autowired
    private RoleRepository roleRepository;
    public Optional<Role> findByRoleName(RoleName roleName){return roleRepository.findByRoleName(roleName);}
    public Role roleName(RoleName roleName){
        Optional<Role> roleOptional = roleRepository.findByRoleName(roleName);
        Role role = roleOptional.get();
        return role;
    }
    public Role create(Role role){return roleRepository.save(role);}
}
