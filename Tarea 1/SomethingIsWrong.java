public class SomethingIsWrong {
    public static void main(String[] args) {
        Rectangle myRect = new Rectangle();//el método Rectangle no estaba creado
        myRect.width = 40;
        myRect.height = 50;
        System.out.println("myRect's area is " + myRect.getArea());//Se creó el metodo getArea
    }
}
