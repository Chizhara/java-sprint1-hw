import java.util.Scanner;

public class MonthData {

    int[] days;
    public MonthData(int monthNum){
        if(monthNum >= 12 || monthNum <= 1)
            if(monthNum == 2)
                days = new int[28];
            else if(monthNum <= 7)
                if(monthNum % 2 == 1)
                    days = new int[31];
                else
                    days = new int[30];
            else
            if(monthNum % 2 == 1)
                days = new int[30];
            else
                days = new int[31];
    }

    public void saveCountOfSteps(int dayNum, int stepsCount){
        days[dayNum - 1] = stepsCount;
    }

    public void printDaysAndStepsFromMonth(Scanner scanner){
        for(int i = 0; i < days.length; i++)
            System.out.println((i + 1) + " день: " + days[i]);
    }

    public int sumStepsFromMonth(){
        int resultSumSteps = 0;

        for(int i = 0; i < days.length; i++)
            resultSumSteps += days[i];

        return resultSumSteps;
    }

    public int maxSteps(){
        int resultMaxSteps;

        resultMaxSteps = days[0];
        for(int i = 1; i < days.length; i++)
            if(days[i] > resultMaxSteps)
                resultMaxSteps = days[i];

        return resultMaxSteps;
    }

    public int bestSeries(int goalByStepsPerDay){
        int resultBestSeria = 0;
        int bufbestSeria = 0;

        for(int i = 0; i < days.length; i++)
            if(days[i] >= goalByStepsPerDay)
                bufbestSeria++;
            else
                if(bufbestSeria > resultBestSeria){
                    resultBestSeria = bufbestSeria;
                    bufbestSeria = 0;
                }

        return resultBestSeria;
    }

}
