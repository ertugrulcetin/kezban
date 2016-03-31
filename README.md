# kezban

Extended Collection & Utility library for Clojure.

## Usage

**when-let-multi**: Multiple binding version of **when-let**

```clojure

user=> (when-let-multi [a 1 b 2 c 3]
                       (println "I'm in love with the coco")
                       a)
=>I'm in love with the coco
=> 1                      

``

## License

Copyright © 2016 FIXME

Distributed under the Eclipse Public License either version 1.0 or (at
your option) any later version.
