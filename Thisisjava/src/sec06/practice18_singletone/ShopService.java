package sec06.practice18_singletone;

public class ShopService {
	
	private static ShopService Singletone;
	
	//생성자 private으로 막기 
	private ShopService() {
		
	}
	
	public static ShopService getInstance() {
		return Singletone;
	}
}
