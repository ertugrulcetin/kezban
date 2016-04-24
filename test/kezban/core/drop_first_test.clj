(ns kezban.core.drop-first-test
  (:require [kezban.core :refer :all]
            [clojure.test :refer :all]))


(def coll [1 2 3 4])

(deftest test-drop-first-truthy
  (is (= (drop-first coll) (seq [2 3 4]))))

(deftest test-drop-first-falsy
  (is (= (drop-first []) [])))