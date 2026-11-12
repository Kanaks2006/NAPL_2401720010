
#r "nuget: Microsoft.Data.Sqlite"
#r "nuget: MongoDB.Driver"

module Q2 =

    open Microsoft.Data.Sqlite
    open MongoDB.Bson
    open MongoDB.Driver

    let main () =

        // =================================
        // PART 1: SQLITE DATABASE
        // =================================

        printfn "===== SQLITE DATABASE ====="

        // Connect to SQLite
        use connection =
            new SqliteConnection("Data Source=students.db")

        connection.Open()
        printfn "Connected to SQLite!"

        // Create table
        use setup = connection.CreateCommand()
        setup.CommandText <-
            """CREATE TABLE IF NOT EXISTS Students
               (Id INTEGER PRIMARY KEY, Name TEXT, Age INTEGER)"""
        setup.ExecuteNonQuery() |> ignore

        // Remove previous test record
        use cleanup = connection.CreateCommand()
        cleanup.CommandText <- "DELETE FROM Students WHERE Id = 1"
        cleanup.ExecuteNonQuery() |> ignore

        // Function to display students
        let showSQLiteStudents () =
            use command = connection.CreateCommand()
            command.CommandText <- "SELECT * FROM Students"

            use reader = command.ExecuteReader()

            let mutable found = false

            while reader.Read() do
                found <- true
                printfn "ID: %d, Name: %s, Age: %d"
                    (reader.GetInt32(0))
                    (reader.GetString(1))
                    (reader.GetInt32(2))

            if not found then
                printfn "No students found."

        // CREATE
        printfn "\n1. CREATE Operation"

        use insert = connection.CreateCommand()
        insert.CommandText <-
            "INSERT INTO Students VALUES (1, 'Kanak', 20)"
        insert.ExecuteNonQuery() |> ignore

        showSQLiteStudents ()

        // READ
        printfn "\n2. READ Operation"
        showSQLiteStudents ()

        // UPDATE
        printfn "\n3. UPDATE Operation"

        use update = connection.CreateCommand()
        update.CommandText <-
            "UPDATE Students SET Age = 21 WHERE Id = 1"
        update.ExecuteNonQuery() |> ignore

        showSQLiteStudents ()

        // DELETE
        printfn "\n4. DELETE Operation"

        use delete = connection.CreateCommand()
        delete.CommandText <-
            "DELETE FROM Students WHERE Id = 1"
        delete.ExecuteNonQuery() |> ignore

        showSQLiteStudents ()

        printfn "SQLite CRUD completed!"

        // =================================
        // PART 2: MONGODB DATABASE
        // =================================

        printfn "\n===== MONGODB DATABASE ====="

        // Connect to MongoDB
        let client = MongoClient("mongodb://localhost:27017")

        let database = client.GetDatabase("FSharpLab")

        let collection =
            database.GetCollection<BsonDocument>("Students")

        printfn "Connected to MongoDB!"

        let filter =
            Builders<BsonDocument>.Filter.Eq("_id", 1)

        // Remove previous test record
        collection.DeleteOne(filter) |> ignore

        // Function to display students
        let showMongoStudents () =
            let students =
                collection.Find(
                    Builders<BsonDocument>.Filter.Empty
                ).ToList()

            if students.Count = 0 then
                printfn "No students found."
            else
                for student in students do
                    printfn "%s" (student.ToJson())

        // CREATE
        printfn "\n1. CREATE Operation"

        let student = BsonDocument()
        student.Add("_id", BsonInt32(1))
        student.Add("Name", BsonString("Kanak"))
        student.Add("Age", BsonInt32(20))

        collection.InsertOne(student)
        showMongoStudents ()

        // READ
        printfn "\n2. READ Operation"

        let result = collection.Find(filter).ToList()

        for student in result do
            printfn "%s" (student.ToJson())

        // UPDATE
        printfn "\n3. UPDATE Operation"

        let update =
            Builders<BsonDocument>.Update
                .Set("Name", "Kanak Sharma")
                .Set("Age", 21)

        collection.UpdateOne(filter, update) |> ignore
        showMongoStudents ()

        // DELETE
        printfn "\n4. DELETE Operation"

        collection.DeleteOne(filter) |> ignore
        showMongoStudents ()

        printfn "MongoDB CRUD completed!"

        printfn "\nAll CRUD operations completed successfully!"

// Run the program
Q2.main ()
