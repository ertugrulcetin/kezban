(ns kezban.string.default-str-test
  (:require [kezban.string :refer :all]
            [clojure.test :refer :all]))

(deftest default-str-test-truthy-with-one-arg
  (is (= (default-str "kerem") "kerem"))
  (is (= (default-str "can") "can")))

(deftest default-str-test-truthy
  (is (= (default-str "ertu" "def") "ertu"))
  (is (= (default-str "can" "def") "can")))

(deftest default-str-test-falsy-with-one-arg
  (is (= (default-str nil) ""))
  (is (= (default-str "") ""))
  (is (= (default-str "") "")))

(deftest default-str-test-falsy
  (is (= (default-str nil "def") "def"))
  (is (= (default-str "" "def") "def"))
  (is (= (default-str "  " "def") "def")))