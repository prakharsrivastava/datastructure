
class Rectangle_:
    
    def __init__(self, h:int, w:int):
        self.w=w
        self.h=h

    def getArea(self)->int:
        return self.h * self.w
    



class Square_(Rectangle_):
    
     def __init__(self, s:int):
       super().__init__(s,s)


     def getArea(self)->int : 
        return self.h*self.w
    
 
if __name__ == "__main__":    
    r=Rectangle_(5,8).getArea()
    print(r)    
    s=Square_(5).getArea()
    print(s)    
    


from abc import ABC, abstractmethod

# Define an abstract base class for Shape
class Shape(ABC):

    @abstractmethod
    def get_area(self) -> int:
        pass  # Enforce implementation in subclasses


# Rectangle class inheriting from Shape
class Rectangle(Shape):
    def __init__(self, height: int, width: int):
        self.height = height
        self.width = width

    def get_area(self) -> int:
        return self.height * self.width


# Square class inheriting from Shape
class Square(Shape):
    def __init__(self, side: int):
        self.side = side

    def get_area(self) -> int:
        return self.side * self.side


# Example usage
rect = Rectangle(5, 10)
print("Rectangle Area:", rect.get_area())

sq = Square(4)
print("Square Area:", sq.get_area())

