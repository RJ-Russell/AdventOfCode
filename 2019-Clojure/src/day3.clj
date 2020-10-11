(ns day3
  (:require [clojure.string :refer [split]]))

(def parse-input
  (->
   (slurp "resources/day3_data")
   (split #"\n")))

(defn process-instruction
  [[x y]
   instruction]
  (let [direction (first instruction)
        distance (Integer/parseInt (subs instruction 1))]
    (case direction
      \R (for [x' (range (inc x) (+ x distance 1))] [x' y])
      \L (for [x' (reverse (range (- x distance) x))] [x' y])
      \U (for [y' (range (inc y) (+ y distance 1))] [x y'])
      \D (for [y' (reverse (range (- y distance) y))] [x y']))))

(defn process-instructions
  ([directions] (process-instructions directions [0 0]))
  ([directions origin]))
