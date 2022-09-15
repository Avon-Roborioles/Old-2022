package org.firstinspires.ftc.teamcode;


import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

//Drives straight to warehouse area


@Autonomous


public class Auto_Red_Right_14 extends org.firstinspires.ftc.teamcode.Auto_Base_14 {

    @Override
    public void runOpMode() throws InterruptedException {


        this.init_classes(true);

        waitForStart();

        imu_drive.setZero();

        auto_motors.goToSpot(36, .75);

        imu_drive.strafeLeft(.75,35);


        Thread.sleep( 10000);
    }

}