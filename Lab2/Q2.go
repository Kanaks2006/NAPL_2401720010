package main

import "fmt"

func main() {

	// Slice
	var students []string
	var name string

	fmt.Println("Enter 3 student names:")

	for i := 0; i < 3; i++ {
		fmt.Scan(&name)
		students = append(students, name)
	}

	fmt.Println("Original slice:", students)

	// Add
	fmt.Print("Enter a student to add: ")
	fmt.Scan(&name)
	students = append(students, name)
	fmt.Println("After adding:", students)

	// Remove by index
	var index int
	fmt.Print("Enter index to remove: ")
	fmt.Scan(&index)

	students = append(students[:index], students[index+1:]...)
	fmt.Println("After removing:", students)

	// Update
	fmt.Print("Enter index to update: ")
	fmt.Scan(&index)

	fmt.Print("Enter new name: ")
	fmt.Scan(&name)

	students[index] = name
	fmt.Println("After updating:", students)

	// Map
	marks := make(map[string]int)

	var subject string
	var mark int

	fmt.Println("\nEnter 2 subjects and marks:")

	for i := 0; i < 2; i++ {
		fmt.Print("Enter subject: ")
		fmt.Scan(&subject)

		fmt.Print("Enter marks: ")
		fmt.Scan(&mark)

		marks[subject] = mark
	}

	fmt.Println("Original map:", marks)

	// Insert
	fmt.Print("Enter subject to insert: ")
	fmt.Scan(&subject)

	fmt.Print("Enter marks: ")
	fmt.Scan(&mark)

	marks[subject] = mark
	fmt.Println("After inserting:", marks)

	// Delete
	fmt.Print("Enter subject to delete: ")
	fmt.Scan(&subject)

	delete(marks, subject)
	fmt.Println("After deleting:", marks)

	// Lookup
	fmt.Print("Enter subject to lookup: ")
	fmt.Scan(&subject)

	fmt.Println("Marks:", marks[subject])
}
