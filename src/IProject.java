public interface IProject {
    int getMonthlyCost(String year, String month);
    int getMonthlyRevenue(String year, String month);
    int getMonthlyGrossProfit(String year, String month);
    int getYearlyCost(String year);
    int getYearlyRevenue(String year);
    int getYearlyGrossProfit(String year);
}
