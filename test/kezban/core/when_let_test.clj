(ns kezban.core.when-let-test
  (:require [kezban.core :refer :all]
            [clojure.test :refer :all]))

(deftest test-when-let*-truthy
  (is (= (when-let* [a 1] a) 1))
  (is (= (when-let* [a 1 b 2] a) 1))
  (is (= (when-let* [a 1 b 2 c true] b) 2))
  (is (= (when-let* [a 1 b 2 c true] c) true)))

(deftest test-when-let*-truthy-with-body
  (is (= (when-let* [a 1 b 2]
                         (println "Hi there sexy!")
                         (dotimes [_ 3]
                           (println "Yeah.."))
                         a) 1))

  (is (= (when-let* [a 1 b 2 c true]
                         (println "Let's try again!")
                         "Me Gusto!") "Me Gusto!")))

(deftest test-when-let*-falsy
  (is (= (when-let* [a 1 b nil] a) nil))
  (is (= (when-let* [a 1 b 2 c false] b) nil))
  (is (= (when-let* [a 1 b false c 3] a) nil)))

(deftest test-when-let*-falsy-with-body
  (is (= (when-let* [a 1 b 2 c false]
                         (println "Come on run this shit!")
                         (println "Damn!")
                         a) nil))

  (is (= (when-let* [a 1 b false c 3]
                         (println "Please?")
                         a) nil)))
