package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.DcMotor;

@TeleOp
@Disabled
public class Tshirt extends LinearOpMode {
    private CRServo fl = null;
    private CRServo fr = null;
    private CRServo bl = null;
    private CRServo br = null;
    private CRServo t = null;
    private DcMotor CL = null;
    private DcMotor CM = null;
    private DcMotor CR = null;
    private double rp = 0;
    private double lp = 0;
    private double sp = .4;
    private boolean x = false;
    private boolean a = false;
    private boolean b = false;
    private boolean lt = false;
    private boolean rt = false;
    private boolean up = false;
    private boolean down = false;
    @Override
    public void runOpMode() throws InterruptedException {
        fl = hardwareMap.get(CRServo.class,"fl");
        bl = hardwareMap.get(CRServo.class,"bl");
        fr = hardwareMap.get(CRServo.class,"fr");
        br = hardwareMap.get(CRServo.class,"br");
        t = hardwareMap.get(CRServo.class,"tm");
        CL = hardwareMap.get(DcMotor.class,"solLeft");
        CM = hardwareMap.get(DcMotor.class,"solCenter");
        CR = hardwareMap.get(DcMotor.class,"solRight");
        waitForStart();
        while(opModeIsActive()) {
            a = this.gamepad1.a;
            x = this.gamepad1.x;
            b = this.gamepad1.b;
            up = this.gamepad1.dpad_up;
            down = this.gamepad1.dpad_down;
            lt = this.gamepad1.left_bumper;
            rt = this.gamepad1.right_bumper;
            lp = -(this.gamepad1.left_stick_y);
            rp = this.gamepad1.right_stick_y;
            if(x) {
                CL.setPower(1);
            }
            else {
                CL.setPower(0);
            }
            if(a) {
                CM.setPower(1);
            }
            else {
                CM.setPower(0);
            }
            if(b) {
                CR.setPower(1);
            }
            else {
                CR.setPower(0);
            }
            if(lt) {
                t.setPower(-1);
            }
            else if(rt) {
                t.setPower(1);
            }
            else{
                t.setPower(0);
            }
            if(up) {
                sp += .1;
                Thread.sleep(500);
            }
            if(down) {
                sp -= .1;
                Thread.sleep(500);
            }
            telemetry.addData("Speed",sp);
            telemetry.update();
            rp = rp*sp;
            lp = lp*sp;
            fr.setPower(rp);
            br.setPower(rp);
            fl.setPower(lp);
            bl.setPower(lp);
        }
    }

}
