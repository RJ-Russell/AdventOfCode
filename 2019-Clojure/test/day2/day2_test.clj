(ns day2-test
  (:require
   [clojure.test :refer [deftest is]]
   [day2 :as d2]))


(deftest process-state-returns-correct-values
  (is (=  [2 0 0 0 99] (d2/process-opcode [1 0 0 0 99] 0)))
  (is (=  [2 3 0 6 99] (d2/process-opcode [2 3 0 3 99] 0)))
  (is (=  [2 4 4 5 99 9801] (d2/process-opcode [2 4 4 5 99 0] 0))))

(deftest process-input
  (is (= [30 1 1 4 2 5 6 0 99] (d2/process-opcode [1 1 1 4 99 5 6 0 99] 0))))