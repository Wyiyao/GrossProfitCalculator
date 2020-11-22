public class Company {
    public Project[] projects;

    Company(Project[] projects) {
        this.projects = projects;
    }

    public int getMonthlyGrossProfit(String year, String month) {
        int sum = 0;
        for (Project project: this.projects) {
            sum += project.getMonthlyGrossProfit(year, month);
        }
        return  sum;
    }

    public int getYearlyGrossProfit(String year) {
        int sum = 0;
        for (Project project: this.projects) {
            sum += project.getYearlyGrossProfit(year);
        }
        return  sum;
    }
}
