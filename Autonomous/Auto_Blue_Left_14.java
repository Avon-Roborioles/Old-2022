package org.firstinspires.ftc.teamcode;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

import java.util.ArrayList;
import org.firstinspires.ftc.teamcode.State;
import org.firstinspires.ftc.teamcode.StateController;

//Drives straight to warehouse area

@Autonomous
public class Auto_Blue_Left_14 extends org.firstinspires.ftc.teamcode.Auto_Base_14 {

    @Override
    public void runOpMode() throws InterruptedException {

        this.init_classes(false);

        StateController sc = new StateController();
        ArrayList<ArrayList<State>> states = new ArrayList<ArrayList<State>>();
        //populate states
        ArrayList<State> states1 = new ArrayList<State>();
        states1.add(new State() {
            @Override
            public void start() {
                armlifts.arm_auto(2);
            }
            @Override
            public void doWhileNotDone() {

            }
            @Override
            public boolean checkDone() {
                return armlifts.isBusy();
            }
            @Override
            public void stop() {
                armlifts.arm_stop_stay();
            }
        });
        states1.add(new org.firstinspires.ftc.teamcode.StraightDriveState(12, 1, imu_drive_states));
        states.add(states1);

        ArrayList<State> states2 = new ArrayList<State>();
        states2.add(new org.firstinspires.ftc.teamcode.StrafeLeftState(10, 1, imu_drive_states));
        states2.add(new State() {
            int i = 0;
            @Override
            public void start() {
                auto_carousel.carousel_auto_SM(telemetry);
            }
            @Override
            public void doWhileNotDone() {
                i++;
            }
            @Override
            public boolean checkDone() {
                return i > 1500;
            }
            @Override
            public void stop() {
                auto_carousel.carousel_auto_SM_stop();
            }
        });
        states.add(states2);

        sc.getStates(states);

        waitForStart();

        sc.runStates();

//        do {
//            auto_motors.goToSpot(50, .7);
//            auto_carousel.carousel_auto_SM(telemetry);
//        } while(auto_motors.isBusy());
//
//        auto_motors.stopMotors();
//        auto_carousel.carousel_auto_SM_stop();




       Thread.sleep( 10000);
    }

}