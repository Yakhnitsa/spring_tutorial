package com.yurets_y.spring_tutor_001.configuration_profiles;


/* В тестовом окружении возможно явно указывать профиль, без аргумента VM*/

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@ActiveProfiles({"test"})
//Указание разных конфигураций для тестирования
//@ActiveProfiles({"development"})
//@ActiveProfiles({"production"})
// Указание общего указателя для нескольких файлов *-config = { development-config; production-config; test-config }
@ContextConfiguration(locations = {"classpath:spring/configurations/*-config.xml"})
public class ProfilesApplicationXmlTest {
    @Autowired
    private ConnectionService connection;

    @Test
    public void configurationTest() {
        System.out.println(connection);
    }
}
