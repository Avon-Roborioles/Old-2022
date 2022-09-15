package org.firstinspires.ftc.teamcode;


import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

public abstract class Auto_Base_15 extends LinearOpMode {
    protected org.firstinspires.ftc.teamcode.Mecanum_Methods_Autonomus auto_motors = new org.firstinspires.ftc.teamcode.Mecanum_Methods_Autonomus();
    protected org.firstinspires.ftc.teamcode.Carousel_Call auto_carousel = new org.firstinspires.ftc.teamcode.Carousel_Call();
    protected org.firstinspires.ftc.teamcode.Distance_Sensor distance_sensor = new org.firstinspires.ftc.teamcode.Distance_Sensor();
    protected org.firstinspires.ftc.teamcode.Arm_15455 arm = new org.firstinspires.ftc.teamcode.Arm_15455();
    protected org.firstinspires.ftc.teamcode.Intake_15455 intake = new org.firstinspires.ftc.teamcode.Intake_15455();
    protected org.firstinspires.ftc.teamcode.Turntable_15455 turntable = new org.firstinspires.ftc.teamcode.Turntable_15455();

    protected org.firstinspires.ftc.teamcode.Mecanum_IMU imu_drive = new org.firstinspires.ftc.teamcode.Mecanum_IMU();
    protected org.firstinspires.ftc.teamcode.Mecanum_IMU_States imu_drive_states = new org.firstinspires.ftc.teamcode.Mecanum_IMU_States();
    protected org.firstinspires.ftc.teamcode.StateController sc = new org.firstinspires.ftc.teamcode.StateController();

    protected int inchToTicks = 91;
    protected int scorePosition;

    public void init_classes(boolean red_alliance) {
        auto_motors.init_auto_drive_motors(hardwareMap, telemetry);

        auto_carousel.init_carousel(hardwareMap, "carousel", false);
        arm.init_arm(hardwareMap, "arm");
        intake.init_intake(hardwareMap, "intake");
        distance_sensor.initDistance(hardwareMap, telemetry, red_alliance);
        turntable.init_turntable(hardwareMap,telemetry,  "turntable");

        imu_drive.init_drive_motors(hardwareMap, telemetry, false);
        imu_drive_states.init_drive_motors(hardwareMap, telemetry, false);


    }
    public void sense_barcode_red (){
        scorePosition = 3; //furthest to the right, won't be changed if it doesn't see 1 or 2

        if(distance_sensor.checkSeesSomething()) {
            scorePosition = 2;
        }
        auto_motors.goToSpot(-8, 1);

        if(distance_sensor.checkSeesSomething()) {
            scorePosition = 1;
        }

        telemetry.addData("Final Scoring Position Found: ", scorePosition);
        telemetry.update();
        //done sensing barcode :)
    }

    public void sense_barcode_blue (){
        scorePosition = 1; //furthest to the right, won't be changed if it doesn't see 1 or 2

        if(distance_sensor.checkSeesSomething()) {
            scorePosition = 2;
        }
        auto_motors.goToSpot(-8, 1);

        if(distance_sensor.checkSeesSomething()) {
            scorePosition = 3;
        }

        telemetry.addData("Final Scoring Position Found: ", scorePosition);
        telemetry.update();
        //done sensing barcode :)
    }
}