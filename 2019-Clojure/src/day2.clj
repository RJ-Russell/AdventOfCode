(ns day2
  (:require [clojure.string :refer [split]]))

(def parse-input
  (->>
   (split (slurp "resources/day2_data") #",")
   (mapv #(Integer/parseInt %))))

(defn calculate-and-replace
  [oc op i p1 p2]
  (let [v1 (nth oc p1)
        v2 (nth oc p2)]
    (case op
      1 (assoc oc i (+ v1 v2))
      2 (assoc oc i (* v1 v2)))))

(defn process-opcode
  [oc pc]
  (let [op (nth oc pc)]
    (if (or (= 99 op) (> (+ pc 3) (count oc)))
      oc
      (let [p1 (nth oc (+ pc 1))
            p2 (nth oc (+ pc 2))
            i (nth oc (+ pc 3))]
        (recur (calculate-and-replace oc op i p1 p2) (+ pc 4))))))

(defn run
  [oc]
  (-> oc
      (process-opcode 0)
      (first)))

(defn part1
  []
  (-> parse-input
      (assoc 1 12
             2 2)
      (run)))
  ;; => 9706670

(defn part2
  []
  (for [n (range 0 100)
        v (range 0 100)
        :when (= (-> parse-input (assoc 1 n 2 v) (run)) 19690720)]
    (+ v (* 100 n))))
  ;; => (2552)
