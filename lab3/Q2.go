package main

import "fmt"

// function to change the value of the pointer
func UpdateValue(p *int) {
	*p = 100
}

// creating the structure
type Student struct {
	name  string
	age   int
	marks int
}

// now writing the main function

func main() {

	num := 10
	fmt.Println("Value of num:", num)
	fmt.Println("Address of num:", &num)
	fmt.Println("Value using pointer:", *(&num))

	fmt.Println("\nBefore function:", num)

	UpdateValue(&num)

	fmt.Println("After function:", num)

	student := new(Student)
	student.name = "kanak"
	student.age = 20
	student.marks = 85

	fmt.Println("\nStudent Details:")
	fmt.Println("Name:", student.name)
	fmt.Println("Age:", student.age)
	fmt.Println("Marks:", student.marks)
}
