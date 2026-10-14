package org.firstinspires.ftc.teamcode.OpModes;

import com.acmerobotics.dashboard.config.Config;
import com.qualcomm.hardware.limelightvision.Limelight3A;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.acmerobotics.dashboard.FtcDashboard;
import com.acmerobotics.dashboard.telemetry.MultipleTelemetry;

import org.firstinspires.ftc.teamcode.RobotSystems.Shooter;


@Config
@TeleOp(name = "pidf")
public class pidf extends OpMode {
    Shooter shooter;
//    Limelight3A limelight3A;
    public static double rpm = 0;
    @Override
    public void init() {
        shooter = new Shooter(hardwareMap);
        telemetry = new MultipleTelemetry(
                telemetry,
                FtcDashboard.getInstance().getTelemetry()
        );

//        limelight3A = hardwareMap.get(Limelight3A.class, "limelight");
    }

    @Override
    public void loop() {
        shooter.setVelocityLeft(rpm);
        shooter.setVelocityRight(rpm);

        telemetry.addData("rpm", rpm);
        telemetry.addData("l",shooter.getVelocityLeft());
        telemetry.addData("r",shooter.getVelocityRight());
        telemetry.update();




    }
}
