(ns kezban.core)

(defn- kezban
  []
  "I'M DAMN SEXY!")

(defmacro assert-all
  [& pairs]
  `(do (when-not ~(first pairs)
         (throw (IllegalArgumentException.
                  (str (first ~'&form) " requires " ~(second pairs) " in " ~'*ns* ":" (:line (meta ~'&form))))))
       ~(let [more (nnext pairs)]
          (when more
            (list* `assert-all more)))))

(defn- get-secondary-values-from-vector
  [bindings]
  (map #(second %) (partition 2 bindings)))

(defmacro when-let-multi
  "Multiple binding version of when-let"
  [bindings & body]
  (assert-all
    (vector? bindings) "a vector for its binding"
    (even? (count bindings)) "exactly even forms in binding vector")
  `(let [r# (and ~@(get-secondary-values-from-vector bindings))]
     (when r#
       (let* ~(destructure bindings) ~@body))))

(defmacro when-not-let-multi
  "Not version of when-let-multi"
  [bindings & body]
  (assert-all
    (vector? bindings) "a vector for its binding"
    (even? (count bindings)) "exactly even forms in binding vector")
  `(let [r# (not (or ~@(get-secondary-values-from-vector bindings)))]
     (when r#
       (let* ~(destructure bindings) ~@body))))

(defmacro if-let-multi
  "Multiple binding version of if-let"
  ([bindings then]
   `(if-let-multi ~bindings ~then nil))
  ([bindings then else]
   (assert-all
     (vector? bindings) "a vector for its binding"
     (even? (count bindings)) "exactly even forms in binding vector")
   `(let [temp# (and ~@(get-secondary-values-from-vector bindings))]
      (if temp#
        (let* ~(destructure bindings) ~then)
        (let* ~(destructure bindings) ~else)))))

(defmacro if-not-let-multi
  "Multiple binding version of if-not"
  ([bindings then]
   `(if-not-let-multi ~bindings ~then nil))
  ([bindings then else]
   (assert-all
     (vector? bindings) "a vector for its binding"
     (even? (count bindings)) "exactly even forms in binding vector")
   `(let [temp# (not (or ~@(get-secondary-values-from-vector bindings)))]
      (if temp#
        (let* ~(destructure bindings) ~then)
        (let* ~(destructure bindings) ~else)))))

(defmacro ->>>
  "Takes a set of functions and value at the end of the arguments.
   Returns a result that is the composition
   of those funtions.Applies the rightmost of fns to the args(last arg is the value/input!),
   the next fn (right-to-left) to the result, etc."
  [& form]
  `((comp ~@(butlast form)) ~(last form)))

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
   (let [val (first (loop [i n
                           result coll]
                      (if (zero? i)
                        result
                        (if (neg? i)
                          nil
                          (recur (- i 1) (next result))))))]
     (if (nil? val)
       not-found
       val))))

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
  ([x y] (not (. clojure.lang.Numbers (gt x y))))
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

(defn any?
  [pred coll]
  ((complement not-any?) pred coll))

;;not-{fun}? Start
(def not-nil? (complement nil?))

(def not-symbol? (complement symbol?))

(def not-keyword? (complement keyword?))

(def not-chunked-seq? (complement chunked-seq?))

(def not-delay? (complement delay?))

(def not-identical? (complement identical?))

(def not-zero? (complement zero?))

(def not-pos? (complement pos?))

(def not-neg? (complement neg?))

(def not-integer? (complement integer?))

(def not-even? (complement even?))

(def not-odd? (complement odd?))

(def not-map-entry? (complement map-entry?))

(def not-contains? (complement contains?))

(def not-volatile? (complement volatile?))

(def not-reduced? (complement reduced?))

(def not-number? (complement number?))

(def not-ratio? (complement ratio?))

(def not-decimal? (complement decimal?))

(def not-float? (complement float?))

(def not-rational? (complement rational?))

(def not-set? (complement set?))

(def not-special-symbol? (complement special-symbol?))

(def not-var? (complement var?))

(def not-class? (complement class?))

(def not-bound? (complement bound?))

(def not-thread-bound? (complement thread-bound?))

(def not-isa? (complement isa?))

(def not-distinct? (complement distinct?))

(def not-empty? (complement empty?))

(def not-coll? (complement coll?))

(def not-list? (complement list?))

(def not-ifn? (complement ifn?))

(def not-fn? (complement fn?))

(def not-associative? (complement associative?))

(def not-sequential? (complement sequential?))

(def not-sorted? (complement sorted?))

(def not-counted? (complement counted?))

(def not-reversible? (complement reversible?))

(def not-future? (complement future?))

(def not-future-done? (complement future-done?))

(def not-future-cancelled? (complement future-cancelled?))

(def not-realized? (complement realized?))

;;TODO example will be added as soon as possible!
(def not-tagged-literal? (complement tagged-literal?))

;;TODO example will be added as soon as possible!
(def not-reader-conditional? (complement reader-conditional?))

(def not-seq? (complement seq?))

(def not-char? (complement char?))

(def not-string? (complement string?))

(def not-map? (complement map?))

(def not-vector? (complement vector?))

(defn fuck-the-system
  "Terminates the system!"
  []
  (System/exit 31))