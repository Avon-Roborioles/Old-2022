package org.firstinspires.ftc.teamcode;


import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;

//Runs carousel program and parks

@Autonomous
//@Disabled
public class Auto_Red_Left_14 extends org.firstinspires.ftc.teamcode.Auto_Base_14 {

    @Override
    public void runOpMode() throws InterruptedException {

        this.init_classes(true);

        waitForStart();

        auto_motors.strafeRight(1, 1);

        imu_drive.setZero();

        imu_drive.strafeLeft(0.8, 14.5); //from 8

        auto_motors.goToSpot(-23, 0.75); //from -25

        auto_carousel.run_carousel_auto_14(telemetry,true);

        imu_drive.strafeLeft(0.75, 28); //from 30

//        auto_motors.turn45left(.6);

        auto_motors.goToSpot(-14, .75);



        Thread.sleep(10000);
    }
}