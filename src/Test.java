import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("hi");
        System.out.println("give me a date: ");
        System.out.print("Day: ");
        int inputDay= scanner.nextInt();
        System.out.print("Month: ");
        String month = scanner.next().toUpperCase();
        Month inputMonth= Month.valueOf(month);
        System.out.print("Year: ");
        int inputYear=scanner.nextInt();
        Date inputDate= new Date(inputDay,inputMonth,inputYear);
        System.out.println(" wait for me please, I suck at math");
        AnswerDay guess = new AnswerDay(inputDate);
        System.out.println("was that day by any chance a : "+ guess.getFinalanswer()+ " ?");

        scanner.close();
    }
}
