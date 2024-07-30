package processing.sketches;

import processing.core.PApplet;

//import controlP5.*;  To add a few sliders/buttons for increasing rotation speeds and hue incrementing cycles


public class Main extends PApplet {

    //ControlP5 cp5;
    float angle = 0;
    float reverseAngle = 0;
    float thirdReverseAngle = 0;
    float fourthReverseAngle = 0;
    float squareSize;
    float circleSize;
    float innerSquareSize;
    float newCircleSize;
    float newSquareSize;
    float thirdCircleSize;
    float thirdSquareSize;
    float fourthCircleSize;
    float fourthSquareSize;
    float hueShift = 0;
    float saturationShift = 100;
    float brightnessShift = 100;
    boolean darkening = true;
    float baseHue = 0;
    //float colorIncrement = 0.2f;
    //float rotationSpeedMultiplier1 = 1;
    //float rotationSpeedMultiplier2 = 1;
    //float rotationSpeedMultiplier3 = 1;
    //float rotationSpeedMultiplier4 = 1;


    public void settings() {
        size(600, 600);
    }

    public void setup() {
        // Sets the color mode to HSB, 360 being the max Hue,
        // 100 the max Saturation, and 100 the max Brightness
        colorMode(HSB, 360, 100, 100);
        squareSize = (width - 50) * sqrt(2) / 2;
        circleSize = squareSize;
        innerSquareSize = circleSize * sqrt(2) / 2;
        newCircleSize = innerSquareSize * sqrt(2) / 2 ;
        newSquareSize = newCircleSize * sqrt(2) / 2;
        thirdCircleSize = newCircleSize * sqrt(2) / 2;
        thirdSquareSize = thirdCircleSize * sqrt(2) / 2;
        fourthCircleSize = thirdSquareSize * sqrt(2) / 2;
        fourthSquareSize = fourthCircleSize * sqrt(2) / 2;
        rectMode(CENTER);

        //cp5 = new ControlP5(this);
    }

    public void draw() {
        // Recreates the background to be black each 'draw'
        background(93, 0, 0);

        // Increment hue shift
        //hueShift = (hueShift + 100.5f) % 360;

        // Handle color transition
        if (darkening) {
            saturationShift -= 0.2f;
            brightnessShift -= 0.2f;
            if (brightnessShift <= 20) {
                darkening = false;
            }
        } else {
            saturationShift += 0.2f;
            brightnessShift += 0.2f;
            if (brightnessShift >= 100) {
                darkening = true;
                baseHue = (baseHue + 20) % 360;
            }
        }

        drawFirstCircle();

        drawFirstRotatingSquare();

        drawSecondCircle();

        drawSecondRotatingSquare();

        drawThirdCircle();

        drawThirdRotatingSquare();

        drawFourthCircle();

        drawFourthRotatingSquare();
    }

    /**
     * Method to get color based on current shifts.
     */
    public int getColor(float hue, float saturation, float brightness) {
        return color((baseHue + hue) % 360, constrain(saturation, 0, 100), constrain(brightness, 0, 100));
    }

    public void drawFirstCircle() {
        //Choose a color with fill
        fill(getColor(0, saturationShift, brightnessShift));
        noStroke();

        //Draw an ellipse
        ellipse(width / 2, height / 2, width-50, height-50);

    }

    /**
     * Draw a rotating square that touches the sides of the existing ellipse
     * which itself touches the sides of the inner square.
     */
    public void drawFirstRotatingSquare() {
        //Calculate the rotating angle
        angle += radians(1);

        //Push and pop matrix to isolate
        pushMatrix();

        //Translate to the center of the circle
        translate(width / 2, height / 2);

        //Rotate by the current angle
        rotate(angle);

        //Draw the square
        stroke(getColor(10, saturationShift, brightnessShift));
        fill(getColor(10, saturationShift, brightnessShift));
        rect(0, 0, squareSize, squareSize);

        popMatrix();
    }

    public void drawSecondCircle() {
        //Push and pop matrix to isolate transformations
        pushMatrix();

        //Translate to the center of the circle
        translate(width / 2, height / 2);

        // Draw the navy blue circle
        //noFill();
        fill(getColor(20, saturationShift, brightnessShift));
        stroke(getColor(20, saturationShift, brightnessShift));
        ellipse(0, 0, circleSize, circleSize);

        popMatrix();
    }

    public void drawSecondRotatingSquare() {
        // Calculate the reverse rotation angle
        reverseAngle -= radians(2);

        //Push and pop matrix to isolate transformations
        pushMatrix();

        //Translate to the center of the circle
        translate(width / 2, height / 2);

        //Rotate by the reverse angle
        rotate(reverseAngle);

        //Draw the blue square
        stroke(getColor(30, saturationShift, brightnessShift));
        fill(getColor(30, saturationShift, brightnessShift));
        rect(0, 0, innerSquareSize, innerSquareSize);

        popMatrix();
    }

    public void drawThirdCircle() {
        // Push and pop matrix to isolate transformation
        pushMatrix();

        //Translate to the center of the circle
        translate(width / 2, height / 2);

        // Draw the red circle
        //noFill();
        stroke(getColor(40, saturationShift, brightnessShift));
        fill(getColor(40, saturationShift, brightnessShift));
        ellipse(0, 0, newCircleSize * sqrt(2), newCircleSize * sqrt(2));

        popMatrix();
    }

    public void drawThirdRotatingSquare() {
        // Calculate the third reverse rotation angle
        thirdReverseAngle += radians(4);

        // Push and pop matrix to isolate transformation
        pushMatrix();

        // Translate to the center of the circle
        translate(width / 2, height / 2);

        // Rotate by the third reverse angle
        rotate(thirdReverseAngle);

        // Draw the red square
        stroke(getColor(50, brightnessShift, saturationShift));
        fill(getColor(50, brightnessShift, brightnessShift));
        rect(0, 0, newSquareSize * sqrt(2), newSquareSize * sqrt(2));

        popMatrix();
    }

    public void drawFourthCircle() {
        // Push and pop matrix to isolate transformations
        pushMatrix();

        //Translate to the center of the circle
        translate(width / 2, height / 2);

        // Draw the fourth blue circle
        //noFill();
        stroke(getColor(60, saturationShift, brightnessShift));
        fill(getColor(60, saturationShift, brightnessShift));
        ellipse(0, 0, newSquareSize * sqrt(2), newSquareSize * sqrt(2));

        popMatrix();
    }

    public void drawFourthRotatingSquare() {
        // Calculate the fourth reverse angle
        fourthReverseAngle -= radians(8);

        //Push and pop matrix to isolate transformations
        pushMatrix();

        // Translate to the center of the circle
        translate(width / 2, height / 2);

        //Rotate by the new reverse angle
        rotate(fourthReverseAngle);

        //Draw the new blue square
        stroke(getColor(70, saturationShift, brightnessShift));
        fill(getColor(70, saturationShift, brightnessShift));
        rect(0, 0, newSquareSize, newSquareSize);

        popMatrix();
    }

    public static void main(String[] args) {
        PApplet.main("processing.sketches.Main");
    }
}


































