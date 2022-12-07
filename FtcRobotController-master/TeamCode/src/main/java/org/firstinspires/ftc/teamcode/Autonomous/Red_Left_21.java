package org.firstinspires.ftc.teamcode.Autonomous;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

@Autonomous
public class Red_Left_21 extends  org.firstinspires.ftc.teamcode.Autonomous.Auto_Base_21 {
    public void runOpMode() throws InterruptedException {
        init_classes(true);
        waitForStart();
        //one tile is 24 in
        //START
        //Scan cone
        lift.run_lift_21945_auto(telemetry, 0.5,0);
        simpleWait(10);
        camera.init_camera(hardwareMap, "webcam", telemetry);
        zone = camera.zone();

    }
}

