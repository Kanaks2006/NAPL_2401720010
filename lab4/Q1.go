package main

import "fmt"

func square(ch chan int, n int) {

	fmt.Println("Square go routine started")

	ch <- n * n

	fmt.Println("Go routine completed")
}

func cube(ch chan int, n int) {

	fmt.Println("Cube go routine started")

	ch <- n * n * n

	fmt.Println("Cube go routine completed")
}

func fibonacci(ch chan int, n int) {

	fmt.Println("Fibonacci go routine started")

	a, b := 0, 1

	for i := 0; i < n; i++ {
		a, b = b, a+b
	}

	ch <- a

	fmt.Println("Fibonacci go routine completed")

}

func main() {

	ch := make(chan int)

	var n1, n2, n3 int

	fmt.Print("Enter number for square: ")
	fmt.Scan(&n1)

	fmt.Print("Enter number for cube: ")
	fmt.Scan(&n2)

	fmt.Print("Enter Fibonacci position: ")
	fmt.Scan(&n3)

	go square(ch, n1)
	go cube(ch, n2)
	go fibonacci(ch, n3)

	for i := 0; i < 3; i++ {
		fmt.Println("Result:", <-ch)
	}
}
