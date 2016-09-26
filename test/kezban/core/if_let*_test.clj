(ns kezban.core.if-let*-test
  (:require [kezban.core :refer :all]
            [clojure.test :refer :all]))


(deftest test-if-let*-truthy
  (is (= (if-let* [a 1] a 2) 1))
  (is (= (if-let* [a 1] a 2) 1))
  (is (= (if-let* [a 1 b 2] a) 1))
  (is (= (if-let* [a 1 b 2 c true] b) 2))
  (is (= (if-let* [a 1 b 2 c true] c) true)))

(deftest test-if-let*-truthy-with-body
  (is (= (if-let* [a 1 b 2]
                  (do
                    (println "Hey Handsome!")
                    (* a b))) 2))

  (is (= (if-let* [a 1 b 3 c true]
                  "Good girl!") "Good girl!")))

(deftest test-if-let*-falsy
  (is (= (if-let* [a 1 b nil] a) nil))
  (is (= (if-let* [a 1 b 2 c false] b) nil))
  (is (= (if-let* [a 1 b false c 3] a) nil)))

(deftest test-if-let*-falsy-then
  (is (= (if-let* [a 1 b nil] a "Hmm :)") "Hmm :)"))
  (is (= (if-let* [a 1 b 2 c false] b "Let me try that") "Let me try that"))
  (is (= (if-let* [a 1 b false c 3] a "I don't bite") "I don't bite")))