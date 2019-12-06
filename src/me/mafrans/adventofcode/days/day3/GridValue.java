package me.mafrans.adventofcode.days.day3;

public class GridValue {
    public int x = 0;
    public int y = 0;
    public int val = 0;

    public GridValue(int x, int y, int val) {
        this.x = x;
        this.y = y;
        this.val = val;
    }

    @Override
    public String toString() {
        return String.format("{\"x\": %d, \"y\": %d, \"v\": %s}", x, y, val);
    }

    @Override
    public boolean equals(Object obj) {
        return (obj instanceof GridValue) && ((GridValue)obj).x == x && ((GridValue)obj).y == y && ((GridValue)obj).val == val;
    }

    @Override
    public int hashCode() {
        return 10000000 * x + 10 * y + val;
    }
}
