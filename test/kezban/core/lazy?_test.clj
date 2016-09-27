(ns kezban.core.lazy?-test
  (require [clojure.test :refer :all]
           [kezban.core :refer :all]))

(deftest test-false
  (is (= (lazy? nil) false))
  (is (= (lazy? []) false))
  (is (= (lazy? [1 2 3]) false)))

(deftest test-true
  (is (= (lazy? (lazy-seq 1)) true))
  (is (= (lazy? (lazy-cat [1 2 3] [4 5 6])) true))
  (is (= (lazy? (for [i (range 10)] i)) true))
  (is (= (lazy? (interleave [1 2] [3 4] [5 6])) true)))

