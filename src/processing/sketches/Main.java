package processing.sketches;

import processing.core.PApplet;


public class Main extends PApplet {

    float angle = 0;
    float reverseAngle = 0;
    float thirdReverseAngle = 0;
    float fourthReverseAngle = 0;
    float scale = 1;
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


    public void settings() {
        size(600, 600);
    }

    public void setup() {
        colorMode(HSB, 360, 100, 100);
        calculateSizes();
        rectMode(CENTER);
    }

    public void draw() {
        background(93, 0, 0);

        // Increment hue shift
        hueShift = (hueShift + 100.5f) % 360;

        if (keyPressed) {
            if (key == '+') {
                scale += 0.01;
                calculateSizes();
            } else if (key == '-') {
                scale -= 0.01;
                calculateSizes();
            }
        }

        if (darkening) {
            saturationShift -= 5.2f;
            brightnessShift -= 5.2f;
            if (brightnessShift <= 20) {
                darkening = false;
            }
        } else {
            saturationShift += 5.2f;
            brightnessShift += 5.2f;
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

    public void calculateSizes() {
        squareSize = (width - 50) * sqrt(2) / 2 * scale;
        circleSize = squareSize;
        innerSquareSize = circleSize * sqrt(2) / 2;
        newCircleSize = innerSquareSize * sqrt(2) / 2 ;
        newSquareSize = newCircleSize * sqrt(2) / 2;
        thirdCircleSize = newCircleSize * sqrt(2) / 2;
        thirdSquareSize = thirdCircleSize * sqrt(2) / 2;
        fourthCircleSize = thirdSquareSize * sqrt(2) / 2;
        fourthSquareSize = fourthCircleSize * sqrt(2) / 2;
    }

    public int getColor(float hue, float saturation, float brightness) {
        return color((baseHue + hue) % 360, constrain(saturation, 0, 100), constrain(brightness, 0, 100));
    }

    public void drawFirstCircle() {
        fill(getColor(0, saturationShift, brightnessShift));
        noStroke();
        pushMatrix();
        //ellipse(width / 2, height / 2, width-50, height-50);
        ellipse(width / 2, height / 2, (width - 50) * scale, (height - 50) * scale);
        popMatrix();
    }

    public void drawFirstRotatingSquare() {
        angle += radians(1);
        pushMatrix();
        translate(width / 2, height / 2);
        rotate(angle);
        stroke(getColor(10, saturationShift, brightnessShift));
        fill(getColor(10, saturationShift, brightnessShift));
        rect(0, 0, squareSize, squareSize);
        popMatrix();
    }

    public void drawSecondCircle() {
        pushMatrix();
        translate(width / 2, height / 2);
        fill(getColor(20, saturationShift, brightnessShift));
        stroke(getColor(20, saturationShift, brightnessShift));
        ellipse(0, 0, circleSize, circleSize);
        popMatrix();
    }

    public void drawSecondRotatingSquare() {
        reverseAngle -= radians(2);
        pushMatrix();
        translate(width / 2, height / 2);
        rotate(reverseAngle);
        stroke(getColor(30, saturationShift, brightnessShift));
        fill(getColor(30, saturationShift, brightnessShift));
        //box(innerSquareSize);
        rect(0, 0, innerSquareSize, innerSquareSize);
        popMatrix();
    }

    public void drawThirdCircle() {
        pushMatrix();
        translate(width / 2, height / 2);
        stroke(getColor(40, saturationShift, brightnessShift));
        fill(getColor(40, saturationShift, brightnessShift));
        ellipse(0, 0, newCircleSize * sqrt(2), newCircleSize * sqrt(2));
        popMatrix();
    }

    public void drawThirdRotatingSquare() {
        thirdReverseAngle += radians(4);
        pushMatrix();
        translate(width / 2, height / 2);
        rotate(thirdReverseAngle);
        stroke(getColor(50, brightnessShift, saturationShift));
        fill(getColor(50, brightnessShift, brightnessShift));
        //box( newSquareSize * sqrt(2));
        rect(0, 0, newSquareSize + sqrt(2), newSquareSize * sqrt(2));
        popMatrix();
    }

    public void drawFourthCircle() {
        pushMatrix();
        translate(width / 2, height / 2);
        stroke(getColor(60, saturationShift, brightnessShift));
        fill(getColor(60, saturationShift, brightnessShift));
        ellipse(0, 0, newSquareSize * sqrt(2), newSquareSize * sqrt(2));
        popMatrix();
    }

    public void drawFourthRotatingSquare() {
        fourthReverseAngle -= radians(8);
        pushMatrix();
        translate(width / 2, height / 2);
        rotate(fourthReverseAngle);
        stroke(getColor(70, saturationShift, brightnessShift));
        fill(getColor(70, saturationShift, brightnessShift));
        //box(newSquareSize);
        rect(0, 0, newSquareSize, newSquareSize);
        popMatrix();
    }

    public static void main(String[] args) {
        PApplet.main("processing.sketches.Main");
    }
}


































