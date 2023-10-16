interface BackEndWork{
	public void addCompany(String company,Connection con) throws Exception;
	public void removeCompany(String company,Connection con) throws Exception;
	public void listOfCompanies(Connection con) throws Exception;
	public void adminProfile(Connection con) throws Exception;
	public boolean checkUserName(String userName,Connection con) throws Exception;
	public int userVerification(String user, String password,Connection con) throws Exception;
	public void addJob(String job, int num,Connection con) throws Exception;
	public void removeJob(String job,Connection con) throws Exception;
	public void addEmployer(int rowCount, String erName, String erCompany, String erDesignation, String erMail,
			String erUserName, String erPass,Connection con) throws Exception;
	public void addEmployee(int rowCount, String emName, String emQualification, String emMail, long emMobileNumber,
			String emYear, String emUserName, String emPass,Connection con) throws Exception;
	public void listOfJobs(Connection con) throws Exception;
	public void erUpdateName(String name, String userName,Connection con) throws Exception;
	public void erUpdateCompany(String company, String userName,Connection con) throws Exception;
	public void erUpdateDesignation(String designation, String userName,Connection con) throws Exception;
	public void erUpdateMail(String mail, String userName,Connection con) throws Exception;
	public void empUpdateName(String name, String userName,Connection con) throws Exception;
	public void emUpdateQualification(String qualification, String userName,Connection con) throws Exception;
	public void emUpdateNumber(long number, String userName,Connection con) throws Exception;
	public void emUpdateMail(String mail, String userName,Connection con) throws Exception;
	public void profileDetails(String userName,Connection con) throws Exception;
	public void erProfileDetails(String userName,Connection con) throws Exception;
	public void applyForJob(Connection con) throws Exception;
}