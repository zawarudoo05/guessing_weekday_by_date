public class Date {
    private int day;
    private Month month;
    private int year;
    public Date(int day,Month month,int year){
        setDay(day);
        setMonth(month);
        setYear(year);
    }
    public int getDay() {
        return day;
    }
    public void setDay(int day) {
        this.day = day;
    }
    public Month getMonth() {
        return month;
    }
    public void setMonth(Month month) {
        this.month = month;
    }
    public int getYear() {
        return year;
    }
    public void setYear(int year) {
        if (year <= 0){
            System.out.println(" year is not valid");
        }
        else this.year= year;
    }
}
