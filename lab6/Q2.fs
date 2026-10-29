
printf "Enter an integer: "
let n = int (System.Console.ReadLine())

let rec isPrime n divisor =
    if n < 2 then
        false
    elif divisor * divisor > n then
        true
    elif n % divisor = 0 then
        false
    else
        isPrime n (divisor + 1)

let result = isPrime n 2

if result then
    printfn "%d is a prime number." n
else
    printfn "%d is not a prime number." n
