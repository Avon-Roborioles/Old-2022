package org.firstinspires.ftc.teamcode;


import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;

//Runs carousel program and parks

@Autonomous

//@Disabled
public class Auto_Blue_Right_14 extends org.firstinspires.ftc.teamcode.Auto_Base_14 {

    @Override
    public void runOpMode() throws InterruptedException {

        this.init_classes(true);

        waitForStart();

       auto_motors.strafeLeft(1, 1);

        imu_drive.setZero();

        imu_drive.strafeRight(.8, 10);

       auto_motors.goToSpot(-20, .75);

       auto_carousel.run_carousel_auto_14(telemetry,false);

//        imu_drive.turnToReset(1);

        auto_motors.goToSpot(5,.75);

        imu_drive.strafeRight(1, 30);

        auto_motors.goToSpot(-9, .75);

        Thread.sleep(10000);
    }
}