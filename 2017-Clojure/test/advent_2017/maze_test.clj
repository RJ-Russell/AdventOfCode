(ns advent-2017.maze_test
  (:require [clojure.test :refer :all]
            [advent-2017.maze :refer :all]))

(def test-input [0 3 0 1 -3])
(deftest finished?-test
  (testing "Returns true if out of bounds of vector, false otherwise"
    (is (= (out-of-bounds? [test-input -1]) true))
    (is (= (out-of-bounds? [test-input 5]) true))
    (is (= (out-of-bounds? [test-input 3]) false))
    (is (= (out-of-bounds? [test-input 0]) false))))

(deftest transition-test
  (testing "Returns updated maze with updated value to index into the vector"
    (is (= (transition [test-input 0]) [[1 3 0 1 -3] 0]))
    (is (= (transition [test-input 1]) [[0 4 0 1 -3] 4]))
    (is (= (transition [test-input 2]) [[0 3 1 1 -3] 2]))))

(deftest navigate-test
  (testing "Returns 5 steps with test input"
    (is (= (navigate test-input transition) 5))))

(deftest navigate-test2
  (testing "Returns 5 steps with test input"
    (is (= (navigate test-input transition2) 10))))
