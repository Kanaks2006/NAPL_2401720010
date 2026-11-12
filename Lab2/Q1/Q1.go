package main

import (
	"Go-Exp2/mathutil"
	"fmt"
)

func main() {
	text := "Hello World"

	fmt.Println("Original String:", text)
	fmt.Println("Reversed String:", mathutil.Reverse(text))
	fmt.Println("Number of Vowels:", mathutil.CountVowels(text))

	fmt.Println("\nFactorial of 5:", mathutil.Factorial(5))
	fmt.Println("2 raised to power 3:", mathutil.Power(2, 3))
}
