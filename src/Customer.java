import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record Customer(
        String firstName,
        String middleName,
        String gender,
        String nationality,
        double height,
        double weight,
        int birthYear,
        int birthMonth,
        int birthDay,
        String phone,
        String zip,
        String country,
        String region,
        String district,
        String city,
        String street,
        String house,
        String apartment,
        String creditCard,
        String bankAccount
) {}