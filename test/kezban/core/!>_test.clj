(ns kezban.core.!>-test
  (:require [kezban.core :refer :all]
            [clojure.test :refer :all]))

(deftest >!-test-truthy
  (is (= (!> 1 2) true))
  (is (= (!> 1 2 3) true))
  (is (= (!> 1 2 3 4) true)))

(deftest >!-test-falsy
  (is (= (!> 2 1) false))
  (is (= (!> 1 2 3 1) false))
  (is (= (!> 1 2 3 4 3) false)))
