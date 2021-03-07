public class Rectangle implements Polygon{
    public float width = 0;
    public float lenghth =0;

    public Rectangle(float lenghth, float width){
        this.width = width;
        this.lenghth = lenghth;
    }

    public float getArea(){
        return lenghth * width;
    }

    public int getSides(){
        return 4;
    }
}