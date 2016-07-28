# kezban [![Build Status](https://travis-ci.org/ertugrulcetin/kezban.svg?branch=master)](https://travis-ci.org/ertugrulcetin/kezban)

Extended Collection & Utility library for **Clojure**.

The library targets **Clojure 1.8** and above.

##Leiningen

[![Clojars Project](https://img.shields.io/clojars/v/kezban.svg)](https://clojars.org/kezban)

## Usage

###kezban.core

**when-let***: Multiple binding version of when-let

```clojure

(use 'kezban.core)

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

(use 'kezban.core)

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

(use 'kezban.core)

;;Applying Right-To-Left 
;;Last Argument has to be a value(input)!

;; comp equivalent: ((comp inc #(* % 2)) 5)
;; standard equivalent (inc (#(* % 2) 5))

user=> (->>> inc #(* % 2) 5) ;;5 is the input
=> 11


;; comp equivalent: ((comp inc second reverse) '("a" 2 7 "b"))
;; standard equivalent (inc (second (reverse '("a" 2 7 "b"))))

user=> (->>> inc second reverse '("a" 2 7 "b")) ;;'("a" 2 7 "b") is the input
=> 8
```

**drop-first**: derivative function of **drop**

```clojure

(use 'kezban.core)

user=> (drop-first [1 2 3])
=> (2 3)

user=> (drop-first [])
=> ()
   
```

**nth-safe**: safe version of **nth**

```clojure

(use 'kezban.core)

(def coll [1 2 3 4 5])

user=> (nth-safe coll 0)
=> 1

user=> (nth-safe coll 12)
=> nil

user=> (nth-safe coll 12 "gimme more!")
=> "gimme more!"
   
```

**third, fourth, fifth, sixth, seventh, eighth, ninth, tenth**: addition to **first and second**

```clojure

(use 'kezban.core)

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

**!>**: Not version of **>**

```clojure

(use 'kezban.core)

user=> (!> 1 2)
=> true

user=> (!> 2 1)
=> false
   
```

**!<**: Not version of **<**

```clojure

(use 'kezban.core)

user=> (!< 2 1)
=> true

user=> (!< 1 2)
=> false
   
```

**any?**: reverse logic of **not-any?**

```clojure

(use 'kezban.core)

(def mixed [1 2 3 4 5 6 7 8])

(def only-odds [1 3 5 7 9])

user=> (any? odd? mixed)
=> true

user=> (any? even? only-odds)
=> false
   
```

**not-nil?**: Not version of **nil?**

```clojure

(use 'kezban.core)

user=> (not-nil? "I'm not nil bro!")
=> true

user=> (not-nil? nil)
=> false
   
```

**not-symbol?**: Not version of **symbol?**

```clojure

(use 'kezban.core)

user=> (not-symbol? "No man, I'm not a symbol")
=> true

user=> (not-symbol? 'here-we-go-i-am-the-symbol)
=> false
   
```

**not-keyword?**: Not version of **keyword?**

```clojure

(use 'kezban.core)

user=> (not-keyword? "Are u messing with me?")
=> true

user=> (not-keyword? :get-out-of-here)
=> false

```

**not-chunked-seq?**: Not version of **chunked-seq?**

```clojure

(use 'kezban.core)

user=> (not-chunked-seq? (iterate inc 10))
=> true

user=> (not-chunked-seq? (range 10))
=> false
   
```

**not-delay?**: Not version of **delay?**

```clojure

(use 'kezban.core)

=> (def v (delay (do (println "I Don't F*** With U") 
                            (Thread/sleep 1000) 
                            10)))

user=> (not-delay? "You bet!")
=> true

user=> (not-delay? v)
=> false
   
```

**not-identical?**: Not version of **identical?**

```clojure

(use 'kezban.core)

user=> (not-identical? "we ain't identical" "you nailed it!")
=> true

user=> (not-identical? "you again?" "you again?")
=> false
   
```

**not-zero?**: Not version of **zero?**

```clojure

(use 'kezban.core)

user=> (not-zero? 666)
=> true

user=> (not-zero? 0)
=> false
   
```

**not-pos?**: Not version of **pos?**

```clojure

(use 'kezban.core)

user=> (not-pos? -31)
=> true

user=> (not-pos? 69)
=> false
   
```

**not-pos?**: Not version of **pos?**

```clojure

(use 'kezban.core)

user=> (not-pos? -31)
=> true

user=> (not-pos? 69)
=> false
   
```

**not-neg?**: Not version of **neg?**

```clojure

(use 'kezban.core)

user=> (not-neg? 31)
=> true

user=> (not-neg? -69)
=> false
   
```

**not-integer?**: Not version of **integer?**

```clojure

(use 'kezban.core)

user=> (not-integer? 69.31)
=> true

user=> (not-integer? 62)
=> false
   
```

**not-even?**: Not version of **even?**

```clojure

(use 'kezban.core)

user=> (not-even? 1)
=> true

user=> (not-even? 2)
=> false
   
```

**not-odd?**: Not version of **odd?**

```clojure

(use 'kezban.core)

user=> (not-odd? 2)
=> true

user=> (not-odd? 1)
=> false
   
```

**not-map-entry?**: Not version of **map-entry?**

```clojure

(use 'kezban.core)

user=> (not-map-entry? (seq {:nasty 1 :sexy 2}))
=> true

user=> (not-map-entry? (first (seq {:nasty 1 :sexy 2})))
=> false
   
```

**not-contains?**: Not version of **contains?**

```clojure

(use 'kezban.core)

user=> (not-contains? {:good-boys 10 :bad-girls 20} :nasty-girls)
=> true

user=> (not-contains? {:good-boys 10 :bad-girls 20} :good-boys)
=> false
   
```

**not-volatile?**: Not version of **volatile?**

```clojure

(use 'kezban.core)

(def volatile-ass (volatile! 0))

(def ass 0)

user=> (not-volatile? ass)
=> true

user=> (not-volatile? volatile-ass)
=> false
   
```

**not-reduced?**: Not version of **reduced?**

```clojure

(use 'kezban.core)

(def white-ass :language-please!)

(def black-ass (reduced :you-wanna-fight?))


user=> (not-reduced? white-ass)
=> true

user=> (not-reduced? black-ass)
=> false
   
```

**not-number?**: Not version of **number?**
   
```clojure
   
(use 'kezban.core)
   
user=> (not-number? "Who do u think u are?")
=> true
   
user=> (not-number? 13)
=> false
      
```

**not-ratio?**: Not version of **ratio?**
   
```clojure
   
(use 'kezban.core)
   
user=> (not-ratio? "You messing with the wrong daddy")
=> true
   
user=> (not-ratio? 1/5)
=> false
      
```

**not-decimal?**: Not version of **decimal?**
   
```clojure
   
(use 'kezban.core)
   
user=> (not-decimal? 1)
=> true
   
user=> (not-decimal? 1M)
=> false
      
```

**not-float?**: Not version of **float?**
   
```clojure
   
(use 'kezban.core)
   
user=> (not-float? "Jesus!!")
=> true
   
user=> (not-float? 1.5)
=> false
      
```

**not-rational?**: Not version of **rational?**
   
```clojure
   
(use 'kezban.core)
   
user=> (not-rational? 1.5)
=> true
   
user=> (not-rational? 1)
=> false
      
```

**not-set?**: Not version of **set?**
   
```clojure
   
(use 'kezban.core)
   
user=> (not-set? ["this" "is" "bloody" "sexy"])
=> true
   
user=> (not-set? #{"watch your language sir!"})
=> false
      
```

**not-special-symbol?**: Not version of **special-symbol?**
   
```clojure
   
(use 'kezban.core)
   
user=> (not-special-symbol? 'candy-shop)
=> true
   
user=> (not-special-symbol? 'if)
=> false
      
```

**not-var?**: Not version of **var?**
   
```clojure
   
(use 'kezban.core)

(def sexy-var)
   
user=> (not-var? 'i-m-not-a-var-bitch)
=> true
   
user=> (not-var? #'sexy-var)
=> false
      
```

**not-class?**: Not version of **class?**
   
```clojure
   
(use 'kezban.core)
   
user=> (not-class? "nope go to James Gosling and ask why?")
=> true
   
user=> (not-class? java.lang.String)
=> false
      
```

**not-bound?**: Not version of **bound?**
   
```clojure
   
(use 'kezban.core)

(def pamela-anderson)

(def kim-kardashian 69)
   
user=> (not-bound? #'pamela-anderson)
=> true
   
user=> (not-bound? #'kim-kardashian)
=> false
      
```

**not-thread-bound?**: Not version of **thread-bound?**
   
```clojure
   
(use 'kezban.core)
   
user=> (not-thread-bound? #'map)
=> true
   
user=> (not-thread-bound? #'*warn-on-reflection*)
=> false
      
```

**not-isa?**: Not version of **isa?**
   
```clojure
   
(use 'kezban.core)

(derive ::bitch ::pimp)

(derive ::drug-dealer ::mafia)
   
user=> (not-isa? ::drug-dealer ::pimp)
=> true
   
user=> (not-isa? ::bitch ::pimp)
=> false
      
```

**not-distinct?**: Not version of **distinct?**
   
```clojure

(use 'kezban.core)
   
user=> (not-distinct? 1 2)
=> true
   
user=> (not-distinct? 69 69)
=> false
      
```

**not-empty?**: Not version of **empty?**
   
```clojure

(use 'kezban.core)
   
user=> (not-empty? ["do" "me" "good"])
=> true
   
user=> (not-empty? [])
=> false
      
```

**not-coll?**: Not version of **coll?**
   
```clojure

(use 'kezban.core)
   
user=> (not-coll? "i ain't coll")
=> true
   
user=> (not-coll? [])
=> false
      
```

**not-list?**: Not version of **list?**
   
```clojure

(use 'kezban.core)
   
user=> (not-list? "i ain't list too")
=> true
   
user=> (not-list? '())
=> false
      
```

**not-ifn?**: Not version of **ifn?**
   
```clojure

(use 'kezban.core)
   
user=> (not-ifn? "i ain't function too god dammit")
=> true
   
user=> (not-ifn? #("i'm the function dammit"))
=> false
      
```

**not-fn?**: Not version of **fn?**
   
```clojure

(use 'kezban.core)
   
user=> (not-fn? 5)
=> true
   
user=> (not-fn? #("bring it on"))
=> false
      
```

**not-associative?**: Not version of **associative?**
   
```clojure

(use 'kezban.core)
   
user=> (not-associative? '(1 2 3))
=> true
   
user=> (not-associative? [1 2 3])
=> false
      
```

**not-sequential?**: Not version of **sequential?**
   
```clojure

(use 'kezban.core)
   
user=> (not-sequential? "nope sorry!")
=> true
   
user=> (not-sequential? [1 2 3])
=> false
      
```

**not-sorted?**: Not version of **sorted?**
   
```clojure

(use 'kezban.core)

;; Note you can't just pass in a collection that happens to be sorted.
user=> (not-sorted? [1 2 3])
=> true
   
user=> (not-sorted? (sorted-set 5 3 1 2 4))
=> false
      
```

**not-counted?**: Not version of **counted?**
   
```clojure

(use 'kezban.core)

user=> (not-counted? "hmm :)")
=> true
   
user=> (not-counted? ["lets" "make" "party" "in" "ibiza"])
=> false
      
```

**not-reversible?**: Not version of **reversible?**
   
```clojure

(use 'kezban.core)

user=> (not-reversible? '())
=> true
   
user=> (not-reversible? [])
=> false
      
```

**not-future?**: Not version of **future?**
   
```clojure

(use 'kezban.core)

(def f (future (inc 0)))

(def e 1)

user=> (not-future? e)
=> true
   
user=> (not-future? f)
=> false
      
```

**not-future-done?**: Not version of **future-done?**
   
```clojure

(use 'kezban.core)

(def f (future (Thread/sleep 5000) (inc 0)))

user=> (not-future-done? f)
=> true

user=> (Thread/sleep 5000)
=> nil
   
user=> (not-future-done? f)
=> false
      
```

**not-future-cancelled?**: Not version of **future-cancelled?**
   
```clojure

(use 'kezban.core)

(def f (future (Thread/sleep 10000) (inc 0)))

user=> (not-future-cancelled? f)
=> true

user=> (future-cancel f)
=> true
   
user=> (not-future-done? f)
=> false
      
```

**not-seq?**: Not version of **seq?**
   
```clojure

(use 'kezban.core)

user=> (not-seq? ["so" "goooooood"])
=> true

user=> (not-seq? (seq ["so" "goooooood"]))
=> false
      
```

**not-char?**: Not version of **char?**
   
```clojure

(use 'kezban.core)

user=> (not-char? "nope darling")
=> true

user=> (not-char? \S)
=> false
      
```

**not-string?**: Not version of **string?**
   
```clojure

(use 'kezban.core)

user=> (not-string? \a)
=> true

user=> (not-string? "slap me daddy!")
=> false
      
```

**not-map?**: Not version of **map?**
   
```clojure

(use 'kezban.core)

user=> (not-map? "map is over there!")
=> true

user=> (not-map? {:here 69.31})
=> false
      
```

**not-vector?**: Not version of **vector?**
   
```clojure

(use 'kezban.core)

user=> (not-vector? '("vector" "is" "gone"))
=> true

user=> (not-vector? ["here" "i" "am"])
=> false
      
```

###kezban.string

**all-lowercase?**: Checks string consists of lower case chars

```clojure

(use 'kezban.string)

user=> (all-lowercase? "yep")
=> true

user=> (all-lowercase? "Do Me Good")
=> false

;; special chars are not treated as lower case (white spaces, commas etc.)
user=> (all-lowercase? "hey u!!!")
=> false
```

**all-uppercase?**: Checks string consists of upper case chars

```clojure

(use 'kezban.string)

user=> (all-uppercase? "SPIDERMAN")
=> true

user=> (all-uppercase? "boommm")
=> false

;; special chars are not treated as upper case (white spaces, commas etc.)
user=> (all-uppercase? "HEY O")
=> false
```

**substring?**: Checks string-2 substring of string-1 without case sensitivity

```clojure

(use 'kezban.string)

user=> (substring? "hey baby would u join me?" "baby")
=> true

user=> (substring? "come on dude" "dudem")
=> false
```

**default-str**: Returns default string when str is nil/blank etc.

```clojure

(use 'kezban.string)

user=> (default-str "" "abc")
=> "abc"

user=> (default-str "  " "def")
=> "def"

user=> (default-str nil "ghi")
=> "ghi"

user=> (default-str "klm")
=> ""
```

**repeat-str**: Repeat a string n times to form a new string

```clojure

(use 'kezban.string)

user=> (repeat-str 3 "ab")
=> "ababab"

user=> (repeat-str 0 "cd")
=> ""

user=> (repeat-str 5 "")
=> ""

user=> (repeat-str -1 "ef")
=> ""
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
