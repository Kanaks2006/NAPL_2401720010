
(ns Q1
  (:require [ring.adapter.jetty :as jetty])
  (:import [java.sql DriverManager]))

;; Sample Dataset
(def students
  [{:id 1 :name "kanak sharma" :marks 85}
   {:id 2 :name "sanya" :marks 92}
   {:id 3 :name "ananya" :marks 45}])

;; MAP: Calculate Pass or Fail
(def processed-students
  (map (fn [s]
         (assoc s :result
                (if (>= (:marks s) 40) "Pass" "Fail")))
       students))

;; FILTER: Select passed students
(def passed-students
  (filter #(= "Pass" (:result %))
          processed-students))

;; REDUCE: Calculate total marks
(def total-marks
  (reduce + (map :marks students)))

;; Database Connection
(def db-url "jdbc:sqlite:students.db")

;; Write Data to Database
(defn write-database []
  (try
    (with-open [conn (DriverManager/getConnection db-url)
                stmt (.createStatement conn)]
      (.execute stmt
                "CREATE TABLE IF NOT EXISTS students
         (id INTEGER PRIMARY KEY, name TEXT, marks INTEGER)")

      (with-open [ps (.prepareStatement conn
                                        "INSERT OR REPLACE INTO students VALUES (?, ?, ?)")]
        (doseq [s students]
          (.setInt ps 1 (:id s))
          (.setString ps 2 (:name s))
          (.setInt ps 3 (:marks s))
          (.executeUpdate ps)))

      (println "Database records saved successfully"))

    (catch Exception e
      (println "Database write error:" (.getMessage e)))))

;; Read Data from Database
(defn read-database []
  (try
    (with-open [conn (DriverManager/getConnection db-url)
                stmt (.createStatement conn)
                rs (.executeQuery stmt "SELECT * FROM students")]
      (loop [records []]
        (if (.next rs)
          (recur
           (conj records
                 {:id (.getInt rs "id")
                  :name (.getString rs "name")
                  :marks (.getInt rs "marks")}))
          records)))

    (catch Exception e
      (println "Database read error:" (.getMessage e))
      [])))

;; Ring HTTP Endpoint
(defn handler [request]
  {:status 200
   :headers {"Content-Type" "text/plain"}
   :body
   (str "Clojure Data Pipeline\n"
        "\nProcessed Students: "
        (pr-str (vec processed-students))
        "\nPassed Students: "
        (pr-str (vec passed-students))
        "\nTotal Marks: " total-marks
        "\nAverage Marks: " (/ total-marks (count students))
        "\nDatabase Records: "
        (pr-str (read-database)))})

;; Main Function
(defn -main []
  (write-database)
  (println "Server started at http://localhost:3000")
  (jetty/run-jetty handler {:port 3000 :join? true}))
