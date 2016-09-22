(ns kezban.core.xor-test
  (:require [kezban.core :refer :all]
            [clojure.test :refer :all]))

(deftest test-with-no-arg
  (is (= (xor) true)))

(deftest test-with-one-arg
  (is (= (xor 1) 1)))

(deftest test-with-truthy-truthy
  (is (= (xor true true) false))
  (is (= (xor 1 true) false))
  (is (= (xor true 1) false))
  (is (= (xor some reduce) false)))

(deftest test-with-falsy-falsy
  (is (= (xor false false) false))
  (is (= (xor nil false) false))
  (is (= (xor nil nil) nil))
  (is (= (xor nil nil false) false))
  (is (= (xor nil nil false nil) nil)))

(deftest test-with-result-truthy
  (is (= (xor true false) true))
  (is (= (xor false true) true))
  (is (= (xor false true false) true))
  (is (= (xor false true false false) true))
  (is (= (xor false nil false nil nil true) true))
  (is (= (xor some reduce false true) true))
  (is (= (xor some reduce true) true))
  (is (= (xor some reduce true some some) some)))
