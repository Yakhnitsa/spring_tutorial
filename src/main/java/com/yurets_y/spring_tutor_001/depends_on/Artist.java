package com.yurets_y.spring_tutor_001.depends_on;


import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.DependsOn;
import org.springframework.stereotype.Component;

@Component
@DependsOn({"rockGuitar","bassGuitar"})
//Гарантирует создание полноценного компонента, если не включить, экземпляр создастся,
// и приложение упадет, при обращении к неинициализированному компоненту
public class Artist implements ApplicationContextAware {
    private ApplicationContext appContext;
    private Guitar guitar;
    private Guitar bassGuitar;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.appContext = applicationContext;
    }

    public void play(){


        guitar = appContext.getBean("rockGuitar",Guitar.class);
        bassGuitar = appContext.getBean("bassGuitar",Guitar.class);

        System.out.println("Take your guitar....");
        System.out.println("Play!!!");
        guitar.play();
        bassGuitar.play();
    }
}
