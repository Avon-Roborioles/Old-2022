package org.firstinspires.ftc.teamcode.Call_Upon_Classes;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.Telemetry;

import java.util.Objects;

@SuppressWarnings("IntegerDivisionInFloatingPointContext")
public class Mecanum_Methods_Autonomus_Power_Curve {


    private DcMotor fl = null;
    private DcMotor bl = null;
    private DcMotor fr = null;
    private DcMotor br = null;
    private DcMotor x_encoder=null;
    private DcMotor y_encoder=null;
    private Telemetry telemetry = null;
    private final int i = 0;


    public void init_encoders(HardwareMap hardwareMap){
        x_encoder = hardwareMap.get(DcMotor.class, "x");
        y_encoder = hardwareMap.get(DcMotor.class, "y");
    }
    /*
    for deadwheels
    D=35mm
    C=110mm/2.80in
    1 rotation = 8192 ticks
    thus 8192 ticks is 2.8 in
    2925 ticks is approx 1 inch
     */
    /*
    make one here for normal wheels
     */

    private void init_individual_motor(DcMotor motor, boolean isLeft){
        if (isLeft) motor.setDirection(DcMotorSimple.Direction.REVERSE);
        motor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        motor.setTargetPosition(0);
        motor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        motor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
    }

    public void init_auto_drive_motors(HardwareMap hardwareMap, Telemetry telemetry) {
        this.telemetry = telemetry;
        fl = hardwareMap.get(DcMotor.class, "fl");
        init_individual_motor(fl, true);

        fr = hardwareMap.get(DcMotor.class, "fr");
        init_individual_motor(fr, false);

        bl = hardwareMap.get(DcMotor.class, "bl");
        init_individual_motor(bl, true);

        br = hardwareMap.get(DcMotor.class, "br");
        init_individual_motor(br, false);
    }

    public void setRelativeTargetAllsetPowerAll(int target, double power) {
        fl.setTargetPosition(fl.getCurrentPosition() + target);
        bl.setTargetPosition(bl.getCurrentPosition() + target);
        fr.setTargetPosition(fr.getCurrentPosition() + target);
        br.setTargetPosition(br.getCurrentPosition() + target);
        double flpower = ((-4 * (Math.pow(fl.getCurrentPosition()/ fl.getTargetPosition(), 2))) + (4 * fl.getCurrentPosition()/ fl.getTargetPosition())) * power;
        double blpower = ((-4 * (Math.pow(bl.getCurrentPosition()/ bl.getTargetPosition(), 2))) + (4 * bl.getCurrentPosition()/ bl.getTargetPosition())) * power;
        double frpower = ((-4 * (Math.pow(fr.getCurrentPosition()/ fr.getTargetPosition(), 2))) + (4 * fr.getCurrentPosition()/ fr.getTargetPosition())) * power;
        double brpower = ((-4 * (Math.pow(br.getCurrentPosition()/ br.getTargetPosition(), 2))) + (4 * br.getCurrentPosition()/ br.getTargetPosition())) * power;
        fl.setPower(flpower);
        bl.setPower(blpower);
        fr.setPower(frpower);
        br.setPower(brpower);
    }
    public void setPowerAll(double power) {
        fl.setPower(power);
        bl.setPower(power);
        fr.setPower(power);
        br.setPower(power);
    }

    public void setRelativeTargetIndividualsetPowerIndividual(int fl_target, int bl_target, int fr_target, int br_target,double FL, double FR, double BR, double BL) {
        fl.setTargetPosition(fl_target + fl.getCurrentPosition());
        bl.setTargetPosition(bl_target + bl.getCurrentPosition());
        fr.setTargetPosition(fr_target + fr.getCurrentPosition());
        br.setTargetPosition(br_target + br.getCurrentPosition());
        double flpower = ((-4 * (Math.pow(fl.getCurrentPosition()/ fl.getTargetPosition(), 2))) + (4 * fl.getCurrentPosition()/ fl.getTargetPosition())) * FL;
        double blpower = ((-4 * (Math.pow(bl.getCurrentPosition()/ bl.getTargetPosition(), 2))) + (4 * bl.getCurrentPosition()/ bl.getTargetPosition())) * BL;
        double frpower = ((-4 * (Math.pow(fr.getCurrentPosition()/ fr.getTargetPosition(), 2))) + (4 * fr.getCurrentPosition()/ fr.getTargetPosition())) * FR;
        double brpower = ((-4 * (Math.pow(br.getCurrentPosition()/ br.getTargetPosition(), 2))) + (4 * br.getCurrentPosition()/ br.getTargetPosition())) * BR;
        fl.setPower(flpower);
        br.setPower(brpower);
        bl.setPower(blpower);
        fr.setPower(frpower);
    }




    public void read_encoders(){
    y_encoder.getCurrentPosition();
    x_encoder.getCurrentPosition();
    }


    public void goToSpot(int inches, double power){
        inches*=45;
        setRelativeTargetAllsetPowerAll(inches, power);
//        while (isBusy()){}

    }

    public void stopMotors() {setPowerAll(0);}

    public void turn90left (double power){
        setRelativeTargetIndividualsetPowerIndividual((int) Math.floor(-1440*1.2*.5),(int) Math.floor(-1440*1.2*.5),(int) Math.floor(1440*1.2*.5), (int) Math.floor(1440*1.2*.5), -power,power,power,-power);
        while (isBusy()){}
    }
    public void turn90right (double power){
        setRelativeTargetIndividualsetPowerIndividual((int) Math.floor(1440*1.2*.5),(int) Math.floor(1440*1.2*.5),(int) Math.floor(-1440*1.2*.5), (int) Math.floor(-1440*1.2*.5), power,-power,-power,power);
        while (isBusy()){}
    }
    public void turn45left (double power){
        setRelativeTargetIndividualsetPowerIndividual((int) Math.floor(-1440*1.2*.25),(int) Math.floor(-1440*1.2*.25),(int) Math.floor(1440*1.2*.25), (int) Math.floor(1440*1.2*.25),-power,power,power,-power);
        while (isBusy()){}
    }
    public void turn45right (double power){
        setRelativeTargetIndividualsetPowerIndividual((int) Math.floor(1440*1.2*.25),(int) Math.floor(1440*1.2*.25),(int) Math.floor(-1440*1.2*.25), (int) Math.floor(-1440*1.2*.25), power,-power,-power,power);
        while (isBusy()){}
    }
    public void turnByDegree (double power, double degrees){
        setRelativeTargetIndividualsetPowerIndividual((int) Math.floor(1440*1.2*(.25/45)*degrees),(int) Math.floor(1440*1.2*(2.5/45)*degrees),(int) Math.floor(-1440*1.2*(2.5/45)*degrees), (int) Math.floor(-1440*1.2*(2.5/45)*degrees),power,-power,-power,power);
        while (isBusy()){}
    }

    public void strafeLeft(double power, double inches) {
        //107 ticks= 1 inch
        inches*=53.5;
        setRelativeTargetIndividualsetPowerIndividual((int)-inches,(int) inches,(int)inches,(int)-inches, -power, power, -power, power);
        while (isBusy()){}
    }
    public void strafeRight(double power, double inches) {
        inches*=53.5;
        setRelativeTargetIndividualsetPowerIndividual((int)inches,(int)-inches,(int)-inches,(int)inches, power, -power, power, -power);
        while (isBusy()){}
    }

    // probably should re-write this one
    public boolean isBusy (){
//        getTelemetry(telemetry);
        int totalBusy=0;
        if (fl.isBusy())
            totalBusy++;
        if (bl.isBusy())
            totalBusy++;
        if (br.isBusy())
            totalBusy++;
        if (fr.isBusy())
            totalBusy++;

        return totalBusy >= 4;
    }

    public void park_14(int zone, boolean red_alliance){
        if (zone == 2) {

        } else if (zone == 3) {

        } else {

        }
    }


    public void getTelemetry (Telemetry telemetry){
        telemetry.addData("fl encoder value: ",fl.getCurrentPosition());
        telemetry.addData("fr encoder value: ",fr.getCurrentPosition());
        telemetry.addData("bl encoder value: ",bl.getCurrentPosition());
        telemetry.addData("br encoder value: ",br.getCurrentPosition());
    }

    //move method takes axis the bot is meant to move on and the amount of tiles it is meant to move (and simplify calling)
    public void move(String axis, double tiles) {
        //determine what axis wants to be moved on
        if (Objects.equals(axis, "x")) {
            //determines which direction the robot need to travel (since negative traveled time doesn't mean negative direction)
            if (tiles > 0) {
                //add motion that takes timePoweredOutput as the time the motors have to be powered for to move forward the desired amount of tiles
                strafeRight(0.5, 24*tiles);
            }
            else if (tiles < 0) {
                //add motion that takes timePoweredOutput as the time the motors have to be powered for to move backward the desired amount of tiles
                strafeLeft(0.5, 24* Math.abs(tiles));
            }
        }
        else if (Objects.equals(axis, "y")) {
            //determines which direction the robot need to travel (since negative traveled time doesn't mean negative direction)
            if (tiles > 0) {
                //add motion that takes timePoweredOutput as the time the motors have to be powered for to move right the desired amount of tiles
                for (int i=0; tiles > i; i++) {
                    goToSpot(24, 0.5);
                }
            }
            else if (tiles < 0) {
                //add motion that takes timePoweredOutput as the time the motors have to be powered for to move left the desired amount of tiles
                for (int i=0; tiles < i; i--) {
                    goToSpot((int) (-24* Math.abs(tiles)), -0.5);
                }
//                for (int i; tiles > i; i++) {
//                    goToSpot(24, 0.5);
//                }
            }
        }
    }

    //takes integer that multiplies 90 degree turns
    public void turn(int turnAmount) {
        if (turnAmount > 0) {
            for (int i=0; turnAmount > i; i++) {
                turn90right(0.5);
            }
        }
        else if (turnAmount < 0) {
            for (int i=0; turnAmount < i; i--) {
                turn90left(0.5);
            }
        }
    }
//    public void turn(int turnAmount) {
//        if (turnAmount > 0) {
//            for (int i; turnAmount > i; i++) {
//                turn90right(0.5);
//            }
//        }
//        else if (turnAmount < 0) {
//            for (int i; turnAmount < i; i--) {
//                turn90left(0.5);
//            }
//        }
}
