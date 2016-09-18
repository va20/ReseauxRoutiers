/**
 * Created by saif on 18/09/2016.
 */
public enum Direction {
    NORD_SUD("↓"),
    //SUD_NORD("↑"),
    //OUEST_EST("→"),
    EST_OUEST("←");

    private String direction;
    Direction(String d) {
        this.direction=d;
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    @Override
    public String toString() {
        return this.direction;
    }
}
