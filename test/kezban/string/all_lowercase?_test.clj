(ns kezban.string.all-lowercase?-test
  (:require [kezban.string :refer :all]
            [clojure.test :refer :all]))

(deftest all-lowercase?-test-truthy
         (is (= (all-lowercase? "abc") true))
         (is (= (all-lowercase? "ert") true))
         (is (= (all-lowercase? "can") true)))

(deftest all-lowercase?-test-falsy
  (is (= (all-lowercase? nil) false))
  (is (= (all-lowercase? "") false))
  (is (= (all-lowercase? " ") false))
  (is (= (all-lowercase? "abC") false))
  (is (= (all-lowercase? "ab c") false))
  (is (= (all-lowercase? "ab1c") false))
  (is (= (all-lowercase? "ab/c") false))
  (is (= (all-lowercase? "give it to me!") false)))