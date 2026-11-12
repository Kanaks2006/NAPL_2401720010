
module Q2

// List.map - Square each element
let list1 = [1; 2; 3; 4; 5]
let list2 = [2; 4; 6; 8]

let squares1 = List.map (fun x -> x * x) list1
let squares2 = List.map (fun x -> x * x) list2

printfn "List.map:"
printfn "Original: %A" list1
printfn "Squared: %A" squares1
printfn "Original: %A" list2
printfn "Squared: %A" squares2

// List.filter - Select even numbers
let even1 = List.filter (fun x -> x % 2 = 0) list1
let even2 = List.filter (fun x -> x % 2 = 0) [1; 3; 5; 7; 8; 10]

printfn "\nList.filter:"
printfn "Even numbers: %A" even1
printfn "Even numbers: %A" even2

// List.fold - Calculate sum
let sum1 = List.fold (fun acc x -> acc + x) 0 list1
let sum2 = List.fold (fun acc x -> acc + x) 0 list2

printfn "\nList.fold:"
printfn "Sum of first list: %d" sum1
printfn "Sum of second list: %d" sum2
