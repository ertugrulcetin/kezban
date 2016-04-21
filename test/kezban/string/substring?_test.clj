(ns kezban.string.substring?-test
  (:require [kezban.string :refer :all]
            [clojure.test :refer :all])
  (:import (java.util Locale)))

(deftest substring?-test-nil-check
  (is (= (substring? nil nil) false))
  (is (= (substring? nil "ertu") false))
  (is (= (substring? "ertu" nil) false)))

(deftest substring?-test-blank-check
  (is (= (substring? "ertu" "") false))
  (is (= (substring? "" "ertu") false))
  (is (= (substring? " " "") false))
  (is (= (substring? " " " ") false))
  (is (= (substring? "ertu" " ") false))
  (is (= (substring? " " "can") false)))

(deftest substring?-test-truthy
  (is (= (substring? "ertu" "er") true))
  (is (= (substring? "erTu" "eR") true))
  (is (= (substring? "hi guys" "guys") true))
  (is (= (substring? "give me more!" "me") true))
  (is (= (substring? "give me more!" "!") true)))

(deftest substring?-test-truthy-with-turkish-locale
  (is (= (substring? "canım aşkım" "aşkım" (Locale. "tr" "TR")) true))
  (is (= (substring? "canım aşkım" "AŞKIM" (Locale. "tr" "TR")) true))
  (is (= (substring? "canım aşkım" "CaNIm" (Locale. "tr" "TR")) true))
  (is (= (substring? "canım aşkım" "aşKI" (Locale. "tr" "TR")) true))
  (is (= (substring? "ğüşiöç" "ÖÇ" (Locale. "tr" "TR")) true))
  (is (= (substring? "ğüşiöç" "ĞÜ" (Locale. "tr" "TR")) true)))

(deftest substring?-test-falsy
  (is (= (substring? "give me that!" "mes") false))
  (is (= (substring? "give me that!" "!.") false))
  (is (= (substring? "give me that!" "give.") false))
  (is (= (substring? "give me that!" "me.") false)))
