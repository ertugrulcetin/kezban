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

(defmacro ->>>
  "Takes a set of functions and value at the end of the arguments.
   Returns a result that is the composition
   of those funtions.Applies the rightmost of fns to the args(last arg is the value/input!),
   the next fn (right-to-left) to the result, etc."
  [& form]
  `((comp ~@(butlast form)) ~(last form)))