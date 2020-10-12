(ns day3-test
  (:require
   [clojure.test :refer [deftest is testing]]
   [day3 :as d3]))


(deftest process-single-instruction
  (testing "Move in a single direction a given number from a given origin returns final end point"
    (is (=  [[4 1] [3 1] [2 1] [1 1]] (d3/process-instruction [0 1] "R4")))
    (is (=  [[-4 1] [-3 1] [-2 1] [-1 1]] (d3/process-instruction [0 1] "L4")))
    (is (=  [[0 1] [1 1] [2 1] [3 1] [4 1]] (d3/process-instruction [5 1] "L5")))
    (is (=  [[1 5] [1 4] [1 3] [1 2]] (d3/process-instruction [1 1] "U4")))
    (is (=  [[0 -4] [0 -3] [0 -2] [0 -1]] (d3/process-instruction [0 0] "D4")))))

(deftest process-series-of-instructions
  (testing "Given a series of instructions, creates a cumulative list of endpoints"
    (is (= [[1 0] [1 -3] [1 -2] [1 -1]] (d3/process-instructions [0 0] ["R1" "D3"])))
    (is (= [[0 7] [0 6] [0 5] [0 4] [0 3] [0 2] [0 1]
            [6 7] [5 7] [4 7] [3 7] [2 7] [1 7]
            [6 3] [6 4] [6 5] [6 6]
            [2 3] [3 3] [4 3] [5 3]]
           (d3/process-instructions [0 0] ["U7" "R6" "D4" "L4"])))
    (is (= [[8 0] [7 0] [6 0] [5 0] [4 0] [3 0] [2 0] [1 0]
            [8 5] [8 4] [8 3] [8 2] [8 1]
            [3 5] [4 5] [5 5] [6 5] [7 5]
            [3 2] [3 3] [3 4]]
           (d3/process-instructions [0 0] ["R8" "U5" "L5" "D3"])))))
