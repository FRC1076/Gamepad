/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package net.pihi;
import edu.wpi.first.wpilibj.Joystick; 
import edu.wpi.first.wpilibj.DriverStation; 

/**
 *
 * @author PiHi Samurai 1076
 */
public class Gamepad extends Joystick{
    static final int LEFT_BUMPER = 5;
    static final int RIGHT_BUMPER = 6;
    static final int LEFT_TRIGGER = 7;
    static final int RIGHT_TRIGGER = 8;
    
    
    static final int F310_A = 1;
    static final int F310_B = 2;
    static final int F310_X = 3;
    static final int F310_Y = 4;
    static final int F310_LB = 5;
    static final int F310_RB = 6;
    static final int F310_L_STICK = 7;
    static final int F310_R_STICK = 8;
    
    static final int F310_LEFT_Y = 2;
    static final int F310_LEFT_X = 1;
    static final int F310_R_RIGHT_Y = 5;
    static final int F310_R_RIGHT_X = 6;
    static final int F310_TRIGGER_AXIS = 3;
    static final int F310_DPAD_X_AXIS = 6;
 
    //enum
    static final int kLeftXAxis = 0;
    static final int kLeftYAxis = 1;
    static final int kRightXAxis = 2;
    static final int kRightYAxis = 3;

    
    static final int kCenter = 0;
    static final int kUp = 1;
    static final int kUpLeft = 2;
    static final int kLeft = 3;
    static final int kDownLeft = 4;
    static final int kDown = 5;
    static final int kDownRight = 6;
    static final int kRight = 7;
    static final int kUpRight = 8;
    
    static final int kLeftXAxisNum = 1;
    static final int kLeftYAxisNum = 2;
    static final int kRightXAxisNum = 3;
    static final int kRightYAxisNum = 4;
    static final int kDPadXAxisNum = 5;
    static final int kDPadYAxisNum = 6;
    
    
    static final int kLeftAnalogStickButton = 11;
    static final int kRightAnalogStickButton = 12;
    
    int port;
    DriverStation driverStation;
    Gamepad(int port){
        super(port);
        this.port = port;
        driverStation = DriverStation.getInstance();
    }
    
    double getLeftX(){
        return getRawAxis(kLeftXAxisNum);
    }
    double getLeftY(){
        return getRawAxis(kLeftYAxisNum);
    }
    double getRightX(){
        return getRawAxis(kRightXAxisNum);
    }
    double getRightY(){
        return getRawAxis(kRightYAxisNum);
    }
    public double getRawAxis(int axis){
            return driverStation.getStickAxis(port, axis);
    }
    
    double getAxis(int axis){
        if(axis == kLeftXAxis)
            return getLeftX();
        if(axis == kLeftYAxis)
            return -getLeftY();
        if(axis == kRightXAxis)
            return getRightX();
        if(axis == kRightYAxis)
            return -getRightY();
        return 0;
        
    }
    
    boolean getNumberedButton(int button){
        return ((0x1 << (button-1)) & driverStation.getStickButtons(port)) != 0;
    }
    boolean GetLeftPush()
{
    return getNumberedButton(kLeftAnalogStickButton);
}

/**
 * Gets whether or not the right analog stick is depressed.
 *
 * @return The state of the right analog stick button.
 */
boolean GetRightPush()
{
    return getNumberedButton(kRightAnalogStickButton);
}

int GetDPad()
{
    double x = getRawAxis(kDPadXAxisNum);
    double y = getRawAxis(kDPadYAxisNum);

    if (x < -0.5 && y < -0.5)
        return kUpLeft;
    if (x < -0.5 && y > 0.5)
        return kDownLeft;
    if (x > 0.5 && y > 0.5)
        return kDownRight;
    if (x > 0.5 && y < -0.5)
        return kUpRight;
    if (y < -0.5)
        return kUp;
    if (x < -0.5)
        return kLeft;
    if (y > 0.5)
        return kDown;
    if (x > 0.5)
        return kRight;

  return kCenter;
}
    
}
