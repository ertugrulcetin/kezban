(ns kezban.string.abbreviate-test
  (:require [kezban.string :refer :all]
            [clojure.test :refer :all]))

(deftest test-nil
  (is (= nil (abbreviate nil 1 2))))

(deftest test-illegal-argument
  (is (thrown? IllegalArgumentException (abbreviate "abcdefghij" 0 3)))
  (is (thrown? IllegalArgumentException (abbreviate "abcdefghij" 5 6))))

(deftest test-middle
  (is (= "...ghij..." (abbreviate "abcdefghijklmno" 6 10)))
  )