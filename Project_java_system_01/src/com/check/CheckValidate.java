package com.check;

import java.time.LocalDate;
import java.time.Period;
import java.util.Calendar;
import java.util.Date;
import java.util.regex.Pattern;

import com.models.EmployeeModel;

public class CheckValidate {

	// Check type of file upload validate
	public static boolean checkType(String url) {
		if (false) {
			return false;
		} else {
			return true;
		}
	}

	// Check name validate - Thom
	public boolean checkName(String name) {
		if (name.length() < 2 || name.length() >30) {
			return false;
		} else {
			return true;
		}
	}

	// Check name validate - Thom
	public boolean checkAddress(String name) {
		if (name.length() < 2  ) {
			return false;
		} else {
			return true;
		}
	}

	// Check name validate - Thom
	public boolean checkString(String name) {
		if (name.length() < 2) {
			return false;
		} else {
			return true;
		}
	}

	// Check date validate  (age >=18) - Thom
	public static boolean checkDate(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		int year = calendar.get(Calendar.YEAR);
		int month = calendar.get(Calendar.MONTH) + 1;
		int day = calendar.get(Calendar.DATE);
		LocalDate l1 = LocalDate.of(year, month, day);
		LocalDate nowDate = LocalDate.now();
		Period diff = Period.between(l1, nowDate);
		if (diff.getYears() < 18) {
			return false;
		} else {
			return true;
		}
	}

	// Check date validate - Thom Ver2
	public static boolean checkDate10(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		int year = calendar.get(Calendar.YEAR);
		int month = calendar.get(Calendar.MONTH) + 1;
		int day = calendar.get(Calendar.DATE);
		LocalDate l1 = LocalDate.of(year, month, day);
		LocalDate nowDate = LocalDate.now();
		Period diff = Period.between(l1, nowDate);
		if (diff.getYears() < 10) {
			return false;
		} else {
			return true;
		}
	}

	// Check phone validate - Thom
	public static boolean checkPhone(String phone) {
		// Or phone.contains("[a-zA-Z]+") == false
		if (phone.matches("[0-9]+") && phone.length() > 8 && phone.length() < 16) {
			return true;
		} else {
			return false;
		}
	}

	// Check phone validate - Thom
	public boolean checkNumber(String phone) {
		// Or phone.contains("[a-zA-Z]+") == false
		if (phone.matches("[0-9]+")) {
			return true;
		} else {
			return false;
		}
	}

	// Check email validate - Thom
	public static boolean checkEmail(String email) {
		if (email.length() > 18) {
			return Pattern.matches("^[a-zA-Z][\\w-]+@(gmail.com|GMAIL.COM)$", email);
		} else {
			return false;
		}
	}

	// Check password validate - Thom
	public static boolean checkPassword(String password) {
		return Pattern.matches("^(.{0,7}|[^0-9]*|[^A-Z]*|[^a-z]*|[a-zA-Z0-9]*)$", password);
	}
	
	// Check password validate - Thom
		public static boolean checkPasswordRegex(String password) {
			return password.length() >= 5;
		}

	// Check username validate - Thom
	public static boolean checkUsername(String username) {
		if (username.length() <= 18 && username.length() >= 6) {
			return Pattern.matches("^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d]{8,}$", username);
		} else {
			return false;
		}
	}

	// Check authorName validate - Thom
	public static boolean checkAuthorName(String author) {
		if (author.length() > 4) {
			return Pattern.matches("[a-zA-Z]{2,}+[\\s]+[a-zA-Z]{2,}", author);
		} else {
			return false;
		}
	}
	
	public static boolean checkUsernameUse(String username) {
		EmployeeModel employeeModel = new EmployeeModel();
		if(employeeModel.checkLogin(username)!=null) {
			return false;
		}else {
			return true;
		}
	}
}
