(ns kezban.string.default-str-test
  (:require [kezban.string :refer :all]
            [clojure.test :refer :all]))

(deftest default-str-test-truthy-with-one-arg
  (is (= (default "kerem") "kerem"))
  (is (= (default "can") "can")))

(deftest default-str-test-truthy
  (is (= (default "ertu" "def") "ertu"))
  (is (= (default "can" "def") "can")))

(deftest default-str-test-falsy-with-one-arg
  (is (= (default nil) ""))
  (is (= (default "") ""))
  (is (= (default "") "")))

(deftest default-str-test-falsy
  (is (= (default nil "def") "def"))
  (is (= (default "" "def") "def"))
  (is (= (default "  " "def") "def")))