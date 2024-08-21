package JavaMission.Num11;


public class Account {
	
	private String depoNumber;
	private String depositor;
	private int deposit;
	private String password;
	
	private String superPw;	// 관리자 비밀번호
	
	

	public String getSuperPw() {
		return "super";
	}
	



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
		System.out.println(depositor+"\t"+depoNumber+"\t"+deposit);
	}
	
}
