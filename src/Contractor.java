
public class Contractor extends Labor {

    private int hourlyRate;

    Contractor() {
        super();
    }

    /**
     * Constructor
     * @param name; contractor name
     */
    Contractor(String name) {
        super(name);
        this.laborType = EnumLaborType.CONTRACTOR;
        this.hourlyRate = 0;
    }

    /**
     * Constructor
     * @param id; labor id
     * @param name; contractor name
     * @param category; contractor labor category
     * @param hourlyPay; contractor hourly pay.
     */
    Contractor(int id, String name, String category, int hourlyPay) {
        super(id, name, category);
        this.laborType = EnumLaborType.CONTRACTOR;
        this.hourlyRate = hourlyPay;
    }

    /**
     * get employee's monthly pay
     */
    @Override
    public int getMonthlyPay(String year, String month) {
        return this.hourlyRate * this.getTotalHoursByMonth(year, month);
    }

    @Override
    public int getYearlyPay(String year) {
        return this.hourlyRate * this.getTotalHoursByYear(year);
    }

}
