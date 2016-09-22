(ns kezban.string
  (:require [clojure.string :as str]
            [kezban.core :as kez])
  (:import (java.util Locale)))


(defn all-lowercase?
  "Checks all letters are lowercase returns true if not returns false"
  [^CharSequence s]
  (if (str/blank? s)
    false
    (every? #(Character/isLowerCase %) s)))

(defn all-uppercase?
  "Checks all letters are uppercase returns true if not returns false"
  [^CharSequence s]
  (if (str/blank? s)
    false
    (every? #(Character/isUpperCase %) s)))

(defn substring?
  "Checks s2 substring of s1 without case sensitivity"
  ([^CharSequence s1 ^CharSequence s2]
   (substring? s1 s2 (Locale/getDefault)))
  ([^CharSequence s1 ^CharSequence s2 ^Locale locale]
   (if (or (str/blank? s1) (str/blank? s2))
     false
     (str/includes? (.toLowerCase (.toString s1) locale) (.toLowerCase (.toString s2) locale)))))

(defn default-str
  "Returns default string when str is nil/blank etc."
  ([str]
   (default-str str ""))
  ([str def-str]
   (if (str/blank? str)
     def-str
     str)))

(defn repeat-str
  "Repeat a String n times to form a new String"
  [n ^CharSequence s]
  (apply str (repeat n s)))

(defn any-blank?
  [coll]
  (if (empty? coll)
    false
    (kez/any? str/blank? coll)))

(defn not-any-blank?
  [coll]
  (complement any-blank?))

(defn get-new-offset
  [offset str-len max-width]
  (let [off1 (and (> offset str-len) str-len)
        off2 (and (< (- str-len offset) (- max-width 3)) (- str-len (- max-width 3)))]
    (or (reduce #(if %2 %2) nil [off1 off2]) offset)))

(defn abbreviate
  [str offset max-width]
  (when str
    (let [str-len (count str)
          new-offset (get-new-offset offset str-len max-width)]
      (cond
        (< max-width 4) (throw (IllegalArgumentException. "Minimum abbreviation width is 4"))
        (<= (count str) max-width) str
        (<= new-offset 4) (str (subs str 0 (- max-width 3)) "...")
        (< max-width 7) (throw (IllegalArgumentException. "Minimum abbreviation width with offset is 7"))
        (< (+ new-offset (- max-width 3)) str-len) (str "..." (abbreviate (subs str new-offset) 0 (- max-width 3)))
        :else
        (str "..." (subs str (- str-len (- max-width 3))))))))