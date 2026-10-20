package org.firstinspires.ftc.teamcode.RobotSystems;

import com.acmerobotics.dashboard.config.Config;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.teamcode.Util.PIDFController;
@Config
public class Shooter {
    public DcMotorEx shooterMotorLeft;
    public DcMotorEx shooterMotorRight;
    PIDFController pidfControllerLeft;
    PIDFController pidfControllerRight;
    private final double TICKS_PER_REVOLUTION = 28 ;
    public static double kp = 0.0024;
    public static double ki = 0;
    public static double kd = 0;
    public static double kf = 0.000206;
    public double targetVelocity = 0;
    public double targetVel = 0;


    public Shooter(HardwareMap hardwareMap){
        shooterMotorLeft = hardwareMap.get(DcMotorEx.class,"motor 1");
        shooterMotorRight = hardwareMap.get(DcMotorEx.class,"motor 2");
        shooterMotorLeft.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        shooterMotorRight.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        shooterMotorRight.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        shooterMotorLeft.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        shooterMotorLeft.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.FLOAT);
        shooterMotorRight.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.FLOAT);
        pidfControllerLeft = new PIDFController(kp, ki, kd,kf, 1,0,true);
        pidfControllerRight = new PIDFController(kp, ki, kd,kf, 1,0,true);
        shooterMotorRight.setDirection(DcMotorSimple.Direction.FORWARD);
        shooterMotorLeft.setDirection(DcMotorSimple.Direction.REVERSE);



    }
    public void startShootLeft(double power){
        shooterMotorLeft.setPower(power);
    }
    public void startShootRight(double power){
        shooterMotorRight.setPower(power);
    }

    public void stopShooter(){
        shooterMotorLeft.setPower(0);
        shooterMotorRight.setPower(0);
    }


    public double getVelocityRight(){
        double velocity = shooterMotorRight.getVelocity();
        return ((velocity * 60) / TICKS_PER_REVOLUTION);
    }
    public double getVelocityLeft(){
        double velocity = shooterMotorLeft.getVelocity();
        return ((velocity * 60) / TICKS_PER_REVOLUTION);
    }

    public void setVelocityRight(double Velocity){
        startShootRight(pidfControllerRight.updateController(Velocity, getVelocityRight()));
    }

    public void setVelocityLeft(double Velocity){
        startShootLeft(pidfControllerLeft.updateController(Velocity, getVelocityLeft()));
    }

    }


