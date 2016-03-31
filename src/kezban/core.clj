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
