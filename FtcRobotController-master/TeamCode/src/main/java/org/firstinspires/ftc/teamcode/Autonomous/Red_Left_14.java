package org.firstinspires.ftc.teamcode.Autonomous;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import org.firstinspires.ftc.teamcode.Autonomous.*;
import org.firstinspires.ftc.teamcode.Call_Upon_Classes.*;

@Autonomous
public class Red_Left_14 extends org.firstinspires.ftc.teamcode.Autonomous.Auto_Base_14 {

    public void runOpMode() {
        init_classes(true);
        waitForStart();
        while (opModeIsActive()) {
            lift.runlift_auto(telemetry);
        }
    }

}