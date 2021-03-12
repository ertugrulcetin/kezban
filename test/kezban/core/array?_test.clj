(ns kezban.core.array?-test
  (:require [clojure.test :refer :all]
            [kezban.core :refer :all])
  (:import (java.util List)))

(deftest test-false
  (is (= (array? nil) false))
  (is (= (array? false) false))
  (is (= (array? true) false))
  (is (= (array? 1) false))
  (is (= (array? [1 2 3]) false))
  (is (= (array? "ertu") false))
  (is (= (array? :nope (char-array 1)) false))
  (is (= (array? :nope nil) false))
  (is (= (array? :nope) false)))

(deftest test-true
  (is (= (array? (char-array 1)) true))
  (is (= (array? (byte-array 1)) true))
  (is (= (array? (short-array 1)) true))
  (is (= (array? (int-array 1)) true))
  (is (= (array? (long-array 1)) true))
  (is (= (array? (float-array 1)) true))
  (is (= (array? (double-array 1)) true))
  (is (= (array? (boolean-array 1)) true))
  (is (= (array? (make-array String 1)) true))
  (is (= (array? (make-array List 1)) true)))

(deftest test-type-true
  (is (= (array? :char (char-array 1)) true))
  (is (= (array? :byte (byte-array 1)) true))
  (is (= (array? :short (short-array 1)) true))
  (is (= (array? :int (int-array 1)) true))
  (is (= (array? :long (long-array 1)) true))
  (is (= (array? :float (float-array 1)) true))
  (is (= (array? :double (double-array 1)) true))
  (is (= (array? :boolean (boolean-array 1)) true)))
