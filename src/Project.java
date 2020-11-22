import java.util.ArrayList;
import java.util.List;

public class Project implements IProject{
    public List<Labor> members;

    Project() {
        this.members = new ArrayList<>();
    }

    /**
     * Get monthly Labor cost
     * @param year; year
     * @param month; month
     * @return Monthly cost (total labor cost)
     */
    @Override
    public int getMonthlyCost(String year, String month) {
        int sum = 0;
        for (Labor labor: this.members) {
            sum += labor.getMonthlyPay(year, month);
        }
        return sum;
    }

    /**
     * Get Monthly Revenue
     * @param year; year
     * @param month; month
     * @return Monthly Revenue (total billable rate * hours)
     */
    @Override
    public int getMonthlyRevenue(String year, String month) {
        int sum = 0;
        for (Labor labor: this.members) {
            sum += labor.getMonthlyRevenue(year, month);
        }
        return sum;
    }

    /**
     * Get monthly gross profit
     * @param year; year
     * @param month; month
     * @return monthly gross profit (revenue - cost)
     */
    @Override
    public int getMonthlyGrossProfit(String year, String month) {
        return this.getMonthlyRevenue(year, month) - this.getMonthlyCost(year, month);
    }

    /**
     * Get yearly labor cost
     * @param year;
     * @return all members' yearly cost
     */
    @Override
    public int getYearlyCost(String year) {
        int sum = 0;
        for (Labor labor: this.members) {
            sum += labor.getYearlyPay(year);
        }
        return sum;
    }

    /**
     * Get yearly revenue
     * @param year;
     * @return all members' billable rate
     */
    @Override
    public int getYearlyRevenue(String year) {
        int sum = 0;
        for (Labor labor: this.members) {
            sum += labor.getYearlyRevenue(year);
        }
        return sum;
    }

    /**
     * Get yearly gross profit;
     * @param year
     * @return yearly revenue - yearly cost.
     */
    @Override
    public int getYearlyGrossProfit(String year) {
        return this.getYearlyRevenue(year) - this.getYearlyCost(year);
    }
}
