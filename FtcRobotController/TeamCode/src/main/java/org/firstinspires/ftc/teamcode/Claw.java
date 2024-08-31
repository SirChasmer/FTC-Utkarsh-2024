package org.firstinspires.ftc.teamcode;

import static org.firstinspires.ftc.robotcore.external.BlocksOpModeCompanion.gamepad1;

import com.arcrobotics.ftclib.command.SubsystemBase;
import com.arcrobotics.ftclib.hardware.ServoEx;
import com.arcrobotics.ftclib.hardware.SimpleServo;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.internal.camera.delegating.DelegatingCaptureSequence;

public class Claw extends SubsystemBase {
    private ServoEx leftClaw;
    private ServoEx rightClaw;

    public Claw(HardwareMap hmap) {
        rightClaw = new SimpleServo(hmap, "rightC", 0, 180);
        leftClaw = new SimpleServo(hmap, "leftC", 0, 180);
    }

    public void open() {
        rightClaw.setPosition(180);
        leftClaw.setPosition(0);
    }
    public void close() {
        rightClaw.setPosition(0);
        leftClaw.setPosition(180);
    }




}
