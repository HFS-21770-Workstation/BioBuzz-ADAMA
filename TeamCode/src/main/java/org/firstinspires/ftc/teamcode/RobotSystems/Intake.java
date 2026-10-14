package org.firstinspires.ftc.teamcode.RobotSystems;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class Intake {
    public DcMotor intakeMotor;

    public Intake(HardwareMap hardwareMap){
    intakeMotor = hardwareMap.dcMotor.get("IntakeMotor");
    }
    public void startIntake(){
      intakeMotor.setPower(0.4);
    }

    public void stopIntake(){
        intakeMotor.setPower(0);
    }
    public void reversIntake(){
        intakeMotor.setPower(-1);
    }

}
