
(ns Q1
  (:import [java.util ArrayList HashMap]))

;; 1. Calling Java static methods
(println "Absolute value:" (Math/abs -25))
(println "Current time:" (System/currentTimeMillis))

;; 2. Creating Java objects
(def list1 (new ArrayList))
(def map1 (new HashMap))

;; 3. Calling instance methods
(.add list1 "Apple")
(.add list1 "Banana")
(.add list1 "Mango")

(.put map1 "Name" "Kanak")
(.put map1 "Course" "BSc Computer Science")

(println "Java ArrayList:" list1)
(println "Java HashMap:" map1)

;; 4. Converting between Clojure and Java collections

;; Java collection to Clojure collection
(def clj-list (vec list1))
(println "Clojure vector:" clj-list)

;; Clojure collection to Java collection
(def java-list (java.util.ArrayList. [10 20 30]))
(println "Java collection:" java-list)
