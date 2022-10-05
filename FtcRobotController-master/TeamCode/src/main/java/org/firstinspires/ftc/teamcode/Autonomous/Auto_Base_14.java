package org.firstinspires.ftc.teamcode.Autonomous;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.teamcode.Call_Upon_Classes.Intake_14954;
import org.firstinspires.ftc.teamcode.Call_Upon_Classes.Lift_14954;
import org.firstinspires.ftc.teamcode.Mecanum_Methods_Autonomus;
import org.firstinspires.ftc.teamcode.Lift_14954;
import org.firstinspires.ftc.teamcode.Intake_14954;

public abstract class Auto_Base_14 extends LinearOpMode {
    protected org.firstinspires.ftc.teamcode.Mecanum_Methods_Autonomus auto_motors = new Mecanum_Methods_Autonomus();
    protected org.firstinspires.ftc.teamcode.Lift_14954 lift = new Lift_14954();
    protected org.firstinspires.ftc.teamcode.Intake_14954 intake = new Intake_14954();
}
