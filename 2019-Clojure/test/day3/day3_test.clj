(ns day3-test
  (:require
   [clojure.test :refer [deftest is testing]]
   [day3 :as d3]))


(deftest process-single-instruction
  (testing "Move in a single direction a given number from a given origin"
    (is (=  [[1 1] [2 1] [3 1] [4 1]] (d3/process-instruction [0 1] "R4")))
    (is (=  [[-4 1] [-3 1] [-2 1] [-1 1]] (d3/process-instruction [0 1] "L4")))
    (is (=  [[0 1] [1 1] [2 1] [3 1] [4 1]] (d3/process-instruction [5 1] "L5")))
    (is (=  [[1 2] [1 3] [1 4] [1 5]] (d3/process-instruction [1 1] "U4")))
    (is (=  [[0 -4] [0 -3] [0 -2] [0 -1]] (d3/process-instruction [0 0] "D4")))))
