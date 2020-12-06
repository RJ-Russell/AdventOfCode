(ns adventofcode.day1
  (:require [clojure.string :refer [split]]))

(def parse-input
  (->>
   (split (slurp "resources/day1_data") #"\n")
   (map #(Integer/parseInt %))))

(defn find-two []
  (let [nums (set parse-input)]
    (for [val1 nums
          :let [val2 (- 2020 val1)]
          :when (< val1 val2)
          :when (contains? nums val2)]
      [val1 val2])))

(defn find-three []
  (let [nums (set parse-input)]
    (for [val1 nums
          val2 nums
          :let [val3 (- 2020 val1 val2)]
          :when (< val1 val2 val3)
          :when (contains? nums val3)]
      [val1 val2 val3])))

(defn part1 []
  (->> (find-two)
       (map #(reduce * %))))
  ;; => (468051)

(defn part2 []
  (->> (find-three)
       (map #(reduce * %))))
  ;; => (272611658)
