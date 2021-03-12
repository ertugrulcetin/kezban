(ns kezban.core.quoted-test
  (:require [clojure.test :refer :all]
            [kezban.core :refer :all]))

(deftest test-false
  (is (= (quoted? nil) false))
  (is (= (quoted? true) false))
  (is (= (quoted? false) false))
  (is (= (quoted? 1) false))
  (is (= (quoted? 1.1) false))
  (is (= (quoted? :a) false))
  (is (= (quoted? "ertu") false))
  (is (= (quoted? \a) false)))

(deftest test-true
  (is (= (quoted? 'ertu) true))
  (is (= (quoted? '()) true)))

(deftest test-1st-level-true
  (is (= (quoted? '(println "canısı")) true))
  (is (= (quoted? '(reduce + [1 2])) true)))

(deftest test-1st-level-false
  (is (= (quoted? (println "canısı")) false)))

(deftest test-2nd-level-true
  (is (= (quoted? '((list "canısı"))) true))
  (is (= (quoted? '(("deneme" "canısı"))) true))
  (is (= (quoted? '(("deneme" "canısı"))) true)))

(deftest test-2nd-level-falsy
  (is (= (quoted? ('(list "canısı"))) false))
  (is (= (quoted? ('("deneme" "canısı"))) false))
  (is (= (quoted? ('("deneme" "canısı"))) false)))

(deftest test-3th-level-true
  (is (= (quoted? '('('(println "aga" 1)))) true))
  (is (= (quoted? '('('(println "aga" 1.2)))) true)))

(deftest test-3th-level-true
  (is (= (quoted? (('(println "aga" 1)))) false))
  (is (= (quoted? (('(println "aga" 1.2)))) false)))

(deftest test-with-list
  (is (= (quoted? (println nil false)) false)))

(deftest test-with-vector-true
  (is (= (quoted? '[(println "Deneme") me reduce]) true))
  (is (= (quoted? '[]) true)))

(deftest test-with-vector-false
  (is (= (quoted? [(println "Deneme") me reduce]) false))
  (is (= (quoted? []) false)))

(deftest test-with-map-true
  (is (= (quoted? '{:a 1 :b 2}) true))
  (is (= (quoted? '{}) true)))

(deftest test-with-map-false
  (is (= (quoted? {:a 1 :b 2}) false))
  (is (= (quoted? {}) false)))

(deftest test-with-set-true
  (is (= (quoted? '#{:a :b :c}) true))
  (is (= (quoted? '#{}) true)))

(deftest test-with-set-false
  (is (= (quoted? #{:a :b :c}) false))
  (is (= (quoted? #{}) false)))
