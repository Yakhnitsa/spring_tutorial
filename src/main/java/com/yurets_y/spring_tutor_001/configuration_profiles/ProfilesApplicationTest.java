package com.yurets_y.spring_tutor_001.configuration_profiles;


/* В тестовом окружении возможно явно указывать профиль, без аргумента VM*/

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;

@RunWith(SpringRunner.class)
@ActiveProfiles({"development"})
@ContextConfiguration(classes = {
        DevelopmentConfig.class,
        ProductionConfig.class
    }
)
public class ProfilesApplicationTest {
    @Autowired
    private ConnectionService connection;

    @Test
    public void configurationTest() {
        System.out.println(connection);
    }
}
