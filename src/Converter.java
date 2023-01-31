public class Converter {
    private int ratioSetpToCm = 75;
    private int ratioStepToCalories = 50;

    int convertToKm(int steps){
        int resultKm = (steps * ratioSetpToCm) / 100000;
        return resultKm;
    }

    int convertStepsToKilocalories(int steps){
        int resultKilocalories = (steps * ratioStepToCalories) / 1000;
        return  resultKilocalories;
    }

}
