package org.firstinspires.ftc.teamcode.Autonomous;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

@Autonomous
public class Red_Right_21 extends  org.firstinspires.ftc.teamcode.Autonomous.Auto_Base_21 {

    public void runOpMode() throws InterruptedException {
        auto_motors.init_auto_drive_motors(hardwareMap, telemetry);
        lift.init_lift_motor_21945(hardwareMap, "lift");
        intake.init_intake_motor_21945(hardwareMap, "intake");
        imu_drive.init_drive_motors(hardwareMap, telemetry, false);
        turntable.init_turntable_21945(hardwareMap, "turntable");
        waitForStart();

    }

}
