package com.vnaidu;

public class Land extends Base {

    private int x;
    private int y;
    private int checked;
    private boolean fertile;

    public Land(int x, int y, int checked, boolean fertile) {
        this.x = x;
        this.y = y;
        this.checked = checked;
        this.fertile = fertile;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getChecked() {
        return checked;
    }

    public void setChecked(int checked) {
        this.checked = checked;
    }

    public boolean getFertile() {
        return fertile;
    }

    public void setFertile(boolean fertile) {
        this.fertile = fertile;
    }
}
