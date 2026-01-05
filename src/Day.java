public enum Day {
    SUNDAY(1),MONDAY(2),TUSEDAY(3),WEDNESDAY(4),THURSDAY(5),FRIDAY(6),SATURDAY(7);
    private int dayNumber;
    Day(int dayNumber){
        this.dayNumber= dayNumber;
    }
    public int getDayNumber() {
        return dayNumber;
    }
}
