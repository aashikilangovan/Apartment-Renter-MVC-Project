package model.user;

public class Login extends user{
	private static authenticationController authencontroller = new authenticationController();
	public Login(String name, String address, String phone, Account account, int age, Role role) {
		super(name,address,phone,account,age,role);
		setName(name);
		setAddress(address);
		setPhone(phone);
		setAccount(account);
		setAge(age);
		setRole(role);
	}

	public Login(){
		super();
	}

	public boolean

}
