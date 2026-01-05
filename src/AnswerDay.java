public class AnswerDay {
    private Doomsday doom;
    private Month finalMonth;
    private int inputDay;
    private Day finalanswer;
    public AnswerDay(Date date){
        doom = new Doomsday(date);
        inputDay= date.getDay();
        finalMonth= date.getMonth();
        finalanswer= calculateFinalDay(doom.getDoomsday(),finalMonth);

    }

    private Day calculateFinalDay(Day doomsday,Month month){
        Day answerDay;
        Day specialDay=doom.getDoomsday();
        int specialDayIndicator = getSpecialDayForMonth(month);
        int difference = inputDay_specialDay_difference(inputDay,specialDayIndicator);
        if (difference_postivity_check(inputDay,specialDayIndicator)){
            answerDay =switch_answerDay_forward(specialDay,difference);
            return answerDay;
        }
        else {
            answerDay= switch_answerDay_Backward(specialDay,difference);
            return answerDay;
        }
    }

    private Day switch_answerDay_forward(Day specialDay,int difference) {
        int indicator= specialDay.getDayNumber();
        Day answer = switch (indicator){
            case 1 -> goForwardSunday(difference);
            case 2 -> goForwardMonday(difference);
            case 3 -> goForwardTuesday(difference);
            case 4 -> goForwardWednesday(difference);
            case 5 -> goForwardThursday(difference);
            case 6 -> goForwardFriday(difference);
            case 7 -> goForwardSaturday(difference);

            default -> throw new IllegalStateException("Unexpected value: " + indicator);
        };
        return answer;
    }

    private Day switch_answerDay_Backward(Day specialDay, int difference ) {
        int indicator= specialDay.getDayNumber();
        Day answer = switch (indicator){
            case 1 -> goBackwardSunday(difference);
            case 2 -> goBackwardMonday(difference);
            case 3 -> goBackwardTuesday(difference);
            case 4 -> goBackwardWednesday(difference);
            case 5 -> goBackwardThursday(difference);
            case 6 -> goBackwardFriday(difference);
            case 7 -> goBackwardSaturday(difference);
            default -> throw new IllegalStateException("Unexpected value: " + indicator);
        };
        return answer;
    }

    private boolean difference_postivity_check(int inputDay,int specialDay){
        if ((inputDay-specialDay)>0){
            return true;
        }
        else return false;
    }
    private int inputDay_specialDay_difference(int inputDay,int specialDay){
        int difference= Math.abs(inputDay-specialDay);
        difference = difference %7;
        return difference;

    }
    private int getSpecialDayForMonth(Month month){
        int specialDay = switch (month) {
            case JANUARY -> 3;
            case FEBRUARY -> 28;
            case MARCH -> 14;
            case APRIL -> 4;
            case MAY -> 9;
            case JUNE -> 6;
            case JULY -> 11;
            case AUGUST -> 8;
            case SEPTEMBER -> 5;
            case OCTOBER -> 10;
            case NOVEMBER -> 7;
            case DECEMBER -> 12;
        };
        return specialDay;
    }
    private Day goForwardMonday(int difference){
        if (difference == 0){
            return Day.MONDAY;
        }
        Day answer = switch (difference) {
            case 1 -> Day.TUSEDAY;
            case 2 -> Day.WEDNESDAY;
            case 3 -> Day.THURSDAY;
            case 4 -> Day.FRIDAY;
            case 5 -> Day.SATURDAY;
            case 6 -> Day.SUNDAY;
            default -> throw new IllegalStateException("Unexpected value: " + difference);
        };
        return answer;
    }
    private Day goForwardTuesday(int difference){
        if (difference == 0){
            return Day.TUSEDAY;
        }
        Day answer = switch (difference) {
            case 1 -> Day.WEDNESDAY;
            case 2 -> Day.THURSDAY;
            case 3 -> Day.FRIDAY;
            case 4 -> Day.SATURDAY;
            case 5 -> Day.SUNDAY;
            case 6 -> Day.MONDAY;
            default -> throw new IllegalStateException("Unexpected value: " + difference);
        };
        return answer;
    }
    private Day goForwardWednesday(int difference){
        if (difference == 0){
            return Day.WEDNESDAY;
        }
        Day answer = switch (difference) {
            case 1 -> Day.THURSDAY;
            case 2 -> Day.FRIDAY;
            case 3 -> Day.SATURDAY;
            case 4 -> Day.SUNDAY;
            case 5 -> Day.MONDAY;
            case 6 -> Day.TUSEDAY;
            default -> throw new IllegalStateException("Unexpected value: " + difference);
        };
        return answer;
    }
    private Day goForwardThursday(int difference){
        if (difference == 0){
            return Day.THURSDAY;
        }
        Day answer = switch (difference) {
            case 1 -> Day.FRIDAY;
            case 2 -> Day.SATURDAY;
            case 3 -> Day.SUNDAY;
            case 4 -> Day.MONDAY;
            case 5 -> Day.TUSEDAY;
            case 6 -> Day.WEDNESDAY;
            default -> throw new IllegalStateException("Unexpected value: " + difference);
        };
        return answer;
    }
    private Day goForwardFriday(int difference){
        if (difference == 0){
            return Day.FRIDAY;
        }
        Day answer = switch (difference) {
            case 1 -> Day.SATURDAY;
            case 2 -> Day.SUNDAY;
            case 3 -> Day.MONDAY;
            case 4 -> Day.TUSEDAY;
            case 5 -> Day.WEDNESDAY;
            case 6 -> Day.THURSDAY;
            default -> throw new IllegalStateException("Unexpected value: " + difference);
        };
        return answer;
    }
    private Day goForwardSaturday(int difference){
        if (difference == 0){
            return Day.SATURDAY;
        }
        Day answer = switch (difference) {
            case 1 -> Day.SUNDAY;
            case 2 -> Day.MONDAY;
            case 3 -> Day.TUSEDAY;
            case 4 -> Day.WEDNESDAY;
            case 5 -> Day.THURSDAY;
            case 6 -> Day.FRIDAY;
            default -> throw new IllegalStateException("Unexpected value: " + difference);
        };
        return answer;
    }
    private Day goForwardSunday(int difference){
        if (difference == 0){
            return Day.SUNDAY;
        }
        Day answer = switch (difference) {
            case 1 -> Day.MONDAY;
            case 2 -> Day.TUSEDAY;
            case 3 -> Day.WEDNESDAY;
            case 4 -> Day.THURSDAY;
            case 5 -> Day.FRIDAY;
            case 6 -> Day.SATURDAY;
            default -> throw new IllegalStateException("Unexpected value: " + difference);
        };
        return answer;
    }
    private Day goBackwardSunday(int differnce){
        if (differnce == 0){
            return Day.SUNDAY;
        }
        Day Answer = switch (differnce){
            case 1 -> Day.SATURDAY;
            case 2 -> Day.FRIDAY;
            case 3 -> Day.THURSDAY;
            case 4 -> Day.WEDNESDAY;
            case 5 -> Day.TUSEDAY;
            case 6 -> Day.MONDAY;
            default -> throw new IllegalStateException("Unexpected value: " + differnce);
        };
        return Answer;

    }
    private Day goBackwardMonday(int differnce){
        if (differnce == 0){
            return Day.MONDAY;
        }
        Day Answer = switch (differnce){
            case 1 -> Day.SUNDAY;
            case 2 -> Day.SATURDAY;
            case 3 -> Day.FRIDAY;
            case 4 -> Day.THURSDAY;
            case 5 -> Day.WEDNESDAY;
            case 6 -> Day.TUSEDAY;
            default -> throw new IllegalStateException("Unexpected value: " + differnce);
        };
        return Answer;

    }
    private Day goBackwardTuesday(int differnce){
        if (differnce == 0){
            return Day.TUSEDAY;
        }
        Day Answer = switch (differnce){
            case 1 -> Day.MONDAY;
            case 2 -> Day.SUNDAY;
            case 3 -> Day.SATURDAY;
            case 4 -> Day.FRIDAY;
            case 5 -> Day.THURSDAY;
            case 6 -> Day.WEDNESDAY;
            default -> throw new IllegalStateException("Unexpected value: " + differnce);
        };
        return Answer;

    }
    private Day goBackwardWednesday(int differnce){
        if (differnce == 0){
            return Day.WEDNESDAY;
        }
        Day Answer = switch (differnce){
            case 1 -> Day.TUSEDAY;
            case 2 -> Day.MONDAY;
            case 3 -> Day.SUNDAY;
            case 4 -> Day.SATURDAY;
            case 5 -> Day.FRIDAY;
            case 6 -> Day.THURSDAY;
            default -> throw new IllegalStateException("Unexpected value: " + differnce);
        };
        return Answer;

    }
    private Day goBackwardThursday(int differnce){
        if (differnce == 0){
            return Day.THURSDAY;
        }
        Day Answer = switch (differnce){
            case 1 -> Day.WEDNESDAY;
            case 2 -> Day.TUSEDAY;
            case 3 -> Day.MONDAY;
            case 4 -> Day.SUNDAY;
            case 5 -> Day.SATURDAY;
            case 6 -> Day.FRIDAY;
            default -> throw new IllegalStateException("Unexpected value: " + differnce);
        };
        return Answer;

    }
    private Day goBackwardFriday(int differnce){
        if (differnce == 0){
            return Day.FRIDAY;
        }
        Day Answer = switch (differnce){
            case 1 -> Day.THURSDAY;
            case 2 -> Day.WEDNESDAY;
            case 3 -> Day.TUSEDAY;
            case 4 -> Day.MONDAY;
            case 5 -> Day.SUNDAY;
            case 6 -> Day.SATURDAY;
            default -> throw new IllegalStateException("Unexpected value: " + differnce);
        };
        return Answer;

    }
    private Day goBackwardSaturday(int differnce){
        if (differnce == 0){
            return Day.SATURDAY;
        }
        Day Answer = switch (differnce){
            case 1 -> Day.FRIDAY;
            case 2 -> Day.THURSDAY;
            case 3 -> Day.WEDNESDAY;
            case 4 -> Day.TUSEDAY;
            case 5 -> Day.MONDAY;
            case 6 -> Day.SUNDAY;
            default -> throw new IllegalStateException("Unexpected value: " + differnce);
        };
        return Answer;

    }
    public Day getFinalanswer() {
        return finalanswer;
    }
}
