(ns kezban.!<-test
  (:require [kezban.core :refer :all]
            [clojure.test :refer :all]))

(deftest <!-test-truthy
         (is (= (!< 2 1) true))
         (is (= (!< 3 2 1) true))
         (is (= (!< 4 3 2 1) true)))

(deftest <!-test-falsy
         (is (= (!< 1 2) false))
         (is (= (!< 1 3 2 1) false))
         (is (= (!< 3 4 3 2 1) false)))