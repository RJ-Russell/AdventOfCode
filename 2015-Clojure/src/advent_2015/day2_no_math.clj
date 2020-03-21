(ns advent-2015.day2-no-math
  (:require [clojure.string :refer [split-lines split]]))

(defn strs->ints
  [d]
  (map
   (fn [el]
     (map #(Integer/parseInt %) el)) d))

(def data
  (->> (slurp "resources/no_math_data")
       (split-lines)
       (map #(split % #"x"))
       (strs->ints)))

(defn surface-area
  [el]
  (let [[l w h] el]
    (+ (* 2 l w) (* 2 w h) (* 2 l h))))

(defn shortest-side
  [el]
  (let [sorted-el (sort el)]
    (* (first sorted-el) (second sorted-el))))

(defn smallest-perimeter
  [el]
  (let [sorted-el (sort el)]
    (+ (* 2 (first sorted-el)) (* 2 (second sorted-el)))))

(defn cubic-volume
  [el]
  (let [[l w h] el]
    (* l w h)))


(defn part1
  []
  (reduce +
          (map #(+ (surface-area %) (shortest-side %)) data)))

(defn part2
  []
  (reduce +
          (map #(+ (smallest-perimeter %) (cubic-volume %)) data)))
