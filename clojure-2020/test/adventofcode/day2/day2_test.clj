(ns day2-test
  (:require
   [clojure.test :refer [deftest is]]
   [adventofcode.day2 :as d2]))

(def example-input ["1-3 a: abcde" "1-3 b: cdefg" "2-9 c: ccccccccc" "1-3 a: acade"])

(deftest parse-instruction-returns-correct-list
  (is (= (d2/parse-line (first example-input)) ["1" "3" "a" "abcde"])))

(deftest process-single-non-compliant-password-part1
  (is (= (d2/valid-password1? (first example-input)) true))
  (is (= (d2/valid-password1? (second example-input)) false))
  (is (= (d2/valid-password1? (nth example-input 2)) true)))

(deftest process-single-non-compliant-password-part2
  (is (= (d2/valid-password2? (first example-input)) true))
  (is (= (d2/valid-password2? (second example-input)) false))
  (is (= (d2/valid-password2? (nth example-input 2)) false))
  (is (= (d2/valid-password2? (nth example-input 3)) false)))
