package me.mafrans.adventofcode.days.day3;

public class GridValue2 {
    public int x = 0;
    public int y = 0;
    public int val1 = 0;
    public int val2 = 0;

    public GridValue2(int x, int y, int id, int val2) {
        this.x = x;
        this.y = y;
        this.val1 = id;
        this.val2 = val2;
    }

    @Override
    public String toString() {
        return String.format("{x: %d, y: %d, v1: %s, v2: %s}", x, y, val1, val2);
    }

    @Override
    public boolean equals(Object obj) {
        return (obj instanceof GridValue2) && ((GridValue2)obj).x == x && ((GridValue2)obj).y == y && ((GridValue2)obj).val1 == val1;
    }

    @Override
    public int hashCode() {
        return 10000000 * x + 10 * y + val1;
    }
}
