(ns kezban.core.nnth-test
  (:require [clojure.test :refer :all]
            [kezban.core :refer :all]))

(deftest test-nil
  (is (= (nnth nil 0) nil))
  (is (= (nnth [] 0) nil))
  (is (= (nnth '() 0) nil)))

(deftest test-like-nth
  (is (= (nnth [0 1 2 3] 0) 0))
  (is (= (nnth [0 1 2 3] 1) 1))
  (is (= (nnth [0 1 2 3] 2) 2))
  (is (= (nnth [0 1 2 3] 3) 3))
  (is (= (nnth [0 1 2 3] 4) nil)))

(deftest test-like-ffirst
  (is (= (nnth [[0 1 2 3]] 0 0) 0)))

(deftest test-nested-level-2
  (is (= (nnth [[0 1 2] [3 4 5] [6 7 8]] 1 2) 5))
  (is (= (nnth [[0 1 2] [3 4 5] [6 7 8]] 2 2) 8)))

(deftest test-nested-level-3
  (is (= (nnth [[[0 1 2]] [[3 4 5]] [[6 7 8]]] 1 0 0) 3))
  (is (= (nnth [[[0 1 2]] [[3 4 5]] [[6 7 8]]] 1 0 1) 4))
  (is (= (nnth [[[0 1 2]] [[3 4 5]] [[6 7 8]]] 1 0 9) nil)))
