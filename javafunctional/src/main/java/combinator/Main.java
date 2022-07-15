package combinator;

import java.time.LocalDate;

import static combinator.CustomerRegistrationValidator.*;

public class Main {
    public static void main(String[] args) {
        Customer customer = new Customer(
                "Alice",
                "alice@gmail.com",
                "+08549584988",
                LocalDate.of(2000, 1, 1)
        );
        System.out.println(isEmailValid().and(isPhoneNumberValid()).and(isAnAdult()).apply(customer));
    }
}
