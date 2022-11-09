package model.user;

public class Register extends user{
	private static authenticationController authencontroller = new authenticationController();
	public Register(String name, String address, String phone, Account account, int age, Role role) {
		super(name,address,phone,account,age,role);
		setName(name);
		setAddress(address);
		setPhone(phone);
		setAccount(account);
		setAge(age);
		setRole(role);
	}

	public Register(){
		super();
	}

	public void registerUserData(String username, String firstName, String lastName, int age,
								 String phoneNo, String address, String userRole, String userPassword){


			userStmt.setString(1, username);
			userStmt.setString(2, firstName);
			userStmt.setString(3, lastName);
			userStmt.setInt(4, age);
			userStmt.setString(5, phoneNo);
			userStmt.setString(6, address);
			userStmt.setString(7, userRole);
			userStmt.setString(8, userPassword);


		/*
			for(){
				String username = s.get(1);
				String firstname = s.get(2);
				String lastname = s.get(3);
				String age = Integer.parseInt(s.get(4));
				String phoneNo = s.get(5);
				String address = s.get(6);
				String roleUser = s.get(7);
				String pass = s.get(8);
			}
*/
			if(Objects.equals(userRole, "renter")){
				registerRenter(username);
			} else if(Objects.equals(userRole, "landlord")){
				registerLandlord(username);
			} else if(Objects.equals(userRole, "manager")){
				registerManager(username);
			}

			userStmt.executeUpdate();
			userStmt.close();
		} catch (SQLException e){
			System.out.println("Database Error");
		}
	}

	// user Registration for Renter
	public void registerRenter(String renterUsername){
		try{
			Connection dbConnect = DriverManager.getConnection(connect.getDbUrl(),
					connect.getUsername(), connect.getPassword());
			String query = "INSERT INTO renterInfo " +
					"(username) " +
					"VALUES (?)";
			PreparedStatement userStmt = dbConnect.prepareStatement(query);

			userStmt.setString(1, renterUsername);
			userStmt.executeUpdate();
			userStmt.close();
		} catch (SQLException e){
			System.out.println("Database Error");
		}
	}

	// user Registration for Landlord
	public void registerLandlord(String landlordUsername){
		try{
			Connection dbConnect = DriverManager.getConnection(connect.getDbUrl(),
					connect.getUsername(), connect.getPassword());
			String query = "INSERT INTO landlordInfo " +
					"(username) " +
					"VALUES (?)";
			PreparedStatement userStmt = dbConnect.prepareStatement(query);

			userStmt.setString(1, landlordUsername);
			userStmt.executeUpdate();
			userStmt.close();
		} catch (SQLException e){
			System.out.println("Database Error");
		}
	}

	// user Registration for Manager
	public void registerManager(String managerUsername){
		try{
			Connection dbConnect = DriverManager.getConnection(connect.getDbUrl(),
					connect.getUsername(), connect.getPassword());
			String query = "INSERT INTO managerInfo " +
					"(username) " +
					"VALUES (?)";
			PreparedStatement userStmt = dbConnect.prepareStatement(query);

			userStmt.setString(1, managerUsername);
			userStmt.executeUpdate();
			userStmt.close();
		} catch (SQLException e){
			System.out.println("Database Error");
		}
	}
}
