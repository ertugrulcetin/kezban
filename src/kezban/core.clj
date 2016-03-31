(ns kezban.core)

(defn- kezban
  []
  "I'M DAMN SEXY!")

;;TODO Write assert-me macro for multiple assertion

(defn- get-secondary-values-from-vector
  [bindings]
  (map #(second %) (partition 2 bindings)))

(defmacro when-let-multi
  [bindings & body]
  "Multiple binding version of when-let"
  (assert (vector? bindings) "a vector for its binding")
  (assert (even? (count bindings)) "exactly even forms in binding vector")
  `(let [r# (and ~@(get-secondary-values-from-vector bindings))]
     (when r#
       (let* ~(destructure bindings) ~@body))))

(defmacro if-let-multi
  ([bindings then]
   `(if-let-multi ~bindings ~then nil))
  ([bindings then else]
   `(let [temp# (and ~@(get-secondary-values-from-vector bindings))]
      (if temp#
        (let* ~(destructure bindings) ~then)
        (let* ~(destructure bindings) ~else)))))

(defmacro ->>>
  ([f val]
   ((comp f) val))
  [& form]
  `((comp ~@(butlast form)) ~(last form)))