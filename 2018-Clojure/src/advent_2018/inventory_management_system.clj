(ns advent-2018.inventory_management_system
  (:require [clojure.string :refer [split-lines]]))

(def input
  (split-lines (slurp "resources/inventory_management_system_data")))

(defn get-freqs []
  (->> input
       (map frequencies)
       (map vals)))

(defn has-count [coll val]
  (keep #(some #{val} %) coll))

(defn part1 []
  (* (count (has-count (get-freqs) 2))
     (count (has-count (get-freqs) 3))))
