package edu.java.mvc.menu;

public enum Menu {
	QUIT, CREATE, READ_ALL, READ_BY_INDEX, UPDATE, DELETE, UNKNOWN;
	
	public static Menu getvalue(int n) {
		Menu[] menus = Menu.values();
		if (n >= 0 && n < menus.length) {
			return menus[n];
		}
		return menus[menus.length-1];
	}
}