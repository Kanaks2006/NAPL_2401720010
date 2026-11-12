package mathutil

// Reverse reverses a string.
func Reverse(str string) string {
	reversed := ""

	for i := len(str) - 1; i >= 0; i-- {
		reversed += string(str[i])
	}

	return reversed
}

// CountVowels counts vowels in a string.
func CountVowels(str string) int {
	count := 0

	for _, ch := range str {
		switch ch {
		case 'a', 'e', 'i', 'o', 'u',
			'A', 'E', 'I', 'O', 'U':
			count++
		}
	}

	return count
}

// Factorial calculates factorial.
func Factorial(n int) int {
	result := 1

	for i := 1; i <= n; i++ {
		result *= i
	}

	return result
}

// Power calculates the power of a number.
func Power(base, exponent int) int {
	result := 1

	for i := 1; i <= exponent; i++ {
		result *= base
	}

	return result
}
