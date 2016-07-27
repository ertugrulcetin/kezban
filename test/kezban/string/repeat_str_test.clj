(ns kezban.string.repeat-str-test
  (:require [kezban.string :refer :all]
            [clojure.test :refer :all]))

(deftest repeat-str-test-truthy
  (is (= (repeat 1 "er") "er"))
  (is (= (repeat 2 "er") "erer"))
  (is (= (repeat 3 "er") "ererer")))

(deftest repeat-str-test-falsy
  (is (= (repeat 2 "") ""))
  (is (= (repeat 0 "er") ""))
  (is (= (repeat -1 "er") ""))
  (is (= (repeat -2 "er") ""))
  (is (= (repeat -1 "") ""))
  (is (= (repeat -1 nil) ""))
  (is (= (repeat 0 nil) ""))
  (is (= (repeat 1 nil) ""))
  (is (= (repeat 2 nil) "")))
