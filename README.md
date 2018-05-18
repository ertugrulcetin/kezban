# kezban [![Build Status](https://travis-ci.org/ertugrulcetin/kezban.svg?branch=master)](https://travis-ci.org/ertugrulcetin/kezban) [![GitHub License](https://img.shields.io/badge/license-Apache-blue.svg)](https://github.com/ertugrulcetin/kezban/blob/master/LICENSE)

Utility library for **Clojure**.

The library targets **Clojure 1.8** and above.

## Leiningen

[![Clojars Project](https://clojars.org/kezban/kezban/latest-version.svg)](https://clojars.org/kezban)

## Usage

### kezban.core

```clojure
;;use kezban.core
(use 'kezban.core)
```

**when-let***: Multiple binding version of when-let

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

**if-let***: Multiple binding version of if-let

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

**->>>**: Alternative to **->**  ,  **->>**  and  **(comp) with one arg**

```clojure

;;Applying Left-To-Right
;;First Argument has to be a value(input)!

;; comp equivalent: ((comp #(+ 1 %) #(+ % 1) inc) 5)
;; standard equivalent (+ 1 (+ (inc 5) 1))

user=> (->>> 5 inc #(+ % 1) #(+ 1 %)) ;;5 is the input
=> 8


;; comp equivalent: ((comp inc second reverse) '("a" 2 8 "b"))
;; standard equivalent (inc (second (reverse '("a" 2 8 "b"))))

user=> (->>> '("a" 2 8 "b") reverse second inc) ;;'("a" 2 8 "b") is the input
=> 9
```

**drop-first**: derivative function of **drop**

```clojure

user=> (drop-first [1 2 3])
=> (2 3)

user=> (drop-first [])
=> ()
```

**nth-safe**: safe version of **nth**

```clojure

(def coll [1 2 3 4 5])

user=> (nth-safe coll 0)
=> 1

user=> (nth-safe coll 12)
=> nil

user=> (nth-safe coll 12 "gimme more!")
=> "gimme more!"
```

**nnth**: nested version of **nth**

```clojure

(nnth [1 [2 3 [4 5]]] 1 2 1)
=> 5
```

**third, fourth, fifth, sixth, seventh, eighth, ninth, tenth**: addition to **first and second**

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

**any?**: reverse logic of **not-any?**

```clojure

(def mixed [1 2 3 4 5 6 7 8])

(def only-odds [1 3 5 7 9])

user=> (any? odd? mixed)
=> true

user=> (any? even? only-odds)
=> false
```

**def-**: default version of **def**
```clojure

(def- my-coll [1 2 3])
=> #'kezban.core/my-coll

(:private (meta #'kezban.core/my-coll))
=> true
```


## License
```
  Copyright © 2016 Ertuğrul Çetin
  
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
