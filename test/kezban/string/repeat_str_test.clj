(ns kezban.string.repeat-str-test
  (:require [kezban.string :refer :all]
            [clojure.test :refer :all]))

(deftest repeat-str-test-truthy
  (is (= (repeat-str 1 "er") "er"))
  (is (= (repeat-str 2 "er") "erer"))
  (is (= (repeat-str 3 "er") "ererer")))

(deftest repeat-str-test-falsy
  (is (= (repeat-str 2 "") ""))
  (is (= (repeat-str 0 "er") ""))
  (is (= (repeat-str -1 "er") ""))
  (is (= (repeat-str -2 "er") ""))
  (is (= (repeat-str -1 "") ""))
  (is (= (repeat-str -1 nil) ""))
  (is (= (repeat-str 0 nil) ""))
  (is (= (repeat-str 1 nil) ""))
  (is (= (repeat-str 2 nil) "")))
