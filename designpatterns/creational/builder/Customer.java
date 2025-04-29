package designpatterns.creational.builder;

public class Customer {
    private final String firstName;
    private final String lastName;
    private final String middleName;
    private final String primaryMail;
    private final String secondaryMail;
    private final String primaryMobile;
    private final String secondaryMobile;

    public Customer(CustomerBuilder customerBuilder) {
        this.firstName = customerBuilder.getFirstName();
        this.lastName = customerBuilder.getLastName();
        this.middleName = customerBuilder.getMiddleName();
        this.primaryMail = customerBuilder.getPrimaryMail();
        this.secondaryMail = customerBuilder.getSecondaryMail();
        this.primaryMobile = customerBuilder.getPrimaryMobile();
        this.secondaryMobile = customerBuilder.getSecondaryMobile();
    }

    @Override
    public String toString() {
        return "\nCustomer{" +
                "\nfirstName='" + firstName + '\'' +
                ", \nlastName='" + lastName + '\'' +
                ", \nmiddleName='" + middleName + '\'' +
                ", \nprimaryMail='" + primaryMail + '\'' +
                ", \nsecondaryMail='" + secondaryMail + '\'' +
                ", \nprimaryMobile='" + primaryMobile + '\'' +
                ", \nsecondaryMobile='" + secondaryMobile + '\'' +
                '}';
    }
}
