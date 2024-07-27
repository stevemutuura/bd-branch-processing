package processing.sketches;

import processing.core.PApplet;

public class Main extends PApplet {

    float angle = 0;
    float squareSize;

    public void settings() {
        size(600, 600);
    }

    public void setup() {
        // Sets the color mode to HSB, 360 being the max Hue,
        // 100 the max Saturation, and 100 the max Brightness
        colorMode(HSB, 360, 100, 100);
        squareSize = (width - 50) * sqrt(2) / 2;
        rectMode(CENTER);
    }

    public void draw() {
        // Recreates the background to be black each 'draw'
        background(0, 0, 0);

        // Create a branch to allow you to work on the new feature of rectangles
        drawRectangles();

        // Create a branch to allow you to work on the new feature of ellipses
        drawGreenCircle();

        // Look at the code in this method for some sample uses of rect and ellipse
        //drawSamples();

        //Add the rotating square inside the existing circle
        drawRotatingSquare();
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
        stroke(0, 0, 100);
        fill(70.0f, 80.0f, 80.0F);
        rect(0, 0, squareSize, squareSize);

        popMatrix();
    }

    public void drawSamples() {
        // Fill changes the color to shade in the following drawn shapes
        fill(300.0f, 80.0f, 85.0f);
        // Rect draws a rect with the given parameters
        rect(100, 100, 400, 400);

        fill(100.0f, 100.0f, 100.0f);
        // Ellipse draws an ellipse with the given parameters
        ellipse(300, 150, 200, 100);
    }

    /**
     * Draw a few rectangles, each with different colors at different parts of the screen.
     */
    public void drawRectangles() {
        //Choose a color with fill
        fill(20.0f, 88.0f, 30.0f);

        //Draw a rectangle.
        rect(0, 0, 600, 600);

        //Choose a color for second rectangle with fill
        fill(650.0f, 100.0f, 100.0f);

        //Draws second rectangle
        rect(25, 25, width -50 , width - 50);
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

    public static void main(String[] args) {
        PApplet.main("processing.sketches.Main");
    }
}
