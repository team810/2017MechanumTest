// RobotBuilder Version: 2.0
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.


package org.usfirst.frc810.MecanumDrive;

import org.usfirst.frc810.MecanumDrive.commands.*;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

import org.usfirst.frc810.MecanumDrive.subsystems.*;


/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
    //// CREATING BUTTONS
    // One type of button is a joystick button which is any button on a joystick.
    // You create one by telling it which joystick it's on and which button
    // number it is.
    // Joystick stick = new Joystick(port);
    // Button button = new JoystickButton(stick, buttonNumber);

    // There are a few additional built in buttons you can use. Additionally,
    // by subclassing Button you can create custom triggers and bind those to
    // commands the same as any other Button.

    //// TRIGGERING COMMANDS WITH BUTTONS
    // Once you have a button, it's trivial to bind it to a button in one of
    // three ways:

    // Start the command when the button is pressed and let it run the command
    // until it is finished as determined by it's isFinished method.
    // button.whenPressed(new ExampleCommand());

    // Run the command while the button is being held down and interrupt it once
    // the button is released.
    // button.whileHeld(new ExampleCommand());

    // Start the command when the button is released  and let it run the command
    // until it is finished as determined by it's isFinished method.
    // button.whenReleased(new ExampleCommand());


    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    public JoystickButton resetCameraButton;
    public JoystickButton mediumSpeedButton;
    public JoystickButton slowSpeedButton;
    public JoystickButton resetGyroButton;
    public JoystickButton cameraTrackButton;
    public JoystickButton lineUpButton;
    public Joystick j1;

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS

    public OI() {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS

        j1 = new Joystick(0);
        
        lineUpButton = new JoystickButton(j1, 4);
        lineUpButton.whileHeld(new LineUpSequence());
        cameraTrackButton = new JoystickButton(j1, 5);
        cameraTrackButton.whileHeld(new VisionMoveCamera());
        resetGyroButton = new JoystickButton(j1, 3);
        resetGyroButton.whenPressed(new ResetGyro());
        slowSpeedButton = new JoystickButton(j1, 1);
        slowSpeedButton.whileHeld(new Drive(.4));
        mediumSpeedButton = new JoystickButton(j1, 2);
        mediumSpeedButton.whileHeld(new Drive(.7));
        resetCameraButton = new JoystickButton(j1, 6);
        resetCameraButton.whenPressed(new SetCameraPosition(.5, .5));


        // SmartDashboard Buttons
        SmartDashboard.putData("Autonomous Command", new AutonomousCommand());
        SmartDashboard.putData("SetCameraPosition: Center", new SetCameraPosition(.5, .5));
        SmartDashboard.putData("LineUpSequence", new LineUpSequence());
        SmartDashboard.putData("WaitCommand", new WaitCommand());
        SmartDashboard.putData("RotateToAngle: angle", new RotateToAngle(0));
        SmartDashboard.putData("RecordCommand", new RecordCommand());
        SmartDashboard.putData("ReadAutonomous", new ReadAutonomous());

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
        
        SmartDashboard.putNumber("PID P", .03);
        SmartDashboard.putNumber("PID I", .001);
        SmartDashboard.putNumber("PID D", .08);
    }

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=FUNCTIONS
    public Joystick getJ1() {
        return j1;
    }


    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=FUNCTIONS
}

