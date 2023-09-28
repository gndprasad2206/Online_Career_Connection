class Employer{
	private String name;
	private String id;
	private String company;
	private String designation;
	private String mail;
	private String userName;
	private String password;
	public Employer(String id,String name,String company,String designation,String mail,String userName,String password) {
		this.id=id+"E";
		this.name=name;
		this.company=company;
		this.designation=designation;
		this.mail=mail;
		this.userName=userName;
		this.password=password;
	}
	public String getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public String getDesignation() {
		return designation;
	}
	public String getMail() {
		return mail;
	}
	public String getUserName() {
		return userName;
	}
	public String getPassword() {
		return password;
	}
	public String getCompany() {
		return company;
	}
	public void setName(String name) {
		this.name= name;
	}
	public void setDesignation(String designation) {
		this.designation= designation;
	}
	public void setMail(String mail) {
		this.mail= mail;
	}
	public void setCompany(String company) {
		this.company=company;
	}
}