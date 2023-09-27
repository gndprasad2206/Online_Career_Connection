public class Online_Job_Portal {
	public static int erNextid=1;
	public static int emNextid=1;
	public static void main(String[] args) {
		HashMap<String,Integer>jobs=new HashMap<String,Integer>();
		jobs.put("Web Developer",0);
		jobs.put("Software Engineer",0);
		jobs.put("Software Developer",0);
		jobs.put("Front End Developer",0);
		jobs.put("Back End Developer",0);
		Scanner sc=new Scanner(System.in);
		OnlinePortal op=new OnlinePortal();
		Admin admin=new Admin();
		while(true) {
			System.out.println("**Welcome to Online Career Connection**\n1.Sign In\n2.Login\n3.Close\nSelect one option");
			int choice1=sc.nextInt();
			
			switch(choice1){
			case 1:
				System.out.println();
				System.out.println("Sign-in As a...\n1.Employer\n2.Employee\n3.Back\nSelect One option");
				int choice2=sc.nextInt();
				switch(choice2){
				case 1:
					System.out.println();
					sc.nextLine();
					System.out.print("Enter Name: ");
					String erName=sc.nextLine();
					System.out.print("Enter Company Name: ");
					String erCompany=sc.nextLine();
					System.out.print("Designation: ");
					String erDesignation=sc.nextLine();
					System.out.println("Enter Mail Id: ");
					String erCheckMail=sc.nextLine();
					String erMail="";
					int erIndex=erCheckMail.indexOf("@");
					if(erIndex==-1) {
						try {
							throw new InvalidMailId("Invalid mail formate ! !");
						}catch(InvalidMailId e) {
							System.out.println(e.getMessage());
							System.out.println("Mail Must Contain @gmail.com or @email.com");
							System.out.print("RE-Enter the Mail: ");
							erCheckMail=sc.nextLine();
							erIndex=erCheckMail.indexOf("@");
						}
					}
					try {
						String sub1=erCheckMail.substring(erIndex);
						if(validMail(sub1)) {
							erMail=erCheckMail;
						}
						else {
							throw new InvalidMailId("Invalid Mail Formate :@gmail.com or @email.com");
						}
					}catch(InvalidMailId e) {
						System.out.println(e.getMessage());
						System.out.println("Enter mail Again..");
						erMail=sc.nextLine();
					}
					System.out.println("User Name must Contais capital latter,small latter,Number and Special Charecter");
					System.out.print("Set User-Name: ");
					String erCheckUserName=sc.nextLine();
					String erUserName="";
					if(validUserName(erCheckUserName)) {
						erUserName=erCheckUserName;
					}
					else {
						try {
							throw new InvalidUserName("Invalid user Name Formate");
						}
						catch(InvalidUserName e) {
							System.out.println(e.getMessage());
							System.out.println("Enter User-name Again..");
							erUserName=sc.nextLine();
						}
					}
					while(op.checkUserName(erUserName)) {
						System.out.println("User Name Should Be Unic ! !\nRe-Enter User-Name");
						System.out.println("User Name must Contais capital latter,small latter,Number and Special Charecter");
						erUserName=sc.nextLine();
						if(validUserName(erUserName)) {
							erUserName=erUserName;
						}
						else {
							try {
								throw new InvalidUserName("Invalid user Name Formate");
							}catch(InvalidUserName e) {
								System.out.println(e.getMessage());
								System.out.println("User Name must Contais capital latter,small latter,Number and Special Charecter\nRe-Enter User-Name");
								erUserName=sc.nextLine();
							}
						}
					}
					String erPass="";
					System.out.print("Set New Password: ");
					String pass1=sc.nextLine();
					System.out.print("Enter Again New Password: ");
					String pass2=sc.nextLine();
					if(pass1.equals(pass2)) {
						erPass=pass1;
					}
					else {
						try {
							throw new PasswordNotMatching("Password Not Matching ! ! !");
						}
						catch(PasswordNotMatching e) {
							System.out.println(e.getMessage());
							System.out.println("Re-Enter New Password..");
							erPass=sc.nextLine();
						}
					}
					Integer num=new Integer(erNextid++);
					String erId=num.toString();
					Employer empr= new Employer(erId,erName,erCompany,erDesignation,erMail,erUserName,erPass);
					op.addEmployer(empr);
					break;
				case 2:
					sc.nextLine();
					System.out.print("Enter Name: ");
					String emName=sc.nextLine();
					System.out.print("Enter Qualification: ");
					String emQualification=sc.nextLine();
					System.out.print("Enter Mail: ");
					String emMail="";
					String emCheckMail=sc.nextLine();
					int emIndex=emCheckMail.indexOf("@");
					if(emIndex==-1) {
						try {
							throw new InvalidMailId("Invalid mail formate ! !");
						}catch(InvalidMailId e) {
							System.out.println(e.getMessage());
							System.out.println("Mail Must Contain @gmail.com or @email.com");
							System.out.print("RE-Enter the Mail: ");
							emCheckMail=sc.nextLine();
							emIndex=emCheckMail.indexOf("@");
						}
					}
					String emSub=emCheckMail.substring(emIndex);
					if(validMail(emSub)) {
						emMail=emCheckMail;
					}
					else {
						try {
							throw new InvalidMailId("Invalid Mail Formate: @gmail or @email");
						}catch(InvalidMailId e) {
							System.out.println(e.getMessage());
							System.out.print("Re-Enter the Mail: ");
							emMail=sc.nextLine();
						}
					}
					System.out.print("Enter Mobile Number: ");
					long emCheckMobileNumber=sc.nextLong();
					long emMobileNumber=0;
					if(validMobileNumber(emCheckMobileNumber)) {
						emMobileNumber=emCheckMobileNumber;
					}
					else {
						try {
							throw new InvalidMobileNumber("Invalid Mobile Number!!");
						}catch(InvalidMobileNumber e) {
							System.out.println(e.getMessage());
							System.out.print("Re-Enter Mobile Number: ");
							emMobileNumber=sc.nextLong();
						}
					}
					sc.nextLine();
					System.out.print("Year Of Complition: ");
					String emYear=sc.nextLine();
					System.out.print("Set New User Name: ");
					String emCheckUserName=sc.nextLine();
					String emUserName="";
					if(validUserName(emCheckUserName)) {
						emUserName=emCheckUserName;
					}
					else {
						try {
							throw new InvalidUserName("Invalid User  Name Formate ! !");
						}
						catch(InvalidUserName e) {
							System.out.println(e.getMessage());
							System.out.println("Re-Enter New User Name");
							emUserName=sc.nextLine();
						}
					}
					while(op.checkUserName(emUserName)) {
						System.out.println("User Name Should Be Unic ! !\nRe-Enter User-Name");
						System.out.println("User Name must Contais capital latter,small latter,Number and Special Charecter");
						emUserName=sc.nextLine();
						if(validUserName(emUserName)) {
							emUserName=emUserName;
						}
						else {
							try {
								throw new InvalidUserName("Invalid user Name Formate");
							}catch(InvalidUserName e) {
								System.out.println(e.getMessage());
								System.out.println("User Name must Contais capital latter,small latter,Number and Special Charecter\nRe-Enter User-Name");
								emUserName=sc.nextLine();
							}
						}
					}
					System.out.print("Set New Password: ");
					String emPass="";
					String emPass1=sc.nextLine();
					System.out.print("Re-Enter New Password: ");
					String emPass2=sc.nextLine();
					if(emPass1.equals(emPass2)) {
						emPass=emPass1;
					}
					else {
						try {
							throw new PasswordNotMatching("PassWord Miss Match ! !");
						}
						catch(PasswordNotMatching e) {
							System.out.println(e.getMessage());
							System.out.println("Re-Enter Password..");
							emPass=sc.nextLine();
						}
					}
					Integer emNum=new Integer(emNextid++);
					String emId=emNum.toString();
					Employee emp=new Employee(emName,emId,emQualification,emMail,emMobileNumber,emYear,emUserName,emPass);
					op.addEmployee(emp);
					break;
				default :
					break;
				}
				break;
			case 2:
				System.out.println("Log-in...");
				sc.nextLine();
					System.out.print("Enter User Name: ");
					String aUserName=sc.nextLine();
					System.out.print("Enter Password: ");
					String aPass=sc.nextLine();
					List l=new ArrayList(op.userVerification(aUserName, aPass));
					int check1=(int)l.get(1);
					switch(check1) {
					case 1:
						Employer er=(Employer)l.get(0);
						boolean t1=true;
						while(t1) {
						System.out.println("**Welcome To Employer Section**\n1.List Of Job Notification\n2.Add Job Notifications\n3.Details Updation\n4.Log-out\nSelect One Option");
						int choice4=sc.nextInt();
						switch(choice4) {
						case 1:
							System.out.println("List Of Job Notifications");
							Set keys = jobs.keySet();
						    for (Object k : keys) {
						      System.out.println(k + "----->" + jobs.get(k));
						    }
						    break;
						case 2:
							System.out.print("Enter New Job Title: ");
							sc.nextLine();
							String newJob=sc.nextLine();
							jobs.put(newJob,0);
							System.out.println("Job Nofification Added Sucessfully..");
							break;
						case 3:
							System.out.println("Which Data you want to Update...\n1.Name\n2.company\n3.Designation\n4.Mail\n5.Back\nSelect One Option");
							int choice5=sc.nextInt();
							switch(choice5) {
							case 1:
								sc.nextLine();
								System.out.print("Enter Name: ");
								String erNewName=sc.nextLine();
								op.erUpdateName(erNewName,er);
								break;
							case 2:
								sc.nextLine();
								System.out.print("Enter Company: ");
								String erNewCompany=sc.nextLine();
								op.erUpdateCompany(erNewCompany, er);
								break;
							case 3:
								sc.nextLine();
								System.out.print("Enter Designation: ");
								String erNewDesignation=sc.nextLine();
								op.erUpdateDesignation(erNewDesignation, er);
								break;
							case 4:
								sc.nextLine();
								System.out.print("Enter Mail-Id");
								String erCheckNewMail=sc.nextLine();
								String erNewMail="";
								if(validMail(erCheckNewMail)) {
									erNewMail=erCheckNewMail;
								}
								else {
									try {
										throw new InvalidMailId("Invalid Mail Id Formate ! !");
									}catch(InvalidMailId e) {
										System.out.println(e.getMessage());
										System.out.print("Re-Enter Mail: ");
										erNewMail=sc.nextLine();
									}
								}
								op.erUpdateMail(erNewMail, er);
								break;
							default:
								break;
							}
						default:
							t1=false;
							break;
						}
						}
						break;
					case 2:
						Employee emp=(Employee)l.get(0);
						boolean t2=true;
						while(t2) {
						System.out.println("**Welcome to Employee Section**\n1.Job Notifications\n2.Profile\n3.Detail Updation\n4.Log-Out\nSelect One Option");
						int choice5=sc.nextInt();
						switch(choice5) {
						case 1:
							int i=1;
							Set keys = jobs.keySet();
						    for (Object k : keys) {
						      System.out.println(i+"."+k);
						      i++;
						    }
						    System.out.println("Type Job Role here to apply: ");
						    sc.nextLine();
						    String emJobRole=sc.nextLine();
						    jobs.replace(emJobRole,(jobs.get(emJobRole)+1));
						    System.out.println("Applied Successfully..");
						    break;
						case 2:
							System.out.println("Profile Details...");
							op.profileDetails(emp);
							break;
						case 3:
							System.out.println("Which Data you want to Update...\n1.Name\n2.Qualification\3.Mobile Number\n4.Mail\n5.Back\nSelect One Option");
							int choice6=sc.nextInt();
							switch(choice6) {
							case 1:
								System.out.print("Enter Name: ");
								String emNewName=sc.nextLine();
								op.empUpdateName(emNewName,emp);
								break;
							case 2:
								System.out.print("Enter Qualification: ");
								String emNewQualification=sc.nextLine();
								op.emUpdateQualification(emNewQualification, emp);
								break;
							case 3:
								System.out.print("Enter Mobile Number: ");
								long erNewNumber=0;
								long erCheckNewNumber=sc.nextLong();
								if(validMobileNumber(erCheckNewNumber)) {
									erNewNumber=erCheckNewNumber;
								}
								else {
									try {
										throw new InvalidMobileNumber("Invalid Mobile Number! ! ");
									}catch(InvalidMobileNumber e) {
										System.out.println(e.getMessage());
										System.out.print("Re-Enter Mobile Number: ");
										erNewNumber=sc.nextLong();
									}
								}
								op.emUpdateNumber(erNewNumber, emp);
								break;
							case 4:
								System.out.print("Enter Mail-Id");
								String emCheckNewMail=sc.nextLine();
								String emNewMail="";
								if(validMail(emCheckNewMail)) {
									emNewMail=emCheckNewMail;
								}
								else {
									try {
										throw new InvalidMailId("Invalid Mail Id Formate ! !");
									}catch(InvalidMailId e) {
										System.out.println(e.getMessage());
										System.out.print("Re-Enter Mail: ");
										emNewMail=sc.nextLine();
									}
								}
								op.emUpdateMail(emNewMail, emp);
								break;
							default:
								break;
							}
						default:
							t2=false;
							break;
							}
						}
						break;
					case 3:
						Admin ad=(Admin)l.get(0);
						boolean t3=true;
						while(t3) {
							System.out.println("*Wlcome To ADMIN Section*\n1.Add Company\n2.Remove Company\n3.List Of Companies\n4.Profile\n5.Log-out\nSelect one option");
							int choice6=sc.nextInt();
							switch(choice6) {
							case 1:
								sc.nextLine();
								System.out.print("Enter New Comapany Name: ");
								String newCompany=sc.nextLine();
								op.addCompany(newCompany);
								break;
							case 2:
								System.out.print("Enter Company Name to remove: ");
								String oldCompany=sc.nextLine();
								op.removeCompany(oldCompany);
								break;
							case 3:
								op.listOfCompanies();
								break;
							case 4:
								op.adminProfile(ad);
								break;
							default:
								t3=false;
								break;
							}
						}
					}break;
					
					default:
						System.out.println("Shut Down....");
						System.exit(0);
				}
				
			}
		}

	public  static boolean validUserName(String userName) {
		// TODO Auto-generated method stub
		int capitalCount=0,smallCount=0,numberCount=0,specialCount=0;
		for(int i=0;i<userName.length();i++) {
			char ch=userName.charAt(i);
			if(ch>='a'&&ch<='z') {
				smallCount++;
			}
			else if(ch>='A'&&ch<='Z') {
				capitalCount++;
			}
			else if(ch>='0'&& ch<='9') {
				numberCount++;
			}
			else {
				specialCount++;
			}
		}
		if(capitalCount!=0 && smallCount!=0 && numberCount!=0 && specialCount!=0) {
			return true;
		}
		else {
			return false;
		}
	}
	public static boolean validMail(String sub1){
		if(sub1.equals("@gmail.com")||sub1.equals("@email.com")) {
			return true;
		}
		else {
			return false;
		}
	}
	public static boolean validMobileNumber(long number) {
		if(1000000000<=number && 9999999999l>=number) {
			return true;
		}
		else {
			return false;
		}
	}
	
}
