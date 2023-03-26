package dta.myorganize.init;

import dta.myorganize.enums.QuotaName;
import dta.myorganize.enums.RoleName;
import dta.myorganize.model.Quota;
import dta.myorganize.model.Role;
import dta.myorganize.model.User;
import dta.myorganize.service.QuotaService;
import dta.myorganize.service.RoleService;
import dta.myorganize.service.UserService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
@Component
public class StartApplication implements CommandLineRunner {
    @Autowired
    private UserService userService;
    @Autowired
    private StartRole startRole;
    @Autowired
    private StartQuota startQuota;
    @Autowired
    private PasswordEncoder encoder;
    @Value("${security.password}")
    private String password;

    @Override
    public void run(String... args) throws Exception {

        // Criação automatica da tabela de Quotas
        startQuota.startQuota();

        // Criação automatica da tabelas de Roles
        Role roleAdmin = startRole.startRole();

        // Criação automatica do usuário admin
        Optional<User> userOptional = userService.findByUsername("admin");
        if(userOptional.isEmpty()){
            User user = new User();
            user.setName("administrador");
            user.setUsername("admin");
            user.setPassword(encoder.encode(password));
            user.setEmail("admin@admin.com.br");
            user.getRoles().add(roleAdmin);
            userService.createStart(user);
        }
    }
}
