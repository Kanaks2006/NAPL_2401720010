
;; Experiment 17: Clojure Core Immutable Data Structures

;; 1. LIST
(println "----- LIST -----")

(def original-list '(10 20 30))

(println "Original List:" original-list)
(println "First Element:" (first original-list))
(println "Rest of List:" (rest original-list))

(def new-list (conj original-list 5))

(println "New List after conj:" new-list)
(println "Original List remains:" original-list)


;; 2. VECTOR
(println "\n----- VECTOR -----")

(def original-vector [10 20 30])

(println "Original Vector:" original-vector)
(println "Element at index 1:" (get original-vector 1))
(println "Count of Elements:" (count original-vector))

(def new-vector (conj original-vector 40))

(println "New Vector after conj:" new-vector)
(println "Original Vector remains:" original-vector)


;; 3. MAP
(println "\n----- MAP -----")

(def original-map {:name "Kanak" :age 20})

(println "Original Map:" original-map)

(def updated-map (assoc original-map :city "Delhi"))

(println "New Map after assoc:" updated-map)

(def removed-map (dissoc original-map :age))

(println "New Map after dissoc:" removed-map)
(println "Value of name:" (get original-map :name))
(println "Original Map remains:" original-map)


;; 4. SET
(println "\n----- SET -----")

(def original-set #{10 20 30})

(println "Original Set:" original-set)

(def added-set (conj original-set 40))

(println "New Set after conj:" added-set)

(def removed-set (disj original-set 20))

(println "New Set after disj:" removed-set)

(println "Contains 20:" (contains? original-set 20))
(println "Original Set remains:" original-set)
