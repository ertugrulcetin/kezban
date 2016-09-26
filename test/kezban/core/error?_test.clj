(ns kezban.core.error?-test
  (require [clojure.test :refer :all]
           [kezban.core :refer :all]))

(deftest test-throws-exception-true
  (is (= (error? (do (println "Aga") (throw (RuntimeException. "Deneme")))) true))
  (is (= (error? (do (println "Aga") (throw (Throwable. "Deneme")))) true))
  (is (= (error? (do (println "Aga") (throw (Error. "Deneme")))) true))
  (is (= (error? (do (println "Aga") (throw (IndexOutOfBoundsException. "Deneme")))) true)))

(deftest test-no-exception-false
  (is (= (error?) false))
  (is (= (error? (println "Do me")) false))
  (is (= (error? (do (println "Oki"))) false)))



