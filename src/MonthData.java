public class MonthData {

    int[] days;
    public MonthData(int monthNum){
        monthNum++;

        if(monthNum <= 12 || monthNum >= 1)
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
        days[dayNum] = stepsCount;
    }

    public void printDaysAndStepsFromMonth(){
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
        int resultBestSeries = 0;
        int bufBestSeries = 0;

        for(int i = 0; i < days.length; i++)
        {
            if(days[i] >= goalByStepsPerDay)
                bufBestSeries++;
            else
                bufBestSeries = 0;
            if(bufBestSeries > resultBestSeries)
                resultBestSeries = bufBestSeries;
        }

        return resultBestSeries;
    }
}