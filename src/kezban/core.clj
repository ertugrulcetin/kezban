(ns kezban.core
  (:require [clojure.pprint :as pp]
            [clojure.walk :as walk]))

(defn- kezban
  []
  "I'M DAMN SEXY!")

(defmacro ^:private assert-all
  [& pairs]
  `(do (when-not ~(first pairs)
         (throw (IllegalArgumentException.
                  (str (first ~'&form) " requires " ~(second pairs) " in " ~'*ns* ":" (:line (meta ~'&form))))))
       ~(let [more (nnext pairs)]
          (when more
            (list* `assert-all more)))))

(defmacro when-let*
  "Multiple binding version of when-let"
  [bindings & body]
  (when (seq bindings)
    (assert-all
      (vector? bindings) "a vector for its binding"
      (even? (count bindings)) "exactly even forms in binding vector"))
  (if (seq bindings)
    `(when-let [~(first bindings) ~(second bindings)]
       (when-let* ~(vec (drop 2 bindings)) ~@body))
    `(do ~@body)))

(defmacro if-let*
  "Multiple binding version of if-let"
  ([bindings then]
   `(if-let* ~bindings ~then nil))
  ([bindings then else]
   (when (seq bindings)
     (assert-all
       (vector? bindings) "a vector for its binding"
       (even? (count bindings)) "exactly even forms in binding vector"))
   (if (seq bindings)
     `(if-let [~(first bindings) ~(second bindings)]
        (if-let* ~(vec (drop 2 bindings)) ~then ~else)
        ~(if-not (second bindings) else))
     then)))

;;TODO Change doc... imp has been changed !!!!
(defmacro ->>>
  "Takes a set of functions and value at the end of the arguments.
   Returns a result that is the composition
   of those funtions.Applies the rightmost of fns to the args(last arg is the value/input!),
   the next fn (left-to-right) to the result, etc."
  [& form]
  `((comp ~@(reverse (rest form))) ~(first form)))

(defn drop-first
  "Return a lazy sequence of all, except first value"
  [coll]
  (drop 1 coll))

(defn nth-safe
  "Returns the value at the index. get returns nil if index out of
   bounds,unlike nth nth-safe does not throw an exception, returns nil instead.nth-safe
   also works for strings, Java arrays, regex Matchers and Lists, and,
   in O(n) time, for sequences."
  ([coll n] (nth-safe coll n nil))
  ([coll n not-found]
   (if (neg? n)
     not-found
     (let [val (first (loop [i n result coll]
                        (if (zero? i)
                          result
                          (recur (dec i) (rest result)))))]
       (or val not-found)))))

(defn third
  "Gets the third element from collection"
  [coll]
  (nth-safe coll 2))

(defn fourth
  "Gets the fourth element from collection"
  [coll]
  (nth-safe coll 3))

(defn fifth
  "Gets the fifth element from collection"
  [coll]
  (nth-safe coll 4))

(defn sixth
  "Gets the sixth element from collection"
  [coll]
  (nth-safe coll 5))

(defn seventh
  "Gets the seventh element from collection"
  [coll]
  (nth-safe coll 6))

(defn eighth
  "Gets the eighth element from collection"
  [coll]
  (nth-safe coll 7))

(defn ninth
  "Gets the ninth element from collection"
  [coll]
  (nth-safe coll 8))

(defn tenth
  "Gets the tenth element from collection"
  [coll]
  (nth-safe coll 9))

(defn !>
  "Not version of >"
  ([x] true)
  ([x y] ((complement >) x y))
  ([x y & more]
   (if (not (> x y))
     (if (next more)
       (recur y (first more) (next more))
       (not (> y (first more))))
     false)))

(defn !<
  "Not version of <"
  ([x] true)
  ([x y] (not (. clojure.lang.Numbers (lt x y))))
  ([x y & more]
   (if (not (< x y))
     (if (next more)
       (recur y (first more) (next more))
       (not (< y (first more))))
     false)))

(defn <<
  "Bitwise shift left"
  [x n]
  (bit-shift-left x n))

(defn >>
  "Bitwise shift right"
  [x n]
  (bit-shift-right x n))

(defn >>>
  "Bitwise shift right, without sign-extension."
  [x n]
  (unsigned-bit-shift-right x n))

(defn xor-result
  [x y]
  (if (and x y)
    false
    (or x y)))

;;TODO doc will be added!
(defmacro xor
  ([] true)
  ([x] x)
  ([x & next]
   `(let [first# ~x
          second# ~(first next)]
      (if (= (count '~next) 1)
        (xor-result first# second#)
        (xor (xor-result first# second#) ~@(rest next))))))

(defmacro pprint-macro
  [form]
  `(pp/pprint (walk/macroexpand-all '~form)))

(defn any?
  [pred coll]
  ((complement not-any?) pred coll))