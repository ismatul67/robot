public class Robotku {
    private int x;
    private int y;
    private Direction dir;

    public Robotku(int x, int y, Direction dir) {
        this.x = x;
        this.y = y;
        this.dir = dir;
    }

    @Override
    public String toString() {
        return x +","+ y+":"+ dir;
    }

    public void runCommand(String[] commands) {
        for(String command: commands) {
            if (command.toUpperCase().equals("C")) {
                FileUtility.reset();
            }else{
                move(command.toUpperCase());
                FileUtility.write(toString());
            }
        }
    }

    public void move(String command) {
        Movement gerakan = Movement.valueOf(command);
        switch (gerakan) {
            case F:
                forward();
                break;
            case B:
                backward();
                break;
            case R:
                turnRight();
                break;
            case L:
                turnLeft();
                break;
        }

    }
    public void forward() {
        switch (this.dir) {
            case N:
                y++;
                break;
            case E:
                x++;
                break;
            case W:
                x--;
                break;
            case S:
                y--;
                break;
    
        }


    }
    public void backward() {
        switch (this.dir) {
            case N:
                y--;
                break;
            case E:
                x--;
                break;
            case W:
                x++;
                break;
            case S:
                y++;
                break;
        }


    }

    public void turnRight () {
        // dir.turnRight();
        switch (this.dir) {
            case N:
            this.dir=Direction.E;
                break;
            case E:
            this.dir=Direction.S;
                break;
            case S:
            this.dir=Direction.W;
                break;
            case W:
            this.dir=Direction.N;
             break;
            default:
                System.out.println("perintah salah");
                break;
        }

    }

    public void turnLeft () {
        // dir.turnLeft();
        switch (this.dir) {
            case N:
            this.dir=Direction.W;
                break;
            case W:
            this.dir=Direction.S;
                break;
            case S:
            this.dir=Direction.E;
                break;
            case E:
            this.dir=Direction.N;
             break;
            default:
                System.out.println("perintah salah");
                break;
        }
    }

}
