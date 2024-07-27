package processing.sketches;

import processing.core.PApplet;

public class Main extends PApplet {

    float angle = 0;
    float reverseAngle = 0;
    float squareSize;
    float circleSize;
    float innerSquareSize;

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
        rectMode(CENTER);
    }

    public void draw() {
        // Recreates the background to be black each 'draw'
        background(93, 0, 0);

        //Look at the code in this method for some sample uses of rect and ellipse
        drawRectangles();

        // Create a branch to allow you to work on the new feature of ellipses
        drawGreenCircle();

        //Add the rotating square inside the existing circle
        drawRotatingSquare();

        // Draw the navy blue circle inside the rotating square
        drawWhiteStripe();

        // Draw the reverse rotating blue square inside the white stripe
        drawReverseRotatingBlueSquare();
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
        stroke(78.0f, 80.0f, 80.0f);
        fill(70.0f, 80.0f, 80.0F);
        rect(0, 0, squareSize, squareSize);

        popMatrix();
    }

    /**
     * Draw the navy blue circle inside the rotating square.
     */
    public void drawWhiteStripe() {
        //Push and pop matrix to isolate transformations
        pushMatrix();

        //Translate to the center of the circle
        translate(width / 2, height / 2);

        // Draw the navy blue circle
        noFill();
        stroke(48, 12, 100);
        ellipse(0, 0, circleSize, circleSize);

        popMatrix();
    }

    /**
     * Draw a few ellipses, each with different colors at different parts of the screen.
     */
    public void drawGreenCircle() {
        //Choose a color with fill
        fill(100.0f, 150.0f, 80.0f);

        //Draw an ellipse
        ellipse(width / 2, height / 2, width-50, height-50);

    }

    public void drawRectangles() {
        //Draw a red square at (0, 0) with 25% width and height
        fill(0, 100, 100); //Red color in HSB
        noStroke();
        rect(0, 0, width + 0.25f, height + 0.25f);
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
        stroke(197, 92, 46);
        noFill();
        rect(0, 0, innerSquareSize, innerSquareSize);

        popMatrix();
    }

    public static void main(String[] args) {
        PApplet.main("processing.sketches.Main");
    }
}
