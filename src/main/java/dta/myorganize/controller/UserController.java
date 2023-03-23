package dta.myorganize.controller;

import dta.myorganize.model.User;
import dta.myorganize.model.form.UserForm;
import dta.myorganize.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/users")
@PreAuthorize("hasRole('ROLE_ADMIN')")
public class UserController {
    @Autowired
    private UserService userService;
    @PreAuthorize("permitAll")
    @GetMapping
    public String userHome(){return "Users - Esse modulo está em desenvolvimento";}
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PostMapping("/create")
    public User create(@RequestBody UserForm userForm){return userService.create(userForm);}
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PutMapping("/update")
    public User update(@RequestBody UserForm userForm){return userService.update(userForm);}
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @DeleteMapping("/delete")
    public String delete(@RequestParam(value = "uuid") UUID uuid){return userService.delete(uuid);}
}
