(ns kezban.any-test
  (:require [kezban.core :refer :all]
            [clojure.test :refer :all]))

(def mixed [1 2 3 4 5 6 7 8])

(def only-odds [1 3 5 7 9])

(def only-evens [2 4 6 8 10])

(deftest test-any-truthy
  (is (= (any? odd? mixed) true))
  (is (= (any? even? mixed) true))
  (is (= (any? pos? mixed) true)))

(deftest test-any-falsy
  (is (= (any? neg? mixed) false))
  (is (= (any? odd? only-evens) false))
  (is (= (any? even? only-odds) false)))