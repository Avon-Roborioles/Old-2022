package org.firstinspires.ftc.teamcode.Autonomous;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

@Autonomous
public class Just_Park_21 extends  Auto_Base_21 {
    public void runOpMode() throws InterruptedException {

            init_classes(false);
            waitForStart();
            //one tile is 24 in
            //START
            //Scan cone
            auto_motors.strafeLeft(0.5, 4);
            lift.run_lift_21945_auto(telemetry, 0.5, 0);
            simpleWait(10);
            camera.init_camera(hardwareMap, "webcam", telemetry);
            zone = camera.zone();
            lift.run_lift_21945_auto(telemetry, 0, 0);
            simpleWait(1000);
            //Move forward
            auto_motors.goToSpot(15, 0.5);
            while (auto_motors.isBusy()) {
            }

            //drive forward to middle
            auto_motors.goToSpot(10, 0.5);
            while (auto_motors.isBusy()) {
            }
            parking21();
            //SPLIT TO PARK
            //needs to be in middle of 2
            //LEFT (1)
            
            //SPLIT TO PARK
            //LEFT (1)
//            if (zone == 1) {
//                auto_motors.strafeLeft(0.5, 24);
//
//                //stop
//            }
//            //Middle (2)
//            else if (zone == 2) {
//mm
//                //stop
//            }
//            //Right
//            else if (zone == 3) {
//                auto_motors.strafeRight(0.5, 24);
//
//                //stop
//            }
    }
}
