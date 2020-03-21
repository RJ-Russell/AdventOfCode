(ns advent-2018.inventory-management-system-test
  (:require [clojure.test :refer :all]
            [advent-2018.inventory_management_system :refer :all]))

;; Part 1 Tests
(def test-input1 [[1 1 1 1 1]  ;; contains no letters that appear exactly two or three times.
                  [2 3 1]      ;; contains two a and three b, so it counts for both.
                  [1 2 1 1 1]  ;; contains two b, but no letter appears exactly three times.
                  [1 1 3 1]    ;; contains three c, but no letter appears exactly two times.
                  [2 1 1 2]    ;; contains two a and two d, but it only counts once.
                  [1 1 1 1 2]  ;; contains two e.
                  [3 3]])      ;; contains three a and three b, but it only counts once.

(deftest has-2-letters-that-appear-in-input-returns-4
  (is (= 4 (count (has-count test-input1 2)))))

(deftest has-3-letters-that-appear-in-input-returns-3
  (is (= 3 (count (has-count test-input1 3)))))

(deftest has-no-letters-that-appear-in-input-returns-0
  (is (= 0 (count (has-count [[1 1 1 1 1]] 2))))
  (is (= 0 (count (has-count [[1 1 1 1 1]] 3)))))

(deftest counts-distinct-characters-that-repeat-the-same-number-of-times-as-only-one
  (is (= 1 (count (has-count [[3 3]] 3)))))

;; Part 2 Tests
(def test-input2 ["abcde" "fghij" "klmno" "pqrst" "fguij" "axcye" "wvxyz"])
