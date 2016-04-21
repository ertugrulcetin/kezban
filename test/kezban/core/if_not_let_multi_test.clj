(ns kezban.if-not-let-multi-test
  (:require [kezban.core :refer :all]
            [clojure.test :refer :all]))


(deftest test-if-not-let-multi-truthy
  (is (= (if-not-let-multi [a false] 1) 1))
  (is (= (if-not-let-multi [a nil b nil] 1) 1))
  (is (= (if-not-let-multi [a false b nil c false] 2) 2))
  (is (= (if-not-let-multi [a false b false c false] true) true)))


(deftest test-if-not-let-multi-truthy-with-body
  (is (= (if-not-let-multi [a false b false]
                       (do
                         (println "Hey Handsome!")
                         2)) 2))

  (is (= (if-not-let-multi [a false b false c nil]
                       "Good girl!") "Good girl!")))

(deftest test-if-not-let-multi-falsy
  (is (= (if-not-let-multi [a 1 b 1] a) nil))
  (is (= (if-not-let-multi [a 1 b 2 c false] b) nil))
  (is (= (if-not-let-multi [a 1 b 3 c 3] a) nil)))

(deftest test-if-not-let-multi-falsy-then
  (is (= (if-not-let-multi [a 1 b nil] a "Hmm :)") "Hmm :)"))
  (is (= (if-not-let-multi [a 1 b 2 c false] b "Let me try that") "Let me try that"))
  (is (= (if-not-let-multi [a 1 b false c 3] a "I don't bite") "I don't bite")))