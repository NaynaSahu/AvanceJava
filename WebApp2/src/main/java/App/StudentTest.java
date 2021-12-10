package App;

import java.util.ArrayList;
import java.util.Iterator;

public class StudentTest {
	public static void main(String[] args) throws Exception {
		//TestAdd();
		//TestUpdate();
		//TestDelete();
		//TestGet();
		TestSelect();
		
		
	}
	public static void TestAdd() throws Exception {
		StudentBean bean = new StudentBean();
		bean.setFirstName("Nayna");
		bean.setLastName("Sahu");
		bean.setRollNo("101");
		bean.setSession("A");
		StudentModel model = new StudentModel();
		model.add(bean);
	}
	public static void TestUpdate() throws Exception {
		StudentBean bean = new StudentBean();
		bean.setFirstName("Rekha");
		bean.setLastName("Sahu");
		bean.setSession("B");
		bean.setRollNo("101");
		StudentModel model = new StudentModel();
		model.update(bean);
	}
	public static void TestDelete() throws Exception {
		//StudentBean bean = new StudentBean();
		//bean.setRollNo("103");
		StudentModel model = new StudentModel();
		model.delete("103");
		
	}
	public static void TestGet() throws Exception {
		StudentBean bean = StudentModel.get("101");
		
		System.out.println(bean.getId());
		System.out.println(bean.getRollNo());
		System.out.println(bean.getFirstName());
		System.out.println(bean.getLastName());
		System.out.println(bean.getSession());
		
	}

	public static void TestSelect() throws Exception {
		StudentModel model = new StudentModel();
		StudentBean bean = new StudentBean();
		ArrayList list = model.search(bean);
		Iterator it = list.iterator();
		while(it.hasNext()) {
			bean =(StudentBean) it.next();
			System.out.println(bean.getId());
			System.out.println(bean.getRollNo());
			System.out.println(bean.getFirstName());
			System.out.println(bean.getLastName());
			System.out.println(bean.getSession());
		}
	}

}
