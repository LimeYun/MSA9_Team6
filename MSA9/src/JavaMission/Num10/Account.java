package JavaMission.Num10;


public class Account {
	
	private String depoNumber;
	private String depositor;
	private int deposit;
	private String password;
	




	public Account() {
		this("���¾���", "�̸�����", 0, "0000");
	}

	public Account(String depoNumber, String depositor, int deposit, String password) {
		this.depoNumber = depoNumber;
		this.depositor = depositor;
		this.deposit = deposit;
		this.password = password;
	}
	
	
	public String getDepoNumber() {
		return depoNumber;
	}

	public void setDepoNumber(String depoNumber) {
		this.depoNumber = depoNumber;
	}

	public String getDepositor() {
		return depositor;
	}

	public void setDepositor(String depositor) {
		this.depositor = depositor;
	}

	public int getDeposit() {
		return deposit;
	}

	public void setDeposit(int deposit) {
		if (deposit > 1000000000) return;	// int �̻� �Ա� �Ұ�
		this.deposit += deposit;			// �ܰ� �ջ�
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	
	// ������ȸ ������
	public void accountList() {
		System.out.printf("���¹�ȣ : %s, �̸� : %s, ��й�ȣ : %s, �ܰ� : %,d��%n"
				, depoNumber, depositor, password, deposit);
	}
	
}

