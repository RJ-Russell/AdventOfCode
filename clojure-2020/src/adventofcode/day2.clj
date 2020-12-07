(ns adventofcode.day2
  (:require [clojure.string :refer [split]]))

(def parse-input
  (->>
   (split (slurp "resources/day2_data") #"\n")))

(defn parse-line [line]
  (->> line
       (re-seq #"(\d+)-(\d+) ([a-z]): ([a-z]*)")
       flatten
       rest))

(defn parse-fields
  [line]
  (let [rule (parse-line line)
        password (last rule)
        n1 (Integer/parseInt (first rule))
        n2 (Integer/parseInt (second rule))
        char (.charAt (nth rule 2) 0)
        freqs (frequencies (last rule))
        num-occurrences (get freqs char)]
    [password n1 n2 char num-occurrences]))

(defn valid-password1? [line]
  (let [[_ start end _ num-occurrences] (parse-fields line)]
    (if (nil? num-occurrences)
      false
      (<= start num-occurrences end))))

(defn valid-password2? [rules]
  (let [[password p1 p2 char _] (parse-fields rules)
        first-pos (get password (dec p1))
        second-pos (get password (dec p2))]
    (not=
     (= first-pos char)
     (= second-pos char))))

(defn count-valid-passwords [pred results]
  (->> results
       (filter pred)
       (count)))

(defn part1 []
  (count-valid-passwords valid-password1? parse-input))
  ;; => 636

(defn part2 []
  (->> parse-input
       (filter valid-password2?)
       (count)))
  ;; => 588
