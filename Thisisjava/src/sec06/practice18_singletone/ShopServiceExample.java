package sec06.practice18_singletone;

public class ShopServiceExample {
	
	public static void main(String[] args) {
		
		ShopService obj1=ShopService.getInstance();
		ShopService obj2=ShopService.getInstance();

		if(obj1==obj2) {
			System.out.println(obj1);

			System.out.println("같은 shopservice 객체 ");
			
		}else {
			System.out.println("다른 shopservice 객체 ");

		}
	}
}
