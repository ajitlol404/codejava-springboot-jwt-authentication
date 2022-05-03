package com.springjwt;

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
    UserRepository userRepository;

    @Test
    public void testCreateUser() {
        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

        String rawPassword = "12345678";
        User newUser = new User("akn1@mail.com", passwordEncoder.encode(rawPassword));

        User savedUser = userRepository.save(newUser);
    }

}
