import java.util.function.Supplier;

public class SupplierTesting {
    public static void main( String[] args ) {
        Supplier<String> helloSupplier = () -> "hello";

        for (int i = 0; i < 5; i++)
            System.out.println(helloSupplier.get());
    }
}
