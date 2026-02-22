package main;
import models.*;
import config.ProjectConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App {
    public static void main(String[] args) {
        // Initialize the spring context.
        var context = new AnnotationConfigApplicationContext(ProjectConfig.class);

        // Get the 3 instances of Parrot from the context.
        var p1 =  context.getBean("parrot1", Parrot.class);
        var p2 = context.getBean("parrot2", Parrot.class);
        var p3 =  context.getBean("parrot3", Parrot.class);
        System.out.println(p1.getName());
        System.out.println(p2.getName());
        System.out.println(p3.getName());

        // Get the Person instance from the context.
        var person = context.getBean(Person.class);
        System.out.println("\n" + person.getName());
        System.out.println(person.getParrot());
    }
}