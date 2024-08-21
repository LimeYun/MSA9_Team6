package JavaMission.Num11;

import java.util.Scanner;

public class Bank {
	
	static Account[] accounts = new Account[1000];	// 고객 정보배열
	static int index = 0;
	
	// 계좌 등록
	public static void creat () {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("계좌번호 >> ");
		String number = sc.nextLine();
		
		System.out.print("예금주 >> ");
		String name = sc.nextLine();
		
		System.out.print("최초예금액 >> ");
		int money = sc.nextInt();
		
		sc.nextLine();
		
		System.out.print("비밀번호 >> ");
		String pw = sc.nextLine();
		
		Account ac = new Account(number, name, money, pw);
		
		System.out.println("'"+ac.getDepositor()+"'님의 계좌가 개설되었습니다.");
		accounts[index] = ac;
		index++;
		
	}

	// 입금
	public static void input() {
		Scanner sc = new Scanner(System.in);
		

		System.out.print("계좌번호 >> ");
		String number = sc.nextLine();
		
		Account find = findnumber(number);
		
		
		System.out.print("입금액 >> ");

		int money = sc.nextInt();

		System.out.println("'" +find.getDepositor()+"'님에게 입금하시는게 맞으십니까?");
		System.out.println("1. 예 \n2. 아니오");
		System.out.print("입력 >> ");
		int num = sc.nextInt();
		if ( num == 1 ) {
			find.setDeposit(money);
			System.out.println("'"+find.getDepositor()+"'님의 계좌에 "+money+"원이 입금되었습니다.");
		}
		else 
			return;
	}
	
	//출금
	public static void output() {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("계좌번호 >> ");
		String number = sc.nextLine();
		System.out.print("비밀번호 >> ");
		String pw = sc.nextLine();
		
		Account find = findname(pw);
		if ( find == null ) {
			System.out.println("비밀번호가 다릅니다.");
			return;
		}
		
		System.out.print("출금액 >> ");
		int money = sc.nextInt();
		
		find.setDeposit(-money);
		
		System.out.println("'"+find.getDepositor()+"'님의 계좌에서 "+money+"원이 출금되었습니다.");
	}
	
	// 계좌조회
	public static void check() {
		Scanner sc = new Scanner(System.in);
		System.out.print("계좌번호 : ");
		String number = sc.nextLine();
		System.out.print("비밀번호 : ");
		String pw = sc.nextLine();
		
		Account find = findname(pw);
		
		if ( find == null ) {
			System.out.println("없는 계좌번호이거나 비밀번호가 다릅니다.");
			return;
		}
		
		System.out.println("'"+find.getDepositor()+"' 님의 계좌잔액은 "+find.getDeposit()+"원 입니다.");

	}
	
	// 계좌목록
	public static void list() {
		Scanner sc = new Scanner(System.in);
		
		Account superPw = new Account();
		
		System.out.print("관리자 비밀번호 >> ");
		
		String pw = sc.nextLine();
		
		if (superPw.getSuperPw().equals(pw)) {
			System.out.println("예금주\t계좌번호\t잔고");
			for (int i = 0; i < index; i++) {
				accounts[i].accountList();
			}
		}
		else {
			System.out.println("비밀번호가 다릅니다.");
			return;
		}

	}

	// 계좌번호로 이름 찾기
	public static Account findnumber(String accountNumber) {
		
		Account a = new Account();
		
		for (int i = 0; i < index; i++) {
			if ( accounts[i].getDepoNumber().equals(accountNumber) ) {
				a = accounts[i];
			}
		}
		
		return a;
	}
	
	// 비밀번호로 이름 찾기
	public static Account findname(String pw) {
		
		Account b = new Account();
		
		for (int i = 0; i < index; i++) {
			if ( accounts[i].getPassword().equals(pw)) {

				return accounts[i];
			}
		}
		return null;
		
	}

	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int num = 0;
		
		do {
			System.out.println("==============================");
			System.out.println("1. 계좌등록");
			System.out.println("2. 입금");
			System.out.println("3. 출금");
			System.out.println("4. 계좌조회");
			System.out.println("5. 계좌목록");
			System.out.println("6. 종료");
			System.out.println("==============================");
			System.out.print("입력 >> ");
			
			num = sc.nextInt();
			
			if ( num == 6)
				break;

			switch (num) {
			case 1: creat();

				break;
			case 2: input();

				break;
			case 3: output();

				break; 
			case 4: check();

				break;
			case 5: list();

				break;
		
			}

		} while (num != 6);
		System.out.println("프로그램을 종료합니다.");
	
	
		sc.close();
	}	// main
	

}	// class


