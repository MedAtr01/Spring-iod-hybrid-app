package Presentation;

import Dao.IDao;
import Metier.IMetier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ContextAnnotationAutowireCandidateResolver;

import java.time.LocalDate;

public class PresSpringAnnotations {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext("Ext","Metier");
        IMetier metier = context.getBean(IMetier.class);
        System.out.println(metier.calculAge());
    }
}
