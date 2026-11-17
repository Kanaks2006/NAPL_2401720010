
open System
open Microsoft.Data.Sqlite

// 1. Domain Model using Record Type
type Student = {
    Id: int
    Name: string
    Age: int
    Course: string
}

// 2. Database Connection
let connectionString = "Data Source=students.db"

let getConnection() =
    new SqliteConnection(connectionString)

// Create Table
let createTable() =
    use con = getConnection()
    con.Open()

    let cmd = con.CreateCommand()
    cmd.CommandText <-
        "CREATE TABLE IF NOT EXISTS Students
         (Id INTEGER PRIMARY KEY, Name TEXT, Age INTEGER, Course TEXT)"

    cmd.ExecuteNonQuery() |> ignore

// 3. Add Student (CREATE)
let addStudent student =
    use con = getConnection()
    con.Open()

    let cmd = con.CreateCommand()
    cmd.CommandText <-
        "INSERT INTO Students VALUES ($id, $name, $age, $course)"

    cmd.Parameters.AddWithValue("$id", student.Id) |> ignore
    cmd.Parameters.AddWithValue("$name", student.Name) |> ignore
    cmd.Parameters.AddWithValue("$age", student.Age) |> ignore
    cmd.Parameters.AddWithValue("$course", student.Course) |> ignore

    cmd.ExecuteNonQuery() |> ignore
    printfn "Student added successfully!"

// 4. View Students (READ)
let viewStudents() =
    use con = getConnection()
    con.Open()

    let cmd = con.CreateCommand()
    cmd.CommandText <- "SELECT * FROM Students"

    use reader = cmd.ExecuteReader()

    let students = ResizeArray<Student>()

    while reader.Read() do
        students.Add({
            Id = reader.GetInt32(0)
            Name = reader.GetString(1)
            Age = reader.GetInt32(2)
            Course = reader.GetString(3)
        })

    students |> Seq.toList

// 5. Update Student (UPDATE)
let updateStudent id newCourse =
    use con = getConnection()
    con.Open()

    let cmd = con.CreateCommand()
    cmd.CommandText <-
        "UPDATE Students SET Course = $course WHERE Id = $id"

    cmd.Parameters.AddWithValue("$course", newCourse) |> ignore
    cmd.Parameters.AddWithValue("$id", id) |> ignore

    cmd.ExecuteNonQuery() |> ignore
    printfn "Student updated successfully!"

// 6. Delete Student (DELETE)
let deleteStudent id =
    use con = getConnection()
    con.Open()

    let cmd = con.CreateCommand()
    cmd.CommandText <- "DELETE FROM Students WHERE Id = $id"
    cmd.Parameters.AddWithValue("$id", id) |> ignore

    cmd.ExecuteNonQuery() |> ignore
    printfn "Student deleted successfully!"

// 7. Higher Order Functions: Map and Filter
let processStudents students =
    let names =
        students |> List.map (fun s -> s.Name)

    let adults =
        students |> List.filter (fun s -> s.Age >= 18)

    printfn "Student Names: %A" names
    printfn "Students aged 18 or above: %A" adults

// 8. Pattern Matching
let checkStudent student =
    match student.Age with
    | age when age >= 18 -> printfn "%s is an adult" student.Name
    | _ -> printfn "%s is a minor" student.Name

// 9. Main Program
[<EntryPoint>]
let main argv =
    createTable()

    let s1 = {
        Id = 1
        Name = "Japneet Kaur "
        Age = 21
        Course = "Computer Science"
    }

    let s2 = {
        Id = 2
        Name = "Kanak Sharma"
        Age = 20
        Course = "Mathematics"
    }

    // CREATE
    addStudent s1
    addStudent s2

    // READ
    let students = viewStudents()

    printfn "\nAll Students:"
    students |> List.iter (fun s -> printfn "%A" s)

    // MAP AND FILTER
    processStudents students

    // PATTERN MATCHING
    students |> List.iter checkStudent

    // UPDATE
    updateStudent 1 "Data Science"

    // DELETE
    deleteStudent 2

    printfn "\nFinal Student Records:"
    viewStudents() |> List.iter (fun s -> printfn "%A" s)

    0
