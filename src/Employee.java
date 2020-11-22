public class Employee extends Labor {

    private int annualSalary;

    Employee() {
        super();
    }

    Employee(String name) {
        super(name);
        this.laborType = EnumLaborType.EMPLOYEE;
        this.annualSalary = 0;
    }

    /**
     * Constructor
     * @param id; labor id
     * @param name; employee name
     * @param category; category
     * @param annualSalary; annual salary
     */
    Employee(int id, String name, String category, int annualSalary) {
        super(id, name, category);
        this.laborType = EnumLaborType.EMPLOYEE;
        this.annualSalary = annualSalary;
    }

    private int getMonthlySalary() {
        return Math.round((float)this.annualSalary / 12);
    }

    /**
     * get employee's monthly pay
     * @return
     */
    @Override
    public int getMonthlyPay(String year, String month) {
        return this.getMonthlySalary();
    }

    @Override
    public int getYearlyPay(String year) {
        int times = 0;
        for (TimeSheet timeSheet : this.timeSheets) {
            if (timeSheet.year.equals(year)) {
                times += 1;
            }
        }
        return this.getMonthlySalary() * times;
    }

}
