import scala.annotation.meta.setter
class Rectangless(var width:Int , var height :Int){

    def getArea():Int={
        return height * width;
    }

}

class Square(side:Int) extends Rectangless(side,side){

    override def getArea(): Int = {
        return side*side;
    }
}

// Main Object to Test
object Main extends App {

    var r =Rectangless(3,5)

    print(r.getArea())

}


    //correct implementation
    trait Shape{
        def getArea():Int;
    }

    class Rectangles(height:Int,width:Int) extends  Shape{

     
        def  getArea():Int= {
            // TODO Auto-generated method stub
           return height*width;
        }

    

    }

    class Squares(Side:Int) extends  Shape{

        
        def  getArea():Int= {
            // TODO Auto-generated method stub
           return Side*Side;
        }

    }

