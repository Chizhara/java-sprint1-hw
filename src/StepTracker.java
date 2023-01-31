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

        for(int i = 1; i <= 12; i++)
            monthsToData[i] = new MonthData(i);
    }

    public void addNewNumberStepsPerDay(){
        System.out.println("Напишите номер месяца от 1 до 12");
        int monthNum = scanner.nextInt();

        System.out.println("Напишите номер дня от 1 до " + monthsToData[monthNum - 1].days.length);
        int dayNum = scanner.nextInt();

        System.out.println("Напишите количество шагов");
        int stepsCount = scanner.nextInt();

        monthsToData[monthNum - 1].saveCountOfSteps(dayNum, stepsCount);
    }

    public void changeStepGoal(){
        System.out.println("Введите новое значение для цели по количеству шагов за день:");
        goalByStepsPerDay = scanner.nextInt();
    }

    public void printStatictic(){
        System.out.println("Введите номер месяца от 1 до 12");
        int monthNum = scanner.nextInt();

        System.out.println("Количество пройденных шагов по дням:");
        monthsToData[monthNum].printDaysAndStepsFromMonth(scanner);

        System.out.println("\nОбщее количество шагов за месяц: " + monthsToData[monthNum].sumStepsFromMonth());
        System.out.println("\nМаксимальное пройденное количество шагов в месяце: " + monthsToData[monthNum].maxSteps());
        System.out.println("\nСреднее количество шагов: " + (monthsToData[monthNum].maxSteps() / monthsToData[monthNum].days.length));
        System.out.println("\nПройденная дистанция: " + converter.convertToKm(monthsToData[monthNum].sumStepsFromMonth()) + " км");
        System.out.println("\nКоличество сожженных килокалорий: " + converter.convertStepsToKilocalories(monthsToData[monthNum].sumStepsFromMonth()));
        System.out.println("\nЛучшая серия: " + monthsToData[monthNum].bestSeries(goalByStepsPerDay));
    }
}

