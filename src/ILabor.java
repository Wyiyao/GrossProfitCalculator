public interface ILabor {

    // Timesheet manipulations.
    int getTotalHoursByMonth(String year, String month);
    int getTotalHoursByYear(String year);
    void setTimeSheet(TimeSheet timeSheet);
    void removeTimeSheet(TimeSheet timeSheet);
    int getMonthlyPay(String year, String month);
    int getMonthlyRevenue(String year, String month);
    int getYearlyPay(String year);
    int getYearlyRevenue(String year);
}
