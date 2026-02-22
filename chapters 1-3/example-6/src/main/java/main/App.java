package main;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import models.Parrot;
import config.ProjectConfig;

import java.util.function.Supplier;


public class App {
    public static void main(String[] args) {
        // Initialize the spring context.
        var context = new AnnotationConfigApplicationContext(ProjectConfig.class);

        // Define an instance we want to add to the Spring Context.
        var parrot = new Parrot();
        parrot.setName("KFC");

        // Define a supplier for the Parrot.
        Supplier<Parrot> parrotSupplier = () -> parrot;

        // Add the instance to the Spring context.
        context.registerBean("parrot1", Parrot.class, parrotSupplier);

        // Retrieve an instance from the context.
        var instance = context.getBean(Parrot.class);
        System.out.println(instance.getName());

        // Getting an instance by the bean name.
        var i2 = context.getBean("parrot1", Parrot.class);
        System.out.println(i2.getName());

        System.out.println(i2 == instance);

        // Adding additional configurations about the bean in the varargs parameter.
        var p2 = new Parrot();
        p2.setName("Nandos");
        Supplier<Parrot> p2Supplier = () -> p2;
        context.registerBean("parrot2",
                        Parrot.class,
                        p2Supplier,
                        bc -> bc.setPrimary(true));
    }
}