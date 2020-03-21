(ns advent-2017.maze
  (:require [clojure.string :as str]))

(def input-file
  (mapv read-string (str/split-lines (slurp "resources/maze_instructions"))))

(defn out-of-bounds? [[maze index]]
  (or (> 0 index) (>= index (count maze))))

(defn get-nth-value [[maze index]] (nth maze index))

(defn transition
  ([[maze index]]
  (let [nth-value (get-nth-value [maze index])]
    [(update maze index inc) (+ nth-value index)]))
  ([[maze index] nth-value]
    [(update maze index inc) (+ nth-value index)]))

(defn transition2
  [[maze index]]
  (let [nth-value (get-nth-value [maze index])]
    (if (>= nth-value 3)
      [(update maze index dec) (+ nth-value index)]
      (transition [maze index] nth-value))))

(defn navigate
  [maze transition-function]
  (loop [steps 0
         maze-and-index [maze 0]]
    (if (out-of-bounds? maze-and-index) steps
      (recur (inc steps) (transition-function maze-and-index)))))


(navigate input-file transition)
(navigate input-file transition2)
