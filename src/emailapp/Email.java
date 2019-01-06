package emailapp;

import java.util.Scanner;

public class Email {
    private String firstName;
    private String lastName;
    private String password;
    private int defaultPasswordLength = 10;
    private String department;
    private String email;
    private String companySuffix = "umagcompany.com";
    private int mailboxCapacity = 500;
    private String alternateEmail;

    Scanner in = new Scanner(System.in);

    public Email() {
        System.out.print("Enter your first name: ");
        this.firstName = in.next();

        System.out.print("Enter your last name: ");
        this.lastName = in.next();

        this.department = setDepartment();

        this.password = randomPassword(defaultPasswordLength);

        email = firstName.toLowerCase() + "." + lastName.toLowerCase() + "@" + department + "." + companySuffix;

    }

    private String setDepartment(){
        System.out.print("Department codes\n1 for Sales\n2 for Development\n3 for Accounting\n0 for none\n Enter department code: ");
        int depChoice = in.nextInt();
        if (depChoice == 1){
            return "sales";
        } else if (depChoice == 2 ) {
            return "dev";
        } else if (depChoice == 3 ) {
            return "acct";
        } else {
            return "";
        }
    }

    private String randomPassword(int length){
        String passwordSet = "ABCDEFGHIJKLMNQPQRSTUWXYZ0123456789!@#$%";
        char[] password = new char[length];
        for (int i = 0; i<length; i++){
            int rand = (int) (Math.random() * passwordSet.length());
            password[i] = passwordSet.charAt(rand);
        }
        return new String(password);
    }

    public void setMailboxCapacity(int mailboxCapacity) {
        this.mailboxCapacity = mailboxCapacity;
    }

    public void setAlternateEmail(String alternateEmail) {
        this.alternateEmail = alternateEmail;
    }

    public void changePassword(String password){
        this.password = password;
    }

    public int getMailboxCapacity() {
        return mailboxCapacity;
    }

    public String getAlternateEmail() {
        return alternateEmail;
    }

    public String getPassword(){
        return this.password;
    }

    public String showInfo(){
        return "Display Name: " + firstName + " " + lastName + "\nCompany Email: " + email + "\nYour password: " + password +"\nMailbox Capacity: " + mailboxCapacity + "mb";
    }
}
