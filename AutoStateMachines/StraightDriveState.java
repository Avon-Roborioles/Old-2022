package org.firstinspires.ftc.teamcode;

public class StraightDriveState implements org.firstinspires.ftc.teamcode.State {
    private double inches;
    private double power;
    private org.firstinspires.ftc.teamcode.Mecanum_IMU_States imu;

    public StraightDriveState(double inches, double power, org.firstinspires.ftc.teamcode.Mecanum_IMU_States imu) {
        this.inches = inches;
        this.power = power;
        this.imu = imu;
    }

    @Override
    public void start() {
        imu.setGoToSpot(inches, power);
    }

    @Override
    public void doWhileNotDone() {
        imu.makeCorrectionsStraight((int) Math.round(inches));
    }

    @Override
    public boolean checkDone() {
        return imu.isBusy();
    }

    @Override
    public void stop() {
        imu.stopDriving();
    }

}