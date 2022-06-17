# Introduction to Graphical Programming with Processing

Processing is a Java library that will allow us to create simple 
graphics to accompany our fundamentals of Java coding. 
This library provides us with tools to create primitive shapes such
as rectangles and ellipses (circles and ovals), and allows us to 
programmatically animate and control them during runtime.

## Getting Started with Processing
 In the starter code for this lesson, you will notice the Main class
 extends PApplet (processing applet). 
 
 ```java
import processing.core.PApplet;

public class Main extends PApplet {
    
    ...
}
```
 
 We will cover extending classes
 in a future lesson, for now all you need to know is that by
 extending from PApplet, we are able to use processing functions
 inside our Main class.
 
 All processing functions can be found on the 
 [reference section](https://www.processing.org/reference) of
 the processing website.
 
 ## Core methods `settings`, `setup`, and `draw`
 
 These are the three functions that control the flow of a processing
 application (called a sketch).
 
 * `settings()` is used to create a window where graphics can be 
 displayed, known as the "canvas".
 
 * `setup()` the code inside the function runs once right after the 
 program runs
 
 * `draw()` this function is called 60 times per second. This is 
 the main application loop and the heart of the program.
 
 ## Starter Code
 
 In the `settings` function we are calling `size` to create a 600
 x 600 pixel canvas window.
 
 In the `setup` function we are picking some color preferences.
 
 - `noStroke()` shapes are drawn without outlines.
 - `colorMode(HSB, 360, 100, 100)` colors are now to be passed using 
 **Hue**, **Saturation**, and **Brightness** values. The Hue values should be passed
between 0 and 360, while the saturation and brightness should be passed
between 0 and 100.
 
 In the `draw` function we are drawing a black background over 
 the canvas. (hue 0, saturation 0, brightness 0).
 
 ## Project Description: Simple Shapes and Branches
 
Using git, we will be demonstrating a standard work flow using
branches to add 'features' to our existing project.

First we will identify and understand some basic Processing
methods and shapes. Second, we will create a branch to work
specifically on a feature that includes new rectangles.
Third, we will work on another branch to work with ellipses.
 
 ## Instructions Part 1: Intro to Processing
 
- Identify what settings, setup, and draw do. 
- Identify what the parameters to fill, rect, and ellipse do.
 
 ## Instructions Part 2: Create a branch, feature-rect
 
On your CLI, make a branch called feature-rect and check it out.

Create a few different rectangles in the drawRectangles() method.

Add and commit your changes on the feature-rect branch, then
checkout your main branch and see what occurs within the project.

Switch back and forth between the main branch and the rectangle branch
and return to your project to see the changes.

On your main branch, merge your feature-rect modifications.


## Instructions Part 3: Create a branch, feature-ellipse

To add familiarity to the process, repeat the same process as above
but this time in a new feature-ellipse branch.



### Extension

Make this project more your own. Example ideas:

- Make your rectangles to build a picture frame.
- Make your ellipses build a target or the Olympic rings.
- Try using any of the skills you learned in Java before, like using 
a for loop to create many shapes at once but offset from each other.
