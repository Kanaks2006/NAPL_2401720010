
(ns Q2)

;; 1. Handling ArithmeticException
(try
  (println "Division:" (/ 10 0))
  (catch ArithmeticException e
    (println "Arithmetic Error:" (.getMessage e)))
  (finally
    (println "Arithmetic block completed")))

;; 2. Handling NullPointerException
(try
  (let [x nil]
    (.length x))
  (catch NullPointerException e
    (println "Null Pointer Error:" (.getMessage e)))
  (finally
    (println "Null block completed")))

;; 3. Function that throws a custom exception
(defn check-age [age]
  (if (< age 18)
    (throw (ex-info "Age must be 18 or above"
                    {:age age :error "Underage"}))
    (println "Eligible to vote")))

;; Handling custom exception and graceful recovery
(try
  (check-age 16)
  (catch clojure.lang.ExceptionInfo e
    (println "Custom Error:" (ex-message e))
    (println "Error Details:" (ex-data e))
    (println "Recovery: Please enter a valid age."))
  (finally
    (println "Custom exception block completed")))
