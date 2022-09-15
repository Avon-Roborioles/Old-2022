package org.firstinspires.ftc.teamcode;


import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

@Autonomous


public class Red_Left_15 extends org.firstinspires.ftc.teamcode.Auto_Base_15 {

    @Override
    public void runOpMode() throws InterruptedException {
        this.init_classes(true);


        waitForStart();
        this.sense_barcode_red();
        imu_drive.setZero();


        imu_drive.strafeLeft(1, 5);
        imu_drive.goToSpot(-10.5, 1);
        imu_drive.strafeRight(1,1);
        auto_carousel.run_carousel_auto(telemetry, true);
        imu_drive.strafeLeft(.75, 9);
        auto_motors.goToSpot(43,1);
        arm.autoArmUp(2);
        turntable.turntable_auto(-80,1);
        arm.autoArmUp(scorePosition);
        imu_drive.strafeLeft(1,4.5);
        if (scorePosition==2) imu_drive.strafeLeft(1,1);
        if (scorePosition==3) imu_drive.strafeLeft(1,6.5);
        intake.autoEject();
        imu_drive.strafeRight(1,7);
        if (scorePosition==3) imu_drive.strafeRight(1,7);
        arm.autoArmUp(2);
        turntable.turntable_auto(-6,1);
        arm.autoArmDown();
        auto_motors.goToSpot(-55,-1);
        imu_drive.strafeLeft(1,16);

        telemetry.update();


    }
}

