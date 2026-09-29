// package main

// import (
// 	"bufio"
// 	"fmt"
// 	"os"
// 	"strconv"
// 	"strings"
// )

// type Person struct {
// 	Name   string
// 	Age    int
// 	Job    string
// 	Salary float64
// }

// var scanner = bufio.NewScanner(os.Stdin)

// func (p *Person) ReadData() {
// 	fmt.Print("Enter name: ")
// 	scanner.Scan()
// 	p.Name = scanner.Text()

// 	fmt.Print("Enter Age: ")
// 	scanner.Scan()
// 	p.Age, _ = strconv.Atoi(scanner.Text())

// 	fmt.Print("Enter Job: ")
// 	scanner.Scan()
// 	p.Job = scanner.Text()

// 	fmt.Print("Enter Salary: ")
// 	scanner.Scan()
// 	p.Salary, _ = strconv.ParseFloat(strings.TrimSpace(scanner.Text()), 64)
// }

// func (p Person) PrintData() {
// 	fmt.Println("Name  :", p.Name)
// 	fmt.Println("Age   :", p.Age)
// 	fmt.Println("Job   :", p.Job)
// 	fmt.Println("Salary:", p.Salary)
// }

// func main() {
// 	var person1 Person
// 	var person2 Person

// 	fmt.Println("Person 1")
// 	person1.ReadData()

// 	fmt.Println("\nPerson 2")
// 	person2.ReadData()

// 	fmt.Println("\nDetails")
// 	person1.PrintData()
// 	person2.PrintData()
// }
