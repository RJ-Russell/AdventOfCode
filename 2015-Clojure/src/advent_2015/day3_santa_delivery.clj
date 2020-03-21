(ns advent-2015.day3-santa-delivery
  (:require [clojure.string :refer [split-lines split]]))

(def data (slurp "resources/santa_delivery_data"))

(defn calculate-coord
  [coord direction]
  (let [[x y] coord]
   (case direction
     \^ [x (inc y)]
     \> [(inc x) y]
     \v [x (dec y)]
     \< [(dec x) y])))
(def calculate-coord-reduction (partial reductions calculate-coord [0 0]))

(defn calculate-house-count
  [route]
  (->> route
       (set)
       (count)))

(defn part1
  []
  (->> data
       (calculate-coord-reduction)
       (calculate-house-count)))

(defn part2
  []
  (let [santa-route (calculate-coord-reduction (take-nth 2 data))
        robot-route (calculate-coord-reduction (take-nth 2 (rest data)))]
    (-> (concat santa-route robot-route)
         (calculate-house-count))))
