(ns advent-2017.corruption_checksum
  (:require [clojure.string :as str]))

(def input-file (slurp "resources/checksum_corruption"))

(defn parse-rows [input] (str/split input #"\n"))

(defn parse-lines
  [input]
  (map (fn
    [line]
    (let [string-line (str/split line #"\s+")]
      (mapv (fn [val] (Integer/parseInt val)) string-line)))
  input))

(defn diff
  "Returns the difference of the max - min of the list"
  [list]
  (- (apply max list) (apply min list)))

(defn div
  "Returns the result of the two numbers that can be evenly divided"
  [list]
  (first
    (for [fst list
          snd list
          :when
            (and
              (not= fst snd)
              (zero? (rem fst snd))
          )]
          (/ fst snd))))

(defn parse-and-diff
  [input]
  (map diff (parse-lines (parse-rows input))))

(defn parse-and-div
  [input]
  (map div (parse-lines (parse-rows input))))

(defn checksum1 [spreadsheet] (reduce + (parse-and-diff spreadsheet)))
(defn checksum2 [spreadsheet] (reduce + (parse-and-div spreadsheet)))

(checksum2 input-file)

(parse-and-div input-file)
