package main

import "fmt"

func main() {
	for {
		var choice int
		fmt.Println("Enter a choice")
		fmt.Println("1 Integer")
		fmt.Println("2 Float")
		fmt.Println("3 Exit")
		fmt.Scan(&choice)

		if choice == 1 {
			var a int
			fmt.Println("Enter 1 Integer:")
			fmt.Scan(&a)

			var b int
			fmt.Println("Enter 2 Integer:")
			fmt.Scan(&b)

			fmt.Println("The sum of two numbers is:", a+b)
			fmt.Println("The difference of two numbers is:", a-b)
			fmt.Println("The product of two numbers is:", a*b)
			fmt.Println("The division of two numbers is:", a/b)

		} else if choice == 2 {
			var a float64
			fmt.Println("Enter 1 num:")
			fmt.Scan(&a)

			var b float64
			fmt.Println("Enter 2 num:")
			fmt.Scan(&b)

			fmt.Println("The sum of two numbers is:", a+b)
			fmt.Println("The difference of two numbers is:", a-b)
			fmt.Println("The product of two numbers is:", a*b)
			fmt.Println("The division of two numbers is:", a/b)

		} else if choice == 3 {
			fmt.Println("Exit")
			break
		} else {
			fmt.Println("Invalid Choice")
		}
	}
}
