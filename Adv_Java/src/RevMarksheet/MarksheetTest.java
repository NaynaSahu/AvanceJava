package RevMarksheet;

public class MarksheetTest {
	public static void main(String[] args) throws Exception {
		
		TestAdd();
	}
	public static void TestAdd() throws Exception {
		MarksheetBean bean = new MarksheetBean();
		bean.setId(109);
		bean.setFname("Dhwani");
		bean.setLname("Bhatiya");
		bean.setRollNo("9");
		bean.setChem(90);
		bean.setMath(98);
		bean.setPhy(100);
		
		MarksheetModel Model = new MarksheetModel();
		Model.add(bean);
		
	}
	public static void TestUpdate() throws Exception {
		MarksheetBean bean =new MarksheetBean();
		bean.setId(109);
		bean.setFname("Dhwani");
		bean.setLname("Birthare");
		bean.setRollNo("9");
		bean.setChem(90);
		bean.setMath(98);
		bean.setPhy(100);
		
		MarksheetModel Model = new MarksheetModel();
		Model.add(bean);
		
	}public static void TestGet() throws Exception {
		MarksheetModel model = new MarksheetModel();
		model.get("5");
	}
	public static void TestDelete() throws Exception {
		MarksheetModel model = new MarksheetModel();
		model.Delete("3");
	}
	public static void TestGetMeriList() throws Exception {
		MarksheetModel model = new MarksheetModel();
		model.getMeritList();
		
	}
	public static void TestSelect() throws Exception {
		MarksheetModel model = new MarksheetModel();
		model.Select();
		
	}




}
