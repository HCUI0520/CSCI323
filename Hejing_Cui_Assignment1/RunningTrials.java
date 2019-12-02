
/**
 * Running Trials
 * Author: Hejing Cui and Carolyn Yao
 * Does this compile or finish running within 5 seconds? Y
 */

public class RunningTrials {

    // Do not change the parameters!
    public int runTrialsRecur(int possibleSpeeds, int days) {
        int minTests = 0;
        if(possibleSpeeds == 0 || days == 0){
            return minTests;
        }
        //set all possible injuire number
        int injurie_counter = possibleSpeeds - 1;
        minTests = injurie_counter + 1;

        //recursive call
        //decrease possible speed and day by testing
        //day parameter means weeks, so real day is days * 7
        minTests += runTrialsRecur(possibleSpeeds - 1, days * 7 - 1);
        return minTests;
    }

    // Optional:
    // Pick whatever parameters you want to, just make sure to return an int.
    public int runTrialsMemoized() {
        int minTests = 0;
        // Your optional code here
        return minTests;
    }

    // Do not change the parameters!
    public int runTrialsBottomUp(int possibleSpeeds, int days) {
        int minTests = 0;
        //days mean weeks, real days is given day * 7
        int train_days = days * 7;
        //counter
        int day_counter = 0;
        int test_range = 0;
        int injurie_counter = 0;
        //injuries are possible at all possible speeds.
        //so each speed can has injuries
        while (day_counter <= train_days) {
            //if test is available to last speed, it end test
            if (injurie_counter == possibleSpeeds) {
                break;
            }
            test_range = injurie_counter - 1;
            minTests += test_range + 2;
            //for each speed test, injurie can be occured
            injurie_counter++;
            day_counter++; //when injurie is happens, day is lose
        }
        return minTests;
    }

    public static void main(String args[]) {
        RunningTrials running = new RunningTrials();
        // Do not touch the below lines of code, your output will automatically be formatted
        int minTrials1Recur = running.runTrialsRecur(12, 5);
        int minTrials1Bottom = running.runTrialsBottomUp(12, 5);
        int minTrials2Recur = running.runTrialsRecur(20, 8);
        int minTrials2Bottom = running.runTrialsBottomUp(20, 8);
        System.out.println("12 speeds, 5 weeks: " + minTrials1Recur + " " + minTrials1Bottom);
        System.out.println("20 speeds, 8 weeks: " + minTrials2Recur + " " + minTrials2Bottom);
    }
}
