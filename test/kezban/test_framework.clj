(ns kezban.test-framework
  (:require [clojure.test :refer :all]))

(def foo-file (clojure.java.io/writer "foo.txt"))

;(set! *test-out* foo-file)

;(binding [*test-out* foo-file]
;  )

(deftest test-is
  (is (= 1 1)))

(deftest test-exception
  (is (thrown? ArithmeticException (/ 1 0))))

(deftest test-exception-2
  (is (thrown-with-msg? ArithmeticException #"Divide by zero" (/ 1 0))))

(deftest test-is-with-extra-arg
  (is (= 1 2 "this assertion is wrong!")))

(deftest test-name
  (testing "Arithmetic"
    (testing "with positive integers"
      (is (= 4 (+ 2 2)))
      (is (= 7 (+ 3 4))))
    (testing "with negative integers"
      (is (= -4 (+ -2 -2)))
      (is (= -1 (+ 3 -4))))))

(with-test
  (defn my-function
    [x y]
    (+ x y))
  (is (= 4 (my-function 2 2)))
  (is (= 7 (my-function 3 4))))

(deftest addition
  (is (= 4 (+ 2 2)))
  (is (= 7 (+ 3 4))))

(deftest subtraction
  (is (= 1 (- 4 3)))
  (is (= 3 (- 7 4))))

(deftest arithmetic
  (addition)
  (subtraction))

(run-tests)

(run-all-tests)

;(set! *load-tests* true)

(defn my-test-fixture
  [f]
  (println "Before")
  (f)
  (println "After"))

(defn class-once
  [f]
  (println "Class Before")
  (f)
  (println "Class After"))

(use-fixtures :each my-test-fixture)
(use-fixtures :once class-once)

(deftest test-ex-for-fixture
  (is (= 1 1 (do (println "Aga") 1))))

(deftest test-throw-runtime
  (is (thrown? RuntimeException (throw (RuntimeException. "Deneme")))))