package RestAssuredTest;

import io.codearte.jfairy.Fairy;
import io.codearte.jfairy.producer.company.Company;
import io.codearte.jfairy.producer.person.Person;

public class Utility {
	public static String RandomFirstName() {
		Fairy fairy = Fairy.create();
		Person person = fairy.person();
		String name = person.getFirstName();
		return name;
	}
	
	public static String RandomLastName() {
		Fairy fairy = Fairy.create();
		Person person = fairy.person();
		String name = person.getLastName();
		return name;
	}
	
	public static String RandomUserName() {
		Fairy fairy = Fairy.create();
		Person person = fairy.person();
		String name = person.getUsername();
		return name;
	}
	
	public static String RandomPassword() {
		Fairy fairy = Fairy.create();
		Person person = fairy.person();
		String name = person.getPassword();
		return name;
	}
	
	public static String RandomEmail() {
		Fairy fairy = Fairy.create();
		Person person = fairy.person();
		String name = person.getEmail();
		return name;
	}

	public static String RandomAge() {
		Fairy fairy = Fairy.create();
		Person person = fairy.person();
		int Age = person.getAge();
		String name=Integer.toString(Age);
		return name;
	}
	public static String RandomSalary() {
		Fairy fairy = Fairy.create();
		int RandomNumb = fairy.baseProducer().randomBetween(100000, 900000);
		String name=Integer.toString(RandomNumb);
		return name;
	}
}
