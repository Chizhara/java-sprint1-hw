import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StepTracker tracker = new StepTracker(scanner);

        System.out.println("Программа \"Сётчик калорий\"!");

        String terminalAnswer;
        while(true){
            printMenu();
            terminalAnswer = scanner.next();

            if(terminalAnswer.equals("1")){
                tracker.addNewNumberStepsPerDay();
            } else if(terminalAnswer.equals("2")){
                tracker.changeStepGoal();
            } else if(terminalAnswer.equals("3")){
                tracker.printStatistic();
            } else if(terminalAnswer.equals("0")){
                break;
            } else {
                System.out.println("Введено некорректное значение. Пожалуйста, повторите попытку");
            }
        }
    }

    static void printMenu(){
        System.out.println("Введите одно из следующих значений для продолжения работы программы:");
        System.out.println("1 - Сохранить количество пройденных шагов за определённый день");
        System.out.println("2 - Изменить цель по количеству шагов за день");
        System.out.println("3 - Напечатать статистику за определённый месяц");
        System.out.println("0 - Выход");
    }
}