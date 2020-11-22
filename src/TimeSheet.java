public class TimeSheet {
    public String month;
    public String year;
    public int hours;

    TimeSheet(String month, String year, int hours) {
        this.month = month;
        this.year = year;
        this.hours = hours;
    }

    /**
     * Get timesheet identifier.
     * @return; Unique identifier to determine the timesheet existence
     */
    public String getIdentifier() {
        return this.year + '_' + this.month;
    }

    public String toString() {
        return "year: " + this.year + ", month: " + this.month + ", hour: " + this.hours;
    }
}
