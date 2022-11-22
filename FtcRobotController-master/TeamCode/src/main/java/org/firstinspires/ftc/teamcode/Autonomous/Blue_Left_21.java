package org.firstinspires.ftc.teamcode.Autonomous;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.hardware.DcMotor;

@Autonomous
public class Blue_Left_21 extends  org.firstinspires.ftc.teamcode.Autonomous.Auto_Base_21 {

    public void runOpMode() throws InterruptedException {
        lift.init_lift_motor_21945(hardwareMap, "lift");
        waitForStart();
        lift.run_lift_21945_auto(telemetry,10000, 0);
        //one tile is 24

    }

}
