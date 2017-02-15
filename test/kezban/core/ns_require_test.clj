(ns kezban.core.ns-require-test
  (require [clojure.test :refer :all]
           [kezban.core :refer :all]))

(deftest test-nil
  (is (= (has-ns? nil) false)))

(deftest test-collection-false
  (is (= (has-ns? []) false))
  (is (= (has-ns? #{}) false))
  (is (= (has-ns? '()) false))
  (is (= (has-ns? '{}) false)))

(deftest test-ns-true
  (is (= (has-ns? 'kezban.core) true))
  (is (= (has-ns? 'clojure.test) true)))
