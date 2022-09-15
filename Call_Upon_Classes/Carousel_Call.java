package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.Telemetry;

public class Carousel_Call{
    private DcMotor carousel = null;
    private double carouselStartSpeed = 0.37; //base speed
    private double carouselIncrSpeed = carouselStartSpeed+.05; //speed as carousel is running and increasing
    private double carouselDcrSpeed = -1 * carouselStartSpeed;
    private double displayFinalSpeed = 0; //for display
    
    private double incrAmt = 0.0008; //as carousel runs, increases by this value (.08%)

    //used for backpedaling at the end
    private boolean carouselMovingForwards = false;
    private boolean carouselMovingBackwards = false;

    public void init_carousel(HardwareMap map, String name, boolean invert) { carousel  = map.get(DcMotor.class, name); if (invert) {carousel.setDirection(DcMotorSimple.Direction.REVERSE);} }

    public void run_carousel_loop(Gamepad gamepad1, Telemetry telemetry) {
        //back-pedals a tiny bit once motor stops running
        //updates the final speed it reached from increments to display
        if(carouselMovingForwards && !gamepad1.y) {
            displayFinalSpeed = carouselIncrSpeed;
            carouselIncrSpeed = carouselStartSpeed;
            carousel.setPower(-0.3);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
            }
            carouselMovingForwards = false;
        }
        if (carouselMovingBackwards && !gamepad1.x) {
            displayFinalSpeed = carouselDcrSpeed;
            carouselDcrSpeed = -1 * carouselStartSpeed;
            carousel.setPower(0.3);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
            }
            carouselMovingBackwards = false;
        }



        //controls whether motor is running or not
        //increases pace while pressed
        if(gamepad1.x && gamepad1.b) {
            carousel.setPower(0); //why have you done this
        } else if (gamepad1.y) {
            carousel.setPower(carouselIncrSpeed);
            if(carouselIncrSpeed < .6) {
                carouselIncrSpeed += incrAmt;
            }
            carouselMovingForwards = true;
            carouselMovingBackwards = false;
        } else if (gamepad1.x) {
            carousel.setPower(carouselDcrSpeed);
            if (carouselDcrSpeed > -.6) {
                carouselDcrSpeed -= incrAmt;
            }
            carouselMovingBackwards = true;
            carouselMovingForwards = false;
        } else {
            carousel.setPower(0);
        }

        get_telemetry(telemetry);
    }

    public void run_carousel_auto (Telemetry telemetry, boolean red) {
        double speed=.3;
        if (red) {
          speed*=-1;
        }
        for (int i=0; i<1000; i++) {
            carousel.setPower(speed);

            get_telemetry(telemetry);

        }
        displayFinalSpeed = carouselIncrSpeed;
        get_telemetry(telemetry);
        carousel.setPower(0);


    }

    public void run_carousel_auto_14 (Telemetry telemetry, boolean red) {
        double speed=.3;
        if (red) {
            speed*=-1;
        }
        for (int i=0; i<2500; i++) {
            carousel.setPower(speed);

            get_telemetry(telemetry);

        }
        displayFinalSpeed = carouselIncrSpeed;
        get_telemetry(telemetry);
        carousel.setPower(0);


    }

    public void carousel_auto_SM(Telemetry telemetry) {
        double speed=.3;
        carousel.setPower(speed);
        get_telemetry(telemetry);
    }

    public void carousel_auto_SM_stop() {
        carousel.setPower(0);
    }

    public void get_telemetry (Telemetry telemetry) {
        telemetry.addData("End Ramp Speed", displayFinalSpeed);
        telemetry.addData("Incr Amt", incrAmt);
        telemetry.addData("Carousel Speed", "Speed = " + carouselStartSpeed);
        telemetry.addData("Carou Encoder", "Current Pos = " + carousel.getCurrentPosition());

    }
}
