package App;

public class Validation {

	public static boolean isNull(String val) {
		if (val == null || val.trim().length() == 0) {
			return true;
		} else {
			return false;
		}

	}

	public static boolean isNotNull(String val) {
		return !isNull(val);

	}

	public static boolean isName(String val) {
		String name = "^[a-zA-Z_-]+$";
		if (Validation.isNotNull(val)) {
			boolean check = val.matches(name);
			return check;

		} else {
			return false;
		}
	}

	public static boolean isEmail(String val) {
		String email1 = "^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
		if (Validation.isNotNull(val)) {
			boolean check = val.matches(email1);
			return check;

		} else {
			return false;
		}

	}

	public static boolean isPass(String val) {
		String pass = "^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
		if (Validation.isNotNull(val)) {
			boolean check = val.matches(pass);
			return check;

		} else {
			return false;
		}

	}

}
