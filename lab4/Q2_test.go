package main

import (
	"strings"
	"testing"
)

func TestDivideValid(t *testing.T) {
	result, err := divide(10, 2)
	if err != nil {
		t.Fatalf("Unexpected error: %v", err)
	}
	if result != 5 {
		t.Errorf("Expected 5, got %v", result)
	}
}

func TestDivideByZero(t *testing.T) {
	_, err := divide(10, 0)
	if err == nil {
		t.Fatal("Expected division by zero error")
	}
	if !strings.Contains(err.Error(), "division by zero") {
		t.Errorf("Unexpected error message: %v", err)
	}
}

func TestSquareRootValid(t *testing.T) {
	result, err := squareRoot(25)
	if err != nil {
		t.Fatalf("Unexpected error: %v", err)
	}
	if result != 5 {
		t.Errorf("Expected 5, got %v", result)
	}
}

func TestSquareRootNegative(t *testing.T) {
	_, err := squareRoot(-9)
	if err == nil {
		t.Fatal("Expected negative square root error")
	}
	if !strings.Contains(err.Error(), "negative number") {
		t.Errorf("Unexpected error message: %v", err)
	}
}

func TestEmptyInput(t *testing.T) {
	_, err := validateInput("")
	if err == nil {
		t.Fatal("Expected empty input error")
	}
	if !strings.Contains(err.Error(), "empty") {
		t.Errorf("Unexpected error message: %v", err)
	}
}

func TestValidInput(t *testing.T) {
	result, err := validateInput("Hello Go")
	if err != nil {
		t.Fatalf("Unexpected error: %v", err)
	}
	if result != "Hello Go" {
		t.Errorf("Expected Hello Go, got %v", result)
	}
}
