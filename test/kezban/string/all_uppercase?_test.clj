(ns kezban.string.all-uppercase?-test
  (:require [kezban.string :refer :all]
            [clojure.test :refer :all]))

(deftest all-uppercase?-test-truthy
  (is (= (all-uppercase? "ABC") true))
  (is (= (all-uppercase? "ERT") true))
  (is (= (all-uppercase? "CAN") true)))

(deftest all-uppercase?-test-falsy
  (is (= (all-uppercase? nil) false))
  (is (= (all-uppercase? "") false))
  (is (= (all-uppercase? " ") false))
  (is (= (all-uppercase? "aBC") false))
  (is (= (all-uppercase? "AB C") false))
  (is (= (all-uppercase? "AB1C") false))
  (is (= (all-uppercase? "AB/C") false))
  (is (= (all-uppercase? "GIVE IT TO ME!") false)))