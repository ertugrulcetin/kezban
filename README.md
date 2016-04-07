# kezban

Extended Collection & Utility library for Clojure.


## Usage

**when-let-multi**: Multiple binding version of **when-let**

```clojure

(use 'kezban.core)

user=> (when-let-multi [a 1 b 2 c 3]
                       (println "I'm in love with the coco")
                       a)
=> "I'm in love with the coco"
=> 1

;;returns nil when one binding is nil or false
user=> (when-let-multi [a 1 b nil c 3] 
                              (println "Please print me!!!")
                              a)
=> nil                              
```

**if-let-multi**: Multiple binding version of **if-let**

```clojure

(use 'kezban.core)

user=> (if-let-multi [a 1 b 2 c 3]
                       (* a b c))
=> 6

;;returns then part when one binding is nil or false
user=> (if-let-multi [a 1 b nil c 3] 
                              "Nope not here"
                              "Here I Am Baby!")
=> "Here I Am Baby!"         
                 
user=> (if-let-multi [a 1 b false c 3] 
                              "Nope not here")
=> nil      
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