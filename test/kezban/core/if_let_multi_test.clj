(ns kezban.core.if-let-multi-test
  (:require [kezban.core :refer :all]
            [clojure.test :refer :all]))


(deftest test-if-let-multi-truthy
  (is (= (if-let-multi [a 1] a) 1))
  (is (= (if-let-multi [a 1 b 2] a) 1))
  (is (= (if-let-multi [a 1 b 2 c true] b) 2))
  (is (= (if-let-multi [a 1 b 2 c true] c) true)))

(deftest test-if-let-multi-truthy-with-body
  (is (= (if-let-multi [a 1 b 2]
                       (do
                         (println "Hey Handsome!")
                         (* a b))) 2))

  (is (= (if-let-multi [a 1 b 3 c true]
                       "Good girl!") "Good girl!")))

(deftest test-if-let-multi-falsy
  (is (= (if-let-multi [a 1 b nil] a) nil))
  (is (= (if-let-multi [a 1 b 2 c false] b) nil))
  (is (= (if-let-multi [a 1 b false c 3] a) nil)))

(deftest test-if-let-multi-falsy-then
  (is (= (if-let-multi [a 1 b nil] a "Hmm :)") "Hmm :)"))
  (is (= (if-let-multi [a 1 b 2 c false] b "Let me try that") "Let me try that"))
  (is (= (if-let-multi [a 1 b false c 3] a "I don't bite") "I don't bite")))

;;(run-all-tests)
;;(run-tests 'kezban.if-let-multi-test)