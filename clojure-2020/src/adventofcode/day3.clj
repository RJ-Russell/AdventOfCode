(ns adventofcode.day3
  (:require [clojure.string :refer [split]]))

(def parse-input
  (->>
   (split (slurp "resources/day3_data") #"\n")))

(defn num-trees [[r d]]
  (let [tree-map (take-nth d parse-input)
        row-len (count (first tree-map))
        cols (iterate #(mod (+ r %) row-len) 0)
        path (map nth tree-map cols)
        trees (filter #(= \# %) path)]
    (count trees)))

(defn part1
  []
  (num-trees [3 1]))
  ;; => 276

(defn part2
  []
  (let [instructions [[1 1] [3 1] [5 1] [7 1] [1 2]]]
    (reduce * (map num-trees instructions))))
  ;; => 7812180000
