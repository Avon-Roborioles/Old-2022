package org.firstinspires.ftc.teamcode;


import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import org.firstinspires.ftc.teamcode.State;

import java.util.ArrayList;

@Autonomous



public class STATE_Red_Right_15 extends org.firstinspires.ftc.teamcode.Auto_Base_15 {

    @Override
    public void runOpMode() throws InterruptedException {
        this.init_classes(true);

        ArrayList<ArrayList<State>> statesCollection = new ArrayList<ArrayList<State>>();
        ArrayList<State> states1 = new ArrayList<State>();
        states1.add(new org.firstinspires.ftc.teamcode.StraightDriveState(-12, 1, imu_drive_states));
        statesCollection.add(states1);

        ArrayList<State> states2 = new ArrayList<State>();
        states2.add(new org.firstinspires.ftc.teamcode.StrafeLeftState(16, 1, imu_drive_states));
        states2.add()
        statesCollection.add(states2);



        sc.getStates(statesCollection);
        waitForStart();

        this.sense_barcode_red();
        imu_drive.setZero();

        sc.runStates();

        //remaining code not-states-ed here

//        imu_drive.goToSpot(-12, 1);
//        imu_drive.strafeLeft(1, 16);
        arm.autoArmUp(2);
        turntable.turntable_auto(-90, .5);

        arm.autoArmUp(scorePosition);

        if(scorePosition==1){
            imu_drive.strafeLeft(.75,4.5);
        }else if (scorePosition==2) {
            imu_drive.strafeLeft(.75,6);
        }else{
            imu_drive.strafeLeft(.75, 8);
        }
        intake.autoEject();
        if(scorePosition==1){
            imu_drive.strafeRight(.75,4.5);
        }else if (scorePosition==2) {
            imu_drive.strafeRight(.75,6);
        }else{
            imu_drive.strafeRight(.75, 8);
        }
        arm.autoArmUp(2);
        turntable.turntable_auto(-1, .5);
        arm.autoArmDown();
        imu_drive.strafeRight(1,20);
        imu_drive.goToSpot(55,1);






        telemetry.update();




    }
}