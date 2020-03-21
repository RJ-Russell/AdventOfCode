(ns advent-2018.chronal_calibration
  (:require [clojure.string :refer [split]]))

(def input
  (->>
   (split (slurp "resources/chronal_calibration_data") #"\n")
   (map #(Integer/parseInt %))))

(defn part1 []
  (reduce + input))

(defn part2 []
  (let [vals (reductions + (cycle input))]
    (reduce
     (fn [seen val]
       (if (seen val)
         (reduced val)
         (conj seen val)))
     #{}
     vals)))
