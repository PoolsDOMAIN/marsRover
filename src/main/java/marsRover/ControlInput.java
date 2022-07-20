package marsRover;

import java.util.*;

public class ControlInput {
    private String input;
    private String resultantPositions;

    public ControlInput(String input){
        this.input= input;
    }
    public String parseInput(){
        List<String> inputComponents = new ArrayList<String>(Arrays.asList(input.split(" ")));
        ListIterator<String> inputComponentsPointer = (ListIterator<String>) inputComponents.iterator();
        int upperRightXCoordinateOfMars= Integer.parseInt(inputComponentsPointer.next());
        int upperRightYCoordinateOfMars= Integer.parseInt(inputComponentsPointer.next());

        while(inputComponentsPointer.hasNext()){
            int roverXCoordinate= Integer.parseInt(inputComponentsPointer.next());
            int roverYCoordinate= Integer.parseInt(inputComponentsPointer.next());
            int direction= this.directionToNumber(inputComponentsPointer.next());
            Rover rover = new Rover(roverXCoordinate,roverYCoordinate,direction);

            String instructions= inputComponentsPointer.next();
            String[] subInstructions = instructions.split("");
            if(Objects.equals(subInstructions[0], "L") || Objects.equals(subInstructions[0], "R")){
                for (String step : subInstructions) {
                    if(Objects.equals(step, "L"))
                        rover.RotateLeft();
                    else if(Objects.equals(step, "R"))
                        rover.RotateRight();
                    else
                        rover.moveForward();
                }
            }
            else{
                inputComponentsPointer.previous();
            }

            this.resultantPositions+= rover.XCordinate() +" "+ rover.YCordinate()+" "+ this.numberToDirection(rover.direction())+" ";
        }
        System.out.println(resultantPositions);
        return this.resultantPositions;
    }

    private String numberToDirection(int direction) {
        switch (direction){
            case 0:
                return "E";
            case 1:
                return "N";
            case 2:
                return "W";
            default:
                return "S";
        }
    }

    private int directionToNumber(String next) {
        switch (next){
            case "E":
                return 0;
            case "N":
                return 1;
            case "W":
                return 2;
            default:
                return 3;
        }
    }

    public String finalPositions(){
        return this.parseInput();
    }

}

