package org.firstinspires.ftc.teamcode;


import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

public abstract class Auto_Base_14 extends LinearOpMode {
    protected org.firstinspires.ftc.teamcode.Mecanum_Methods_Autonomus auto_motors = new org.firstinspires.ftc.teamcode.Mecanum_Methods_Autonomus();
    protected org.firstinspires.ftc.teamcode.Carousel_Call auto_carousel = new org.firstinspires.ftc.teamcode.Carousel_Call();
    protected org.firstinspires.ftc.teamcode.Distance_Sensor distance_sensor = new org.firstinspires.ftc.teamcode.Distance_Sensor();
    protected org.firstinspires.ftc.teamcode.Arm_14954 armlifts = new org.firstinspires.ftc.teamcode.Arm_14954();
    protected org.firstinspires.ftc.teamcode.Intake_14954 intake = new org.firstinspires.ftc.teamcode.Intake_14954();

    protected org.firstinspires.ftc.teamcode.Mecanum_IMU imu_drive = new org.firstinspires.ftc.teamcode.Mecanum_IMU();
    protected org.firstinspires.ftc.teamcode.Mecanum_IMU_States imu_drive_states = new org.firstinspires.ftc.teamcode.Mecanum_IMU_States();
    protected org.firstinspires.ftc.teamcode.StateController sc = new org.firstinspires.ftc.teamcode.StateController();

    protected int inchToTicks = 91;
    protected int scorePosition;

    public void init_classes(boolean red_alliance) {
        auto_motors.init_auto_drive_motors(hardwareMap, telemetry);
        auto_carousel.init_carousel(hardwareMap, "carousel", false);
        armlifts.init_armlift(hardwareMap, "armlift1", "armlift2");
        intake.init_intake(hardwareMap, "intake");
        distance_sensor.initDistance(hardwareMap, telemetry, red_alliance);
       boolean flip = red_alliance;
        imu_drive.init_drive_motors(hardwareMap, telemetry, flip);

        imu_drive_states.init_drive_motors(hardwareMap, telemetry, false);
    }
    public void sense_barcode (){
        scorePosition = 3; //furthest to the right, won't be changed if it doesn't see 1 or 2

        if(distance_sensor.checkSeesSomething()) {
            scorePosition = 2;
        }
        imu_drive.goToSpot(-8, 1);

        if(distance_sensor.checkSeesSomething()) {
            scorePosition = 1;
        }

        telemetry.addData("Final Scoring Position Found: ", scorePosition);
        telemetry.update();
        //done sensing barcode :)
    }
}