package sec06.practice19_account;

import java.util.Scanner;
public class BankApplication {
	private static Account1[] accountArray = new Account1[100];
	private static Scanner sc = new Scanner(System.in);
	public static int acc = 0;
	public static void main(String[]args) {
		boolean run = true;
		while(run) {
			System.out.println("------------------------------------------------");
			System.out.println("1.계좌생성 | 2.계좌목록 | 3.예금 | 4.출금 | 5. 종료 |");
			System.out.println("------------------------------------------------");
			System.out.print("선택> ");
			
			int selectNo = sc.nextInt();
			
			if(selectNo==1) {
				createAccount();
				
			}
			else if(selectNo==2) {
				accountList();
			}
			else if(selectNo==3) {
				deposit();
			}
			else if(selectNo==4) {
				withdraw();
			}
			else if(selectNo==5) {
				run=false;
			}
			
		}
		System.out.println("프로그램 종료");
	}

	private static void withdraw() {
		// TODO Auto-generated method stub
		System.out.println("---------------");
		System.out.println("출금");
		System.out.println("---------------");
		System.out.println("계좌번호:");
		String ano = sc.next();
		System.out.println("출금액 :");
		int withdraw = sc.nextInt();
		for(int i=0;i<acc;i++) {
			if(ano.equals(accountArray[i].getAno())) {
				
				accountArray[i].setBalance(accountArray[i].getBalance()-withdraw);
			}
		}

		System.out.println("결과: 출금이 성공되었습니다. ");
	}

	private static void deposit() {
		// TODO Auto-generated method stub
		System.out.println("---------------");
		System.out.println("예금");
		System.out.println("---------------");
		System.out.println("계좌번호:");
		String ano = sc.next();
		System.out.println("예금액 :");
		int deposit = sc.nextInt();
		for(int i=0;i<acc;i++) {
			System.out.println("hi");
			System.out.println(accountArray[i].getAno());
			if(ano.equals(accountArray[i].getAno())) {

				accountArray[i].setBalance(accountArray[i].getBalance()+deposit);
			}
		}
		System.out.println("결과: 예금이 성공되었습니다. ");



	}

	private static void accountList() {
		// TODO Auto-generated method stub
		System.out.println("---------------");
		System.out.println("계좌목록");
		System.out.println("---------------");
		for(int i=0;i<acc;i++) {
			System.out.println(accountArray[i].getAno()+"   "+ accountArray[i].getOwner()+"   "+accountArray[i].getBalance());

		}
	}

	private static void createAccount() {
		// TODO Auto-generated method stub
		System.out.println("---------------");
		System.out.println("계좌생성");
		System.out.println("---------------");
		
		System.out.println("계좌번호:");
		String ano = sc.next();
		System.out.println("계좌주:");
		String owner = sc.next();
		System.out.println("초기입금금액:");
		int balance = sc.nextInt();
		accountArray[acc] = new Account1(ano,owner,balance);
//		accountArray[acc].setAno(ano);
//		accountArray[acc].setOwner(owner);
//		accountArray[acc].setBalance(balance);
		System.out.println("결과: 계좌가 생성되었습니다. ");
		acc++;


	}
	
	
}
