(ns kezban.core.nth-safe-test
  (:require [kezban.core :refer :all]
            [clojure.test :refer :all]))

(def coll [1 2 3 4 5])

(deftest test-nth-safe-truthy
  (is (= (nth-safe coll 0) 1))
  (is (= (nth-safe coll 1) 2))
  (is (= (nth-safe coll 2) 3))
  (is (= (nth-safe coll 3) 4))
  (is (= (nth-safe coll 4) 5)))

(deftest test-nth-safe-falsy
  (is (= (nth-safe coll -1) nil))
  (is (= (nth-safe coll 6) nil))
  (is (= (nth-safe coll 7) nil))
  (is (= (nth-safe coll 8) nil))
  (is (= (nth-safe coll 9) nil))
  (is (= (nth-safe coll 10) nil)))

(deftest test-nth-safe-falsy-with-default-val
  (is (= (nth-safe coll -1 "ertu") "ertu"))
  (is (= (nth-safe coll 6 "sexy") "sexy"))
  (is (= (nth-safe coll 7 "angara") "angara")))

(deftest test-not-found
  (is (= (nth-safe [false "ertu" 1] 0 "!!!") false))
  (is (= (nth-safe [false nil 1] 1 "!!!") nil)))
