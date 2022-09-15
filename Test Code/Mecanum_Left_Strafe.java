package org.firstinspires.ftc.teamcode;


import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.ServoController;


@TeleOp
@Disabled
public class Mecanum_Left_Strafe extends LinearOpMode {
    private DcMotor fl = null;
    private DcMotor bl = null;
    private DcMotor fr = null;
    private DcMotor br = null;
    //private CRServo s1 = null;
    private double left_x = 0;
    private double left_y=0;
    private double right_x = 0;

    @Override
    public void runOpMode() throws InterruptedException {
        fl = hardwareMap.get(DcMotor.class, "fl");
        fr = hardwareMap.get(DcMotor.class, "fr");
        bl = hardwareMap.get(DcMotor.class, "bl");
        br = hardwareMap.get(DcMotor.class, "br");
        //s1 = hardwareMap.get(CRServo.class, "s1");
        bl.setDirection(DcMotor.Direction.REVERSE);
        fl.setDirection(DcMotor.Direction.REVERSE);

        waitForStart();

        while (opModeIsActive() && !this.gamepad1.dpad_down){
            left_x = this.gamepad1.left_stick_x; //strafe
            left_y = -1 * this.gamepad1.left_stick_y;
            right_x = this.gamepad1.right_stick_x; //turn

            // Denominator is the largest motor power (absolute value) or 1
            // This ensures all the powers maintain the same ratio, but only when
            // at least one is out of the range [-1, 1]
            double denominator = Math.max(Math.abs(left_y) + Math.abs(left_x) + Math.abs(right_x), 1);
            double frontLeftPower = (left_y + left_x + right_x) / denominator;
            double backLeftPower = (left_y - left_x + right_x) / denominator;
            double frontRightPower = (left_y - left_x - right_x) / denominator;
            double backRightPower = (left_y + left_x - right_x) / denominator;


            fl.setPower(frontLeftPower);
            fr.setPower(frontRightPower);
            br.setPower(backRightPower);
            bl.setPower(backLeftPower);


            telemetry.addData("fl power: ",frontLeftPower);
            telemetry.addData("fr power: ",frontRightPower);
            telemetry.addData("bl power: ",backLeftPower);
            telemetry.addData("br power: ",backRightPower);

            telemetry.addData("fl encoder", fl.getCurrentPosition());
            telemetry.addData("fr encoder", fr.getCurrentPosition());
            telemetry.addData("bl encoder", bl.getCurrentPosition());
            telemetry.addData("br encoder", br.getCurrentPosition());

            telemetry.update();
        }
        telemetry.clearAll();
        telemetry.addLine("Code force stopped");
        telemetry.update();
    }

}
