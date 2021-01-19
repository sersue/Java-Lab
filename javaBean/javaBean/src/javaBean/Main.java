package javaBean;
import javaBean.Person;
public class Main {
	
	
	public static void main(String args[]) {
		
		Person schoolmate = new Person();
//		Person schoolmate2 = new Person("suelym",23,162,45);

		schoolmate.print();
//		schoolmate2.print();
		schoolmate.setName("suelym");
		schoolmate.setWeight(45);
		schoolmate.print();
		schoolmate.Eating();
	}

}
