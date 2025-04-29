package designpatterns.creational.builder;

public class Main {
    public static void main(String[] args) {
        Customer customer = new CustomerBuilder()
                .withFirstName("Sundar")
                .withMiddleName("Prabu")
                .withLastName("raj")
                .withPrimaryMail("primaryMail@gmail.com")
                .withSecondaryMail("secondaryMail@gmail.com")
                .withPrimaryMobile("1234567890")
                .withSecondaryMobile("0987654321")
                .build();
        System.out.println(customer.toString());
    }
}
