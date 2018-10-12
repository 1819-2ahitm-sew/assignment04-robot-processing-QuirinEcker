package at.htl.robot.gui;

import at.htl.robot.model.Robot;
import processing.core.PApplet;


public class Main extends PApplet {

    // Hier die Member-Attribute eintragen

    private float upperMargin = 50;
    private float leftMargin = 50;
    private float celllength = 50;
    private float tableLength = celllength * 10;
    private Robot robot = new Robot();
    private int x = 0;
    private int y = 0;

    public static void main(String[] args) {
        PApplet.main("at.htl.robot.gui.Main", args);
    }

    public void settings() {
        size(800, 800);
    }

    public void setup() {
        background(209); //https://processing.org/tutorials/color/
        robot.setY(0);
        robot.setX(0);
    }

    /**
     * Diese Methode wird iterativ durchlaufen (wie loop() beim Arduino)
     */
    public void draw() {
        deleteAll();
        drawtable();
        drawRobot();
    }

    private void drawtable() {
        for (int i = 1; i < 12; i++) {
            line(leftMargin, i * upperMargin, leftMargin + tableLength, i * upperMargin);
            line(leftMargin * i, upperMargin, leftMargin * i, upperMargin + tableLength);
        }
    }

    /**
     * Erstellen Sie eine eigene Methode, mittels der der Roboter am Bildschirm gezeichnet wird
     * Die Angabe zu Position des Roboters am Spielfeld erhalten Sie aus dem Roboter-Objekt, welches
     * als Parameter übergeben wird.
     */
    private void drawRobot() {
        if (x < 0 || y < 0) {
            if (x < 0) {
                x = 0;
            } else {
                y = 0;
            }
        }
        ellipse(leftMargin + (celllength / 2) + (celllength * x), upperMargin + (celllength / 2) + (celllength * y), celllength, celllength);
    }

    /**
     * Erstellen Sie eine eigene Methode zum Löschen des Bildschirms
     */
    private void deleteAll() {
        background(209);
    }

    /**
     * In dieser Methode reagieren Sie auf die Tasten
     */
    public void keyPressed() {
        println("pressed " + key + " " + keyCode);

        if (key == 'f' || key == 'F') {
            robot.stepForward();
            x = robot.getX();
            y = robot.getY();
        } else if (key == 'l' || key == 'L') {
            robot.rotateLeft();
        }

    }
}




