
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
    



