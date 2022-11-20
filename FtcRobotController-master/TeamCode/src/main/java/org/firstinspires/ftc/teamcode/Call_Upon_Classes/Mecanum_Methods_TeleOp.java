package org.firstinspires.ftc.teamcode.Call_Upon_Classes;

import com.qualcomm.robotcore.hardware.DcMotor.ZeroPowerBehavior.*;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.Telemetry;

public class Mecanum_Methods_TeleOp {

    private boolean strafe;
    private int strafe_set=1;

    //right == 1
    //left  == -1
    private double denominator;
    private double ly;
    private double lx;
    private double rx;
    private double lt;
    private double rt;
    private boolean du1;
    private boolean dd1;
    private boolean dr1;
    private boolean dl1;
    private double gp2_x;
    private double gp2_y;
    private DcMotor fl = null;
    private DcMotor bl = null;
    private DcMotor fr = null;
    private DcMotor br = null;
    private DcMotor frontEncoder = null;
    private DcMotor leftEncoder = null;
    private DcMotor rightEncoder = null;

    /**
     *
     * @param right_strafe if you want right strafe set true, left set false
     */
    public Mecanum_Methods_TeleOp(boolean right_strafe){
        strafe=right_strafe;
        if (strafe)
            strafe_set = 1;
        else
            strafe_set = -1;

    }


    public void init_drive_motors(HardwareMap hardwareMap) {
        fl = hardwareMap.get(DcMotor.class, "fl");
        fr = hardwareMap.get(DcMotor.class, "fr");
        bl = hardwareMap.get(DcMotor.class, "bl");
        br = hardwareMap.get(DcMotor.class, "br");
        frontEncoder = hardwareMap.get(DcMotor.class, "frontEncoder");
        leftEncoder = hardwareMap.get(DcMotor.class, "leftEncoder");
        rightEncoder = hardwareMap.get(DcMotor.class, "rightEncoder");
        bl.setDirection(DcMotor.Direction.REVERSE);
        fl.setDirection(DcMotor.Direction.REVERSE);
        bl.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        fr.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        fl.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        br.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
    }


    public void run_drive_motors(Gamepad gamepad, Telemetry telemetry){
        ly=-1 * gamepad.left_stick_y;
        lx=gamepad.left_stick_x;
        rx=gamepad.right_stick_x;

        du1=gamepad.dpad_up;
        dd1=gamepad.dpad_down;
        dr1=gamepad.dpad_right;
        dl1=gamepad.dpad_left;



        if (du1) {
            gp2_y = .2;
        }
        else if (dd1) {
            gp2_y = -0.2;
        }
        else if (dr1) {
            gp2_x = 0.2;
        }
        else if (dl1) {
            gp2_x = -0.2;
        }
        else{
            gp2_x = 0;
            gp2_y = 0;
        }



        denominator = Math.max(Math.abs(ly)+Math.abs(lx)+Math.abs(rx), 1);



        fl.setPower((ly+lx+rx+gp2_y+gp2_x)/denominator);
        bl.setPower((ly+gp2_y+(lx+gp2_x)* strafe_set -rx* strafe_set )/denominator);
        fr.setPower((ly+gp2_y-gp2_x-lx-rx)/denominator);
        br.setPower((ly+gp2_y-(lx+gp2_x)* strafe_set +rx* strafe_set )/denominator);

        getTelemetry(telemetry);

    }

    public void run_drive_motors_14(Gamepad gamepad1, Telemetry telemetry){
        ly=-1 * gamepad1.left_stick_y;
        rx=gamepad1.right_stick_x;
        rt = gamepad1.right_trigger*.75;
        lt = gamepad1.left_trigger*.75;

        //added code so when drivers want to drive slow, THE ROBOT IS SLOW!!!
        //simple explanation - when the joystick is forword or backwards less than 50%, the robot moves 20% slower
        //complex explanation - when the absolute value of the joystick (forward or backward) is <= 50%, the robot is 20% slower
        if (ly != 0 && Math.abs(ly) <= 0.7 ) {
            ly = -ly;
            fl.setPower(ly * 0.7);
            bl.setPower(ly * 0.7);
            fr.setPower(ly * 0.7);
            br.setPower(ly * 0.7);


        } else if (ly != 0 && Math.abs(ly) > 0.7) {
            ly = -ly;
            fl.setPower(ly);
            bl.setPower(ly);
            fr.setPower(ly);
            br.setPower(ly);

        } else if (rx > 0){
            fl.setPower(rx);
            bl.setPower(-rx);
            fr.setPower(-rx);
            br.setPower(rx);
        } else if (rx<0) {
            fl.setPower(rx);
            bl.setPower(-rx);
            fr.setPower(-rx);
            br.setPower(rx);
        } else {
            fl.setPower(0);
            fr.setPower(0);
            br.setPower(0);
            bl.setPower(0);
        }

        if (lt > 0) {
            fl.setPower(-lt);
            fr.setPower(lt);
            bl.setPower(-lt);
            br.setPower(lt);
        } else if (rt > 0) {
            fl.setPower(rt);
            fr.setPower(-rt);
            bl.setPower(rt);
            br.setPower(-rt);
        }
        getTelemetry(telemetry);


    }
    public void run_drive_motors_15(Gamepad gamepad1, Telemetry telemetry){
        ly=gamepad1.left_stick_y;
        lx=gamepad1.left_stick_x;
        rx=gamepad1.right_stick_x;

        if (Math.abs(lx)>Math.abs(ly)) {//x power only
            fl.setPower(lx+rx);
            fr.setPower(-lx-rx);
            br.setPower(lx-rx);
            bl.setPower(-lx+rx);

        }else{//y power only
            fl.setPower(-ly+rx);
            fr.setPower(-ly-rx);
            bl.setPower(-ly+rx);
            br.setPower(-ly-rx);
        }

        getTelemetry(telemetry);
    }


    public void getTelemetry (Telemetry telemetry){
        telemetry.addData("fl power: ",fl.getPower());
        telemetry.addData("fr power: ",fr.getPower());
        telemetry.addData("bl power: ",bl.getPower());
        telemetry.addData("br power: ",br.getPower());
//        telemetry.addData("X Dead Wheel Encoder Value: ",x_encoder.getCurrentPosition());


    }

}
