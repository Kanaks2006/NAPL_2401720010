
;; Experiment 18: Sequence Transformations

;; First Collection
(println "===== FIRST COLLECTION =====")

(def numbers [1 2 3 4 5 6])

(println "Original Collection:" numbers)

;; 1. MAP - Square each element
(println "Squares:" (map #(* % %) numbers))

;; 2. FILTER - Select even numbers
(println "Even Numbers:" (filter even? numbers))

;; 3. REDUCE - Calculate sum
(println "Sum:" (reduce + numbers))

;; 4. TAKE and DROP
(println "First Three Elements:" (take 3 numbers))
(println "After Dropping First Three:" (drop 3 numbers))

;; Threading Macro - Chain multiple operations
(println "Threading Macro Result:"
         (->> numbers
              (filter even?)
              (map #(* % %))
              (take 2)))


;; Second Collection
(println "\n===== SECOND COLLECTION =====")

(def numbers2 [10 15 20 25 30 35])

(println "Original Collection:" numbers2)

;; MAP - Add 5 to each element
(println "After Adding 5:" (map #(+ % 5) numbers2))

;; FILTER - Select numbers greater than 20
(println "Numbers Greater Than 20:"
         (filter #(> % 20) numbers2))

;; REDUCE - Calculate maximum
(println "Maximum Number:" (reduce max numbers2))

;; TAKE and DROP
(println "First Two Elements:" (take 2 numbers2))
(println "After Dropping First Two:" (drop 2 numbers2))

;; Threading Macro - Chain multiple operations
(println "Threading Macro Result:"
         (->> numbers2
              (filter #(> % 15))
              (map #(* % 2))
              (take 3)))
