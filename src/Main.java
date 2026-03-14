import java.nio.file.Path;

public class Main {
    public static void main(String[] args) {
        run();
    }

    private static void run() {
        CustomerService service = new CustomerService();

        Path input = Path.of("customers.json");
        Path output = Path.of("odesa_report.txt");

        service.processCustomers(input, output);
    }
}