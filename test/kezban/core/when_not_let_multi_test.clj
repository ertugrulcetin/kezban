(ns kezban.when-not-let-multi-test
  (:require [kezban.core :refer :all]
            [clojure.test :refer :all]))


(deftest test-when-not-let-multi-truthy
         (is (= (when-not-let-multi [a false] 1) 1))
         (is (= (when-not-let-multi [a nil b false] 1) 1))
         (is (= (when-not-let-multi [a nil b nil c nil] 2) 2))
         (is (= (when-not-let-multi [a false b false c false] true) true)))

(deftest test-when-not-let-multi-truthy-with-body
  (is (= (when-not-let-multi [a nil b false]
                         (println "Hi there sexy!")
                         (dotimes [_ 3]
                           (println "Yeah.."))
                         5) 5)))


(deftest test-when-not-let-multi-falsy
  (is (= (when-not-let-multi [a 1 b nil] a) nil))
  (is (= (when-not-let-multi [a 1 b 2 c false] b) nil))
  (is (= (when-not-let-multi [a 1 b 2 c 3] a) nil)))

(deftest test-when-not-let-multi-falsy-with-body
  (is (= (when-not-let-multi [a 1 b 2 c false]
                         (println "Come on run this shit!")
                         (println "Damn!")
                         a) nil))

  (is (= (when-not-let-multi [a 1 b 2 c 3]
                         (println "Please?")
                         a) nil)))