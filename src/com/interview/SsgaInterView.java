package com.interview;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SsgaInterView {

	static String ml = null;
	static Scanner s = null;
	static boolean b = true;

	public static void main(String a[]) throws IOException {

		System.out.println("请输入命令");
		while (b) {
			System.out.println("1---显示所有员工信息");
			System.out.println("2---根据姓名查询员工信息");
			System.out.println("3---显示所有层级信息");
			System.out.println("8---递归显示所有层级信息");
			System.out.println("4---退出系统");

			s = new Scanner(System.in);
			ml = s.next();

			if (ml.equals("1")) {
				EmployeeUtils.show(EmployeeUtils.duru());
			}
			if (ml.equals("2")) {
				b = false;
				System.out.println("请输入员工姓名：");
				String a1 = null;
				a1 = s.next();
				EmployeeUtils.findbyname(EmployeeUtils.duru(), a1);
				b = true;

			}

			if (ml.equals("3")) {
				EmployeeUtils.showjibie();
			}
			if (ml.equals("8")) {

				List<Employee> bossList = EmployeeUtils.boss(EmployeeUtils.duru());
				for (Employee e : bossList) {
					EmployeeUtils.diGuiShowEmployee(e);
				}

			}
			if (ml.equals("4")) {
				b = false;
				System.out.println("thanks!!");
			}
		}

	}
}

class EmployeeUtils {

	private static String head = "";
	private static String increse = "   ";

	public static java.util.List<Employee> duru() throws IOException {
		java.util.List<Employee> li = null;
		BufferedReader b = null;
		try {
			String dizhi = "C:/share/data.txt";
			 b = new BufferedReader(new FileReader(dizhi));
			String s = b.readLine();
			li = new ArrayList<Employee>();
			while (s != null) {
				Employee em = new Employee();
				String[] strs = s.split(",");
				em.setId(strs[0].trim());
				em.setName(strs[1].trim());
				if (strs.length == 4) {
					em.setLeader(strs[3].trim());
				}
				if (strs.length == 3) {
					em.setLeader("null");
				}
				li.add(em);
				s = b.readLine();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        finally{
        	b.close();
        }
		return li;
	}

	public static void show(java.util.List<Employee> li) {
		for (int a = 0; a < li.size(); a++) {
			Employee e1 = li.get(a);
			System.out.println(e1);

		}
	}
	
	@SuppressWarnings("unused")
	public static void findbyname(java.util.List<Employee> li, String aa) {
		Employee e1 = findone(li, aa);
		java.util.List<Employee> e2 = findtop(li, aa);
		java.util.List<Employee> e3 = findxia(li, aa);
		String shangji = null;
		;
		
		String xiaji = null;
		;
		if (e1 == null) {
			System.out.println("该员工不存在");
		}
		if (e2.size() == 0) {
			shangji = "null";
		}
		if (e3.size() == 0) {
			xiaji = "null";
		}
		System.out.println("上级：");
		if (e2.size() == 0) {
			System.out.println("null");
		}
		for (int a = 0; a < e2.size(); a++) {
			System.out.println(e2.get(a));
		}
		System.out.println("员工：" + "\n" + e1);
		System.out.println("下级：");
		if (e3.size() == 0) {
			System.out.println("null");
		}
		for (int a = 0; a < e3.size(); a++) {
			System.out.println(e3.get(a));
		}

	}

	public static Employee findone(java.util.List<Employee> li, String aa) {
		Employee e = null;
		for (int a = 0; a < li.size(); a++) {
			if (aa.equals(li.get(a).getName())) {
				e = li.get(a);
				break;
			}
		}

		return e;

	}

	public static java.util.List<Employee> findtop(java.util.List<Employee> li, String aa) {
		Employee e = findone(li, aa);
		java.util.List<Employee> eList = new ArrayList<Employee>();
		if (e == null) {
			// System.out.println("该员工不存在");
			return eList;
		} else {
			for (int a = 0; a < li.size(); a++) {
				if (e.getLeader().equals(li.get(a).getName())) {
					eList.add(li.get(a));
				}

			}
		}
		return eList;

	}

	public static java.util.List<Employee> findxia(java.util.List<Employee> li, String aa) {
		Employee e = findone(li, aa);
		java.util.List<Employee> eList = new ArrayList<Employee>();
		if (e == null) {
			// System.out.println("该员工不存在");
			return eList;
		} else {
			for (int a = 0; a < li.size(); a++) {
				if (e.getName().equals(li.get(a).getLeader())) {
					eList.add(li.get(a));
				}

			}
		}
		return eList;

	}

	public static java.util.List<Employee> boss(java.util.List<Employee> li) {
		Employee e = null;
		java.util.List<Employee> bosslist = new ArrayList<Employee>();
		for (int a = 0; a < li.size(); a++) {
			if (li.get(a).getLeader().equals("null")) {
				e = li.get(a);
				bosslist.add(e);
			}

		}
		return bosslist;
	}

	// 显示层级信息
	public static void showjibie() throws IOException {
		java.util.List<Employee> boss = boss(duru());
		for (int b = 0; b < boss.size(); b++) {
			Employee e1 = boss.get(b);
			java.util.List<Employee> erji = findxia(duru(), e1.getName());
			System.out.println(e1.getName());
			for (int a = 0; a < erji.size(); a++) {
				System.out.println("    " + erji.get(a).getName());
				Employee e2 = erji.get(a);
				java.util.List<Employee> sanji = findxia(duru(), e2.getName());
				for (int c = 0; c < sanji.size(); c++) {
					System.out.println("        "
							+ sanji.get(c).getName());
					Employee e3 = sanji.get(c);
					java.util.List<Employee> siji = findxia(duru(), e3.getName());
					for (int d = 0; d < siji.size(); d++) {
						System.out.println("           "
								+ siji.get(d).getName());
						java.util.List<Employee> wuji = findxia(duru(),
								siji.get(d).getName());
						for (int f = 0; f < wuji.size(); f++) {
							System.out.println("             "
									+ wuji.get(f).getName());
						}
					}
				}
			}

		}

	}

	public static void diGuiShowEmployee(Employee employee) throws IOException {

		System.out.println(head + employee.getId());

		head += increse;
		List<Employee> employeeList = findxia(duru(), employee.getName());

		if (employeeList.size() > 0) {

			for (int i = 0; i < employeeList.size(); i++) {

				diGuiShowEmployee(employeeList.get(i));
			}
		}

		head = head.substring(0, head.length() - 3);

	}

}

class Employee {

	private String id;
	private String name;
	private String leader;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLeader() {
		return leader;
	}

	public void setLeader(String leader) {
		this.leader = leader;
	}

	public String toString() {
		return this.id + "  " + this.name + "   " + this.leader;
	}

}
