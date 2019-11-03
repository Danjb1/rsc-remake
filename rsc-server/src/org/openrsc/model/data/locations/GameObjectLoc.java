package org.openrsc.model.data.locations;

/**
 * Represents a static game object location.
 */
public class GameObjectLoc {
    /**
     * The id of the gameObject
     */
    public int id;
    /**
     * The objects x coord
     */
    public int x;
    /**
     * The objects y coord
     */
    public int y;
    /**
     * The direction it faces
     */
    public int direction;
    /**
     * Type of object - 0: Object, 1: WallObject
     */
    public int type;

    public int getId() {
        return id;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getDirection() {
        return direction;
    }

    public int getType() {
        return type;
    }
}
