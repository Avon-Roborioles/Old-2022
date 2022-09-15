package org.firstinspires.ftc.teamcode;

import org.firstinspires.ftc.teamcode.State;
import java.util.ArrayList;

public class StateController {

    private ArrayList<ArrayList<State>> allStates;
    private ArrayList<State> currentStates;
    private int nextStateNum = 0;

    public void getStates(ArrayList<ArrayList<State>> states) {
        this.allStates = states;
    }

    private void changeState() {
        currentStates = allStates.get(nextStateNum);
        nextStateNum += 1;
    }

    public void runStates() {
        while (nextStateNum < allStates.size()){
            changeState();
            for(int i = 0; i < currentStates.size(); i++) {
                currentStates.get(i).start();
            }
            while(!currentStates.isEmpty()) {
                ArrayList<State> statesToDelete = new ArrayList<State>(); //add states to here so that we don't get concurrent editing error
                for (int i = 0; i < currentStates.size(); i++) {
                    currentStates.get(i).doWhileNotDone(); //for things like IMU driving where it corrects as it goes
                    if (currentStates.get(i).checkDone()) {
                        currentStates.get(i).stop();
                        statesToDelete.add(currentStates.get(i));
                    }
                }
                currentStates.removeAll(statesToDelete);
            }
        }
    }


}