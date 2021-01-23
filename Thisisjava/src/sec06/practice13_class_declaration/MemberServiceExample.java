package sec06.practice13_class_declaration;

public class MemberServiceExample {
	
	public static void main(String[] args) {
		
		MemberService memberservice = new MemberService();
		boolean result = memberservice.login("hong","12345");
		
		if(result) {
			System.out.println("로그인 되었습니다");
			memberservice.logout("hong");
		} else {
			System.out.println("id password 가 올바르지 않습니다 ");

		}
		
	}
}
