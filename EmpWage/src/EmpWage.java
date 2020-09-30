import java.util.*;

class EmpWage {
	public static void main(String args[]) {

		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the number of companies details to be added");
		int y = sc.nextInt();
		ArrayList<SampleEmp> arr = new ArrayList<SampleEmp>();
		boolean j = true;
		for (int i = 0; i < y; i++) {
			System.out.println("Enter the name of the company:");
			String n = sc.next();
			System.out.println("Enter employee wage per day:");
			int wage_per_day = sc.nextInt();
			System.out.println("Enter employee working hours per month:");
			int hrs_per_month = sc.nextInt();
			System.out.println("Enter employee working days per month:");
			int days_per_month = sc.nextInt();
			SampleEmp e = new SampleEmp(n, wage_per_day, days_per_month, hrs_per_month);
			e.Calculate();
			arr.add(e);
		}
		while (j) {
			System.out.println("Do you want to access company details(Y/N)");
			String acc = sc.next();
			if (acc.equalsIgnoreCase("N")) {
				j = false;
				break;
			}
			System.out.println("Enter company name to access its details");
			String s = sc.next();
			int key = 0;
			for (int i = 0; i < arr.size(); i++) {
				if (arr.get(i).name.equalsIgnoreCase(s)) {
					System.out.println("WAGE=" + arr.get(i).wage);
					key = 1;
					break;
				}
			}
			if (key == 0) {
				System.out.println("Company details not found");
			}
		}
	}
}

class SampleEmp implements Calculation {
	int w = 0;
	int h = 0;
	int d = 0;
	int wage;
	String name;

	public SampleEmp(String name, int w, int d, int h) {
		this.w = w;
		this.h = h;
		this.d = d;
		this.name = name;

	}

	public void Calculate() {
		int wage = 0;
		int hours = 0;
		int days = 0;
		{
			while (days <= d || hours <= h) {
				int randomValue = (int) Math.floor(Math.random() * 10 % 3);
				switch (randomValue) {
				case 1:
					wage = wage + w * 8;
					hours = hours + 8;
					days = days + 1;
					break;
				case 2:
					wage = wage + w * 4;
					hours = hours + 4;
					days = days + 1;
					break;
				default:
					wage = wage + 0;
				}
			}
			this.wage = wage;
			System.out.println("Daily Wage="+w);
			System.out.println("Wage per month " + wage);
		}
	}
}

interface Calculation {
	void Calculate();
}