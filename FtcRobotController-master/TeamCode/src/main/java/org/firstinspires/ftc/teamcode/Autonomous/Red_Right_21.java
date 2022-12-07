package org.firstinspires.ftc.teamcode.Autonomous;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

@Autonomous
public class Red_Right_21 extends  org.firstinspires.ftc.teamcode.Autonomous.Auto_Base_21 {

    public void runOpMode() throws InterruptedException {
        init_classes(true);
        waitForStart();
        //one tile is 24 in
        //Start
        //run lift up so camera can see
        lift.run_lift_21945_auto(telemetry,  0.5);
        simpleWait(100);
        //Scan the cone
        camera.init_camera(hardwareMap, "webcam", telemetry);
        zone = camera.zone();
        lift.run_lift_21945_auto(telemetry,  0);
        simpleWait(100);
        auto_motors.goToSpot(39, 0.5);
        simpleWait(1000);




        //SPLIT TO PARK
        //needs to be in middle of 2
        //LEFT (1)
        switch(zone) {
            case(1):
                auto_motors.strafeLeft(0.5, 24);
            case(3):
                auto_motors.strafeRight(0.5, 24);
        }



    }
}