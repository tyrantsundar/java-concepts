package designpatterns.creational.builder;

public class CustomerBuilder {
    private String firstName;
    private String lastName;
    private String middleName;
    private String primaryMail;
    private String secondaryMail;
    private String primaryMobile;
    private String secondaryMobile;
    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public String getPrimaryMail() {
        return primaryMail;
    }

    public String getSecondaryMail() {
        return secondaryMail;
    }

    public String getPrimaryMobile() {
        return primaryMobile;
    }

    public String getSecondaryMobile() {
        return secondaryMobile;
    }
    public CustomerBuilder withFirstName(String firstName){
        this.firstName = firstName;
        return this;
    }

    public CustomerBuilder withLastName(String lastName){
        this.lastName = lastName;
        return this;
    }

    public CustomerBuilder withMiddleName(String middleName){
        this.middleName = middleName;
        return this;
    }

    public CustomerBuilder withPrimaryMobile(String primaryMobile){
        this.primaryMobile = primaryMobile;
        return this;
    }
    public CustomerBuilder withSecondaryMobile(String secondaryMobile){
        this.secondaryMobile = secondaryMobile;
        return this;
    }

    public CustomerBuilder withPrimaryMail(String primaryMail){
        this.primaryMail = primaryMail;
        return this;
    }

    public CustomerBuilder withSecondaryMail(String secondaryMail){
        this.secondaryMail = secondaryMail;
        return this;
    }

    public Customer build(){
        return new Customer(this);
    }
}
