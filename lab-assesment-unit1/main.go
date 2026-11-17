package main

import (
	"errors"
	"fmt"
)

// Item structure
type Item struct {
	ID       int
	Name     string
	Quantity int
	Price    float64
}

// Slice to store inventory items
var inventory []Item

// Add item
func AddItem(item Item) error {
	if item.ID <= 0 || item.Name == "" || item.Quantity < 0 || item.Price < 0 {
		return errors.New("invalid item details")
	}

	for _, v := range inventory {
		if v.ID == item.ID {
			return errors.New("item already exists")
		}
	}

	inventory = append(inventory, item)
	return nil
}

// Update item
func UpdateItem(id int, quantity int, price float64) error {
	if quantity < 0 || price < 0 {
		return errors.New("invalid quantity or price")
	}

	for i := range inventory {
		if inventory[i].ID == id {
			inventory[i].Quantity = quantity
			inventory[i].Price = price
			return nil
		}
	}

	return errors.New("item not found")
}

// Remove item
func RemoveItem(id int) error {
	for i, item := range inventory {
		if item.ID == id {
			inventory = append(inventory[:i], inventory[i+1:]...)
			return nil
		}
	}

	return errors.New("item not found")
}

// Statistics structure
type Statistics struct {
	TotalValue float64
	ItemCount  int
}

// Calculate statistics using goroutine and channel
func CalculateStats() Statistics {
	ch := make(chan Statistics)

	go func() {
		var s Statistics
		s.ItemCount = len(inventory)

		for _, item := range inventory {
			s.TotalValue += float64(item.Quantity) * item.Price
		}

		ch <- s
	}()

	return <-ch
}

// Main function
func main() {
	inventory = []Item{}

	fmt.Println("Adding Items")

	AddItem(Item{1, "Laptop", 5, 50000})
	AddItem(Item{2, "Mouse", 10, 500})
	AddItem(Item{3, "Keyboard", 7, 1200})

	fmt.Println("Inventory:", inventory)

	fmt.Println("\nUpdating Laptop")
	err := UpdateItem(1, 8, 52000)
	if err != nil {
		fmt.Println(err)
	} else {
		fmt.Println("Updated successfully")
	}

	fmt.Println("\nRemoving Mouse")
	err = RemoveItem(2)
	if err != nil {
		fmt.Println(err)
	} else {
		fmt.Println("Removed successfully")
	}

	fmt.Println("\nFinal Inventory:", inventory)

	stats := CalculateStats()

	fmt.Println("\nInventory Summary")
	fmt.Println("Total Items:", stats.ItemCount)
	fmt.Printf("Total Value: Rs. %.2f\n", stats.TotalValue)
}
