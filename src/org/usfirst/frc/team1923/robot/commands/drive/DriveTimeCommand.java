package org.usfirst.frc.team1923.robot.commands.drive;

import org.usfirst.frc.team1923.robot.Robot;

import com.ctre.CANTalon.TalonControlMode;

import edu.wpi.first.wpilibj.command.Command;

public class DriveTimeCommand extends Command {

    private double power;

    public DriveTimeCommand(double power, double timeOut) {
        requires(Robot.driveSubSys);
        setTimeout(timeOut);
        this.power = power;
    }

    @Override
    protected void initialize() {

    }

    @Override
    protected void execute() {
        Robot.driveSubSys.drive(this.power, this.power, TalonControlMode.PercentVbus);
    }

    @Override
    protected boolean isFinished() {
        return isTimedOut();
    }

    @Override
    protected void end() {
        Robot.driveSubSys.stop();
    }

    @Override
    protected void interrupted() {
        end();
    }

}
