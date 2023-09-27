class Employee{
	private String name;
	private String id;
	private String qualification;
	private String mail;
	private long number;
	private String year_of_course_complition;
	private String userName;
	private String password;
	public Employee(String name,String id,String qualification,String mail,long number,String year,String userName,String password) {
		this.name=name;
		this.id=id+"C";
		this.qualification=qualification;
		this.mail=mail;
		this.number=number;
		this.year_of_course_complition=year;
		this.userName=userName;
		this.password=password;
	}
	public String getName() {
		return name;
	}
	public String getId() {
		return id;
	}
	public String getQualification() {
		return qualification;
	}
	public String getMail() {
		return mail;
	}
	public long getNumber() {
		return number;
	}
	public String getYear_of_course_complition() {
		return year_of_course_complition;
	}
	public String getUserName() {
		return userName;
	}
	public String getPassword() {
		return password;
	}
	public void setName(String name) {
		this.name=name;
	}
	public void setMail(String mail) {
		this.mail= mail;
	}
	public void setQualification(String qualification) {
		this.qualification=qualification;
	}
	public void setNumber(long number) {
		this.number=number;
	}
	
}