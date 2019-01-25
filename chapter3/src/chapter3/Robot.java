package chapter3;

import java.util.ArrayList;

public class Robot {
    private enum Direction {NORTH, EAST, SOUTH, WEST};

    private int xPosition;
    private int yPosition;
    private Direction heading;
    int maxMoves;
    int moves;
    private int sensorVal;
    private final int sensorActions[];
    private Maze maze;
    private ArrayList<int[]> route;


    /*
    * @param sensorActions
    * @param maze
    * @param maxMoves
    * */
    public Robot(int[] sensorActions, Maze maze, int maxMoves){
        this.sensorActions = this.calcSensorActions(sensorActions);
        this.maze = maze;
        int startPos[] = this.maze.getStartPosition();
        this.xPosition = startPos[0];
        this.yPosition = startPos[1];
        this.sensorVal = -1;
        this.heading = Direction.EAST;
        this.maxMoves = maxMoves;
        this.moves = 0;
        this.route = new ArrayList<int[]>();
        this.route.add(startPos);
    }

    public void run(){
        while (true){
            this.moves++;
            if(this.getNextAction() == 0){
                return;
            }

            if(this.maze.getPositionValue(this.xPosition, this.yPosition) == 4){
                return;
            }

            if(this.moves > this.maxMoves){
                return;
            }
            this.makeNextAction();
        }
    }

    private int[] calcSensorActions(int[] sensorActionsStr){
        int numActions = (int) sensorActionsStr.length/2;
        int sensorActions[] = new int[numActions];

        for(int sensorValue = 0;sensorValue < numActions; sensorValue++) {
            int sensorAction = 0;
            if (sensorActionsStr[sensorValue * 2] == 1) {
                sensorAction += 2;
            }
            if (sensorActionsStr[(sensorValue * 2) + 1] == 1) {
                sensorAction += 1;
            }
            sensorActions[sensorValue] = sensorAction;
        }
        return sensorActions;
    }

    public void makeNextAction(){
        if(this.getNextAction() == 1){
            int currentX = this.xPosition;
            int currentY = this.yPosition;

            if(Direction.NORTH == this.heading){
                this.yPosition += -1;
                if(this.yPosition < 0){
                    this.yPosition = 0;
                }
            }
            else if(Direction.EAST == this.heading){
                this.xPosition += 1;
                if(this.xPosition > this.maze.getMaxX()){
                    this.xPosition = this.maze.getMaxX();
                }
            }
            else if(Direction.SOUTH == this.heading){
                this.yPosition += 1;
                if(this.yPosition > this.maze.getMaxY()){
                    this.yPosition = this.maze.getMaxY();
                }
            }
            else if(Direction.WEST == this.heading){
                this.xPosition += -1;
                if(this.xPosition < 0){
                    this.xPosition = 0;
                }
            }

            if(this.maze.isWall(this.xPosition, this.yPosition) == true){
                this.xPosition = currentX;
                this.yPosition = currentY;
            }
            else{
                if(currentX != this.xPosition || currentY != this.yPosition){
                    this.route.add(this.getPosition());
                }
            }
        }
        else if(this.getNextAction() == 2)
    }

    public int getNextAction(){
        return this.sensorActions[this.getSensorValue()];
    }

    public int getSensorValue(){
        if(this.sensorVal > -1){
            return this.sensorVal;
        }
        boolean frontSensor, frontLeftSensor, frontRightSensor,
                leftSensor, rightSensor, backSensor;
        frontSensor = frontLeftSensor = frontRightSensor =
                leftSensor = rightSensor = backSensor = false;
        if(this.getHeading() == Direction.NORTH){

        }
    }

    public int[] getPosition(){
        return new int[]{this.xPosition, this.yPosition};
    }

    private Direction getHeading() {
        return this.heading;
    }

    public ArrayList<int[]> getRoute(){
        return this.route;
    }

    public String printRoute(){
        String route = "";
        for(Object routeStep : this.route){
            int step[] = (int[]) routeStep;
            route += "{" + step[0] + "," + step[1] + "}";
        }
        return route;
    }
}
