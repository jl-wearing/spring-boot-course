package main;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import models.Parrot;
import config.ProjectConfig;
import java.util.function.Supplier;

public class App {
    public static void main(String[] args) {
        // Initialize the Spring context.
        // When adding beans programmatically, if you add the configuration, you won't be allowed to add new beans.
        // Hence, you must refresh the context after adding beans to the context.
        var context = new AnnotationConfigApplicationContext();

        // Suppose we have an array of Parrots of varying colors.
        String[] colors = {"red", "green", "blue"};
        String[] parrotNames = {"messi", "ronaldo", "nazario", "mbappe", "erling", "toyota", "subaru", "imprezza", "supra", "e70 x5m", "e92 m3"};
        Parrot[] parrots = new Parrot[parrotNames.length];

        int counter = 1;
        for (int i = 0; i < parrotNames.length; i++) {
            // Initialize a parrot.
            parrots[i] = new Parrot();
            // Set the name of the parrot.
            parrots[i].setName(parrotNames[i]);
            // Set the color of the parrot.
            parrots[i].setColor(colors[i % 3]);

            // Now, suppose we only want to add green parrots to the context.
            if (parrots[i].getColor().equals("green")) {
                final Parrot currentParrot = parrots[i];

                // Add the parrot to the context.
                context.registerBean("parrot" + counter,
                        Parrot.class,
                        () -> currentParrot);
                counter++;
            }
        }

        // Lock the context.
        context.refresh();

        // Check
        var p1 = context.getBean("parrot1", Parrot.class);
        System.out.println(p1.getColor());
        System.out.println(p1.getName());
    }
}