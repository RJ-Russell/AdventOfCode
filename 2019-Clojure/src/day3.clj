(ns day3
  (:require [clojure.string :refer [split split-lines]]
            [clojure.set :refer [intersection]]))

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
      \R (for [x' (reverse (range (inc x) (+ x distance 1)))] [x' y])
      \L (for [x' (range (- x distance) x)] [x' y])
      \U (for [y' (reverse (range (inc y) (+ y distance 1)))] [x y'])
      \D (for [y' (range (- y distance) y)] [x y']))))

(defn process-instructions
  ([instructions] (process-instructions [0 0] instructions))
  ([origin instructions]
   (loop [origin origin
          [fi & ri] instructions
          result []]
     (if (nil? fi)
       (apply concat result)
       (let [segment (process-instruction origin fi)
             new-origin (first segment)]
         (recur new-origin ri (conj result segment)))))))

(defn manhattan-distance
  ([[x y]]
   (Math/abs (+ x y))))

(defn get-wires
  [instructions]
  (-> instructions
      (split #",")
      (process-instructions)))

(defn part1
  []
  (let [input parse-input
        wire1 (get-wires (first input))
        wire2 (get-wires (second input))]
    (apply min (map manhattan-distance (intersection (set wire1) (set wire2))))))
  ;; => 248


(defn find-thing [needle haystack]
  (first (keep-indexed #(when (= %2 needle) %1) haystack)))

(defn part2
  []
  (let [input parse-input
        wire1 (get-wires (first input))
        wire2 (get-wires (second input))
        intersections (intersection (set wire1) (set wire2))]
    (+ 2
       (apply min (for [point intersections]
                    (+ (find-thing point wire1)
                       (find-thing point wire2)))))))
  ;; => 28938


;; 28580
