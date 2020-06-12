package com.yurets_y.spring_tutor_001.config;


import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

@Configuration
@ImportResource(locations = {"classpath:spring/app-context-annotated.xml",
        "classpath:spring/app-context-autoconnection.xml"})

public class XmlImportedConfiguration {

}
