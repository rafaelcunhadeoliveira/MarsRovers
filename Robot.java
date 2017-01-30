/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.*;

/**
 *
 * @author Rafael
 */
public class Robot {

    private int x = 0;
    private int y = 0;
    private String direction = "";
    private List<String> instructions;

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public String getDirection() {
        return direction;
    }

    public List<String> getInstructions() {
        return instructions;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    public void setInstructions(List<String> instructions) {
        this.instructions = instructions;
    }

    public boolean verifyPosition(String initialPosition) {
        String[] coordinates;
        coordinates = initialPosition.split(" ");

        try {
            x = Integer.parseInt(coordinates[0]);
            y = Integer.parseInt(coordinates[1]);

            if (coordinates[2].equals("N") || coordinates[2].equals("S") || coordinates[2].equals("E") || coordinates[2].equals("W")) {
                direction = coordinates[2];
                return true;
            }
        } catch (ArrayIndexOutOfBoundsException | NumberFormatException e) {
            return false;

        }

        return false;
    }

    public boolean movement(String move) {
        instructions = Arrays.asList(move.split(""));
        for (String singleMove : instructions) {
            switch (singleMove) {
                case "L":
                    changeDirectionLeft();
                    break;
                case "R":
                    changeDirectionRight();
                    break;
                case "M":
                    moveFoward();
                    break;
                default:
                    return false;
            }
        }

        return true;
    }

    public void changeDirectionLeft() {
        switch (direction) {
            case "N":
                direction = "W";
                break;
            case "S":
                direction = "E";
                break;
            case "E":
                direction = "N";
                break;
            case "W":
                direction = "S";
                break;
        }
    }

    public void changeDirectionRight() {
        switch (direction) {
            case "N":
                direction = "E";
                break;
            case "S":
                direction = "W";
                break;
            case "E":
                direction = "S";
                break;
            case "W":
                direction = "N";
                break;
        }
    }

    public void moveFoward() {
        switch (direction) {
            case "N":
                y += 1;
                break;
            case "S":
                y -= 1;
                break;
            case "E":
                x += 1;
                break;
            case "W":
                x -= 1;
                break;
        }
    }
}
