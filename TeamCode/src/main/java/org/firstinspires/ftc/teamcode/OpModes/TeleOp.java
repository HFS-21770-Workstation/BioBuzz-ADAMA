package org.firstinspires.ftc.teamcode.OpModes;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.teamcode.RobotSystems.Intake;
import org.firstinspires.ftc.teamcode.RobotSystems.Shooter;

@com.qualcomm.robotcore.eventloop.opmode.TeleOp(name = "TeleOp")
public class TeleOp extends OpMode {
    Intake intake;
    Shooter shooter;
    @Override
    public void init() {
        intake = new Intake(hardwareMap);
        shooter = new Shooter(hardwareMap);

    }

    @Override
    public void loop() {
//        כפתורי הintake
        if(gamepad1.aWasPressed() && intake.intakeMotor.getPower() == 0){
            intake.startIntake();
        }
        if(gamepad1.aWasPressed() && intake.intakeMotor.getPower() == 1){
            intake.stopIntake();
        }
        if(gamepad1.bWasPressed()){
            intake.reversIntake();
        }
//        כפתורי הshooter
        if(gamepad1.dpadLeftWasPressed() && shooter.shooterMotorLeft.getPower() == 0){
            shooter.startShootLeft(0.5);
        }
        if(gamepad1.dpadLeftWasPressed() && shooter.shooterMotorLeft.getPower() == 0.5){
            shooter.startShootLeft(0);
        }
        if(gamepad1.dpadRightWasPressed() && shooter.shooterMotorRight.getPower() == 0){
            shooter.startShootRight(-0.5);
        }
        if(gamepad1.dpadRightWasPressed() && shooter.shooterMotorRight.getPower() == 0.5){
            shooter.startShootRight(0);
        }
        if(gamepad1.dpadDownWasPressed()){
            shooter.stopShooter();
        }
    }
}
