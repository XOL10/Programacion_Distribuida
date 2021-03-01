public class Rectangle {
    int width = 0;
    int height = 0;
    float area = 0;

    public Rectangle(){

    }

    public float getArea(){
        area = width * height;
        return area;
    }
}
