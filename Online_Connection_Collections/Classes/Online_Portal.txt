class OnlinePortal{
	HashMap <String,Employer> employer=new HashMap<String,Employer>();
	HashMap <String,Employee> employee=new HashMap<String,Employee>();
	Admin adminDetails=new Admin();
	ArrayList<String> companies=new ArrayList<String>();
	public void addCompany(String company) {
		companies.add(company);
		System.out.println("Added company Successfully..");
	}
	public void removeCompany(String company) {
		companies.remove(company);
		System.out.println("Removed Company Sucessfully..");
	}
	public void listOfCompanies() {
		int i=1;
		for(String s:companies) {
			System.out.println(i+"."+s);
			i++;
		}
	}
	public void adminProfile(Admin ad) {
		System.out.println();
		System.out.println("Admin Name: "+ad.getName());
		System.out.println("Admin Id: "+ad.getId());
		System.out.println("Admin Mail: "+ad.getMail());
		System.out.println("Admin UserName: "+ad.getUserName());
	}
	public boolean checkUserName(String userName) {
		boolean check=false;
		int cCheck=0;
		for(Employer empr:employer.values()) {
			if(empr.getUserName().equals(userName)) {
				check=true;
				cCheck++;
				break;
			}
		}
		if(cCheck==0) {
			for(Employee emp:employee.values()) {
				if(emp.getUserName().equals(userName)) {
					check=true;
					cCheck++;
					break;
				}
			}
		}
		if(cCheck==0) {
			if(adminDetails.getUserName().equals(userName))
				check=true;
		}
		return check;
	}
	public List userVerification(String user,String password) {
		int emCount=0;
		List l=new ArrayList();
		for(Employer er:employer.values()) {
			if(er.getUserName().equals(user) && er.getPassword().equals(password)) {
				l.add(er);
				l.add(1);
				emCount++;
				break;
			}
		}
		if(emCount==0) {
			for(Employee em:employee.values()) {
				if(em.getUserName().equals(user) && em.getPassword().equals(password)) {
					l.add(em);
					l.add(2);
					emCount++;
					break;
				}
			}
		}
		if(emCount==0) {
			if(adminDetails.getUserName().equals(user) && adminDetails.getPassword().equals(password)) {
				l.add(adminDetails);
				l.add(3);
			}
		}
		return l;
	}
	public void addEmployer(Employer empr) {
		employer.put(empr.getId(), empr);
		System.out.println("Employer Details added Successfully");
	}
	public void addEmployee(Employee emp) {
		employee.put(emp.getId(), emp);
		System.out.println("Employee Details Added Successfully");
	}
	public void erUpdateName(String name,Employer obj) {
		obj.setName(name);
		System.out.println("Updation Completed Successfully..");
	}
	public void erUpdateCompany(String company,Employer obj) {
		obj.setCompany(company);
		System.out.println("Updation Completed Successfully..");
	}
	public void erUpdateDesignation(String designation,Employer obj) {
		obj.setDesignation(designation);
		System.out.println("Updation Completed Successfully..");
	}
	public void erUpdateMail(String mail,Employer obj) {
		obj.setMail(mail);
		System.out.println("Updation Completed Successfully..");
	}
	public void empUpdateName(String name,Employee emp) {
		emp.setName(name);
		System.out.println("Updation Completed Successfully..");
	}
	public void emUpdateQualification(String qualification, Employee emp) {
		emp.setQualification(qualification);
		System.out.println("Updation Completed Successfully..");
	}
	public void emUpdateNumber(long number,Employee emp) {
		emp.setNumber(number);
		System.out.println("Updation Completed Successfully..");
	}
	public void emUpdateMail(String mail,Employee emp) {
		emp.setMail(mail);
		System.out.println("Updation Completed Successfully..");
	}
	public void profileDetails(Employee emp) {
		System.out.println();
		System.out.println("Job Seeker Id: "+emp.getId());
		System.out.println("Job Seeker Name: "+emp.getName());
		System.out.println("JOb Seeker Qualification: "+emp.getQualification());
		System.out.println("Job Seeker Mail-Id: "+emp.getMail());
		System.out.println("Job Seeker Contact Number: "+emp.getNumber());
		System.out.println("Job Seeker User Name: "+emp.getUserName());
	}
	
}