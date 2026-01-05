public class Doomsday {
    protected Date date;
    protected Day doomsday;
    public Doomsday(Date date){
        this.date= date;
        this.doomsday= calculateDoomsday();
    }
    private Day calculateDoomsday(){
        int doomsdayYear = date.getYear();
        if (doomsdayYear >= 2000){
            Day realDoomsday = after2000doomsday(doomsdayYear);
            return realDoomsday;
        }
        else return Day.FRIDAY; // needs completion for dates before 2000
    }
    private Day after2000doomsday(int doomsdayYear){
        Day realDoomsday = Day.TUSEDAY;
        if (doomsdayYear == 2000) return realDoomsday;
        else {
            int doomsdayNumber = doomsdayYear - 2000;
            doomsdayNumber= doomsdayNumber+ (doomsdayNumber/4);
            doomsdayNumber= doomsdayNumber %7;
            realDoomsday = switchDoomsdayAfter2000(doomsdayNumber);
            return realDoomsday;
        }
    }
    private Day switchDoomsdayAfter2000(int doomsdayNumber){
        Day realDoomdsay = Day.TUSEDAY;
        switch (doomsdayNumber){
            case 1:
                realDoomdsay=Day.WEDNESDAY;
                break;
            case 2:
                realDoomdsay=Day.THURSDAY;
                break;
            case 3:
                realDoomdsay=Day.FRIDAY;
                break;
            case 4:
                realDoomdsay=Day.SATURDAY;
                break;
            case 5:
                realDoomdsay=Day.SUNDAY;
                break;
            case 6:
                realDoomdsay=Day.MONDAY;
                break;
        }
        return realDoomdsay;
    }
    public Day getDoomsday(){
        return this.doomsday;
    }
}
