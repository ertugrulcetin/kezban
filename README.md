# kezban

Extended Collection & Utility library for Clojure.

![Keep Calm And Don't Program Like a Kezban](https://github.com/ertugrulcetin/kezban/blob/master/keep-calm-kezban.png?raw=true)


## Usage

**when-let-multi**: Multiple binding version of **when-let**

```clojure

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

## License

Copyright © 2016 FIXME

Distributed under the Eclipse Public License either version 1.0 or (at
your option) any later version.
