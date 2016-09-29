(ns kezban.core.eval-when
  (require [clojure.test :refer :all]
           [kezban.core :refer :all]))

(deftest test-when-false-produce-nill
  (is (= (eval-when false '(reduce + [1 2])) nil)))

(deftest test-when-nil-produce-nil
  (is (= (eval-when nil '(reduce + [1 2])) nil)))

(deftest test-when-true-produce-eval-result
  (is (= (eval-when true '(reduce + [1 2])) 3))
  (is (= (eval-when (> 1 0) '(reduce + [1 2])) 3))
  (is (= (eval-when (> 1 0) '()) ()))
  (is (= (eval-when (> 1 0) '()) '())))



