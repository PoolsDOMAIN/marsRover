package marsRover;

public class Rover {
    private int roverXCoordinate;
    private int roverYCoordinate;
    private int direction;

    public Rover(int roverXCoordinate, int roverYCoordinate, int direction) {
        this.roverXCoordinate= roverXCoordinate;
        this.roverYCoordinate= roverYCoordinate;
        this.direction= direction;
    }

    public int XCordinate(){
        return this.roverXCoordinate;
    }


    public int YCordinate(){
        return this.roverYCoordinate;
    }


    public int direction(){
        return this.direction;
    }

    public void RotateRight() {
        this.direction-=1;
        if(this.direction==-1)
            this.direction= 3;
    }

    public void RotateLeft() {
        this.direction+=1;
        if(this.direction== 4)
            this.direction=0;
    }

    public void moveForward() {
        if(this.direction==0)
            roverXCoordinate+=1;
        else if(this.direction==2)
            roverXCoordinate-=1;
        else if(this.direction==1)
            roverYCoordinate+=1;
        else
            roverYCoordinate-=1;
    }
}
