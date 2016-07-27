(ns kezban.string.repeat-str-test
  (:require [kezban.string :as kez-str]
            [clojure.test :refer :all]))

(deftest repeat-str-test-truthy
  (is (= (kez-str/repeat-str 1 "er") "er"))
  (is (= (kez-str/repeat-str 2 "er") "erer"))
  (is (= (kez-str/repeat-str 3 "er") "ererer")))

(deftest repeat-str-test-falsy
  (is (= (kez-str/repeat-str 2 "") ""))
  (is (= (kez-str/repeat-str 0 "er") ""))
  (is (= (kez-str/repeat-str -1 "er") ""))
  (is (= (kez-str/repeat-str -2 "er") ""))
  (is (= (kez-str/repeat-str -1 "") ""))
  (is (= (kez-str/repeat-str -1 nil) ""))
  (is (= (kez-str/repeat-str 0 nil) ""))
  (is (= (kez-str/repeat-str 1 nil) ""))
  (is (= (kez-str/repeat-str 2 nil) "")))
