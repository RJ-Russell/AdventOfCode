(ns advent-2015.day5-naughty-nice
  (:require [clojure.string :refer [split-lines split]]))

(def data (split-lines (slurp "resources/naughty_nice_data")))


(defn nice?
  [s]
  (boolean (and
            (> (count (re-seq #"[aeiou]" s)) 2)
            (re-seq #"(\w)\1" s)
            (nil? (re-seq #"(ab|cd|pq|xy)" s)))))

(defn part1
  []
  (get (frequencies (map nice? data)) true))

(defn nicer?
  [s]
  (boolean
   (and
    (re-seq #"(\w)\w\1" s)
    (or
     (re-seq #"(\w{2})\1" s)
     (re-seq #"(\w{2})\w+\1" s)))))

(defn part2
  []
  (get (frequencies (map nicer? data)) true))
