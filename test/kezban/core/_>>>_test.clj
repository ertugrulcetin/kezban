(ns kezban.core.->>>-test
  (:require [kezban.core :refer :all]
            [clojure.test :refer :all]))


(deftest ->>>-test-nil
  (is (= (->>> ) nil)))

(deftest ->>>-test-with-one-arg
  (is (= (->>> 1) 1)))

(deftest name
  (testing "Deneme"
    (is (= 1 1))))

(deftest ->>>-test-with-funtions-and-args
  (is (= (->>> 1 inc inc ) 3))
  (is (= (->>> 5 #(+ % 1) #(* 2 %)) 12)))
