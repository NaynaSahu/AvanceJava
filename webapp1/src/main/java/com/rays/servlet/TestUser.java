package com.rays.servlet;

public class TestUser {
	public static void main(String[] args) throws Exception {
		TestUser y = new TestUser();
		//y.TestAdd();
		y.TestAuthentication();
		/*
		 * UserModel u = new UserModel(); u.select();
		 */
	}
	public void TestAdd() throws Exception {
		UserBean bean = new UserBean();
		bean.setFname("Abhay");
		bean.setLname("Singh");
		bean.setGender("male");
		bean.setEmail("abhay@gmail.com");
		bean.setUser("abhaysahu");
		bean.setPassword("1234");
		
		UserModel y = new UserModel();
		y.add(bean);
		
		
	}
	public void TestAuthentication() throws Exception {
		UserModel y = new UserModel();
		UserBean bean=new UserBean();
		bean =y.Authentication("nayna@gmail.com","naynasahu", "pass1234");
		if(bean!=null) {
			System.out.println(bean.getFname());
			System.out.println(bean.getLname());
			System.out.println(bean.getGender());
			System.out.println(bean.getEmail());
			System.out.println(bean.getUser());
			System.out.println(bean.getPassword());
			
		}
		else if (bean == null){
			System.out.println("user not found...");
		}
	}

}
