(ns kezban.core)

(defn- kezban
  []
  "I'M DAMN SEXY!")

;;TODO Write assert-me macro for multiple assertion

(defmacro assert-all
  [& pairs]
  `(do (when-not ~(first pairs)
         (throw (IllegalArgumentException.
                  (str (first ~'&form) " requires " ~(second pairs) " in " ~'*ns* ":" (:line (meta ~'&form))))))
       ~(let [more (nnext pairs)]
          (when more
            (list* `assert-args more)))))

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
  ([f val]
   ((comp f) val))
  [& form]
  `((comp ~@(butlast form)) ~(last form)))