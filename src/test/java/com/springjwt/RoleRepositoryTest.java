package com.springjwt;

import com.springjwt.user.Role;
import com.springjwt.user.RoleRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import java.util.List;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(false)
public class RoleRepositoryTest {

    @Autowired
    private RoleRepository roleRepository;

    @Test
    public void testCreateRoles() {
        Role admin = new Role("ROLE_ADMIN");
        Role editor = new Role("ROLE_EDITOR");
        Role customer = new Role("ROLE_CUSTOMER");

        roleRepository.saveAll(List.of(admin, editor, customer));

        long numberOfRoles = roleRepository.count();

    }

    @Test
    public void testListRoles() {
        List<Role> listRoles = roleRepository.findAll();
        listRoles.forEach(System.out::println);
    }

}
