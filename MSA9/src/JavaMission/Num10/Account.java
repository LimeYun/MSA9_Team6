package JavaMission.Num10;


public class Account {
	
	private String depoNumber;
	private String depositor;
	private int deposit;
	private String password;
	




	public Account() {
		this("계좌없음", "이름없음", 0, "0000");
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
		if (deposit > 1000000000) return;	// int 이상 입금 불가
		this.deposit += deposit;			// 잔고 합산
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	
	// 계좌조회 돌리기
	public void accountList() {
		System.out.printf("계좌번호 : %s, 이름 : %s, 비밀번호 : %s, 잔고 : %,d원%n"
				, depoNumber, depositor, password, deposit);
	}
	
}

