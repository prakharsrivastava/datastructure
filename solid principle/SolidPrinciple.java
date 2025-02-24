
class Rectangle{
    public int height;
    public int width;

    public void setWidth(int width) {
        this.width = width;
    }

    public void setheight(int height) {
        this.height = height;
    }

    public int getArea() {
        return this.height * this.width;
    }

}

class Square extends Rectangle {

    @Override
    public void setWidth(int width) {
        super.width = width;
        super.height = width;
    }
    @Override
    public void setheight(int height) {
        super.height = height;
        super.width = height;
    }

}
public class SolidPrinciple {

    public static void main(String[] args) {

        //wrong implementation
        Rectangle r= new Square();
        r.setheight(3);
        r.setWidth(3);
        System.out.println(r.getArea());

       //wrong rectangle is not square 
       //subclass should behave in a way that does not break the expectations set by its superclass.
        //Rectangles r= new Squares();
        //r.setSide(4);
        //System.out.println(r.getArea());

    }

    //correct implementation
    interface Shape{
        int getArea();
    }

    class Rectangles implements Shape{

        private int height;
        private int width;

        
        @Override
        public int getArea() {
            // TODO Auto-generated method stub
           return height*width;
        }

        public int getHeight() {
            return height;
        }

        public void setHeight(int height) {
            this.height = height;
        }

        public int getWidth() {
            return width;
        }

        public void setWidth(int width) {
            this.width = width;
        }

    }

    class Squares implements Shape{

        private int side;
       
        @Override
        public int getArea() {
            // TODO Auto-generated method stub
           return side*side;
        }

        public int getSide() {
            return side;
        }

        public void setSide(int side) {
            this.side = side;
        }

    }
}
