package App;

public class TestRegistrationModel {
	public static void main(String[] args) throws Exception {
		TestAdd();
		RegistrationModel model = new RegistrationModel();
		model.Authentication("NaynaSahu", "pass1234");
	}
	public static void TestAdd() throws Exception {
		RegistrationBean bean = new RegistrationBean();
		bean.setDob("1-07-2003");
		bean.setEmail("sahu.nayna2001@gmail.com");
		bean.setFname("Nayna");
		bean.setGender("Female");
		bean.setLname("Sahu");
		bean.setPass("pass1234");
		bean.setUsername("NaynaSahu");
		
		
		
		RegistrationModel model = new RegistrationModel();
		model.add(bean);
		
	}
	

}
