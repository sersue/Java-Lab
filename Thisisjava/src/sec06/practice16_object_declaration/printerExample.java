package sec06.practice16_object_declaration;

public class printerExample {
	public static void main(String[] args) {
		
		//printer 객체를 생성하는 경우  
//		Printer printer = new Printer();
//		printer.println(10);
//		printer.println(true);
//		printer.println(5.7);
//		printer.println("홍길동");
		
		//printer 객체를 생성하지 않는 경우
		Printer.println(10);
		Printer.println(true);
		Printer.println(5.7);
		Printer.println("홍길동");
	}
}
