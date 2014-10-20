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
public class XGamepad extends Joystick{
    static final int LEFT_BUMPER = 5;
    static final int RIGHT_BUMPER = 6;
    static final int LEFT_TRIGGER = 7;
    static final int RIGHT_TRIGGER = 8;
    
    
    static final int X_A = 1;
    static final int X_B = 2;
    static final int X_X = 3;
    static final int X_Y = 4;
    static final int X_LB = 5;
    static final int X_RB = 6;
    static final int X_BACK = 7;
    static final int X_START = 8;
    
    static final int X_LEFT_Y = 2;
    static final int X_LEFT_X = 1;
    static final int X_RIGHT_Y = 5;
    static final int X_RIGHT_X = 4;
    static final int X_TRIGGER_AXIS = 3;
    static final int X_DPAD_X_AXIS = 6;

    
    static final int kCenter = 0;
    static final int kUp = 1;
    static final int kUpLeft = 2;
    static final int kLeft = 3;
    static final int kDownLeft = 4;
    static final int kDown = 5;
    static final int kDownRight = 6;
    static final int kRight = 7;
    static final int kUpRight = 8;
    
    
    static final int X_LEFT_STICK_BUTTON = 9;
    static final int X_RIGHT_STICK_BUTTON = 10;
    
    int port;
    DriverStation driverStation;
    XGamepad(int port){
        super(port);
        this.port = port;
        driverStation = DriverStation.getInstance();
    }
    
    double getLeftX(){
        return getRawAxis(X_LEFT_X);
    }
    double getLeftY(){
        return getRawAxis(X_LEFT_Y);
    }
    double getRightX(){
        return getRawAxis(X_RIGHT_X);
    }
    double getRightY(){
        return getRawAxis(X_RIGHT_Y);
    }
    public double getRawAxis(int axis){
            return driverStation.getStickAxis(port, axis);
    }
    
    boolean getNumberedButton(int button){
        return ((0x1 << (button-1)) & driverStation.getStickButtons(port)) != 0;
    }
    
    boolean getLeftPush()
{
    return getNumberedButton(X_LEFT_STICK_BUTTON);
}
    
boolean getRightPush()
{
    return getNumberedButton(X_RIGHT_STICK_BUTTON);
}

double getDPad()
{
    /*double x = getRawAxis(kDPadXAxisNum);
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

  return kCenter;*/
    return getRawAxis(X_DPAD_X_AXIS);
}
    
}
