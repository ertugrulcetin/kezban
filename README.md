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