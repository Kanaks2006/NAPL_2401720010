module Q1

// Base class
[<AbstractClass>]
type Shape() =
    abstract member Area: unit -> float

// Derived class Circle
type Circle(radius: float) =
    inherit Shape()

    override this.Area() =
        3.14 * radius * radius

// Derived class Rectangle
type Rectangle(length: float, breadth: float) =
    inherit Shape()

    override this.Area() =
        length * breadth

// Creating objects
let circle = Circle(5.0)
let rectangle = Rectangle(4.0, 6.0)

// Displaying areas
printfn "Area of Circle: %f" (circle.Area())
printfn "Area of Rectangle: %f" (rectangle.Area())

// Demonstrating polymorphism
let shapes: Shape list = [circle; rectangle]

printfn "\nPolymorphism:"
for shape in shapes do
    printfn "Area: %f" (shape.Area())