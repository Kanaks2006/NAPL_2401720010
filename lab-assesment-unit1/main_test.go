package main

import "testing"

// Test AddItem
func TestAddItem(t *testing.T) {
	inventory = []Item{}

	err := AddItem(Item{1, "Laptop", 5, 50000})

	if err != nil {
		t.Error("AddItem failed")
	}

	if len(inventory) != 1 {
		t.Error("Item was not added")
	}
}

// Test UpdateItem
func TestUpdateItem(t *testing.T) {
	inventory = []Item{
		{1, "Laptop", 5, 50000},
	}

	err := UpdateItem(1, 10, 55000)

	if err != nil {
		t.Error("UpdateItem failed")
	}

	if inventory[0].Quantity != 10 {
		t.Error("Quantity was not updated")
	}
}

// Test RemoveItem
func TestRemoveItem(t *testing.T) {
	inventory = []Item{
		{1, "Laptop", 5, 50000},
	}

	err := RemoveItem(1)

	if err != nil {
		t.Error("RemoveItem failed")
	}

	if len(inventory) != 0 {
		t.Error("Item was not removed")
	}
}
