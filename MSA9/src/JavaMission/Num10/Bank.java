package JavaMission.Num10;

import java.util.Scanner;

public class Bank {
	
	static Account[] accounts = new Account[1000];	// �� �����迭
	static int index = 0;
	
	// ���� ���
	public static void creat () {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("���¹�ȣ >> ");
		String number = sc.nextLine();
		
		System.out.print("������ >> ");
		String name = sc.nextLine();
		
		System.out.print("���ʿ��ݾ� >> ");
		int money = sc.nextInt();
		
		sc.nextLine();
		
		System.out.print("��й�ȣ >> ");
		String pw = sc.next();
		
		Account ac = new Account(number, name, money, pw);
		
		System.out.println("'"+ac.getDepositor()+"'���� ���°� �����Ǿ����ϴ�.");
		accounts[index] = ac;
		index++;
		
	}

	// �Ա�
	public static void input() {
		Scanner sc = new Scanner(System.in);
		

		System.out.print("���¹�ȣ >> ");
		String number = sc.nextLine();
		
		Account find = findnumber(number);
		
		
		System.out.print("�Աݾ� >> ");

		int money = sc.nextInt();

		System.out.println("'" +find.getDepositor()+"'�Կ��� �Ա��Ͻô°� �����ʴϱ�?");
		System.out.println("1. �� \n2. �ƴϿ�");
		System.out.print("�Է� >> ");
		int num = sc.nextInt();
		if ( num == 1 ) {
			find.setDeposit(money);
			System.out.println("'"+find.getDepositor()+"'���� ���¿� "+money+"���� �ԱݵǾ����ϴ�.");
		}
		else 
			return;
	}
	
	//���
	public static void output() {
	
	}
	
	// ������ȸ
	public static void check() {
		for (int i = 0; i < index; i++) {
			accounts[i].accountList();
		}
	}
	
	// ���¸��
	public static void list() {
		
	}

	// �����̸� ã��
	public static Account findnumber(String accountNumber) {
		
		Account a = new Account();
		
		for (int i = 0; i < index; i++) {
			if ( accounts[i].getDepoNumber().equals(accountNumber) ) {
				a = accounts[i];
			}
		}
		
		return a;
	}

	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int num = 0;
		
		do {
			System.out.println("==============================");
			System.out.println("1. ���µ��");
			System.out.println("2. �Ա�");
			System.out.println("3. ���");
			System.out.println("4. ������ȸ");
			System.out.println("5. ���¸��");
			System.out.println("6. ����");
			System.out.println("==============================");
			System.out.print("�Է� >> ");
			
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
		System.out.println("���α׷��� �����մϴ�.");
	
	
		sc.close();
	}	// main
	

}	// class
