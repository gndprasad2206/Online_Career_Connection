class OnlinePortal {
	Scanner sc = new Scanner(System.in);
	String url = "jdbc:mysql://localhost:3306/online_career_connection";
	String uname = "root";
	String upass = "170780";

	public void addCompany(String company) throws Exception {
		Connection con = DriverManager.getConnection(url, uname, upass);
		Class.forName("com.mysql.jdbc.Driver");
		String comquary = "insert into companies values(?)";
		PreparedStatement comst = con.prepareStatement(comquary);
		comst.setNString(1, company);
		comst.executeUpdate();
		System.out.println("Added company Successfully..");
	}

	public void removeCompany(String company) throws Exception {
		Connection con = DriverManager.getConnection(url, uname, upass);
		Class.forName("com.mysql.jdbc.Driver");
		String comquary = "delete from companies where company_Name='" + company + "'";
		Statement comst = con.createStatement();
		int count = comst.executeUpdate(comquary);
		if (count == 1) {
			System.out.println("Removed Company Sucessfully..");
		} else {
			System.out.println("The Company Name not Saved In Data Base");
		}
	}

	public void listOfCompanies() throws Exception {
		Connection con = DriverManager.getConnection(url, uname, upass);
		Class.forName("com.mysql.jdbc.Driver");
		String comquary = "select * from companies";
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(comquary);
		System.out.println("List of companies");
		while (rs.next()) {
			System.out.println(rs.getString(1));
		}
	}

	public void adminProfile() throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection(url, uname, upass);
		Statement st = con.createStatement();
		String adminquary = "Select * from admin_1";
		ResultSet adrs = st.executeQuery(adminquary);
		System.out.println("Admin Profile");
		while (adrs.next()) {
			System.out.println("Admin Id: " + adrs.getString(1));
			System.out.println("Admin Name: " + adrs.getString(2));
			System.out.println("Admin Mail-Id: " + adrs.getString(3));
			System.out.println("Admin UserName: " + adrs.getString(4));
			System.out.println("Admin Password: " + adrs.getString(5));
		}
	}

	public boolean checkUserName(String userName) throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection(url, uname, upass);
		Statement st1 = con.createStatement();
		Statement st2 = con.createStatement();
		Statement st3 = con.createStatement();
		String erquary = "select * from employer";
		String emquary = "select * from emplyee";
		String adminquary = "select * from admin_1";
		ResultSet errs = st1.executeQuery(erquary);
		ResultSet emrs = st2.executeQuery(emquary);
		ResultSet adrs = st3.executeQuery(adminquary);
		while (errs.next()) {
			if (errs.getString(6).equals(userName)) {
				return true;

			}
		}
		while (emrs.next()) {
			if (emrs.getString(7).equals(userName)) {
				return true;

			}
		}
		while (adrs.next()) {
			if (adrs.getString(4).equals(userName))
				return true;
		}
		st1.close();
		st2.close();
		st3.close();
		con.close();
		return false;
	}

	public int userVerification(String user, String password) throws Exception {
		int c = 0, val = 0;
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection(url, uname, upass);
		Statement st1 = con.createStatement();
		Statement st2 = con.createStatement();
		Statement st3 = con.createStatement();
		String erquary = "select * from employer";
		String emquary = "select * from emplyee";
		String adminquary = "select * from admin_1";
		ResultSet errs = st1.executeQuery(erquary);
		ResultSet emrs = st2.executeQuery(emquary);
		ResultSet adrs = st3.executeQuery(adminquary);
		while (errs.next()) {
			if (errs.getString(6).equals(user) && errs.getString(7).equals(password)) {
				c++;
				val = 1;
			}
		}
		if (c == 0) {
			while (emrs.next()) {
				if (emrs.getString(7).equals(user) && emrs.getString(8).equals(password)) {
					c++;
					val = 2;
				}
			}
		}
		if (c == 0) {
			while (adrs.next()) {
				if (adrs.getString(4).equals(user) && adrs.getString(5).equals(password)) {
					val = 3;
				}
			}
		}
		st1.close();
		st2.close();
		st3.close();
		con.close();
		return val;

	}

	public void addJob(String job, int num) throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection(url, uname, upass);
		String emprQuary = "insert into jobs values(?,?)";
		PreparedStatement st = con.prepareStatement(emprQuary);
		st.setNString(1, job);
		st.setInt(2, num);
		st.executeUpdate();
		System.out.println("Added New Job Successfully");
	}

	public void removeJob(String job) throws Exception {
		Connection con = DriverManager.getConnection(url, uname, upass);
		Class.forName("com.mysql.jdbc.Driver");
		String quary = "delete from jobs where Job_Roll_Name='" + job + "'";
		Statement st = con.createStatement();
		int count = st.executeUpdate(quary);
		if (count == 1) {
			System.out.println("Job Removed successfully");
		} else {
			System.out.println("Job Not Saved in Data Base");
		}
	}

	public void addEmployer(int rowCount, String erName, String erCompany, String erDesignation, String erMail,
			String erUserName, String erPass) throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection(url, uname, upass);
		String emprQuary = "insert into employer values(?,?,?,?,?,?,?)";
		PreparedStatement emprst = con.prepareStatement(emprQuary);
		emprst.setString(1, ((rowCount + 1) + "E"));
		emprst.setNString(2, erName);
		emprst.setString(3, erCompany);
		emprst.setString(4, erDesignation);
		emprst.setString(5, erMail);
		emprst.setString(6, erUserName);
		emprst.setString(7, erPass);
		emprst.executeUpdate();
		System.out.println("Employer Sign-In Completed Successfully");
	}

	public void addEmployee(int rowCount, String emName, String emQualification, String emMail, long emMobileNumber,
			String emYear, String emUserName, String emPass) throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection(url, uname, upass);
		String empQuary = "insert into emplyee values(?,?,?,?,?,?,?,?)";
		PreparedStatement empst = con.prepareStatement(empQuary);
		empst.setString(1, ((rowCount + 1) + "T"));
		empst.setNString(2, emName);
		empst.setString(3, emQualification);
		empst.setString(4, emMail);
		empst.setLong(5, emMobileNumber);
		empst.setString(6, emYear);
		empst.setString(7, emUserName);
		empst.setString(8, emPass);
		empst.executeUpdate();
		System.out.println("Employee Sign-In Completed Successfully");
	}

	public void listOfJobs() throws Exception {
		Connection con = DriverManager.getConnection(url, uname, upass);
		Class.forName("com.mysql.jdbc.Driver");
		Statement st = con.createStatement();
		String quary = "select * from jobs";
		ResultSet rs = st.executeQuery(quary);
		while (rs.next()) {
			System.out.println(rs.getString(1) + "------->" + rs.getInt(2));
		}
	}

	public void erUpdateName(String name, String userName) throws Exception {
		Connection con = DriverManager.getConnection(url, uname, upass);
		Class.forName("com.mysql.jdbc.Driver");
		String quary = "update employer set erName='" + name + "'where erUserName='" + userName + "'";
		Statement st = con.createStatement();
		st.executeUpdate(quary);
		System.out.println("Updation Completed Successfully..");
	}

	public void erUpdateCompany(String company, String userName) throws Exception {
		Connection con = DriverManager.getConnection(url, uname, upass);
		Class.forName("com.mysql.jdbc.Driver");
		String quary = "update employer set erCompany='" + company + "'where erUserName='" + userName + "'";
		Statement st = con.createStatement();
		st.executeUpdate(quary);
		System.out.println("Updation Completed Successfully..");
	}

	public void erUpdateDesignation(String designation, String userName) throws Exception {
		Connection con = DriverManager.getConnection(url, uname, upass);
		Class.forName("com.mysql.jdbc.Driver");
		String quary = "update employer set erDesignation='" + designation + "'where erUserName='" + userName + "'";
		Statement st = con.createStatement();
		st.executeUpdate(quary);
		System.out.println("Updation Completed Successfully..");
	}

	public void erUpdateMail(String mail, String userName) throws Exception {
		Connection con = DriverManager.getConnection(url, uname, upass);
		Class.forName("com.mysql.jdbc.Driver");
		String quary = "update employer set erMail='" + mail + "'where erUserName='" + userName + "'";
		Statement st = con.createStatement();
		st.executeUpdate(quary);
		System.out.println("Updation Completed Successfully..");
	}

	public void empUpdateName(String name, String userName) throws Exception {
		Connection con = DriverManager.getConnection(url, uname, upass);
		Class.forName("com.mysql.jdbc.Driver");
		String quary = "update emplyee set emName='" + name + "'where emUserName='" + userName + "'";
		Statement st = con.createStatement();
		st.executeUpdate(quary);
		System.out.println("Updation Completed Successfully..");
	}

	public void emUpdateQualification(String qualification, String userName) throws Exception {
		Connection con = DriverManager.getConnection(url, uname, upass);
		Class.forName("com.mysql.jdbc.Driver");
		String quary = "update emplyee set emQualification='" + qualification + "'where emUserName='" + userName + "'";
		Statement st = con.createStatement();
		st.executeUpdate(quary);
		System.out.println("Updation Completed Successfully..");
	}

	public void emUpdateNumber(long number, String userName) throws Exception {
		Connection con = DriverManager.getConnection(url, uname, upass);
		Class.forName("com.mysql.jdbc.Driver");
		String quary = "update emplyee set emNumber='" + number + "'where emUserName='" + userName + "'";
		Statement st = con.createStatement();
		st.executeUpdate(quary);
		System.out.println("Updation Completed Successfully..");
	}

	public void emUpdateMail(String mail, String userName) throws Exception {
		Connection con = DriverManager.getConnection(url, uname, upass);
		Class.forName("com.mysql.jdbc.Driver");
		String quary = "update emplyee set emMail='" + mail + "'where emUserName='" + userName + "'";
		Statement st = con.createStatement();
		st.executeUpdate(quary);
		System.out.println("Updation Completed Successfully..");
	}

	public void profileDetails(String userName) throws Exception {
		Connection con = DriverManager.getConnection(url, uname, upass);
		Class.forName("com.mysql.jdbc.Driver");
		String quary = "Select * from emplyee where emUserName='" + userName + "'";
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(quary);
		rs.next();
		System.out.println();
		System.out.println("Job Seeker Id: " + rs.getString(1));
		System.out.println("Job Seeker Name: " + rs.getString(2));
		System.out.println("JOb Seeker Qualification: " + rs.getString(3));
		System.out.println("Job Seeker Mail-Id: " + rs.getString(4));
		System.out.println("Job Seeker Contact Number: " + rs.getLong(5));
		System.out.println("JOb Seeker Year of Passing: " + rs.getString(6));
		System.out.println("Job Seeker User Name: " + rs.getString(7));
	}

	public void erProfileDetails(String userName) throws Exception {
		Connection con = DriverManager.getConnection(url, uname, upass);
		Class.forName("com.mysql.jdbc.Driver");
		String quary = "Select * from employer where erUserName='" + userName + "'";
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(quary);
		rs.next();
		System.out.println();
		System.out.println("Employer Id: " + rs.getString(1));
		System.out.println("Employer Name: " + rs.getString(2));
		System.out.println("Employer Company: " + rs.getString(3));
		System.out.println("Employer Designation: " + rs.getString(4));
		System.out.println("Employer Mail-Id: " + rs.getString(5));
		System.out.println("Employer User Name: " + rs.getString(6));
	}

	public void applyForJob() throws Exception {
		Connection con = DriverManager.getConnection(url, uname, upass);
		Class.forName("com.mysql.jdbc.Driver");
		String quary = "select * from jobs";
		PreparedStatement st = con.prepareStatement(quary);
		ResultSet rs1 = st.executeQuery();
		while (rs1.next()) {
			System.out.println(rs1.getString(1));
		}
		System.out.println("Type Job Role here to apply: ");
		// sc.nextLine();
		String emJobRole = sc.nextLine();
		String quary1 = "select * from jobs where Job_Roll_Name='" + emJobRole + "'";
		PreparedStatement st1 = con.prepareStatement(quary1);
		ResultSet rs2 = st1.executeQuery();
		rs2.next();
		int application = rs2.getInt(2);
		application += 1;
		String quary2 = "update jobs set applications=" + application + " where Job_Roll_Name='" + emJobRole + "'";
		Statement st2 = con.createStatement();
		st2.executeUpdate(quary2);
		System.out.println("Applied Successfully..");
	}

}