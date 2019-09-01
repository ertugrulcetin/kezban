# kezban [![Build Status](https://travis-ci.org/ertugrulcetin/kezban.svg?branch=master)](https://travis-ci.org/ertugrulcetin/kezban) [![GitHub License](https://img.shields.io/badge/license-Apache-blue.svg)](https://github.com/ertugrulcetin/kezban/blob/master/LICENSE)

Utility library for **Clojure and ClojureScript**.

The library targets **Clojure 1.8** and above.

## Leiningen

[![Clojars Project](https://clojars.org/kezban/kezban/latest-version.svg)](https://clojars.org/kezban)

## Usage

### kezban.core

```clojure
;;use kezban.core
(use 'kezban.core)
```

**when-let***

```clojure

user=> (when-let* [a 1 b 2 c 3]
                  (println "I'm in love with the coco")
                  a)
=> "I'm in love with the coco"
=> 1

;;returns nil when one binding is nil or false
user=> (when-let* [a 1 b nil c 3]
                  (println "Please print me!!!")
                  a)
=> nil                              
```

**if-let***

```clojure

user=> (if-let* [a 1 b 2 c (+ a b)]
                c)
=> 3

;;returns then part when one binding is nil or false
user=> (if-let* [a 1 b nil c 3]
                "Nope not here"
                "Here I Am Baby!")
=> "Here I Am Baby!"         
```

**->>>**

```clojure
;; Alternative to ->, ->> and (comp) with one arg
;; Applying Left-To-Right
;; First Argument has to be a value(input)!

;; comp equivalent: ((comp #(+ 1 %) #(+ % 1) inc) 5)
;; standard equivalent (+ 1 (+ (inc 5) 1))

user=> (->>> 5 inc #(+ % 1) #(+ 1 %)) ;;5 is the input
=> 8


;; comp equivalent: ((comp inc second reverse) '("a" 2 8 "b"))
;; standard equivalent (inc (second (reverse '("a" 2 8 "b"))))

user=> (->>> '("a" 2 8 "b") reverse second inc) ;;'("a" 2 8 "b") is the input
=> 9
```

**drop-first**

```clojure

user=> (drop-first [1 2 3])
=> (2 3)

user=> (drop-first [])
=> ()
```

**nth-safe**

```clojure

(def coll [1 2 3 4 5])

user=> (nth-safe coll 0)
=> 1

user=> (nth-safe coll 12)
=> nil

user=> (nth-safe coll 12 "gimme more!")
=> "gimme more!"
```

**nnth**

```clojure

(nnth [1 [2 3 [4 5]]] 1 2 1)
=> 5
```

**third, fourth, fifth, sixth, seventh, eighth, ninth, tenth**

```clojure

(def coll [1 2 3 4 5 6 7 8 9 10])

user=> (third coll)
=> 3

user=> (fourth coll)
=> 4

user=> (fifth coll)
=> 5

user=> (sixth coll)
=> 6

user=> (seventh coll)
=> 7

user=> (eighth coll)
=> 8

user=> (ninth coll)
=> 9

user=> (tenth coll)
=> 10
```

**any?**

```clojure

(def mixed [1 2 3 4 5 6 7 8])

(def only-odds [1 3 5 7 9])

user=> (any? odd? mixed)
=> true

user=> (any? even? only-odds)
=> false
```

**def-**
```clojure

(def- my-coll [1 2 3])
=> #'kezban.core/my-coll

(:private (meta #'kezban.core/my-coll))
=> true
```

**xor**
```clojure

(xor false true nil)
=> true

(xor false nil)
=> nil
```

**pprint-macro**
```clojure

(pprint-macro (when-let [a 1]
                (println a)))
(let*
 [temp__4657__auto__ 1]
 (if temp__4657__auto__ (do (let* [a temp__4657__auto__] (println a)))))
=> nil
```

**eval-when**
```clojure

(eval-when (= 1 1) '(println "Hi"))
Hi
=> nil
```

**quoted?**
```clojure

(quoted? '(+ 1  2))
=> true

(quoted? (+ 1  2))
=> false
```

**array?**
```clojure

(array? (int-array 1))
=> true

(array? :int (int-array 1))
=> true
```

**error?**
```clojure

(error? (throw (RuntimeException. "fail")))
=> true
```

**lazy?**
```clojure

(lazy? (map inc [1 2 3]))
=> true
```

**any?**
```clojure

(any? odd? [2 4 5])
=> true
```

**any-pred**
```clojure

(filter (any-pred even? odd?) [2 4 5 7])
=> (2 4 5 7)
```

**try-> and try->>**
```clojure

(try-> 5 inc dec str inc) ;;also thread last version: try->>
=> nil
```

**has-ns?**
```clojure

(has-ns? 'ns-does-not-exist)
=> false
```

**multi-comp**
```clojure

(def data [{:v 12, :a 10} {:v 21, :a 113} {:v 1, :a 2} {:v 12, :a 223} {:v 100, :a 23} {:v 1, :a 113}])

(sort #(multi-comp [:a :v] > %1 %2) data)
;or
(sort #(multi-comp [:a :v] %2 %1) data)
=> ({:v 12, :a 223} {:v 21, :a 113} {:v 1, :a 113} {:v 100, :a 23} {:v 12, :a 10} {:v 1, :a 2})
```

**with-out-str**
```clojure

(with-out-str (println "Hey!"))
=> "Hey!\n"
```

**with-err-str**
```clojure

(with-err-str (defn + []))
=> "WARNING: + already refers to: #'clojure.core/+ in namespace: kezban.core, being replaced by: #'kezban.core/+\n"
```

**letm**
```clojure

(letm [a 1
       b (+ a 1)])
=> {:a 1, :b 2}
```

**in?**
```clojure

(in? 3 [1 2 3 4])
=> true
```

**take-while-and-n-more**
```clojure

(take-while-and-n-more even? 2 [2 4 6 7 9 13 15])
=> (2 4 6 7 9)
```

**dissoc-in**
```clojure

(dissoc-in {:a {:b {:c 1 :d 2}}} [:a :b :d])
=> {:a {:b {:c 1}}}
```

**with-timeout**
```clojure

(with-timeout 100
              (Thread/sleep 1500))
=> CompilerException java.util.concurrent.TimeoutException

(with-timeout 1000
              (Thread/sleep 500)
              5)
=> 5
```

**url->file**
```clojure

(url->file "http://file.url" (io/file "your file path to get content"))
=> returns your file instance
```

**cond-let**
```clojure

(cond-let [a 5
           b (+ a 1)]

          (even? a)
          (println "a is odd")

          (even? b)
          (println "b is even"))
b is even
=> nil
```

**keywordize**
```clojure

(keywordize "hey Whats Up?")
=> :hey-whats-up?
```

**source-clj-file**
```clojure

(source-clj-file 'clojure.string)
=> returns clojure.string's namespace source code in string
```

**time***
```clojure

;;unlike time, time* allows you to provide more than one form
(time*
  (dotimes [_ 1000])
  (println "Done")
  5)
Done
"Elapsed time: 0.248474 msecs"
=> 5
```

**process-lazy-seq***
```clojure

(process-lazy-seq (fn [i]
                    (println (inc i))) 10000 (range))
                    
;; we can process 10000 data at time and not getting OutOfMemory Exception
```



## License
```
  Copyright © 2018 Ertuğrul Çetin
  
  Licensed under the Apache License, Version 2.0 (the "License");
  you may not use this file except in compliance with the License.
  You may obtain a copy of the License at
  
  http://www.apache.org/licenses/LICENSE-2.0
  
  Unless required by applicable law or agreed to in writing, software
  distributed under the License is distributed on an "AS IS" BASIS,
  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
  See the License for the specific language governing permissions and
  limitations under the License.
```
