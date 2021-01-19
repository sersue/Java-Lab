package javaBean;

public class Person {
	
//	String name ;
//	int age ;
//	int weight;
//	int height;
//	
	//setter,getter
	private String name ;
	private int age ;
	private int weight;
	private int height;
	
	//멤버변수 초기
//	public Person(String name, int age, int height, int weight){
//		this.name=name;
//		this.age =age;
//		this.weight=weight;
//		this.height =height;
//	}
	
	public void setName(String name) {
		this.name=name;
	}
	public void setAge(int age) {
		this.age=age;
	}
	public void setHeight(int height) {
		this.height=height ;
	}
	public void setWeight(int weight) {
		this.weight=weight  ;
	}
	public String getName() {
		return name;
	}
	public int getAge() {
		return age;
	}
	public int getHeight() {
		return height;
	}
	public int getWeight() {
		return weight;
	}
	
	public void print() {
		System.out.println(this.name);
		System.out.println(this.age);
		System.out.println(this.height);
		System.out.println(this.weight);

	}
	

	public void Sleep() {
	
		System.out.println(this.getName()+"is sleeping");
		
	}
	public void Eating() {
		System.out.println(this.getName()+"is Eating");
		int increased=this.getWeight()+1;
		System.out.println(this.getName()+increased+"kg");

	}
	public void pooping() {
		System.out.println(this.getName()+"is Pooping");

	}
}
