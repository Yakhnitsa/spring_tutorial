package com.yurets_y.spring_tutor_001;

import com.yurets_y.spring_tutor_001.annotation.CollectionsHolder;
import com.yurets_y.spring_tutor_001.bean_life_cycle.BeanLifecycleConfig;
import com.yurets_y.spring_tutor_001.bin.MessageSender;
import com.yurets_y.spring_tutor_001.config.AutoScanConfiguration;
import com.yurets_y.spring_tutor_001.config.SimpleConfiguration;
import com.yurets_y.spring_tutor_001.config.XmlImportedConfiguration;
import com.yurets_y.spring_tutor_001.depends_on.Artist;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class Application {
    public static void main(String[] args) {
//        xmlConfiguredApplicationContext();
//        collectionInjectionExample();
        beanLifecycleExample();
    }


    static void xmlConfiguredApplicationContext() {

        ApplicationContext context = new AnnotationConfigApplicationContext(XmlImportedConfiguration.class);
        MessageSender sender = context.getBean("ukrMailSender", MessageSender.class);
        sender.sendMessage();

        sender = context.getBean("confMailSender", MessageSender.class);
        sender.sendMessage();
    }

    static void simpleApplicationContext() {
        ApplicationContext context = new AnnotationConfigApplicationContext(SimpleConfiguration.class);
        MessageSender sender = context.getBean("sender", MessageSender.class);
        sender.sendMessage();
    }

    static void collectionInjectionExample() {
        GenericXmlApplicationContext context = new GenericXmlApplicationContext();
        context.load("classpath:spring/app-context-collections.xml");
        context.refresh();

        CollectionsHolder collectionsHolder = context.getBean("collectionsHolder", CollectionsHolder.class);

        collectionsHolder.getStringList().forEach(System.out::println);

        collectionsHolder.getSimpleMap().forEach((key, value) -> System.out.println(key + " | " + value));

        collectionsHolder.getExtendedMap().forEach((key, value) -> {
                    System.out.print(key + " | ");
                    System.out.println(value.getClass());
                    System.out.println("message: " + value.getMessage());
                }


        );

    }

    static void dependsOnExample(){
        ApplicationContext context = new AnnotationConfigApplicationContext(AutoScanConfiguration.class);
        Artist artist = context.getBean("artist", Artist.class);
        artist.play();
    }

    static void beanAutoconnectionExample(){
        ApplicationContext context = new AnnotationConfigApplicationContext(XmlImportedConfiguration.class);
        context.getBean("compByType");
    }

    static void beanLifecycleExample(){
        GenericApplicationContext context = new AnnotationConfigApplicationContext(BeanLifecycleConfig.class);
        context.getBean("lifecycleBean");
//        System.out.println("creating annotation Comfigured bean");
//        context.getBean("annotationConfiguredLifecycleBean");
        context.close();
    }
}
