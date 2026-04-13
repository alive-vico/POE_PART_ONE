import java.util.Scanner;

public class Registration {

    Scanner scanner = new Scanner(System.in);

    String userName;
    String password;
    String PhoneNumber;
    String FirstName;
    String LastName;

    public boolean checkuserName(String username) {
        return username.length() <= 5 && username.contains("_");
    }

    public boolean checkPassword(String password) {
        if (password.length() < 8) {
            return false;
        }
        boolean hasUppercase = false;
        boolean hasSpecial = false;
        boolean hasDigit = false;

        for (char ch : password.toCharArray()) {
            if ( Character.isUpperCase(ch)) hasUppercase = true;
            if (!Character.isLetterOrDigit(ch)) hasSpecial =true;
            if (Character.isDigit(ch)) hasDigit = true;
        }
        return hasUppercase && hasSpecial && hasDigit;


    }

    public boolean checkphoneNumber(String phoneNumber) {
        return phoneNumber.matches("(\\+27|0)[0-9]{9} ");
    }
    public void Register() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter First Name");
        FirstName = scanner.nextLine();
        System.out.println("Enter Last Name");
        LastName = scanner.nextLine();

        do {
            System.out.println("Enter a username, must contain '_' and should not be more than 5");
            userName = scanner.nextLine();

            if (!checkuserName(userName)){
                System.out.println("invalid userName, please try again");
            }
        }while (!checkuserName(userName));

        do {
            System.out.println("Enter phone number(must contain southAfrican county code and 10 numbers)");
            PhoneNumber = scanner.nextLine();

            if (!checkphoneNumber(PhoneNumber)) {
                System.out.println("invalid phoneNumber, please try again");
            }
        }while ( !checkphoneNumber(PhoneNumber));

        while (true) {
            System.out.println("Enter password");
            password = scanner.nextLine();

            if (checkPassword(password)) {
                break;
            } else {
                System.out.println("Incorrect password");
                System.out.println("Password should contain a capital letter, special characters or digits");
            }
        }


        System.out.println("Registration succesful");

        Login login= new Login(userName,password, "Alive", "Vico");
        login.LoginUser(userName,password);

    }
}
   