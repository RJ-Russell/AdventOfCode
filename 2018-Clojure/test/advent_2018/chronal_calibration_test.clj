(ns advent-2018.chronal_calibration_test
  (:require [clojure.test :refer :all]
            [advent-2018.chronal_calibration]))

(def test-input  [-16 +12 -18 -1 +6 -8 +9 -15 +12])

(deftest part2-duplicate-test
  (= -27 (reduce + test-input)))
