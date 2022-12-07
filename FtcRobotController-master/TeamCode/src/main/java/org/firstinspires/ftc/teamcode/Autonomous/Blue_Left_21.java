package org.firstinspires.ftc.teamcode.Autonomous;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

@Autonomous
public class Blue_Left_21 extends  org.firstinspires.ftc.teamcode.Autonomous.Auto_Base_21 {
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
        auto_motors.goToSpot(33, 0.5);
        simpleWait(1000);
        auto_motors.strafeRight(0.5, 12);
        simpleWait(1000);
        auto_motors.goToSpot(5, 0.5);
        simpleWait(1000);
        //place cone
        lift.run_lift_21945_auto(telemetry, 1, 1994);
        simpleWait(5000);
        intake.run_intake_21945_auto(telemetry, -1);
        simpleWait(1000);
        lift.run_lift_21945_auto(telemetry, 0, 0,);


        auto_motors.goToSpot(-5, 0.5);
        simpleWait(1000);
        auto_motors.strafeLeft(0.5, 12);
        simpleWait(1000);
    }
}
