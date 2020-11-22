import java.util.ArrayList;
import java.util.List;

public class Labor implements ILabor {

    private String name;
    private String category;
    public String projectName;
    public List<TimeSheet> timeSheets;
    private int id;

    public EnumLaborType laborType;

    /**
     * Constructor
     */
    Labor() {
        this("");
    }

    /**
     * Constructor
     * @param name; name
     */
    Labor(String name) {
        this.name = name;
        this.category = "";
        this.timeSheets = new ArrayList<>();
    }

    /**
     * Constructor
     * @param id; labor id
     * @param name; labor name
     * @param category; labor category
     */
    Labor(int id, String name, String category) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.timeSheets = new ArrayList<>();
    }


    /**
     * Get total labor working hours by specific month.
     * @param year; year, i.e. 2020
     * @param month; month, i.e. Jan.
     * @return; int; total hours by the certain year+month.
     */
    @Override
    public int getTotalHoursByMonth(String year, String month) {
        int len = this.timeSheets.size();
        for (int t = 0; t < len; t++) {
            TimeSheet timeSheet = this.timeSheets.get(t);
            if (timeSheet.month.equals(month) && timeSheet.year.equals(year)) {
                return timeSheet.hours;
            }
        }
        return 0;
    }

    /**
     * Get total labor working hours by specific year.
     * @param year; year
     * @return; int; total hours by the certain year.
     */
    @Override
    public int getTotalHoursByYear(String year) {
        int len = this.timeSheets.size();
        int sum = 0;
        for (int t = 0; t < len; t++) {
            TimeSheet timeSheet = this.timeSheets.get(t);
            if (timeSheet.year.equals(year)) {
                sum += timeSheet.hours;
            }
        }
        return sum;
    }

    /**
     * correct existing timesheet or add a new timesheet
     * @param newTimeSheet; new timesheet to be added.
     */
    @Override
    public void setTimeSheet(TimeSheet newTimeSheet) {
        int len = this.timeSheets.size();
        int findIdx = -1;
        for (int t = 0; t < len; t++) {
            TimeSheet timeSheet = this.timeSheets.get(t);
            if (timeSheet.getIdentifier().equals(newTimeSheet.getIdentifier())) {
                findIdx = t;
                break;
            }
        }
        if (findIdx > 0) {
            this.timeSheets.set(findIdx, newTimeSheet);
            return;
        }
        this.timeSheets.add(newTimeSheet);
    }

    /**
     * delete a timesheet record from timesheets.
     * @param timeSheetToDelete
     */
    @Override
    public void removeTimeSheet(TimeSheet timeSheetToDelete) {
        int len = this.timeSheets.size();
        int findIdx = -1;
        for (int t = 0; t < len; t++) {
            TimeSheet timeSheet = this.timeSheets.get(t);
            if (timeSheet.getIdentifier().equals(timeSheetToDelete.getIdentifier())) {
                findIdx = t;
                break;
            }
        }
        if (findIdx == -1) {
            return;
        }
        this.timeSheets.remove(findIdx);
    }

    // maybe can change this to abstact
    @Override
    public int getMonthlyPay(String year, String month) {
        return 0;
    }

    /**
     * Get billable rate by labor category.
     * @return
     */
    private int getBillableRate() {
        switch (this.category) {
            case "PO":
                return 180;
            case "PM":
                return 120;
            case "SM":
                return 75;
            case "SSE":
                return 100;
            case "SE":
                return 80;
            case "SQE":
                return 90;
            case "QE":
                return 60;
            default:
                return 0;
        }
    }

    /**
     * Monthly Revenue = working hours * billable rate.
     * @param year; year
     * @param month; month
     * @return Monthly Revenue;
     */
    @Override
    public int getMonthlyRevenue(String year, String month) {
        for (TimeSheet timeSheet : this.timeSheets) {
            if (timeSheet.year.equals(year) && timeSheet.month.equals(month)) {
                return timeSheet.hours * this.getBillableRate();
            }
        }
        return 0;
    }

    /**
     * Get yearly pay
     * @param year;
     * @return
     */
    @Override
    public int getYearlyPay(String year) {
        return 0;
    }

    /**
     * Get yearly billable cost
     * @param year
     * @return
     */
    @Override
    public int getYearlyRevenue(String year) {
        int sum = 0;
        for (TimeSheet timeSheet : this.timeSheets) {
            if (timeSheet.year.equals(year)) {
                sum += timeSheet.hours * this.getBillableRate();
            }
        }
        return sum;
    }

    /**
     * Print out Labor's information
     * @return
     */
    public String toString() {
        String thstr = "";
        for (TimeSheet timeSheet : this.timeSheets) {
            thstr += (timeSheet.toString() + "\n");
        }
        return "name: " + this.name +
                ", labor type: " + this.laborType +
                ", category: " + this.category +
                ", project: " + this.projectName +
                "\n timesheet: " + thstr;
    }



}
