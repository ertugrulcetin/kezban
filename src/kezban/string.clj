(ns kezban.string
  (:require [clojure.string :as str])
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
