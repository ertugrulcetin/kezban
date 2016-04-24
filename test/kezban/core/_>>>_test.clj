(ns kezban.core.->>>-test
  (:require [kezban.core :refer :all]
            [clojure.test :refer :all]))


(deftest ->>>-test-nil
  (is (= (->>>) nil)))

(deftest ->>>-test-with-one-arg
  (is (= (->>> 1) 1)))

(deftest ->>>-test-with-funtions-and-args
  (is (= (->>> inc inc 1) 3))
  (is (= (->>> inc #(* % 2) 5) 11))
  (is (= (->>> inc second reverse '("a" 2 7 "b")) 8)))

