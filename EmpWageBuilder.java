
public class EmpWageBuilder {
	public static final int IS_PART_TIME = 1;
	public static final int IS_FULL_TIME = 2;
	public static final int EMP_RATE_PER_HOUR = 20;
	public static final int NUM_OF_WORKING_DAYS = 20;
	public static final int MAX_HRS_IN_MONTH = 100;

	public static void main(String[] args) {


		int empWage = 0;
		int totEmpWage = 0, totalWorkingDays = 0, totEmpHrs = 0;

		while (totEmpHrs <= MAX_HRS_IN_MONTH && totalWorkingDays < NUM_OF_WORKING_DAYS) {
			int empCheck = (int) Math.floor(Math.random() * 10) % 3;
			int empHrs=0;
			totalWorkingDays++;
			switch (empCheck) {
			case IS_FULL_TIME:
				empHrs = 8;
				break;
			case IS_PART_TIME:
				empHrs = 4;
				break;
			default:
				empHrs = 0;
			}
			totEmpHrs+=empHrs;
			empWage = empHrs * EMP_RATE_PER_HOUR;
			totEmpWage += empWage;
			System.out.println("Emp Wage=" + empWage);
		}
		System.out.println("Total emp wage=" + totEmpWage);
	}
}
