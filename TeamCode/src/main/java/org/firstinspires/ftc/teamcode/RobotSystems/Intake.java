package org.firstinspires.ftc.teamcode.RobotSystems;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class Intake {
    DcMotor intakeMotor;

    public Intake(HardwareMap hardwareMap){
     intakeMotor = hardwareMap.dcMotor.get("IntakeMotor");
    }
    void startIntake(){
      intakeMotor.setPower(1);
    }

    void stopIntake(){
        intakeMotor.setPower(0);
    }
    void reversIntake(){
        intakeMotor.setPower(-1);
    }

}
