import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.nio.file.*;
import java.io.IOException;
import java.util.*;

public class CustomerService {
    private final ObjectMapper mapper = new ObjectMapper();

    public void processCustomers(Path jsonInput, Path txtOutput) {
        try {
            Map<String, Map<String, Object>> customerMap = mapper.readValue(
                    jsonInput.toFile(),
                    new TypeReference<>() {}
            );

            List<String> results = new ArrayList<>();
            System.out.println("Search data: ");

            for (Map.Entry<String, Map<String, Object>> entry : customerMap.entrySet()) {
                String lastName = entry.getKey();
                Map<String, Object> fields = entry.getValue();

                if ("Odesa".equalsIgnoreCase((String) fields.get("city"))) {
                    System.out.println(lastName + " | " + fields);
                    results.add(lastName + " | " + fields);
                }
            }

            Files.write(txtOutput, results);
            System.out.println("\nAll results saved in: " + txtOutput.getFileName());

        } catch (IOException e) {
            System.err.println("Error with: " + e.getMessage());
        }
    }
}