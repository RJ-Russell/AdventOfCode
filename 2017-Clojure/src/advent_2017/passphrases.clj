(ns advent-2017.passphrases
  (:require [clojure.string :as str]))

(def input-file (slurp "resources/passphrases"))

(def split-lines (partial str/split-lines))
(defn split-line [input] (str/split input #"\s"))

(defn unique-row?
  [row]
  (= row (distinct row)))

(defn has-anagram?
  [row]
  (let [row' (map sort row)]
    (unique-row? row')))


(defn check-valid
  [input func]
  (->> input
    (split-lines)
    (map split-line)
    (filter func)
    (count)))
