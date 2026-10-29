
open System
open System.Text.RegularExpressions

// 1. Reverse a string and check palindrome
let reverseString (s: string) =
    s |> Seq.rev |> Seq.toArray |> String

let isPalindrome (s: string) =
    let reversed = reverseString s
    s = reversed

printfn "----- Reverse and Palindrome -----"

let strings = ["madam"; "hello"; "level"]

strings
|> List.iter (fun s ->
    printfn "String: %s" s
    printfn "Reversed: %s" (reverseString s)
    printfn "Palindrome: %b" (isPalindrome s)
    printfn "")

// 2. Transform a string
let transformString (s: string) =
    if s |> Seq.forall Char.IsLetter then
        s.ToUpper()
    elif s <> "" && (s |> Seq.forall Char.IsDigit) then
        s + s
    else
        s

printfn "----- String Transformation -----"

let values = ["hello"; "123"; "abc123"]

values
|> List.iter (fun s ->
    printfn "%s -> %s" s (transformString s))

printfn ""

// 3. Validate email format using Regex
let isValidEmail (email: string) =
    Regex.IsMatch(
        email,
        @"^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\.[A-Za-z]{2,}$"
    )

printfn "----- Email Validation -----"

let emails =
    ["student@example.com"
     "abc.gmail.com"
     "user123@test.in"]

emails
|> List.iter (fun email ->
    printfn "%s -> %b" email (isValidEmail email))
