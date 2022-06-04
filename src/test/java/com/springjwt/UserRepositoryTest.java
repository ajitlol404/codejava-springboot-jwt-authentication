package com.springjwt;

import com.springjwt.user.Role;
import com.springjwt.user.User;
import com.springjwt.user.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.annotation.Rollback;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(false)
public class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    public void testCreateUser() {
        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

        String rawPassword = "12345678";
        User newUser = new User("akn1@mail.com", passwordEncoder.encode(rawPassword));

        User savedUser = userRepository.save(newUser);
    }

    @Test
    public void testAssignRolesToUser() {
        Integer userId = 3;
        User user = userRepository.findById(userId).get();
        user.addRole(new Role(2));
        user.addRole(new Role(3));
        User updatedUser = userRepository.save(user);

    }

    @Test
    public void  testString()
    {
        String demo="[[ROLE_CUSTOMER], [ROLE_EDITOR]]";
        String replace = demo.replace("[", "").replace("]", "");
        System.out.println(replace);
    }


}
