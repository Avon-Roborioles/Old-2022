package org.firstinspires.ftc.teamcode.Autonomous;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

@Autonomous
public class B_Blue_Left_21 extends  org.firstinspires.ftc.teamcode.Autonomous.Auto_Base_21 {
    public void runOpMode() throws InterruptedException {
        init_classes(false);
        waitForStart();
        //one tile is 24 in
        //START
        //Scan cone
        lift.run_lift_21945_auto(telemetry, 0.5, 0);
        simpleWait(1000);
        camera.init_camera(hardwareMap, "webcam", telemetry);
        zone = camera.zone();
        lift.run_lift_21945_auto(telemetry, 0, 0);
        simpleWait(1000);

        auto_motors.goToSpot(34, 0.5);
        simpleWait(1000);
        auto_motors.strafeRight(0.4, 12);
        simpleWait(1000);
        auto_motors.goToSpot(7, 0.5);
        simpleWait(1000);
        //place cone
        lift.run_lift_21945_auto(telemetry, 0.9, 1994);
        simpleWait(5000);
        intake.run_intake_21945_auto(telemetry, -1);
        simpleWait(1000);
        intake.run_intake_21945_auto(telemetry,0);
        lift.run_lift_21945_auto(telemetry, 0, 0);
        auto_motors.goToSpot(-5, 0.2);
        simpleWait(1000);
        auto_motors.strafeLeft(0.5, 12);
        simpleWait(1000);
        parking21(zone);

//        if (zone == 1) {
//            auto_motors.strafeLeft(0.5, 24);
//
//            //stop
//        }
//        //Middle (2)
//        else if (zone == 2) {
//
//            //stop
//        }
//        //Right
//        else if (zone == 3) {
//            auto_motors.strafeRight(0.5, 24);
//
//            //stop
//        }
    }
}
