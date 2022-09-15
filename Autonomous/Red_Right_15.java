package org.firstinspires.ftc.teamcode;


import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

@Autonomous



public class Red_Right_15 extends org.firstinspires.ftc.teamcode.Auto_Base_15 {

    @Override
    public void runOpMode() throws InterruptedException {
        this.init_classes(true);



        waitForStart();

        this.sense_barcode_red();
        imu_drive.setZero();



        imu_drive.goToSpot(-12, 1);
        imu_drive.strafeLeft(1, 16);
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