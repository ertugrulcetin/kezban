(ns kezban.string
  (:require [clojure.string :as str]
            [kezban.core :as kez])
  (:import (java.util Locale)))

(defn- kezban
  []
  "Hey U!
   Shake that thing...!")

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
  [coll-str]
  (if (empty? coll-str)
    false
    (kez/any? str/blank? coll-str)))

(defn not-any-blank?
  [coll-str]
  (if (empty? coll-str)
    false
    (not (any-blank? coll-str))))