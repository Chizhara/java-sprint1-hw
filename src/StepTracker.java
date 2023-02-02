import java.util.Scanner;

public class StepTracker {
    private Scanner scanner;
    private MonthData[] monthsToData;
    private Converter converter;

    int goalByStepsPerDay = 10000;

    public StepTracker(Scanner scanner){
        this.scanner = scanner;
        converter = new Converter();

        monthsToData = new MonthData[12];

        for(int i = 0; i < 12; i++)
            monthsToData[i] = new MonthData(i);
    }

    public void addNewNumberStepsPerDay(){
        int monthNum = requestPrintMonthNum();

        int dayNum = requestPrintDayNum(monthNum);

        System.out.println("Напишите количество шагов");
        int stepsCount = scanner.nextInt();

        monthsToData[monthNum].saveCountOfSteps(dayNum, stepsCount);
    }

    public void changeStepGoal(){
        System.out.println("Введите новое значение для цели по количеству шагов за день:");
        goalByStepsPerDay = scanner.nextInt();
    }

    public void printStatistic(){
        int monthNum = requestPrintMonthNum();

        System.out.println("Количество пройденных шагов по дням:");
        monthsToData[monthNum].printDaysAndStepsFromMonth();

        System.out.println("\nОбщее количество шагов за месяц: " + monthsToData[monthNum].sumStepsFromMonth());
        System.out.println("\nМаксимальное пройденное количество шагов в месяце: " + monthsToData[monthNum].maxSteps());
        System.out.println("\nСреднее количество шагов: " + (monthsToData[monthNum].maxSteps() / monthsToData[monthNum].days.length));
        System.out.println("\nПройденная дистанция: " + converter.convertToKm(monthsToData[monthNum].sumStepsFromMonth()) + " км");
        System.out.println("\nКоличество сожженных килокалорий: " + converter.convertStepsToKilocalories(monthsToData[monthNum].sumStepsFromMonth()));
        System.out.println("\nЛучшая серия: " + monthsToData[monthNum].bestSeries(goalByStepsPerDay));
    }

    private int requestPrintMonthNum(){
        int resultMonthNum;

        while(true){
            System.out.println("Введите номер месяца от 1 до 12");
            resultMonthNum = scanner.nextInt() - 1;

            if(resultMonthNum >= 0 && resultMonthNum <= 11)
                break;
        }

        return resultMonthNum;
    }

    private int requestPrintDayNum(int monthNum){
        int resultDayNum;

        while(true){
            System.out.println("Напишите номер дня от 1 до " + monthsToData[monthNum].days.length);
            resultDayNum = scanner.nextInt() - 1;

            if(resultDayNum >= 0 && resultDayNum < monthsToData[monthNum].days.length)
                break;
        }

        return resultDayNum;
    }
}
