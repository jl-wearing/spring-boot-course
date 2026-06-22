package org.example;

import org.example.configurations.ProjectConfig;
import org.example.models.Parrot;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App {
    public final static String[] colors = {"red", "green", "blue"};
    private static final String[] names = {"subaru", "imprezza", "gt3rs", "gtr", "g63", "messi", "ronaldo", "nazario", "kaka", "mourinho"};

    public static void main( String[] args ) {
        // Initialize the spring context.
        var context = new AnnotationConfigApplicationContext();

        // Suppose you have a list of parrots of different colors, and you only want to add green parrots to the context.
        Parrot[] flock = new Parrot[10];
        for (int i = 0; i < 10; i++) {
            // Create a new parrot.
            flock[i] = new Parrot();

            // Set the name of the parrot.
            flock[i].setName(names[i]);

            // Set the color of the parrot.
            flock[i].setColor(colors[i % 3]);

            // Add the parrot to the context only if it is green.
            if (flock[i].getColor().equalsIgnoreCase("green")) {
                final int temp = i;
                context.registerBean("parrot" + (i+1), Parrot.class, () -> flock[temp]);
            }
        }

        // Refresh the context.
        context.register(ProjectConfig.class);
        context.refresh();

        // Retrieve the instances in the Spring context.
        String[] names = context.getBeanNamesForType(Parrot.class);

        for (String name : names) {
            Parrot parrot = context.getBean(name, Parrot.class);
            System.out.println(parrot.toString());
        }
    }
}
