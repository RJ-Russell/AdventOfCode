(ns advent-2015.santa-delivery-test
  (:require [clojure.test :refer :all]
            [advent-2015.santa-delivery :refer :all]))


(deftest calculate-coord-increments-correct-coordinate-based-on-direction
  (is (= [0 1] (calculate-coord [0 0] \^)))
  (is (= [1 0] (calculate-coord [0 0] \>)))
  (is (= [0 -1] (calculate-coord [0 0] \v)))
  (is (= [-1 0] (calculate-coord [0 0] \<))))

(deftest reduce-calculate-coord-increments-correct-coordinate-based-on-direction
  (is (= [1 2] (reduce calculate-coord [0 0] ">^^v^<>"))))

(deftest calculate-coord-reductions-returns-each-calculated-coordinate
  (is (= [[0 0] [1 0] [1 1] [1 2] [1 1] [1 2] [0 2] [1 2]] (calculate-coord-reduction ">^^v^<>"))))

(deftest calculate-house-count-returns-correct-number-of-elements-with-duplicates-removed
  (is (= 5 (calculate-house-count (reductions calculate-coord [0 0] ">^^v^<>")))))

