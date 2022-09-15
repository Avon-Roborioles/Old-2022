package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;

@Autonomous
@Disabled
public class Auto_IMU_15 extends org.firstinspires.ftc.teamcode.Auto_Base_15 {

    @Override
    public void runOpMode() throws InterruptedException {
        this.init_classes(false);


        waitForStart();
        imu_drive.setZero();

        imu_drive.strafeRight(30, .75);
        imu_drive.strafeLeft(30,.75);

        Thread.sleep(1000);
    }
}