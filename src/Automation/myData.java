package Automation;

import java.util.Random;

public class myData {

	Random rand = new Random();

	String[] FirstNames = { "Sam", "Tom", "Dan", "Lily", "Dev", "Mel" };

	String[] LastNames = { "Smith", "Rogers", "Clark", "Dacon", "Comms", "Trevors" };

	int randomNumerForTheEmail = rand.nextInt(9845);

	String domain = "@gmail.com";

	int randomFirstNameIndex = rand.nextInt(FirstNames.length);

	int randomLastNameIndex = rand.nextInt(LastNames.length);

	String TheFirstName = FirstNames[randomFirstNameIndex];

	String TheLastName = LastNames[randomLastNameIndex];

	String TheEmail = TheFirstName + TheLastName + randomNumerForTheEmail + domain;

	String Telephone = "1546697532";

	String TheFaxNumber = "354687";

	String TheAddressOne = "Amman- Jordan";

	int theSelectStateIndex = rand.nextInt(1, 10);

	String PostalCode = "1355";

	String LOGINAME = TheFirstName + TheLastName + randomNumerForTheEmail;

	String Password = "P@ssw0rd";

	String ExpectedTextforTheSignUp = "YOUR ACCOUNT HAS BEEN CREATED!";
	
	String TheLogoutMessage = "You have been logged off your account. It is now safe to leave the computer.";
	
	
	String WelcomeMessage = "Welcome back " +TheFirstName;
	
}
