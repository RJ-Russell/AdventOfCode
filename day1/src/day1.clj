(ns day1
  (:require [clojure.string :refer [split]]))

(def parse-input
  (->>
   (split (slurp "resources/day1_data") #"\n")
   (map #(Integer/parseInt %))))

(defn mass->fuel [m]
  (- (int (Math/floor (/ m 3))) 2))

(defn fuel-per-module [initial]
  (loop
   [val (mass->fuel initial)
    coll []]
    (if (<= val 0)
      coll
      (recur (mass->fuel val) (conj coll val)))))

(defn total-fuel-per-module [val]
  (->> val
       (fuel-per-module)
       (reduce +)))

(defn day1
  []
  (reduce + (map mass->fuel parse-input))
  ;; => 3454026
  )

(defn day2
  []
  (reduce + (map total-fuel-per-module parse-input))
  ;; => 5178170
  )
