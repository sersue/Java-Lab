package sec06.practice19_account;

public class Account {

	static final int MIN_BALANCE = 0;
	static final int MAX_BALANCE = 1000000;
	
	private int balance;
	
	public int getBalance() {
		return this.balance;
	}
	
	public void setBalance(int a) {
		if(a>=MIN_BALANCE&&a<=MAX_BALANCE) {
			this.balance=a;
		}
		else {
			//매개변수가 음수이거나 백만원 초과시 현재 balance값 유지   
			this.balance=balance;
		}
	}
}
