package processing.sketches;

import processing.core.PApplet;

public class Main extends PApplet {

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
    }

    public void draw() {
        // Recreates the background to be black each 'draw'
        background(93, 0, 0);

        // Increment hue shift
        hueShift = (hueShift + 0.5f) % 360;

        // Create a branch to allow you to work on the new feature of ellipses
        drawGreenCircle();

        //Add the rotating square inside the existing circle
        drawRotatingSquare();

        // Draw the navy blue circle inside the rotating square
        drawBlueStripe();

        // Draw the reverse rotating blue square inside the white stripe
        drawReverseRotatingBlueSquare();

        // Draw the red circle inside the blue square
        drawRedCircle();

        //Draw rotating red square inside the red circle
        drawRotatingRedSquare();

        // Draw the fourth blue circle inside the rotating red square
        drawFourthBlueCircle();

        // Draw the final blue square rotating on the circumference of the fourth blue square
        drawRotatingBlueSquare();

    }

    /**
     * Draw a rotating square that touches the sides of the existing ellipse
     * which itself touches the sides of the inner square.
     */
    public void drawRotatingSquare() {
        //Calculate the rotating angle
        angle += radians(1);

        //Push and pop matrix to isolate transformation
        pushMatrix();

        //Translate to the center of the circle
        translate(width / 2, height / 2);

        //Rotate by the current angle
        rotate(angle);

        //Draw the square
        stroke((60 + hueShift) % 360, 100, 100);
        fill((60 + hueShift) % 360, 80, 80);
        rect(0, 0, squareSize, squareSize);

        popMatrix();
    }

    /**
     * Draw the navy blue circle inside the rotating square.
     */
    public void drawBlueStripe() {
        //Push and pop matrix to isolate transformations
        pushMatrix();

        //Translate to the center of the circle
        translate(width / 2, height / 2);

        // Draw the navy blue circle
        noFill();
        stroke((197 + hueShift) % 360, 100, 100);
        ellipse(0, 0, circleSize, circleSize);

        popMatrix();
    }

    /**
     * Draw a few ellipses, each with different colors at different parts of the screen.
     */
    public void drawGreenCircle() {
        //Choose a color with fill
        fill((120 + hueShift) % 360, 100, 80);
        noStroke();

        //Draw an ellipse
        ellipse(width / 2, height / 2, width-50, height-50);

    }

    /**
     * Draw a blue square that rotates in the opposite direction (anticlockwise)
     * inside the white stripe, touching its sides.
     */
    public void drawReverseRotatingBlueSquare() {
        // Calculate the reverse rotation angle
        reverseAngle -= radians(2);

        //Push and pop matrix to isolate transformations
        pushMatrix();

        //Translate to the center of the circle
        translate(width / 2, height / 2);

        //Rotate by the reverse angle
        rotate(reverseAngle);

        //Draw the blue square
        stroke((240 + hueShift) % 360, 100, 100);
        noFill();
        rect(0, 0, innerSquareSize, innerSquareSize);

        popMatrix();
    }

    /**
     * Draw the red circle inside the blue square.
     */
    public void drawRedCircle() {
        // Push and pop matrix to isolate transformation
        pushMatrix();

        //Translate to the center of the circle
        translate(width / 2, height / 2);

        // Draw the red circle
        noFill();
        stroke((0 + hueShift) % 360, 100, 100);
        ellipse(0, 0, newCircleSize * sqrt(2), newCircleSize * sqrt(2));

        popMatrix();
    }

    /**
     * Draw the rotating red square inside the red circle.
     */
    public void drawRotatingRedSquare() {
        // Calculate the third reverse rotation angle
        thirdReverseAngle += radians(4);

        // Push and pop matrix to isolate transformation
        pushMatrix();

        // Translate to the center of the circle
        translate(width / 2, height / 2);

        // Rotate by the third reverse angle
        rotate(thirdReverseAngle);

        // Draw the red square
        stroke((0 + hueShift) % 360, 100, 100);
        noFill();
        rect(0, 0, newSquareSize * sqrt(2), newSquareSize * sqrt(2));

        popMatrix();
    }

    /**
     * Draw the fourth blue circle inside the rotating red square.
     */
    public void drawFourthBlueCircle() {
        // Push and pop matrix to isolate transformations
        pushMatrix();

        //Translate to the center of the circle
        translate(width / 2, height / 2);

        // Draw the fourth blue circle
        noFill();
        stroke((240 + hueShift) % 360, 100, 100);
        ellipse(0, 0, newSquareSize * sqrt(2), newSquareSize * sqrt(2));

        popMatrix();
    }

    /**
     * Draw the new rotating blue square inside the new blue circle.
     */
    public void drawRotatingBlueSquare() {
        // Calculate the fourth reverse angle
        fourthReverseAngle -= radians(8);

        //Push and pop matrix to isolate transformations
        pushMatrix();

        // Translate to the center of the circle
        translate(width / 2, height / 2);

        //Rotate by the new reverse angle
        rotate(fourthReverseAngle);

        //Draw the new blue square
        stroke((240 + hueShift) % 360, 100, 100);
        noFill();
        rect(0, 0, newSquareSize, newSquareSize);

        popMatrix();
    }

    public static void main(String[] args) {
        PApplet.main("processing.sketches.Main");
    }
}


































